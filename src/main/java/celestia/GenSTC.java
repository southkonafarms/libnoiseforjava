package celestia;

import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SystemClusterSubSet;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.util.GenRandomRolls;

import celestia.domain.StarExtension;
import celestia.domain.StarExtensionDao;
import celestia.persistence.BasicFileWriter;

/**
 * generates an STC file for celestia
 * 
 * @author jredden
 *
 */

public class GenSTC {
	
	private static Logger logger = Logger.getLogger(GenSTC.class);
	
	private static Integer fakeHipparchLow = new Integer(3000000);
	private static Integer fakeHipparchHigh = new Integer(6000000);
	
	private static MessageFormat baryCentre = new MessageFormat("Barycenter \"{0}\" '{' \n RA {1} \n Dec {2} \n Distance {3} \n '}' \n\n");
	private static MessageFormat star = new MessageFormat("{0} \"{1}\" '{' \n OrbitBarycenter \"{2}\"\n SpectralType \"{3}\"\n AppMag {4}\n EllipticalOrbit '{'\n Period {5}\n SemiMajorAxis {6}\n Eccentricity {7}\n Inclination {8}\n AscendingNode {9}\n '}'\n'}'\n\n ");
	
	/**
	 * 
	 * @return hipparch number for generated stars
	 */
	private static Integer genFakeHipparch(){
		Integer fakeHipparch = 0;
		Integer range = fakeHipparchHigh-fakeHipparchLow;
		Integer delta = GenRandomRolls.Instance().getDX(range);
		fakeHipparch = fakeHipparchLow + delta;
		return fakeHipparch;
	}
	
	private static String buildBaryCentre(String name, Double rightAccension, Double declenation, Double distance) {
		return baryCentre.format(new Object[] { name, rightAccension, declenation, distance.toString() });
	}

	private static String buildStar(Integer hipparch, String name, String barycentre, String spectralType,
			Double magnitude, Double period, Double axis, Double eccentricity, Double inclination,
			Double ascendingnode) {
		return star.format(
				new Object[] { hipparch.toString(), name, barycentre, spectralType, magnitude.toString(), period.toString(),
						axis.toString(), eccentricity.toString(), inclination.toString(), ascendingnode.toString() });
	}
	
	public static void build() {
		StarExtensionDao starExtensionDao = new StarExtensionDao();
		StringBuilder fileImage = new StringBuilder("");
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();
		List<SystemClusterSubSet> systemsWithCluster = systemDao.readSystemsWithClusters();
		for (SystemClusterSubSet systemClusterSubSet : systemsWithCluster) {
			Double rightAscension = RightAscension.buildRightAcension(systemClusterSubSet.getUcoordinate(),
					systemClusterSubSet.getVcoordinate());
			Double declension = Declension.determineQuadrant(rightAscension);
			Double distance = Math.sqrt(systemClusterSubSet.getUcoordinate() * systemClusterSubSet.getUcoordinate()
					+ systemClusterSubSet.getVcoordinate() * systemClusterSubSet.getVcoordinate());
			distance /= 10.0; // scale to celestia maximum, 16K light years.
			String baryCentreName = systemClusterSubSet.getClustername();
			ClusterRep clusterRep = clusterRepDao.readClusterRepById(systemClusterSubSet.getClusterRepId());
			fileImage.append(buildBaryCentre(baryCentreName, rightAscension, declension, distance));
			List<Star> starList = starDao.readStarsInCluster(clusterRep);
			for (Star star : starList) {
				String starName = star.getName();
				String spectralType = StarTypeMapping.doTheMapping(star.getStar_type());
				Double apparentMagnitude = star.getLuminosity();
				Double period = Period.build(Math.abs(star.getDistance_clust_virt_centre()));
				Double semiMajorAxis = star.getDistance_clust_virt_centre();
				Double eccentricity = Eccentriity.build();
				Double inclination = Inclination.build();
				Double ascendingNode = 360.0 * GenRandomRolls.Instance().draw_rand();
				StarExtension starExtension = new StarExtension(null, star.getStarId(), starName, period, semiMajorAxis,
						eccentricity, ascendingNode, inclination, apparentMagnitude);
				if (starExtensionDao.doesStarExtensionExist(starExtension)) {
					// already, there update
					starExtension = starExtensionDao.updateStarExtensionByStarName(starExtension);
				} else {

					starExtension = starExtensionDao.addStarExtension(starExtension);
				}
				logger.info(starExtension);
				fileImage.append(buildStar(genFakeHipparch(), starName, baryCentreName, spectralType, apparentMagnitude,
						period, semiMajorAxis, eccentricity, inclination, ascendingNode));
			}
		}
		String uri = "celestia/cosmos/" + Math.random() + "_cosmos.stc";
		BasicFileWriter.writeIt(fileImage, uri);
	}

	public static void main(String[] args) {
		build();
	}

}
