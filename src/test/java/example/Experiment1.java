package example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.Builder;
import libnoiseforjava.domain.GradientPointParameter;
import libnoiseforjava.domain.RenderImageParameter;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Clamp;
import libnoiseforjava.module.Curve;
import libnoiseforjava.module.Min;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Spheres;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ColorCafe;
import libnoiseforjava.util.ImageCafe;
import libnoiseforjava.util.NoiseMap;
import libnoiseforjava.util.NoiseMapBuilderSphere;

public class Experiment1 {
	// Southernmost coordinate of elevation grid.
	private static Double SOUTH_COORD = -90.0;
	// Northernmost coordinate of elevation grid.
	private static Double NORTH_COORD = 90.0;
	// Westernmost coordinate of elevation grid.
	private static Double WEST_COORD = -180.0;
	// Easternmost coordinate of elevation grid.
	private static Double EAST_COORD = 180.0;
	// Width of elevation grid, in points
	private static Integer GRID_WIDTH = 2048;
	// Height of elevation grid, in points
	private static Integer GRID_HEIGHT = 1024;
	
	private static Double PLANET_CIRCUMFERENCE = 1236800.0;
	private static Double METERS_PER_DEGREE = PLANET_CIRCUMFERENCE / 360.0;


	static Double DEG_EXTENT = EAST_COORD - WEST_COORD;
	static Double GRID_EXTENT = new Double(GRID_WIDTH);
	// double resInMeters = (degExtent / gridExtent) * metersPerDegree;
	static Double RES_IN_METERS = (DEG_EXTENT / GRID_HEIGHT) * METERS_PER_DEGREE;
	static Double INVERSE_RES_IN_METERS = 1.0 / RES_IN_METERS;
	
	static Double LIGHT_CONTRAST = new Double(1.0/RES_IN_METERS);
	
	static List<GradientPointParameter> gradientPointList = new ArrayList<GradientPointParameter>();
	
	static{
		
		GradientPointParameter gradientPointParameter = new GradientPointParameter(-1.0000, new ColorCafe(0, 0, 128, 255));  //deeps
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(-0.2500, new ColorCafe(255, 204, 102, 255));  // shallow
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.0000, new ColorCafe(204, 163, 0, 255));  // not so shallow
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.0625, new ColorCafe(240, 240, 64, 255));  // sand
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.1250, new ColorCafe(255, 255, 102, 255));  // ground
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.3750, new ColorCafe(224, 224, 0, 255));  // dirt
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.7500, new ColorCafe(102, 51, 0, 255));  // rock
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(1.0000, new ColorCafe(255, 255, 255, 255));  // snow
		gradientPointList.add(gradientPointParameter);
		
	}
	
	private static Integer CUR_SEED = GenRandomRolls.Instance().getD1000();

	// Frequency of the planet's continents. Higher frequency produces smaller,
	// more numerous continents. This value is measured in radians.
	private static Double CONTINENT_FREQUENCY = 0.1;
	// The persistence value controls the roughness of the Perlin noise,
	// normally between 0.0 and 1.0
	private static Double BASE_CONTINENT_DEF_PERSISTENCE_0 = 0.7;
	private static Double BASE_CONTINENT_DEF_PERSISTENCE_1 = 0.7;
	// Lacunarity. from Latin meaning gap, or fill space
	// Lacunarity of the planet's continents. Changing this value produces
	// slightly different continents. For the best results, this value should
	// be random, but close to 2.0.
	private static Double CONTINENT_LACUNARITY = 2.908984375;
	// Octave count determines the amount of Perlin noise, the higher the count,
	// the more detail
	private static Integer BASE_CONTINENT_DEF_OCTAVE_COUNT_PE0 = 14;
	private static Integer BASE_CONTINENT_DEF_OCTAVE_COUNT_PE1 = 11;
	// level average
	private static Double P_LEVEL = 0.0;
	
	


	static private Perlin baseContinentDef_pe0 = new Perlin();
	static {
		baseContinentDef_pe0.setSeed(CUR_SEED);
		baseContinentDef_pe0.setFrequency(CONTINENT_FREQUENCY);
		baseContinentDef_pe0.setPersistence(BASE_CONTINENT_DEF_PERSISTENCE_0);
		baseContinentDef_pe0.setLacunarity(CONTINENT_LACUNARITY);
		baseContinentDef_pe0
				.setOctaveCount(BASE_CONTINENT_DEF_OCTAVE_COUNT_PE0);
		baseContinentDef_pe0.setNoiseQuality(NoiseQuality.QUALITY_STD);
	}

	
	
	// 2: [Continent-with-ranges module]: Next, a curve module modifies the
	// output value from the continent module so that very high values appear
	// near planet level average. This defines the positions of the mountain ranges.
	static private Curve baseContinentDef_cu = new Curve(baseContinentDef_pe0);
	static {
		baseContinentDef_cu.addControlPoint(-2.0000 + P_LEVEL, -1.625
				+ P_LEVEL);
		baseContinentDef_cu.addControlPoint(-1.0000 + P_LEVEL, -1.375
				+ P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.0000 + P_LEVEL, -0.375
				+ P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.0625 + P_LEVEL,
				0.125 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.1250 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.2500 + P_LEVEL,
				1.000 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.5000 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.7500 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(1.0000 + P_LEVEL,
				0.500 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(2.0000 + P_LEVEL,
				0.500 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(1.3000 + P_LEVEL,
				0.500 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.8500 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.5300 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.2800 + P_LEVEL,
				1.000 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.1550 + P_LEVEL,
				0.250 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.0925 + P_LEVEL,
				0.125 + P_LEVEL);
		baseContinentDef_cu.addControlPoint(0.3000 + P_LEVEL, -0.375
				+ P_LEVEL);
		baseContinentDef_cu.addControlPoint(-1.3000 + P_LEVEL, -1.375
				+ P_LEVEL);
		baseContinentDef_cu.addControlPoint(-2.3000 + P_LEVEL, -1.625
				+ P_LEVEL);

	}
	
	private static Double BASE_CONTINENT_DEF_BIAS = 0.625;
	// / Sets the scaling factor to apply to the output value from the
	// / source module.
	private static Double BASE_CONTINENT_DEF_SCALE = 0.375;
	// noise clamping bounds
	private static Double BASE_CONTINENT_DEF_CLAMP_LOWER_BOUND = -1.0;
	private static Double BASE_CONTINENT_DEF_CLAMP_UPPER_BOUND = 1.0;

	
	// 3: [Carver module]: This higher-frequency Perlin-noise module will be
	// used by subsequent noise modules to carve out chunks from the mountain
	// ranges within the continent-with-ranges module so that the mountain
	// ranges will not be complely impassible.

	static private Perlin baseContinentDef_pe1 = new Perlin();
	static {
		baseContinentDef_pe1.setSeed(CUR_SEED + 1);
		baseContinentDef_pe1.setFrequency(CONTINENT_FREQUENCY);
		baseContinentDef_pe1.setPersistence(BASE_CONTINENT_DEF_PERSISTENCE_1);
		baseContinentDef_pe1.setLacunarity(CONTINENT_LACUNARITY);
		baseContinentDef_pe1
				.setOctaveCount(BASE_CONTINENT_DEF_OCTAVE_COUNT_PE1);
		baseContinentDef_pe1.setNoiseQuality(NoiseQuality.QUALITY_STD);
	}
	
	// 4: [Scaled-carver module]: This scale/bias module scales the output
	// value from the carver module such that it is usually near 1.0. This
	// is required for step 5.

	static private ScaleBias baseContinentDef_sb = new ScaleBias(
			baseContinentDef_pe1);
	static {
		baseContinentDef_sb.setScale(BASE_CONTINENT_DEF_SCALE);
		baseContinentDef_sb.setBias(BASE_CONTINENT_DEF_BIAS);
	}


	// 5: [Carved-continent module]: This minimum-value module carves out chunks
	// from the continent-with-ranges module. It does this by ensuring that
	// only the minimum of the output values from the scaled-carver module
	// and the continent-with-ranges module contributes to the output value
	// of this subgroup. Most of the time, the minimum-value module will
	// select the output value from the continents-with-ranges module since
	// the output value from the scaled-carver module is usually near 1.0.
	// Occasionally, the output value from the scaled-carver module will be
	// less than the output value from the continent-with-ranges module, so
	// in this case, the output value from the scaled-carver module is
	// selected.
	static private Min baseContinentDef_mi = new Min(baseContinentDef_sb,
			baseContinentDef_cu);

	// 6: [Clamped-continent module]: Finally, a clamp module modifies the
	// carved-continent module to ensure that the output value of this
	// subgroup is between -1.0 and 1.0.

	static private Clamp baseContinentDef_cl = new Clamp(baseContinentDef_mi);
	static {
		baseContinentDef_cl.setBounds(BASE_CONTINENT_DEF_CLAMP_LOWER_BOUND,
				BASE_CONTINENT_DEF_CLAMP_UPPER_BOUND);
	}
	
	static private Spheres pools = new Spheres();
	static{
		pools.setFrequency(3.0);
	}
	
	static Add baseContinent_ad = new Add(pools, baseContinentDef_cl);

	static private Cached baseContinentDef = new Cached(baseContinent_ad);


	@Test
	public void test() {
		NoiseMapBuilderSphere planet = new NoiseMapBuilderSphere();
		NoiseMap elevGrid = new NoiseMap(GRID_WIDTH, GRID_HEIGHT);
	
			planet.setBounds(SOUTH_COORD, NORTH_COORD, WEST_COORD, EAST_COORD);
			planet.setDestSize(GRID_WIDTH, GRID_HEIGHT);

	

		planet.setSourceModule(baseContinentDef);
		planet.setDestNoiseMap(elevGrid);
		planet.build();
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, elevGrid, Boolean.FALSE, LIGHT_CONTRAST,
				LIGHT_CONTRAST);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/" + Math.random()
				+ "Experiment1.png";
		Output.writer(imageCafe, uri);

	}

}
