package celestia.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.util.GenName;
import com.zenred.util.GenRandomRolls;

import celestia.domain.PlanarExtension.OGL_Color;
import celestia.domain.PlanarExtension.PlanarClass;

public class PlanarExtensionDaoTest {
	
	private static Logger logger = Logger.getLogger(PlanarExtensionDaoTest.class);
	private static String PLANAR_NAME;
	static{
		GenName.setPrefix("Planar_");
		PLANAR_NAME = GenName.generate(10);
	}
	
	private static Integer PLANAR_ID = GenRandomRolls.Instance().getD100000();
	private static String TEXTURE = GenName.generate(12);
	private static String NIGHT_TEXTURE = GenName.generate(13);
	private static Double SEMI_MAJOR_AXIS = GenRandomRolls.Instance().draw_rand();
	private static Double ECCENTRICITY = GenRandomRolls.Instance().draw_rand(); 
	private static Double COLOR_R = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double COLOR_G = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double COLOR_B = new Double( GenRandomRolls.Instance().draw_rand());
	private static String SPECULAR_TEXTURE = GenName.generate(20);
	private static Double SPECULAR_POWER = GenRandomRolls.Instance().draw_rand()*100.0;
	private static Double HAZE_COLOR_R = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double HAZE_COLOR_G = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double HAZE_COLOR_B = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double HAZE_DENSITY = new Double(GenRandomRolls.Instance().draw_rand());
	private static Double OBLATENESS = GenRandomRolls.Instance().draw_rand();
	private static Integer ATMOSPHERE_HEIGHT = GenRandomRolls.Instance().getD100();
	private static Double LOWER_COLOR_R = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double LOWER_COLOR_G = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double LOWER_COLOR_B = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double UPPER_COLOR_R = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double UPPER_COLOR_G = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double UPPER_COLOR_B = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double SKY_COLOR_R = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double SKY_COLOR_G = new Double( GenRandomRolls.Instance().draw_rand());
	private static Double SKY_COLOR_B = new Double( GenRandomRolls.Instance().draw_rand());
	private static Integer CLOUD_HEIGHT = GenRandomRolls.Instance().getD100();
	private static Integer CLOUD_SPEED = GenRandomRolls.Instance().getD100();
	private static String CLOUD_MAP = GenName.generate(18);
	private static Double ORBIT_PERIOD = GenRandomRolls.Instance().draw_rand();
	private static Double ORBIT_INCLINATION = GenRandomRolls.Instance().draw_rand();
	private static Double ORBIT_LONG_OF_PERICENTRE = GenRandomRolls.Instance().draw_rand();
	private static Double ORBIT_OF_MEAN_LONGITUDE = GenRandomRolls.Instance().draw_rand();
	private static Double OBLIQUITY = GenRandomRolls.Instance().draw_rand();
	private static Double ROTATION_PERIOD = GenRandomRolls.Instance().draw_rand();
	private static Double ALBEDO = GenRandomRolls.Instance().draw_rand();
	private static Double RADIUS = GenRandomRolls.Instance().draw_rand() * 2000.0 + 3000.0;
	private static Short EMMISIVE = new Short("1");
	private static String BUMP_MAP = GenName.generate(8);
	private static Double BUMP_HEIGHT = GenRandomRolls.Instance().draw_rand();
	private static Double SPECULAR_COLORR = GenRandomRolls.Instance().draw_rand();
	private static Double SPECULAR_COLORG = GenRandomRolls.Instance().draw_rand();
	private static Double SPECULAR_COLORB = GenRandomRolls.Instance().draw_rand();
	
	
	@Test
	public void addReadAndDeleteTest() {
		
		PlanarExtensionDao planarExtensionDao = new PlanarExtensionDao();
		PlanarExtension planarExtension = new PlanarExtension();
		
		OGL_Color ogl_Color = planarExtension.new OGL_Color();
		ogl_Color.rOfRGB = COLOR_R;
		ogl_Color.gOfRGB = COLOR_G;
		ogl_Color.bOfRGB = COLOR_B;
		OGL_Color hazeColor = planarExtension.new OGL_Color();
		hazeColor.rOfRGB = HAZE_COLOR_R;
		hazeColor.gOfRGB = HAZE_COLOR_G;
		hazeColor.bOfRGB = HAZE_COLOR_B;
		OGL_Color lowerColor = planarExtension.new OGL_Color();
		lowerColor.rOfRGB = LOWER_COLOR_R;
		lowerColor.gOfRGB = LOWER_COLOR_G;
		lowerColor.bOfRGB = LOWER_COLOR_B;
		OGL_Color upperColor = planarExtension.new OGL_Color();
		upperColor.rOfRGB = UPPER_COLOR_R;
		upperColor.gOfRGB = UPPER_COLOR_G;
		upperColor.bOfRGB = UPPER_COLOR_B;
		OGL_Color skyColor = planarExtension.new OGL_Color();
		skyColor.rOfRGB = SKY_COLOR_R;
		skyColor.gOfRGB = SKY_COLOR_G;
		skyColor.bOfRGB = SKY_COLOR_B;
		OGL_Color specularColor = planarExtension.new OGL_Color();
		specularColor.rOfRGB = SPECULAR_COLORR;
		specularColor.gOfRGB = SPECULAR_COLORG;
		specularColor.bOfRGB = SPECULAR_COLORB;
		
		planarExtension.setAlbedo(ALBEDO);
		planarExtension.setAtmosphereHeight(ATMOSPHERE_HEIGHT);
		planarExtension.setCloudHeight(CLOUD_HEIGHT);
		planarExtension.setCloudMap(CLOUD_MAP);
		planarExtension.setCloudSpeed(CLOUD_SPEED);
		planarExtension.setColor(ogl_Color);
		planarExtension.setEccentricity(ECCENTRICITY);
		planarExtension.setHazeColor(hazeColor);
		planarExtension.setHazeDensity(HAZE_DENSITY);
		planarExtension.setInclination(ORBIT_INCLINATION);
		planarExtension.setLongOfPericenter(ORBIT_LONG_OF_PERICENTRE);
		planarExtension.setLower(lowerColor);
		planarExtension.setMeanLongitude(ORBIT_OF_MEAN_LONGITUDE);
		planarExtension.setNightTexture(NIGHT_TEXTURE);
		planarExtension.setOblateness(OBLATENESS);
		planarExtension.setObliquity(OBLIQUITY);
		planarExtension.setPeriod(ORBIT_PERIOD);
		planarExtension.setPlanarClass(PlanarClass.PLANET);
		planarExtension.setPlanarId(PLANAR_ID);
		planarExtension.setPlanarName(PLANAR_NAME);
		planarExtension.setRadius(RADIUS);
		planarExtension.setRotationPeriod(ROTATION_PERIOD);
		planarExtension.setSemiMajorAxis(SEMI_MAJOR_AXIS);
		planarExtension.setSky(skyColor);
		planarExtension.setSpecularPower(SPECULAR_POWER);
		planarExtension.setSpecularTexture(SPECULAR_TEXTURE);
		planarExtension.setTexture(TEXTURE);
		planarExtension.setUpper(upperColor);
		planarExtension.setEmmisive(EMMISIVE== 1? Boolean.TRUE : Boolean.FALSE);
		planarExtension.setBumpMap(BUMP_MAP);
		planarExtension.setBumpHeight(BUMP_HEIGHT);
		planarExtension.setSpecularColor(specularColor);
		
		planarExtension = planarExtensionDao.addPlanarExtension(planarExtension);
		logger.info("Planar Extension:" + planarExtension);
		assertTrue(planarExtension.getPlanarExtensionId() != null);
		planarExtensionDao.deletePlanarExtension(planarExtension);
	}


	@Test
	public void addReadUpdateAndDeleteTest() {
		PlanarExtensionDao planarExtensionDao = new PlanarExtensionDao();
		PlanarExtension planarExtension = new PlanarExtension();
		
		OGL_Color ogl_Color = planarExtension.new OGL_Color();
		ogl_Color.rOfRGB = COLOR_R;
		ogl_Color.gOfRGB = COLOR_G;
		ogl_Color.bOfRGB = COLOR_B;
		OGL_Color hazeColor = planarExtension.new OGL_Color();
		hazeColor.rOfRGB = HAZE_COLOR_R;
		hazeColor.gOfRGB = HAZE_COLOR_G;
		hazeColor.bOfRGB = HAZE_COLOR_B;
		OGL_Color lowerColor = planarExtension.new OGL_Color();
		lowerColor.rOfRGB = LOWER_COLOR_R;
		lowerColor.gOfRGB = LOWER_COLOR_G;
		lowerColor.bOfRGB = LOWER_COLOR_B;
		OGL_Color upperColor = planarExtension.new OGL_Color();
		upperColor.rOfRGB = UPPER_COLOR_R;
		upperColor.gOfRGB = UPPER_COLOR_G;
		upperColor.bOfRGB = UPPER_COLOR_B;
		OGL_Color skyColor = planarExtension.new OGL_Color();
		skyColor.rOfRGB = SKY_COLOR_R;
		skyColor.gOfRGB = SKY_COLOR_G;
		skyColor.bOfRGB = SKY_COLOR_B;
		OGL_Color specularColor = planarExtension.new OGL_Color();
		specularColor.rOfRGB = SPECULAR_COLORR;
		specularColor.gOfRGB = SPECULAR_COLORG;
		specularColor.bOfRGB = SPECULAR_COLORB;
		
		planarExtension.setAlbedo(ALBEDO);
		planarExtension.setAtmosphereHeight(ATMOSPHERE_HEIGHT);
		planarExtension.setCloudHeight(CLOUD_HEIGHT);
		planarExtension.setCloudMap(CLOUD_MAP);
		planarExtension.setCloudSpeed(CLOUD_SPEED);
		planarExtension.setColor(ogl_Color);
		planarExtension.setEccentricity(ECCENTRICITY);
		planarExtension.setHazeColor(hazeColor);
		planarExtension.setHazeDensity(HAZE_DENSITY);
		planarExtension.setInclination(ORBIT_INCLINATION);
		planarExtension.setLongOfPericenter(ORBIT_LONG_OF_PERICENTRE);
		planarExtension.setLower(lowerColor);
		planarExtension.setMeanLongitude(ORBIT_OF_MEAN_LONGITUDE);
		planarExtension.setNightTexture(NIGHT_TEXTURE);
		planarExtension.setOblateness(OBLATENESS);
		planarExtension.setObliquity(OBLIQUITY);
		planarExtension.setPeriod(ORBIT_PERIOD);
		planarExtension.setPlanarClass(PlanarClass.PLANET);
		planarExtension.setPlanarId(PLANAR_ID);
		planarExtension.setPlanarName(PLANAR_NAME);
		planarExtension.setRadius(RADIUS);
		planarExtension.setRotationPeriod(ROTATION_PERIOD);
		planarExtension.setSemiMajorAxis(SEMI_MAJOR_AXIS);
		planarExtension.setSky(skyColor);
		planarExtension.setSpecularPower(SPECULAR_POWER);
		planarExtension.setSpecularTexture(SPECULAR_TEXTURE);
		planarExtension.setTexture(TEXTURE);
		planarExtension.setUpper(upperColor);
		planarExtension.setEmmisive(EMMISIVE== 1? Boolean.TRUE : Boolean.FALSE);
		planarExtension.setBumpMap(BUMP_MAP);
		planarExtension.setBumpHeight(BUMP_HEIGHT);
		planarExtension.setSpecularColor(specularColor);
		
		planarExtension = planarExtensionDao.addPlanarExtension(planarExtension);
		logger.info("Next Planar Extension:" + planarExtension);
		assertTrue(planarExtension.getPlanarExtensionId() != null);
		planarExtension.setAlbedo(GenRandomRolls.Instance().draw_rand());
		planarExtension = planarExtensionDao.updatePlanarExtensionByName(planarExtension);
		logger.info("Updated Planar Extension:" + planarExtension);
		assertTrue(planarExtension.getPlanarExtensionId() != null);
		planarExtensionDao.deletePlanarExtension(planarExtension);
	}
}
