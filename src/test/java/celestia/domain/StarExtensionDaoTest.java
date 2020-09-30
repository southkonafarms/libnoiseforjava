package celestia.domain;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StarExtensionDaoTest {
	
	private static Logger logger = Logger.getLogger(StarExtensionDaoTest.class);
	
	public static Integer starId = new Integer(3340);
	public static String starName = "Star.Cluster.THREESTAR_TRINARY.20401.20121.0";
	public static Double period = new Double(4541.131907607);
	public static Double semiMajorAxis = new Double(9706313.014653586);
	public static Double eccentricity = new Double(0.3482509872512699);
	public static Double ascendingNode = new Double(8.20362347892595);
	public static Double inclination = new Double(132.72055166010088);
	public static Double apparantMagnitude = new Double(1.5308);

	@Test
	public void addReadAndDeleteTest() {
		StarExtensionDao starExtensionDao = new StarExtensionDao();
		StarExtension starExtension = new StarExtension(null, starId, starName, period, semiMajorAxis, 
				eccentricity, ascendingNode, inclination, apparantMagnitude);
		StarExtension starExtension_result = starExtensionDao.addStarExtension(starExtension);
		logger.info("addReadAndDeleteTest:" + starExtension_result);
		assertTrue(starExtension_result.getStarExtensionId() != null);
		starExtensionDao.deleteStarExtension(starExtension_result);
	}
	@Test
	public void addReadUpdateAndDeleteTest() {
		StarExtensionDao starExtensionDao = new StarExtensionDao();
		StarExtension starExtension = new StarExtension(null, starId, starName, period, semiMajorAxis, 
				eccentricity, ascendingNode, inclination, apparantMagnitude);
		StarExtension starExtension_result = starExtensionDao.addStarExtension(starExtension);
		logger.info(starExtension_result);
		assertTrue(starExtension_result.getStarExtensionId() != null);
		Boolean doesSystemExist = starExtensionDao.doesStarExtensionExist(starExtension_result);
		assertTrue(doesSystemExist);
		starExtension_result.setApparantMagnitude(starExtension.getApparantMagnitude()+2.0);
		starExtension_result = starExtensionDao.updateStarExtensionByStarName(starExtension_result);
		logger.info("addReadUpdateAndDeleteTest:"+starExtension_result);
		assertTrue(starExtension_result.getStarExtensionId() != null);
		starExtensionDao.deleteStarExtension(starExtension_result);
	}

}
