package celestia;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

public class OblatenessTest {
	
	private static Logger logger = Logger.getLogger(OblatenessTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();
		String starName = starDao.readNameOfRandomStar();
		Star star = starDao.readStarByName(starName);
		List<UnifiedPlanetoidI> planetoids = planetoidDao.readPlanetoidsAroundStar(star);
		for (UnifiedPlanetoidI unifiedPlanetoidI : planetoids) {
			Double oblateness = Oblateness.build(unifiedPlanetoidI);
			logger.info("planar:" + unifiedPlanetoidI.getPlanetoid().getPlanetoidName() + " radiius: "
					+ unifiedPlanetoidI.getPlanetoid().getRadius() + " oblateness:" + oblateness);
			assertTrue(oblateness != null);
		}
	}

}
