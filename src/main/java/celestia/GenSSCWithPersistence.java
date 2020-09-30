package celestia;

import java.util.List;

import com.zenred.cosmos.domain.AstronomicalUnits;
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

import celestia.domain.CelestAtmosphere;
import celestia.domain.ColorRGB;
import celestia.domain.Haze;
import celestia.domain.PlanarExtension;
import celestia.domain.PlanarExtension.OGL_Color;
import celestia.domain.PlanarExtension.PlanarClass;
import celestia.domain.PlanarExtensionDao;

/**
 * generates a celestia ssc file for each star system
 * 
 * @author jredden
 *
 */

public class GenSSCWithPersistence implements SSC_Entry_formatsI {
	
	/**
	 * generic planar builder for SSC 
	 * 
	 * @param unifiedPlanetoidI
	 * @param image
	 * @return processed string image
	 */
	private static PlanarExtension buildPlanar(Star star, UnifiedPlanetoidI unifiedPlanetoidI, PlanarExtension planarExtension){
		planarExtension.setTexture(unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
 		planarExtension.setEmmisive(Boolean.TRUE);;   // light source from primary
		planarExtension.setNightTexture(unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
		planarExtension.setBumpMap(bumpMap.format(new Object[]{unifiedPlanetoidI.getPlanetoid().getPlanetoidName(), bumpMapType}));
		planarExtension.setBumpHeight(BumpHeight.build(unifiedPlanetoidI));
		ColorRGB colorRGB = StarColorMapping.mapStarColor(star.getStar_color());
		OGL_Color oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = colorRGB.getColorR();
		oglColor.gOfRGB = colorRGB.getColorG();
		oglColor.bOfRGB = colorRGB.getColorB();
		planarExtension.setColor(oglColor);
		planarExtension.setSpecularTexture(unifiedPlanetoidI.getPlanetoid().getPlanetoidName());
		colorRGB = PlanarSpecularColor.build(star, unifiedPlanetoidI);
		oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = colorRGB.getColorR();
		oglColor.gOfRGB = colorRGB.getColorG();
		oglColor.bOfRGB = colorRGB.getColorB();
 		planarExtension.setSpecularColor(oglColor);	
		String planarSpecular = PlanarSpecular.build(star, unifiedPlanetoidI).toString();
		planarExtension.setSpecularPower(new Double(planarSpecular));
		Haze haze = PlanarHaze.build(unifiedPlanetoidI);
		oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = haze.getHazeColor().getColorR();
		oglColor.gOfRGB = haze.getHazeColor().getColorG();
		oglColor.bOfRGB = haze.getHazeColor().getColorB();
		planarExtension.setHazeColor(oglColor);
		planarExtension.setHazeDensity(haze.getHazeDensity());
		planarExtension.setRadius(unifiedPlanetoidI.getPlanetoid().getRadius());
		planarExtension.setOblateness(Oblateness.build(unifiedPlanetoidI));

		CelestAtmosphere celestAtmosphere = PlanarAtmosphere.build(star, unifiedPlanetoidI);
		oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = celestAtmosphere.getLower().getColorR();
		oglColor.gOfRGB = celestAtmosphere.getLower().getColorG();
		oglColor.bOfRGB = celestAtmosphere.getLower().getColorB();
		planarExtension.setLower(oglColor);
		
		oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = celestAtmosphere.getUpper().getColorR();
		oglColor.gOfRGB = celestAtmosphere.getUpper().getColorG();
		oglColor.bOfRGB = celestAtmosphere.getUpper().getColorB();
		planarExtension.setUpper(oglColor);

		oglColor = planarExtension.new OGL_Color();
		oglColor.rOfRGB = celestAtmosphere.getSky().getColorR();
		oglColor.gOfRGB = celestAtmosphere.getSky().getColorG();
		oglColor.bOfRGB = celestAtmosphere.getSky().getColorB();
		planarExtension.setSky(oglColor);
		planarExtension.setCloudHeight(celestAtmosphere.getCloudHeight());
		planarExtension.setCloudSpeed(celestAtmosphere.getCloudSpeed());
		planarExtension.setCloudMap(celestAtmosphere.getCloudMap());
		planarExtension.setAtmosphereHeight(celestAtmosphere.getHeight());
		
		planarExtension.setAlbedo(PlanarAlbedo.genAlbedoPlanar(unifiedPlanetoidI));	
		planarExtension.setObliquity(AdditionalPlanarOrbitScalars.genObliquity());
		planarExtension.setRotationPeriod(AdditionalPlanarOrbitScalars.genRotationalPeriod());
		return planarExtension;
	}
	/**
	 * 
	 * @param unifiedPlanetoidI
	 * @param period
	 * @param axis
	 * @return orbit component
	 */
	private static PlanarExtension buildOrbit(UnifiedPlanetoidI unifiedPlanetoidI, Double period, Double axis, PlanarExtension planarExtension){
		Double eccentricity = AdditionalPlanarOrbitScalars.genEccentricity();
		Double inclination = AdditionalPlanarOrbitScalars.genInclination();
		Double longOfPeriCentre = AdditionalPlanarOrbitScalars.genLongOfPericentre();
		Double meanLongitude = AdditionalPlanarOrbitScalars.genMeanLongitude();
		planarExtension.setEccentricity(eccentricity);
		planarExtension.setInclination(inclination);
		planarExtension.setLongOfPericenter(longOfPeriCentre);
		planarExtension.setSemiMajorAxis(axis);
		if(period == Double.NEGATIVE_INFINITY || period == Double.POSITIVE_INFINITY){
			period = Double.MAX_VALUE;
		}
		planarExtension.setPeriod(period);
		planarExtension.setMeanLongitude(meanLongitude);
		return planarExtension;
	}
	/**
	 * 
	 * @param star
	 * @param unifiedPlanetoidI
	 * @return planet image
	 */
	private static PlanarExtension buildPlanet(Star star, UnifiedPlanetoidI unifiedPlanetoidI, PlanarExtension planarExtension){
		planarExtension.setPlanarClass(PlanarClass.PLANET);
		planarExtension = buildPlanar(star, unifiedPlanetoidI, planarExtension);
		Double planarPeriod = PlanarPeriod.build(star, unifiedPlanetoidI);
		Double semiMajorAxis = unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary();
		planarExtension = buildOrbit(unifiedPlanetoidI, planarPeriod, semiMajorAxis, planarExtension);
		return planarExtension;
	}
	/**
	 * 
	 * @param star
	 * @param unifiedPlanetoidI
	 * @param unifiedMoonI
	 * @return moon image
	 */
	private static PlanarExtension buildMoon(Star star, UnifiedPlanetoidI unifiedPlanetoidI, UnifiedPlanetoidI unifiedMoonI, PlanarExtension planarExtension){
		planarExtension.setPlanarClass(PlanarClass.MOON);
		planarExtension = (buildPlanar(star, unifiedPlanetoidI, planarExtension));
		Double moonPeriod = PlanarPeriod.build(unifiedMoonI);
		Double semiMajorAxis = unifiedMoonI.getPlanetoid().getDistanceToPrimary() * AstronomicalUnits.MOON_UNIT;
		planarExtension = buildOrbit(unifiedPlanetoidI, moonPeriod, semiMajorAxis, planarExtension);
		return planarExtension;
	}
	
	/**
	 * primary procedure
	 */
	public static void build() {
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();
		PlanarExtension planarExtension = new PlanarExtension();
		PlanarExtensionDao planarExtensionDao = null;
		List<SystemClusterSubSet> systemsWithCluster = systemDao.readSystemsWithClusters();
		for (SystemClusterSubSet systemClusterSubSet : systemsWithCluster) {
			ClusterRep clusterRep = clusterRepDao.readClusterRepById(systemClusterSubSet.getClusterRepId());
			List<Star> starList = starDao.readStarsInCluster(clusterRep);
			for(Star star : starList){
				List<UnifiedPlanetoidI> unifiedPlanetoidIs = ExistingSystemWithStars
						.readPlanetsAroundStar(star);
				if (unifiedPlanetoidIs.isEmpty()) {
					continue; // no planars
				}
				else{
					planarExtensionDao = new PlanarExtensionDao();
					for (UnifiedPlanetoidI unifiedPlanetoidI : unifiedPlanetoidIs){
						String planetnoidName = unifiedPlanetoidI.getPlanetoid().getPlanetoidName();
						Planetoid planetoid = planetoidDao.readPlanetoidByName(planetnoidName);
						planarExtension = buildPlanet(star, unifiedPlanetoidI, planarExtension);
						planarExtension.setPlanarName(planetnoidName);
						planarExtension.setPlanarId(planetoid.getPlanetoidId());
						if(planarExtensionDao.doesPlanarExtensionExist(planarExtension)){
							PlanarExtension forKey = planarExtensionDao.readPlanarExtensionName(planarExtension.getPlanarName());
							planarExtension.setPlanarExtensionId(forKey.getPlanarExtensionId());
							planarExtensionDao.updatePlanarExtensionByName(planarExtension);
						}
						else{
							planarExtensionDao.addPlanarExtension(planarExtension);
						}
						List<UnifiedPlanetoidI> unifiedMoonsIs = ExistingSystemWithStars
								.readMoonsAroundPlanet(unifiedPlanetoidI.getPlanetoid());
						if(unifiedMoonsIs.isEmpty()){
							continue; // no moons
						}
						else{
							planarExtension = new PlanarExtension();
							for (UnifiedPlanetoidI unifiedMoonI : unifiedMoonsIs) {
								String moonName = unifiedMoonI.getPlanetoid().getPlanetoidName();
								planetoid = planetoidDao.readPlanetoidByName(moonName);
								planarExtension = buildMoon(star, unifiedPlanetoidI, unifiedMoonI, planarExtension);
								planarExtension.setPlanarId(planetoid.getPlanetoidId());
								planarExtension.setPlanarName(moonName);
								if(planarExtensionDao.doesPlanarExtensionExist(planarExtension)){
									PlanarExtension primaryKey = planarExtensionDao.readPlanarExtensionName(moonName);
									planarExtension.setPlanarExtensionId(primaryKey.getPlanarExtensionId());
									planarExtensionDao.updatePlanarExtensionByName(planarExtension);
								}
								else{
									planarExtension.setPlanarExtensionId(null);
									planarExtensionDao.addPlanarExtension(planarExtension);
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		build();

	}

}
