package components;

import java.util.ArrayList;
import java.util.List;

import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.GradientPointParameter;
import libnoiseforjava.util.ColorCafe;

public interface LowSeaLevelPlanarTerranIF {
	
	public static Double sea_level = -0.6;
	
	public static Double shelf_level = -0.775; // must be less than sea level 
	
	public static Double min_elev = -8192.0;
	// maximum elevation on the planet, in meters. this value is approximate.
	public static Double max_elev = 8192.0;
	// sea level calculation parameters
	public static Double parameter0 = 1.0;
	public static Double parameter1 = 2.0;
	// calculate the sea level, in meters
	public static Double seaLevelInMeters = (((sea_level + parameter0) / parameter1) * (max_elev - min_elev))
			+ min_elev;

	static public Double deep_sea_level = -64.0;
	static public Double mountains_amount = 0.8;


	// surface map
	static List<GradientPointParameter> gradientPointList = new ArrayList<GradientPointParameter>();
	static List<ControlPoint> controlPoints = new ArrayList<ControlPoint>();
	static List<ControlPoint> badLandCLiffsControlPoints = new ArrayList<ControlPoint>();
	static List<Double> badLandsTerraceControlPoints = new ArrayList<Double>();
	static List<ControlPoint> riverPositionControlPoints0 = new ArrayList<ControlPoint>();
	static List<ControlPoint> riverPositionControlPoints1 = new ArrayList<ControlPoint>();
	static List<ControlPoint> continentsMountainsControlPoints = new ArrayList<ControlPoint>();

	abstract class AbstractPlanarTerran {

		static {
			GradientPointParameter gradientPointParameter = new GradientPointParameter(-16384.0 + seaLevelInMeters,
					new ColorCafe(3, 29, 63, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(deep_sea_level + seaLevelInMeters,
					new ColorCafe(3, 29, 63, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(-1.0 + seaLevelInMeters,
					new ColorCafe(7, 106, 127, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(0.0 + seaLevelInMeters, new ColorCafe(62, 86, 30, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(1024.0 + seaLevelInMeters,
					new ColorCafe(84, 96, 50, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(2048.0 + seaLevelInMeters,
					new ColorCafe(130, 127, 97, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(3072.0 + seaLevelInMeters,
					new ColorCafe(184, 163, 141, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(4096.0 + seaLevelInMeters,
					new ColorCafe(255, 255, 255, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(6144.0 + seaLevelInMeters,
					new ColorCafe(128, 255, 255, 255));
			gradientPointList.add(gradientPointParameter);
			gradientPointParameter = new GradientPointParameter(16384.0 + seaLevelInMeters,
					new ColorCafe(0, 0, 255, 255));
			gradientPointList.add(gradientPointParameter);

		}

		static {
			ControlPoint controlPoint = new ControlPoint();
			controlPoint.inputValue = -2.0000;
			controlPoint.outputValue = -1.625;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -1.0000;
			controlPoint.outputValue = -1.375;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.0000;
			controlPoint.outputValue = -0.375;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.0625;
			controlPoint.outputValue = 0.125;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.1250;
			controlPoint.outputValue = 0.250;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.2500;
			controlPoint.outputValue = 1.000;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.5000;
			controlPoint.outputValue = 0.2500;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.7500;
			controlPoint.outputValue = 0.2500;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 1.0000;
			controlPoint.outputValue = 0.500;
			controlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 2.0000;
			controlPoint.outputValue = 0.500;
			controlPoints.add(controlPoint);

		}

		static {
			ControlPoint controlPoint = new ControlPoint();
			controlPoint.inputValue = -2.0000;
			controlPoint.outputValue = -2.0000;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -1.0000;
			controlPoint.outputValue = -1.2500;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -0.0000;
			controlPoint.outputValue = -0.7500;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.5000;
			controlPoint.outputValue = -0.2500;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.6250;
			controlPoint.outputValue = 0.8750;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.7500;
			controlPoint.outputValue = 1.0000;
			badLandCLiffsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 2.0000;
			controlPoint.outputValue = 1.2500;
			badLandCLiffsControlPoints.add(controlPoint);
		}

		static {
			badLandsTerraceControlPoints.add(-1.0000);
			badLandsTerraceControlPoints.add(-0.8750);
			badLandsTerraceControlPoints.add(-0.7500);
			badLandsTerraceControlPoints.add(-0.5000);
			badLandsTerraceControlPoints.add(1.0000);
		}

		static {
			ControlPoint controlPoint = new ControlPoint();
			controlPoint.inputValue = -2.0000;
			controlPoint.outputValue = 2.0000;
			riverPositionControlPoints0.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -1.0000;
			controlPoint.outputValue = 1.0000;
			riverPositionControlPoints0.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -0.1250;
			controlPoint.outputValue = 0.785;
			riverPositionControlPoints0.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.0000;
			controlPoint.outputValue = 1.0000;
			riverPositionControlPoints0.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 1.0000;
			controlPoint.outputValue = -1.5000;
			riverPositionControlPoints0.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 2.0000;
			controlPoint.outputValue = -2.0000;
			riverPositionControlPoints0.add(controlPoint);
		}

		static {
			ControlPoint controlPoint = new ControlPoint();
			controlPoint.inputValue = -2.0000;
			controlPoint.outputValue = 2.0000;
			riverPositionControlPoints1.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -1.0000;
			controlPoint.outputValue = 1.5000;
			riverPositionControlPoints1.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = -0.1250;
			controlPoint.outputValue = 0.4375;
			riverPositionControlPoints1.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.0000;
			controlPoint.outputValue = 0.5000;
			riverPositionControlPoints1.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 1.0000;
			controlPoint.outputValue = 0.2500;
			riverPositionControlPoints1.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 2.0000;
			controlPoint.outputValue = 0.0000;
			riverPositionControlPoints1.add(controlPoint);
		}

		static {
			ControlPoint controlPoint = new ControlPoint();
			controlPoint.inputValue = -1.0000;
			controlPoint.outputValue = -0.0625;
			continentsMountainsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 0.0000;
			controlPoint.outputValue = 0.0000;
			continentsMountainsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 1.0 - mountains_amount;
			controlPoint.outputValue = 0.0625;
			continentsMountainsControlPoints.add(controlPoint);
			controlPoint = new ControlPoint();
			controlPoint.inputValue = 1.0000;
			controlPoint.outputValue = 0.2500;
			continentsMountainsControlPoints.add(controlPoint);
		}

	}

}
