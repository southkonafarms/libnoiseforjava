package celestia;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.PlanetoidDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

import celestia.domain.CelestAtmosphere;

public class PlanarAlbedoTest {
	
	private static Logger logger = Logger.getLogger(PlanarAlbedoTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		PlanetoidDao planetoidDao = new PlanetoidDao();
		String starName = starDao.readNameOfRandomStar();
		Star star = starDao.readStarByName(starName);
		List<UnifiedPlanetoidI> planetoids = planetoidDao.readPlanetoidsAroundStar(star);
		for(UnifiedPlanetoidI unifiedPlanetoidI : planetoids){
			Double albedo = PlanarAlbedo.genAlbedoPlanar(unifiedPlanetoidI);
			logger.info("planar:"+unifiedPlanetoidI.getPlanetoid().getPlanetoidName()+ " planarAlbedo" + albedo);
			assertTrue(albedo != null);
		}
	}

}
