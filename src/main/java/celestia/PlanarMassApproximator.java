package celestia;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.AstronomicalUnits;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

public class PlanarMassApproximator {

	private static Logger logger = Logger.getLogger(PlanarMassApproximator.class);

	public static Double genPlanarMass(UnifiedPlanetoidI unifiedPlanetoidI) {
		Double planetMass = unifiedPlanetoidI.getPlanetoid().getRadius() / AstronomicalUnits.EARTH_RADIUS
				* AstronomicalUnits.EARTH_MASS;
		logger.info("planar Mass:" + planetMass);
		return planetMass;
	}
}
