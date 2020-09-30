package celestia.domain;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.zenred.johntredden.domain.AbstractJDBCDao;

import celestia.domain.PlanarExtension.OGL_Color;
import celestia.domain.PlanarExtension.PlanarClass;
import sun.util.logging.resources.logging;

public class PlanarExtensionDao extends AbstractJDBCDao {
	private static Logger logger = Logger.getLogger(PlanarExtensionDao.class);
	
	public static final String PLANET_EXTENSION = "PlanetoidExtension";

	public static final String PLANETOIDEXTENSIONID = "planetoidExtensionId";
	public static final String PLANETOIDID = "planetoidId";
	public static final String PLANETOIDNAME = "planetoidName";
	public static final String TEXTURE = "texture";
	public static final String NIGHTTEXTURE = "nightTexture";
	public static final String SEMIMAJORAXIS = "semiMajorAxis";
	public static final String ECCENTRICITY = "eccentricity";
	public static final String COLORR = "colorR";
	public static final String COLORG = "colorG";
	public static final String COLORB = "colorB";
	public static final String SPECULARTEXTURE = "specularTexture";
	public static final String SPECULARPOWER = "specularPower";
	public static final String HAZECOLORR = "hazeColorR";
	public static final String HAZECOLORG = "hazeColorG";
	public static final String HAZECOLORB = "hazeColorB";
	public static final String HAZEDENSITY = "hazeDensity";
	public static final String OBLATENESS = "oblateness";
	public static final String ATMOSPHEREHEIGHT = "atmosphereHeight";
	public static final String ATMOSPHERELOWERR = "atmosphereLowerR";
	public static final String ATMOSPHERELOWERG = "atmosphereLowerG";
	public static final String ATMOSPHERELOWERB = "atmosphereLowerB";
	public static final String ATMOSPHEREUPPERR = "atmosphereUpperR";
	public static final String ATMOSPHEREUPPERG = "atmosphereUpperG";
	public static final String ATMOSPHEREUPPERB = "atmosphereUpperB";
	public static final String ATMOSPHERESKYR = "atmosphereSkyR";
	public static final String ATMOSPHERESKYG = "atmosphereSkyG";
	public static final String ATMOSPHERESKYB = "atmosphereSkyB";
	public static final String CLOUDHEIGHT = "cloudHeight";
	public static final String CLOUDSPEED = "cloudSpeed";
	public static final String CLOUDMAP = "cloudMap";
	public static final String ORBITPERIOD = "orbitPeriod";
	public static final String ORBITSEMIMAJORAXIS = "orbitSemiMajorAxis";
	public static final String ORBITECCENTRICITY = "orbitEccentricity";
	public static final String ORBITINCLINATION = "orbitInclination";
	public static final String ORBITLONGOFPERICENTRE = "orbitLongOfPeriCentre";
	public static final String ORBITMEANLONGITUDE = "orbitMeanLongitude";
	public static final String OBLIQUITY = "obliquity";
	public static final String ROTATIONPERIOD = "rotationPeriod";
	public static final String ALBEDO = "albedo";
	public static final String PLANAR_CLASS = "planarClass";
	public static final String EMMISIVE = "emmisive";
	public static final String BUMP_MAP = "bumpMap";
	public static final String BUMP_HEIGHT = "bumpHeight";
	public static final String SPECULAR_COLORR = "specularColorR";
	public static final String SPECULAR_COLORG = "specularColorG";
	public static final String SPECULAR_COLORB = "specularColorB";
	public static final String DATESTAMP = "datestamp";
	
	private static String lastPlanarExtensionInsertSql = "SELECT MAX("+PLANETOIDEXTENSIONID+") FROM " + PLANET_EXTENSION;
		
	private static String readPlanarExtensionByIdSql = "SELECT "
			+ " plex." + PLANETOIDEXTENSIONID + " "
			+ " ,plex." + PLANETOIDID + " "
			+ " ,plex." + PLANETOIDNAME + " "
			+ " ,plex." + TEXTURE + " "
			+ " ,plex." + NIGHTTEXTURE + " "			
			+ " ,plex." + SEMIMAJORAXIS + " "
			+ " ,plex." + ECCENTRICITY + " "
			+ " ,plex." + COLORR + " "
			+ " ,plex." + COLORG + " "
			+ " ,plex." + COLORB + " "
			+ " ,plex." + SPECULARTEXTURE + " "
			+ " ,plex." + SPECULARPOWER + " "
			+ " ,plex." + HAZECOLORR + " "
			+ " ,plex." + HAZECOLORG + " "
			+ " ,plex." + HAZECOLORB + " "
			+ " ,plex." + HAZEDENSITY + " "
			+ " ,plex." + OBLATENESS + " "
			+ " ,plex." + ATMOSPHEREHEIGHT + " "
			+ " ,plex." + ATMOSPHERELOWERR + " "
			+ " ,plex." + ATMOSPHERELOWERG + " "
			+ " ,plex." + ATMOSPHERELOWERB + " "
			+ " ,plex." + ATMOSPHEREUPPERR + " "
			+ " ,plex." + ATMOSPHEREUPPERG + " "
			+ " ,plex." + ATMOSPHEREUPPERB + " "
			+ " ,plex." + ATMOSPHERESKYR + " "
			+ " ,plex." + ATMOSPHERESKYG + " "
			+ " ,plex." + ATMOSPHERESKYB + " "
			+ " ,plex." + CLOUDHEIGHT + " "
			+ " ,plex." + CLOUDSPEED + " "
			+ " ,plex." + CLOUDMAP + " "
			+ " ,plex." + ORBITPERIOD + " "
			+ " ,plex." + ORBITSEMIMAJORAXIS + " "
			+ " ,plex." + ORBITECCENTRICITY + " "
			+ " ,plex." + ORBITINCLINATION + " "
			+ " ,plex." + ORBITLONGOFPERICENTRE + " "
			+ " ,plex." + ORBITMEANLONGITUDE + " "
			+ " ,plex." + OBLIQUITY + " "
			+ " ,plex." + ROTATIONPERIOD + " "
			+ " ,plex." + ALBEDO + " "
			+ " ,plex." + PLANAR_CLASS + " "
			+ " ,plex." + EMMISIVE + " "
			+ " ,plex." + BUMP_MAP + " "
			+ " ,plex." + BUMP_HEIGHT + " "
			+ " ,plex." + SPECULAR_COLORR + " "
			+ " ,plex." + SPECULAR_COLORG + " "
			+ " ,plex." + SPECULAR_COLORB + " "
			+ " ,plex." + DATESTAMP + " "
			+ " FROM " + PLANET_EXTENSION + " plex "
			+ " WHERE plex." + PLANETOIDEXTENSIONID + " = ? "
			;

	private static String readPlanarExtensionByPlanarNameSql = "SELECT "
			+ " plex." + PLANETOIDEXTENSIONID + " "
			+ " ,plex." + PLANETOIDID + " "
			+ " ,plex." + PLANETOIDNAME + " "
			+ " ,plex." + TEXTURE + " "
			+ " ,plex." + NIGHTTEXTURE + " "			
			+ " ,plex." + SEMIMAJORAXIS + " "
			+ " ,plex." + ECCENTRICITY + " "
			+ " ,plex." + COLORR + " "
			+ " ,plex." + COLORG + " "
			+ " ,plex." + COLORB + " "
			+ " ,plex." + SPECULARTEXTURE + " "
			+ " ,plex." + SPECULARPOWER + " "
			+ " ,plex." + HAZECOLORR + " "
			+ " ,plex." + HAZECOLORG + " "
			+ " ,plex." + HAZECOLORB + " "
			+ " ,plex." + HAZEDENSITY + " "
			+ " ,plex." + OBLATENESS + " "
			+ " ,plex." + ATMOSPHEREHEIGHT + " "
			+ " ,plex." + ATMOSPHERELOWERR + " "
			+ " ,plex." + ATMOSPHERELOWERG + " "
			+ " ,plex." + ATMOSPHERELOWERB + " "
			+ " ,plex." + ATMOSPHEREUPPERR + " "
			+ " ,plex." + ATMOSPHEREUPPERG + " "
			+ " ,plex." + ATMOSPHEREUPPERB + " "
			+ " ,plex." + ATMOSPHERESKYR + " "
			+ " ,plex." + ATMOSPHERESKYG + " "
			+ " ,plex." + ATMOSPHERESKYB + " "
			+ " ,plex." + CLOUDHEIGHT + " "
			+ " ,plex." + CLOUDSPEED + " "
			+ " ,plex." + CLOUDMAP + " "
			+ " ,plex." + ORBITPERIOD + " "
			+ " ,plex." + ORBITSEMIMAJORAXIS + " "
			+ " ,plex." + ORBITECCENTRICITY + " "
			+ " ,plex." + ORBITINCLINATION + " "
			+ " ,plex." + ORBITLONGOFPERICENTRE + " "
			+ " ,plex." + ORBITMEANLONGITUDE + " "
			+ " ,plex." + OBLIQUITY + " "
			+ " ,plex." + ROTATIONPERIOD + " "
			+ " ,plex." + ALBEDO + " "
			+ " ,plex." + PLANAR_CLASS + " "
			+ " ,plex." + EMMISIVE + " "
			+ " ,plex." + BUMP_MAP + " "
			+ " ,plex." + BUMP_HEIGHT + " "
			+ " ,plex." + SPECULAR_COLORR + " "
			+ " ,plex." + SPECULAR_COLORG + " "
			+ " ,plex." + SPECULAR_COLORB + " "
			+ " ,plex." + DATESTAMP + " "
			+ " FROM " + PLANET_EXTENSION + " plex "
			+ " WHERE plex." + PLANETOIDNAME + " = ? "
			;
	
	private static String readPlanarByNameCountSql  = "SELECT COUNT(*) "
			+ " FROM " + PLANET_EXTENSION + " plex " + " WHERE plex." + PLANETOIDNAME
			+ " = ? "
			;
	
	private static String deletePlanarExtensionSql = "DELETE FROM " + PLANET_EXTENSION + " WHERE " + PLANETOIDEXTENSIONID
			+ " = ? ";	
	
	private static String updatePlanarExtensionSql = "UPDATE " + PLANET_EXTENSION + " plex SET "
			+ " plex." + PLANETOIDEXTENSIONID +" = ?  "
			+ " ,plex." + PLANETOIDID +" = ?  "
			+ " ,plex." + PLANETOIDNAME +" = ?  "
			+ " ,plex." + TEXTURE +" = ?  "
			+ " ,plex." + NIGHTTEXTURE +" = ?  "			
			+ " ,plex." + SEMIMAJORAXIS +" = ?  "
			+ " ,plex." + ECCENTRICITY +" = ?  "
			+ " ,plex." + COLORR +" = ?  "
			+ " ,plex." + COLORG +" = ?  "
			+ " ,plex." + COLORB +" = ?  "
			+ " ,plex." + SPECULARTEXTURE +" = ?  "
			+ " ,plex." + SPECULARPOWER +" = ?  "
			+ " ,plex." + HAZECOLORR +" = ?  "
			+ " ,plex." + HAZECOLORG +" = ?  "
			+ " ,plex." + HAZECOLORB +" = ?  "
			+ " ,plex." + HAZEDENSITY +" = ?  "
			+ " ,plex." + OBLATENESS +" = ?  "
			+ " ,plex." + ATMOSPHEREHEIGHT +" = ?  "
			+ " ,plex." + ATMOSPHERELOWERR +" = ?  "
			+ " ,plex." + ATMOSPHERELOWERG +" = ?  "
			+ " ,plex." + ATMOSPHERELOWERB +" = ?  "
			+ " ,plex." + ATMOSPHEREUPPERR +" = ?  "
			+ " ,plex." + ATMOSPHEREUPPERG +" = ?  "
			+ " ,plex." + ATMOSPHEREUPPERB +" = ?  "
			+ " ,plex." + ATMOSPHERESKYR +" = ?  "
			+ " ,plex." + ATMOSPHERESKYG +" = ?  "
			+ " ,plex." + ATMOSPHERESKYB +" = ?  "
			+ " ,plex." + CLOUDHEIGHT +" = ?  "
			+ " ,plex." + CLOUDSPEED +" = ?  "
			+ " ,plex." + CLOUDMAP +" = ?  "
			+ " ,plex." + ORBITPERIOD +" = ?  "
			+ " ,plex." + ORBITSEMIMAJORAXIS +" = ?  "
			+ " ,plex." + ORBITECCENTRICITY +" = ?  "
			+ " ,plex." + ORBITINCLINATION +" = ?  "
			+ " ,plex." + ORBITLONGOFPERICENTRE +" = ?  "
			+ " ,plex." + ORBITMEANLONGITUDE +" = ?  "
			+ " ,plex." + OBLIQUITY +" = ?  "
			+ " ,plex." + ROTATIONPERIOD +" = ?  "
			+ " ,plex." + ALBEDO +" = ?  "
			+ " ,plex." + PLANAR_CLASS +" = ?  "
			+ " ,plex." + EMMISIVE + " = ?  "
			+ " ,plex." + BUMP_MAP + " = ?  "
			+ " ,plex." + BUMP_HEIGHT + " = ?  "
			+ " ,plex." + SPECULAR_COLORR + " = ? "
			+ " ,plex." + SPECULAR_COLORG + " = ? "
			+ " ,plex." + SPECULAR_COLORB + " = ? "
			+ " ,plex." + DATESTAMP +" = ?  "
			+ " WHERE plex." + PLANETOIDNAME + " = ?"
		;
	/**
	 * 
	 * @param planarExtension
	 * @return planarExtension
	 */
	@Transactional
	public PlanarExtension addPlanarExtension(PlanarExtension planarExtension){
		
		Map<String, Object> planarExtensionMap = PlanarExtension.getPlanarExtensionMap(planarExtension);
		logger.info("addPlanarExtension:"+planarExtension);
		super.jdbcInsertSetup().withTableName(PLANET_EXTENSION).usingColumns(PlanarExtension.csvPlanarExtension()).execute(planarExtensionMap);
		Integer planarExtensionId = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(lastPlanarExtensionInsertSql);
		planarExtension.setPlanarExtensionId(planarExtensionId);
		return readPlanarExtensionById(planarExtensionId);
	}
	
	/**
	 * 
	 * @param planarExtensionId
	 * @return planarExtension
	 */
	@Transactional
	public PlanarExtension readPlanarExtensionById(Integer planarExtensionId){
		Object[] param = { planarExtensionId };
		Map<String, Object> planarExtensionMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readPlanarExtensionByIdSql, param);
		return buildPlanarExtension(planarExtensionMap);
	}
	
	/**
	 * 
	 * @param name
	 * @return planarExtension
	 */
	public PlanarExtension readPlanarExtensionName(String name){
		Object[] param = { name };
		Map<String, Object> planarExtensionMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readPlanarExtensionByPlanarNameSql, param);
		return buildPlanarExtension(planarExtensionMap);
	}
	
	/**
	 * 
	 * @param planarExtension
	 */
	public void deletePlanarExtension(PlanarExtension planarExtension) {
		super.jdbcSetUp().getSimpleJdbcTemplate().update(deletePlanarExtensionSql,
				new Object[] { planarExtension.getPlanarExtensionId() });

	}
	
	/**
	 * 
	 * @param planarExtension
	 * @return yes or no
	 */
	public Boolean doesPlanarExtensionExist(PlanarExtension planarExtension){
		Boolean answer = true;
		int count  = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(readPlanarByNameCountSql, planarExtension.getPlanarName());
		if(0 == count ){
			answer = false;
		}
		return answer;
	}
	
	/**
	 * 
	 * @param planarExtension
	 * @return planarExtension
	 */
	public PlanarExtension updatePlanarExtensionByName(PlanarExtension planarExtension){
		logger.info("updatePlanarExtension:"+planarExtension);

		Short emmisive = 0;
		if(planarExtension.getEmmisive().equals(Boolean.TRUE)){
			emmisive = 1;
		}
		super.jdbcSetUp().getSimpleJdbcTemplate().update(updatePlanarExtensionSql, new Object[]{
				 planarExtension.getPlanarExtensionId()
				 , planarExtension.getPlanarId()
				 , planarExtension.getPlanarName()
				 , planarExtension.getTexture()
				 , planarExtension.getNightTexture()
				 , planarExtension.getSemiMajorAxis()
				 , planarExtension.getEccentricity()
				 , planarExtension.getColor().rOfRGB
				 , planarExtension.getColor().gOfRGB
				 , planarExtension.getColor().bOfRGB
				 , planarExtension.getSpecularTexture()
				 , planarExtension.getSpecularPower()
				 , planarExtension.getHazeColor().rOfRGB
				 , planarExtension.getHazeColor().gOfRGB
				 , planarExtension.getHazeColor().bOfRGB
				 , planarExtension.getHazeDensity()
				 , planarExtension.getOblateness()
				 , planarExtension.getAtmosphereHeight()
				 , planarExtension.getLower().rOfRGB
				 , planarExtension.getLower().gOfRGB
				 , planarExtension.getLower().bOfRGB
				 , planarExtension.getUpper().rOfRGB
				 , planarExtension.getUpper().gOfRGB
				 , planarExtension.getUpper().bOfRGB
				 , planarExtension.getSky().rOfRGB
				 , planarExtension.getSky().gOfRGB
				 , planarExtension.getSky().bOfRGB
				 , planarExtension.getCloudHeight()
				 , planarExtension.getCloudSpeed()
				 , planarExtension.getCloudMap()
				 , planarExtension.getPeriod()
				 , planarExtension.getSemiMajorAxis()
				 , planarExtension.getEccentricity()
				 , planarExtension.getInclination()
				 , planarExtension.getLongOfPericenter()
				 , planarExtension.getMeanLongitude()
				 , planarExtension.getObliquity()
				 , planarExtension.getRotationPeriod()
				 , planarExtension.getAlbedo()
				 , planarExtension.getPlanarClass()
				 , emmisive
				 , planarExtension.getBumpMap()
				 , planarExtension.getBumpHeight()
				 , planarExtension.getSpecularColor().rOfRGB
				 , planarExtension.getSpecularColor().gOfRGB
				 , planarExtension.getSpecularColor().bOfRGB
				 , planarExtension.getDateStamp()
				 , planarExtension.getPlanarName()

		});
		return readPlanarExtensionName(planarExtension.getPlanarName());
	}
	
	/**
	 * 
	 * @param planarExtensionMap
	 * @return planarExtension
	 */
	private PlanarExtension buildPlanarExtension(Map<String, Object> planarExtensionMap){
		PlanarExtension planarExtension = new PlanarExtension();
		String s_PlanarExtensionId = planarExtensionMap.get(PLANETOIDEXTENSIONID).toString();
		planarExtension.setPlanarExtensionId(new Integer(s_PlanarExtensionId));
		String s_PlanetoidId = planarExtensionMap.get(PLANETOIDID).toString();
		planarExtension.setPlanarId(new Integer(s_PlanetoidId));
		planarExtension.setPlanarName(planarExtensionMap.get(PLANETOIDNAME).toString());
		planarExtension.setTexture(planarExtensionMap.get(TEXTURE).toString());
		planarExtension.setNightTexture(planarExtensionMap.get(NIGHTTEXTURE).toString());
		String s_SemiMajorAxis = planarExtensionMap.get(SEMIMAJORAXIS).toString();
		planarExtension.setSemiMajorAxis(new Double(s_SemiMajorAxis));
		String s_Eccentricity = planarExtensionMap.get(ECCENTRICITY).toString();
		planarExtension.setEccentricity(new Double(s_Eccentricity));
		String s_ColorR = planarExtensionMap.get(COLORR).toString();
		String s_ColorG = planarExtensionMap.get(COLORG).toString();
		String s_ColorB = planarExtensionMap.get(COLORB).toString();
		OGL_Color colorRGB = planarExtension.new OGL_Color();
		colorRGB.rOfRGB = new Double(s_ColorR);
		colorRGB.gOfRGB = new Double(s_ColorG);
		colorRGB.bOfRGB = new Double(s_ColorB);
		planarExtension.setColor(colorRGB);
		planarExtension.setSpecularTexture(planarExtensionMap.get(SPECULARTEXTURE).toString());
		String s_SpecularPower = planarExtensionMap.get(SPECULARPOWER).toString();
		planarExtension.setSpecularPower(new Double (s_SpecularPower));
		String s_HazeColorR = planarExtensionMap.get(HAZECOLORR).toString();
		String s_HazeColorG = planarExtensionMap.get(HAZECOLORG).toString();
		String s_HazeColorB = planarExtensionMap.get(HAZECOLORB).toString();
		OGL_Color hazeColorRGB = planarExtension.new OGL_Color();
		hazeColorRGB.rOfRGB = new Double(s_HazeColorR);
		hazeColorRGB.gOfRGB = new Double(s_HazeColorG);
		hazeColorRGB.bOfRGB = new Double(s_HazeColorB);
		planarExtension.setHazeColor(hazeColorRGB);
		String s_HazeDensity = planarExtensionMap.get(HAZEDENSITY).toString();
		planarExtension.setHazeDensity(new Double(s_HazeDensity));
		String s_Oblateness = planarExtensionMap.get(OBLATENESS).toString();
		planarExtension.setOblateness(new Double(s_Oblateness));
		String s_AtmosphereHeight = planarExtensionMap.get(ATMOSPHEREHEIGHT).toString();
		planarExtension.setAtmosphereHeight(new Integer(s_AtmosphereHeight));
		String s_AtmosphereLowerColorR = planarExtensionMap.get(ATMOSPHERELOWERR).toString();
		String s_AtmosphereLowerColorG = planarExtensionMap.get(ATMOSPHERELOWERG).toString();
		String s_AtmosphereLowerColorB = planarExtensionMap.get(ATMOSPHERELOWERB).toString();
		OGL_Color atmosphereLowerColorRGB = planarExtension.new OGL_Color();
		atmosphereLowerColorRGB.rOfRGB = new Double(s_AtmosphereLowerColorR);
		atmosphereLowerColorRGB.gOfRGB = new Double(s_AtmosphereLowerColorG);
		atmosphereLowerColorRGB.bOfRGB = new Double(s_AtmosphereLowerColorB);
		planarExtension.setLower(atmosphereLowerColorRGB);
		String s_AtmosphereUpperColorR = planarExtensionMap.get(ATMOSPHEREUPPERR).toString();
		String s_AtmosphereUpperColorG = planarExtensionMap.get(ATMOSPHEREUPPERG).toString();
		String s_AtmosphereUpperColorB = planarExtensionMap.get(ATMOSPHEREUPPERB).toString();
		OGL_Color atmosphereUpperColorRGB = planarExtension.new OGL_Color();
		atmosphereUpperColorRGB.rOfRGB = new Double(s_AtmosphereUpperColorR);
		atmosphereUpperColorRGB.gOfRGB = new Double(s_AtmosphereUpperColorG);
		atmosphereUpperColorRGB.bOfRGB = new Double(s_AtmosphereUpperColorB);
		planarExtension.setUpper(atmosphereUpperColorRGB);
		String s_AtmosphereSkyColorR = planarExtensionMap.get(ATMOSPHERESKYR).toString();
		String s_AtmosphereSkyColorG = planarExtensionMap.get(ATMOSPHERESKYG).toString();
		String s_AtmosphereSkyColorB = planarExtensionMap.get(ATMOSPHERESKYB).toString();
		OGL_Color atmosphereSkyColorRGB = planarExtension.new OGL_Color();
		atmosphereSkyColorRGB.rOfRGB = new Double(s_AtmosphereSkyColorR);
		atmosphereSkyColorRGB.gOfRGB = new Double(s_AtmosphereSkyColorG);
		atmosphereSkyColorRGB.bOfRGB = new Double(s_AtmosphereSkyColorB);
		planarExtension.setSky(atmosphereSkyColorRGB);
		String s_CloudHeight = planarExtensionMap.get(CLOUDHEIGHT).toString();
		planarExtension.setCloudHeight(new Integer(s_CloudHeight));
		String s_CloudSpeed = planarExtensionMap.get(CLOUDSPEED).toString();
		planarExtension.setCloudSpeed(new Integer(s_CloudSpeed));
		planarExtension.setCloudMap(planarExtensionMap.get(CLOUDMAP).toString());
		String s_OrbitPeriod = planarExtensionMap.get(ORBITPERIOD).toString();
		planarExtension.setPeriod(new Double(s_OrbitPeriod));
		String s_OrbitSemiMajorAxis = planarExtensionMap.get(ORBITSEMIMAJORAXIS).toString();
		planarExtension.setSemiMajorAxis(new Double(s_OrbitSemiMajorAxis));
		String s_OrbitEccentricity = planarExtensionMap.get(ORBITECCENTRICITY).toString();
		planarExtension.setEccentricity(new Double(s_OrbitEccentricity));
		String s_OrbitInclination = planarExtensionMap.get(ORBITINCLINATION).toString();
		planarExtension.setInclination(new Double(s_OrbitInclination));
		String s_OrbitLongOfPeriCentre = planarExtensionMap.get(ORBITLONGOFPERICENTRE).toString();
		planarExtension.setLongOfPericenter(new Double(s_OrbitLongOfPeriCentre));
		String s_OrbitMeanLongitude = planarExtensionMap.get(ORBITMEANLONGITUDE).toString();
		planarExtension.setMeanLongitude(new Double(s_OrbitMeanLongitude));
//		String s_Obliquity = planarExtensionMap.get(OBLIQUITY).toString();
//		planarExtension.setObliquity(new Double(s_Obliquity));
//		String s_RotationPeriod = planarExtensionMap.get(ROTATIONPERIOD).toString();
//		planarExtension.setRotationPeriod(new Double(s_RotationPeriod));
		String s_Albedo = planarExtensionMap.get(ALBEDO).toString();
		planarExtension.setAlbedo(new Double(s_Albedo));
		String planarClass = planarExtensionMap.get(PLANAR_CLASS).toString();
		planarExtension.setPlanarClass(PlanarClass.PLANET);
		if(planarClass.equals("moon")){
			planarExtension.setPlanarClass(PlanarClass.MOON);  // refactor into PlanarClass
		}
		String s_emmisive = planarExtensionMap.get(EMMISIVE).toString();
		if(s_emmisive.equals("0")){
			planarExtension.setEmmisive(Boolean.FALSE);
		}
		else{
			planarExtension.setEmmisive(Boolean.TRUE);
		}
		planarExtension.setDateStamp(planarExtensionMap.get(DATESTAMP).toString());
		planarExtension.setBumpMap(planarExtensionMap.get(BUMP_MAP).toString());
		String s_bumpHeight = planarExtensionMap.get(BUMP_HEIGHT).toString();
		planarExtension.setBumpHeight(new Double(s_bumpHeight));
		String s_SpecularColorR = planarExtensionMap.get(SPECULAR_COLORR).toString();
		String s_SpecularColorG = planarExtensionMap.get(SPECULAR_COLORG).toString();
		String s_SpecularColorB = planarExtensionMap.get(SPECULAR_COLORB).toString();
		OGL_Color specularColor = planarExtension.new OGL_Color();
		specularColor.rOfRGB = new Double(s_SpecularColorR);
		specularColor.gOfRGB = new Double(s_SpecularColorG);
		specularColor.bOfRGB = new Double(s_SpecularColorB);
		planarExtension.setSpecularColor(specularColor);
		return planarExtension;
	}
}
