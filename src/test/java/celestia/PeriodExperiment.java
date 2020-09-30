package celestia;

import org.apache.log4j.Logger;

public class PeriodExperiment {
	
	static private Logger logger = Logger.getLogger(PeriodFirstExperiment.class);
	
	static private Double AUtoMeters = 149597871.0; 
	static private Double magicScalar = 320.0;	// derived by gosh and by golly
	static private Double earthMass = 5.9736e24;
	static private Double earthRadius = 12742.0/2.0;
	static private Double solarMass = 1.98555*10e30;

	public static void main(String[] args) {
		// planets
		Double period = Math.PI * 2.0 *Math.sqrt((Math.pow(0.378*AUtoMeters, 3)/(6.67408e-11*solarMass)));
		logger.info("period:"+period/magicScalar);
		Double period2 = Math.PI * 2.0 *Math.sqrt((Math.pow(0.723*AUtoMeters, 3)/(6.67408e-11*solarMass)));
		logger.info("period2:"+period2/magicScalar);
		Double period3 = Math.PI * 2.0 *Math.sqrt((Math.pow(149597871.0, 3)/(6.67408e-11*solarMass)));
		logger.info("period3:"+period3/magicScalar);
		Double period4 = Math.PI * 2.0 *Math.sqrt((Math.pow(1.524*AUtoMeters, 3)/(6.67408e-11*solarMass)));
		logger.info("period4:"+period4/magicScalar);
		Double period5 = Math.PI * 2.0 *Math.sqrt((Math.pow(5.203*AUtoMeters, 3)/(6.67408e-11*solarMass)));
		logger.info("period5:"+period5/magicScalar);
		Double period6 = Math.PI * 2.0 *Math.sqrt((Math.pow(5.203*AUtoMeters, 3)/(6.67408e-11*solarMass*5.0)));
		logger.info("period6:"+period6/magicScalar);
		
		// moons
		Double planetMass = 12017.937404191465 / earthRadius * earthMass;
		Double periodMoon = Math.PI * 2.0 *Math.sqrt((Math.pow(37386.15228864592, 3)/(6.67408e-11*1.98555*planetMass)));
		logger.info("moon period:" + periodMoon );
		planetMass = 6340.33 / earthRadius * earthMass;
		Double periodMoon2 = Math.PI * 2.0 *Math.sqrt((Math.pow(37386.15228864592, 3)/(6.67408e-11*1.98555*planetMass)));
		logger.info("moon period2:" + periodMoon2 );
		planetMass = 6340.33 / earthRadius * earthMass;
		Double periodMoon3 = Math.PI * 2.0 *Math.sqrt((Math.pow(137386.15228864592, 3)/(6.67408e-11*1.98555*planetMass)));
		logger.info("moon period3:" + periodMoon3 );
	}
	

}
