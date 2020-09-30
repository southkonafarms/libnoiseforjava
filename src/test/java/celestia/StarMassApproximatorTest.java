package celestia;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

public class StarMassApproximatorTest {
	
	private static Logger logger = Logger.getLogger(StarMassApproximatorTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		String starName = starDao.readNameOfRandomStar();
		Star star = starDao.readStarByName(starName);
		Double mass = StarMassApproximator.genStarMass(star.getStar_type());
		logger.info("Star:"+star.getName() + "mStar type:" + star.getStar_type() + " Star Mass:" + mass);
		assertTrue(mass != null);
	}

}
