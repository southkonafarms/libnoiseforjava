package celestia;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

public class RightAcsensionEtDeclinationTest {
	private static Logger logger = Logger.getLogger(RightAcsensionEtDeclinationTest.class);
	

	@Test
	public void test() {
		Double degree0 = RightAscension.buildRightAcension(new Double(3040), new Double(71899));
		logger.info("for 3040 and 71899 angle:" + degree0);
		Double degree1 = RightAscension.buildRightAcension(new Double(75772), new Double(89143));
		logger.info("for 75772 and 89143 angle:" + degree1);
		Double degree2 = RightAscension.buildRightAcension(new Double(28987), new Double(3414));
		logger.info("for 28987 and 3414 angle:" + degree2);
		
		Double declenation0 = Declension.determineQuadrant(degree0);
		logger.info("for 3040 and 71899 declenation:" + declenation0);
		Double declenation1 = Declension.determineQuadrant(degree1);
		logger.info("for 75772 and 89143 declenaton:" + declenation1);
		Double declenation2 = Declension.determineQuadrant(degree2);
		logger.info("for 28987 and 3414 declenaton:" + declenation2);

	}

}
