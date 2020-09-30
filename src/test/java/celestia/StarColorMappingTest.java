package celestia;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;

import celestia.domain.ColorRGB;

public class StarColorMappingTest {
	
	private static Logger logger = Logger.getLogger(StarColorMappingTest.class);

	@Test
	public void test() {
		StarDao starDao = new StarDao();
		String starName = starDao.readNameOfRandomStar();
		Star star = starDao.readStarByName(starName);
		ColorRGB colorRGB = StarColorMapping.mapStarColor(star.getStar_color());
		assertTrue(null != colorRGB);
		logger.info("StarColor:" + star.getStar_color() + " ColorRGB:"+colorRGB);
	}

}
