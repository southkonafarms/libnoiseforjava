package celestia;

import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.ExistingSystemWithStars;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SystemClusterSubSet;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

import celestia.domain.PlanarExtension;
import celestia.domain.PlanarExtensionDao;
import celestia.persistence.BasicFileWriter;

public interface SSC_Entry_formatsI {
	public static String planetClass = "planet";
	public static String moonClass = "moon";
	public static String imageType = ".png";
	public static String nightImageType = ".night.png";
	public static String bumpMapType = ".bump.png";
	public static String specularTextureType = ".specular.png";
	public static String cloudMapType = ".cloud.png";

	// 0 -> planet 1-> star 2-> rest of planet ... or ... 0 -> moon 1 -> planet
	// 2-> rest of moon
	public static MessageFormat planar = new MessageFormat("\"{0}\" \"{1}\" '{' \n {2} \n '}' \n\n");
	// 0 -> moon or planet or other in system object
	public static MessageFormat planarClass = new MessageFormat("Class \"{0}\" \n");
	// png image
	public static MessageFormat texture = new MessageFormat("Texture \"{0}{1}\" \n ");
	// night png image
	public static MessageFormat nightTexture = new MessageFormat("NightTexture \"{0}{1}\" \n ");
	// bump map png image
	public static MessageFormat bumpMap = new MessageFormat("BumpMap \"{0}{1}\" \n ");
	// bump height
	public static MessageFormat bumpHeight = new MessageFormat("BumpHeight {0} \n");
	// generic color of planet from stars color
	public static MessageFormat planarBaseColor = new MessageFormat("Color [ {0} {1} {2} ] \n");
	// specular png image
	public static MessageFormat specularTexture = new MessageFormat("SpecularTexture \"{0}{1}\" \n ");
	// specular power
	public static MessageFormat specularPower = new MessageFormat("SpecularPower {0} \n");
	// specular color
	public static MessageFormat specularColor = new MessageFormat("SpecularColor [ {0} {1} {2} \n ]");
	// haze color
	public static MessageFormat hazeColor = new MessageFormat("HazeColor [ {0} {1} {2} \n ]");
	// haze density
	public static MessageFormat hazePower = new MessageFormat("HazeDensity {0} \n");
	// radius
	public static MessageFormat radius = new MessageFormat("Radius {0} \n");
	// oblateness
	public static MessageFormat oblateness = new MessageFormat("Oblateness {0}\n");
	// atmosphere
	public static MessageFormat planarAtmosphere = new MessageFormat("Atmosphere '{' \n Height {0} \n"
			+ " Lower [ {1} {2} {3} ] \n" + " Upper [ {4} {5} {6} ] \n" + " Sky [ {7} {8} {9} ] \n"
			+ " CloudHeight {10} \n" + " CloudSpeed {11} \n" + " CloudMap \"{12}\" \n" + "'}' \n\n");
	public static MessageFormat ellipticalOrbit = new MessageFormat(
			"ElipticalOrbit '{'\n" + " Period {0} \n" + " SemiMajorAxis {1} \n" + " Eccentricity {2} \n"
					+ " Inclination {3} \n" + " LongOfPericenter {4} \n" + " MeanLongitude {5} \n" + "'}' \n\n");
	public static MessageFormat planarAlbedo = new MessageFormat("Albedo {0} \n");

	/**
	 * uses the formats
	 * 
	 * @author jredden
	 *
	 */
	public abstract class BuildSSCFlatFile {
		private static Logger logger = Logger.getLogger(BuildSSCFlatFile.class);

		public static PlanarExtensionDao planarExtensionDao = new PlanarExtensionDao();

		public static StringBuilder readCommon(UnifiedPlanetoidI unifiedPlanetoidI) {
			StringBuilder fileImage = new StringBuilder();
			PlanarExtension planarExtension = planarExtensionDao
					.readPlanarExtensionName(unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
			fileImage.append(planarClass.format(new Object[] { planarExtension.getPlanarClass().getType() }));
			fileImage.append(
					texture.format(new Object[] { unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), imageType }));
			fileImage.append("Emissive true \n"); // light source from primary
			fileImage.append(nightTexture
					.format(new Object[] { unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), nightImageType }));
			fileImage.append(
					bumpMap.format(new Object[] { unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), bumpMapType }));
			fileImage.append(bumpHeight.format(new Object[] { planarExtension.getBumpHeight() }));
			fileImage.append(planarBaseColor.format(new Object[] { planarExtension.getColor().rOfRGB,
					planarExtension.getColor().gOfRGB, planarExtension.getColor().bOfRGB }));
			fileImage.append(specularTexture
					.format(new Object[] { unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), specularTextureType }));
			fileImage.append(specularColor.format(new Object[] { planarExtension.getSpecularColor().rOfRGB,
					planarExtension.getSpecularColor().gOfRGB, planarExtension.getSpecularColor().bOfRGB }));
			fileImage.append(specularPower.format(new Object[] { planarExtension.getSpecularPower() }));
			fileImage.append(hazeColor.format(new Object[] { planarExtension.getHazeColor().rOfRGB,
					planarExtension.getHazeColor().gOfRGB, planarExtension.getHazeColor().bOfRGB }));
			fileImage.append(hazePower.format(new Object[] { planarExtension.getHazeDensity() }));
			fileImage.append(oblateness.format(new Object[] { planarExtension.getOblateness() }));
			fileImage.append(radius.format(new Object[] { unifiedPlanetoidI.getPlanetoid().getRadius() }));
			// logger.info("at planarAtmosphere");
			fileImage.append(planarAtmosphere.format(new Object[] { planarExtension.getAtmosphereHeight() // {0}
					, planarExtension.getLower().rOfRGB // {1}
					, planarExtension.getLower().gOfRGB // {2}
					, planarExtension.getLower().bOfRGB // {3}
					, planarExtension.getUpper().rOfRGB // {4}
					, planarExtension.getUpper().gOfRGB // {5}
					, planarExtension.getUpper().bOfRGB // {6}
					, planarExtension.getSky().rOfRGB // {7}
					, planarExtension.getSky().gOfRGB // {8}
					, planarExtension.getSky().bOfRGB // {9}
					, planarExtension.getCloudHeight() // {10}
					, planarExtension.getCloudSpeed() // {11}
					, planarExtension.getCloudMap() // {12}
			}));
			fileImage.append(planarAlbedo.format(new Object[] { planarExtension.getAlbedo() }));
			// logger.info("at elipticalOrbit");

			fileImage.append(ellipticalOrbit.format(new Object[] { planarExtension.getPeriod() // {0}
					, planarExtension.getSemiMajorAxis() // {1}
					, planarExtension.getEccentricity() // {2}
					, planarExtension.getInclination() // {3}
					, planarExtension.getLongOfPericenter() // {4}
					, planarExtension.getMeanLongitude() // {5}
			}));
			logger.info("at end:" + fileImage.length());

			return fileImage;
		}

		public static StringBuilder readPlanet(Star star, UnifiedPlanetoidI unifiedPlanetoidI) {
			logger.info("Unified Planet:" + unifiedPlanetoidI);
			StringBuilder fileImage = new StringBuilder();
			fileImage.append(readCommon(unifiedPlanetoidI));
			StringBuilder container = new StringBuilder().append(planar.format(new Object[] {
					unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), star.getName(), fileImage.toString() }));
			logger.info("planet file image:" + container.toString());
			return container;
		}

		public static StringBuilder readMoon(Star star, UnifiedPlanetoidI unifiedPlanetoidI,
				UnifiedPlanetoidI unifiedMoonI) {
			logger.info("Unified Moon:" + unifiedMoonI);
			StringBuilder fileImage = new StringBuilder();
			fileImage.append(readCommon(unifiedMoonI));
			StringBuilder container = new StringBuilder()
					.append(planar.format(new Object[] { unifiedMoonI.getPlanetoid().getPlanetoidName(),
							star.getName() + '/' + unifiedPlanetoidI.getPlanetoid().getPlanetoidName(),
							fileImage.toString() }));
			logger.info("moon file image:" + container.toString());
			return container;
		}

		public static void genSSC_File() {
			StringBuilder fileImage = null;
			StringBuilder masterFileImage = new StringBuilder();
			SystemDao systemDao = new SystemDao();
			ClusterRepDao clusterRepDao = new ClusterRepDao();
			StarDao starDao = new StarDao();
			List<SystemClusterSubSet> systemsWithCluster = systemDao.readSystemsWithClusters();
			for (SystemClusterSubSet systemClusterSubSet : systemsWithCluster) {
				ClusterRep clusterRep = clusterRepDao.readClusterRepById(systemClusterSubSet.getClusterRepId());
				List<Star> starList = starDao.readStarsInCluster(clusterRep);
				for (Star star : starList) {
					fileImage = new StringBuilder();
					List<UnifiedPlanetoidI> unifiedPlanetoidIs = ExistingSystemWithStars.readPlanetsAroundStar(star);
					if (unifiedPlanetoidIs.isEmpty()) {
						continue; // no planars
					} else {
						for (UnifiedPlanetoidI unifiedPlanetoidI : unifiedPlanetoidIs) {
							String planetnoidName = unifiedPlanetoidI.getPlanetoid().getPlanetoidName();
							fileImage.append(readPlanet(star, unifiedPlanetoidI));
//							logger.info("MESSAGE_0:"+ fileImage.toString());
//							logger.info("Planetoid Reading for:" + planetnoidName);
							List<UnifiedPlanetoidI> unifiedMoonsIs = ExistingSystemWithStars
									.readMoonsAroundPlanet(unifiedPlanetoidI.getPlanetoid());
							if (unifiedMoonsIs.isEmpty()) {
								masterFileImage.append(fileImage);
								fileImage = new StringBuilder();
								continue; // no moons
							} else {
								for (UnifiedPlanetoidI unifiedMoonI : unifiedMoonsIs) {
									String moonName = unifiedMoonI.getPlanetoid().getPlanetoidName();
//									logger.info("Moon Reading for:" + moonName);
									fileImage.append(readMoon(star, unifiedPlanetoidI, unifiedMoonI));
								}
//								logger.info("MESSAGE_1:"+ fileImage.toString());
								masterFileImage.append(fileImage);
								fileImage = new StringBuilder();							
							}
//							logger.info("MESSAGE_2:"+ fileImage.toString());
						}
					}
				}
			}
			String uri = "celestia/cosmos/" + Math.random() + "_cosmos.ssc";
			BasicFileWriter.writeIt(masterFileImage, uri);
			fileImage = new StringBuilder();

			return;
		}

	}

}
