package components;

import java.util.List;

import libnoiseforjava.domain.GradientPointParameter;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.ScaleBias;

public abstract class Planar {

	
	protected List<GradientPointParameter> gradientPointList;
	protected static Double planetCircumference;
	
	/*
	 * default constants
	 */
	protected static Double continent_frequency = 1.0;
	// the persistence value controls the roughness of the perlin noise,
	// normally between 0.0 and 1.0
	protected static Double base_continent_def_persistence_0 = 0.5;
	protected static Double base_continent_def_persistence_1 = 0.5;
	// lacunarity. from latin meaning gap, or fill space
	// lacunarity of the planet's continents. changing this value produces
	// slightly different continents. for the best results, this value should
	// be random, but close to 2.0.
	protected static Double continent_lacunarity = 2.208984375;
	// octave count determines the amount of perlin noise, the higher the count,
	// the more detail
	protected static Integer base_continent_def_octave_count_pe0 = 3;
	protected static Integer base_continent_def_octave_count_pe1 = 3;
	// specifies the planet's sea level. this value must be between -1.0
	// (minimum planet elevation) and +1.0 (maximum planet elevation.)
	protected static Double sea_level = PlanarTerranIF.sea_level;
	// / sets the bias to apply to the scaled output value from the source
	// / module.
	protected static Double deep_sea_level = PlanarTerranIF.deep_sea_level;
	protected static Double base_continent_def_bias = 0.625;
	// / sets the scaling factor to apply to the output value from the
	// / source module.
	protected static Double base_continent_def_scale = 0.375;
	// noise clamping bounds
	protected static Double base_continent_def_clamp_lower_bound = -1.0;
	protected static Double base_continent_def_clamp_upper_bound = 1.0;
	// minimum elevation on the planet, in meters. this value is approximate.
	protected static Double min_elev = PlanarTerranIF.min_elev;
	// maximum elevation on the planet, in meters. this value is approximate.
	protected static Double max_elev = PlanarTerranIF.max_elev;
	// sea level calculation parameters
	protected static Double parameter0 = PlanarTerranIF.parameter0;
	protected static Double parameter1 = PlanarTerranIF.parameter1;
	// calculate the sea level, in meters
	protected static Double seaLevelInMeters = PlanarTerranIF.seaLevelInMeters;
	// southernmost coordinate of elevation grid.
	protected static Double south_coord = -90.0;
	// northernmost coordinate of elevation grid.
	protected static Double north_coord = 90.0;
	// westernmost coordinate of elevation grid.
	protected static Double west_coord = -180.0;
	// easternmost coordinate of elevation grid.
	protected static Double east_coord = 180.0;
	// width of elevation grid, in points
	protected static Integer grid_width = 2048;
	// height of elevation grid, in points
	protected static Integer grid_height = 1024;

	protected static Double planet_circumference = 44236800.0;
	protected static Double meters_per_degree = planet_circumference / 360.0;

	// offset to apply to the terrain type definition. low values (< 1.0) cause
	// the rough areas to appear only at high elevations. high values (> 2.0)
	// cause the rough areas to appear at any elevation. the percentage of
	// rough areas on the planet are independent of this value.
	protected static Double terrain_offset = 1.0;


	protected static Double lightbrightness = new Double(2.0);
	protected static Double lightelevation = new Double(45.0);
	protected static Double lightazumith = new Double(135.0);

	protected static Double degextent = east_coord - west_coord;
	protected static Double gridextent = new Double(grid_width);
	
	// Double resinmeters = (degextent / gridextent) * metersperdegree;
	protected static Double resinmeters = (degextent / gridextent) * meters_per_degree;
	protected static Double inverse_res_in_meters = 1.0 / resinmeters;
	
	protected static Double lightcontrast = new Double(1.0/resinmeters);

	// specifies the level on the planet in which continental shelves appear.
	// this value must be between -1.0 (minimum planet elevation) and +1.0
	// (maximum planet elevation), and must be less than sea_level.
	protected static Double shelf_level = -0.375;

	// lacunarity of the planet's mountains. changing this value produces
	// slightly different mountains. for the best results, this value should
	// be random, but close to 2.0.
	protected static Double mountain_lacunarity = 2.142578125;

	// specifies the "twistiness" of the mountains.
	protected  static Double mountains_twist = 1.0;
	// specifies the amount of "glaciation" on the mountains. this value
	// should be close to 1.0 and greater than 1.0.
	protected static Double mountain_glaciation = 1.375;
	// lacunarity of the planet's hills. changing this value produces slightly
	// different hills. for the best results, this value should be random, but
	// close to 2.0.
	protected static Double hills_lacunarity = 2.162109375;
	// specifies the "twistiness" of the hills
	protected static Double hills_twist = 1.0;
	// lacunarity of the planet's plains. changing this value produces slightly
	// different plains. for the best results, this value should be random, but
	// close to 2.0.
	protected static Double plains_lacunarity = 2.314453125;
	// lacunarity of the planet's badlands. changing this value produces
	// slightly different badlands. for the best results, this value should be
	// random, but close to 2.0.
	protected static Double badlands_lacunarity = 2.212890625;
	// specifies the "twistiness" of the badlands.
	protected static Double badlands_twist = 1.0;
	// scaling to apply to the base continent elevations, in planetary elevation
	// units.
	protected static Double continent_height_scale = (1.0 - sea_level) / 4.0;
	// determines the amount of mountainous terrain that appears on the
	// planet. values range from 0.0 (no mountains) to 1.0 (all terrain is
	// covered in mountains). mountainous terrain will overlap hilly terrain.
	// because the badlands terrain may overlap parts of the mountainous
	// terrain, setting mountains_amount to 1.0 may not completely cover the
	// terrain in mountains.
	protected static Double mountains_amount = PlanarTerranIF.mountains_amount;
	// determines the amount of hilly terrain that appears on the planet.
	// values range from 0.0 (no hills) to 1.0 (all terrain is covered in
	// hills). this value must be less than mountains_amount. because the
	// mountainous terrain will overlap parts of the hilly terrain, and
	// the badlands terrain may overlap parts of the hilly terrain, setting
	// hills_amount to 1.0 may not completely cover the terrain in hills.
	protected static Double hills_amount = (1.0 + mountains_amount) / 2.0;
	// determines the amount of badlands terrain that covers the planet.
	// values range from 0.0 (no badlands) to 1.0 (all terrain is covered in
	// badlands.) badlands terrain will overlap any other type of terrain.
	protected static Double badlands_amount = 0.03125;
	// maximum depth of the rivers, in planetary elevation units.
	protected static Double river_depth = 0.0234375;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: continent definition (5 noise modules)
	//
	// this subgroup warps the output value from the the base-continent-
	// definition subgroup, producing more realistic terrain.
	//
	// warping the base continent definition produces lumpier terrain with
	// cliffs and rifts.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [coarse-turbulence module]: this turbulence module warps the output
	// value from the base-continent-definition subgroup, adding some coarse
	// detail to it.
	static protected Double tu0_frequency = 15.25;
	// / the frequency of the turbulence determines how rapidly the
	// / displacement amount changes.
	static protected Double tu0_power_scalar = 113.75;
	// / the power of the turbulence determines the scaling factor that is
	// / applied to the displacement amount.
	static protected Integer tu0_roughness = 13;
	// / the roughness of the turbulence determines the roughness of the
	// / changes to the displacement amount. low values smoothly change
	// / the displacement amount. high values roughly change the
	// / displacement amount, which produces more "kinky" changes.
	// /
	// / internally, there are three perlin noise modules
	// / that displace the input value; one for the @a x, one for the @a y,
	// / and one for the @a z coordinate. the roughness value is equal to
	// / the number of octaves used by the noise::module::perlin noise
	// / modules.
	// 2: [intermediate-turbulence module]: this turbulence module warps the
	// output value from the coarse-turbulence module. this turbulence has
	// a higher frequency, but lower power, than the coarse-turbulence
	// module, adding some intermediate detail to it.

	static protected Double tu1_frequency = 47.25;
	static protected Double tu1_power_scalar = 433.75;
	static protected Integer tu1_roughness = 12;

	// 3: [warped-base-continent-definition module]: this turbulence module
	// warps the output value from the intermediate-turbulence module. this
	// turbulence has a higher frequency, but lower power, than the
	// intermediate-turbulence module, adding some fine detail to it.

	static protected Double tu2_frequency = 95.25;
	static protected Double tu2_power_scalar = 1019.75;
	static protected Integer tu2_roughness = 11;

	// 4: [select-turbulence module]: at this stage, the turbulence is applied
	// to the entire base-continent-definition subgroup, producing some very
	// rugged, unrealistic coastlines. this selector module selects the
	// output values from the (unwarped) base-continent-definition subgroup
	// and the warped-base-continent-definition module, based on the output
	// value from the (unwarped) base-continent-definition subgroup. the
	// selection boundary is near sea level and has a relatively smooth
	// transition. in effect, only the higher areas of the base-continent-
	// definition subgroup become warped; the underwater and coastal areas
	// remain unaffected.

	// / the control module (basecontinentdef) determines the output value to
	// select. if the
	// / output value from the control module is within a range of values
	// / known as the <i>selection range</i>, the getvalue() method outputs
	// / the value from the source module with an index value of 1.
	// / otherwise, this method outputs the value from the source module
	// / with an index value of 0.
	// /
	// / this method assigns the control module an index value of 2.
	// / passing the control module to this method produces the same
	// / results as passing the control module to the setsourcemodule()
	// / method while assigning that noise module an index value of 2.
	// /
	// / this control module must exist throughout the lifetime of this
	// / noise module unless another control module replaces that control
	// / module.

	protected static Double continent_def_se_lower_bounds = sea_level - 0.0375;
	protected static Double continent_def_se_upper_bounds = sea_level + 1000.0375;
	protected static Double continent_def_se_edge_falloff = 0.0625;
	// / by default, there is an abrupt transition between the values from
	// / the two source modules at the boundaries of the selection range.
	// /
	// / for example, if the selection range is 0.5 to 0.8, and the edge
	// / falloff value is 0.1, then the getvalue() method outputs:
	// / - the output value from the source module with an index value of 0
	// / if the output value from the control module is less than 0.4
	// / ( = 0.5 - 0.1).
	// / - a linear blend between the two output values from the two source
	// / modules if the output value from the control module is between
	// / 0.4 ( = 0.5 - 0.1) and 0.6 ( = 0.5 + 0.1).
	// / - the output value from the source module with an index value of 1
	// / if the output value from the control module is between 0.6
	// / ( = 0.5 + 0.1) and 0.7 ( = 0.8 - 0.1).
	// / - a linear blend between the output values from the two source
	// / modules if the output value from the control module is between
	// / 0.7 ( = 0.8 - 0.1 ) and 0.9 ( = 0.8 + 0.1).
	// / - the output value from the source module with an index value of 0
	// / if the output value from the control module is greater than 0.9
	// / ( = 0.8 + 0.1).

	// //////////////////////////////////////////////////////////////////////////
	// module group: terrain type definition
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: terrain type definition (3 noise modules)
	//
	// this subgroup defines the positions of the terrain types on the planet.
	//
	// terrain types include, in order of increasing roughness, plains, hills,
	// and mountains.
	//
	// this subgroup's output value is based on the output value from the
	// continent-definition group. rougher terrain mainly appears at higher
	// elevations.
	//
	// -1.0 represents the smoothest terrain types (plains and underwater) and
	// +1.0 represents the roughest terrain types (mountains).
	//

	// 1: [warped-continent module]: this turbulence module slightly warps the
	// output value from the continent-definition group. this prevents the
	// rougher terrain from appearing exclusively at higher elevations.
	// rough areas may now appear in the the ocean, creating rocky islands
	// and fjords.

	static protected Double terrain_type_tu_frequency = 18.125;
	static protected Double terrain_type_tu_power = 20.59375;
	static protected Integer terrain_type_tu_roughness = 3;

	// 2: [roughness-probability-shift module]: this terracing module sharpens
	// the edges of the warped-continent module near sea level and lowers
	// the slope towards the higher-elevation areas. this shrinks the areas
	// in which the rough terrain appears, increasing the "rarity" of rough
	// terrain.
	static protected Double terrain_type_def_low_control_point = -1.00;
	static protected Double terrain_type_def_mid_control_point_scalar = 2.00;
	static protected Double terrain_type_def_high_control_point = 1.00;

	// //////////////////////////////////////////////////////////////////////////
	// module group: mountainous terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: mountain base definition (9 noise modules)
	//
	// this subgroup generates the base-mountain elevations. other subgroups
	// will add the ridges and low areas to the base elevations.
	//
	// -1.0 represents low mountainous terrain and +1.0 represents high
	// mountainous terrain.
	//

	// 1: [mountain-ridge module]: this ridged-multifractal-noise module
	// generates the mountain ridges.
	static protected Double mountain_base_def_rm0_frequency = 1723.0;
	static protected Integer mountain_base_def_rm0_octave_count = 3;

	// 2: [scaled-mountain-ridge module]: next, a scale/bias module scales the
	// output value from the mountain-ridge module so that its ridges are not
	// too high. the reason for this is that another subgroup adds actual
	// mountainous terrain to these ridges.
	static protected Double mountain_base_def_sb0_scale = 0.5;
	static protected Double mountain_base_def_sb0_bias = 0.375;

	// 3: [river-valley module]: this ridged-multifractal-noise module generates
	// the river valleys. it has a much lower frequency than the mountain-
	// ridge module so that more mountain ridges will appear outside of the
	// valleys. note that this noise module generates ridged-multifractal
	// noise using only one octave; this information will be important in the
	// next step.
	static protected Double mountain_base_def_rm1_frequency = 367.0;
	static protected Integer mountain_base_def_rm1_octave_count = 1;

	// 4: [scaled-river-valley module]: next, a scale/bias module applies a
	// scaling factor of -2.0 to the output value from the river-valley
	// module. this stretches the possible elevation values because one-
	// octave ridged-multifractal noise has a lower range of output values
	// than multiple-octave ridged-multifractal noise. the negative scaling
	// factor inverts the range of the output value, turning the ridges from
	// the river-valley module into valleys.
	static protected Double mountain_base_def_sb1_scale = -2.0;
	static protected Double mountain_base_def_sb1_bias = -0.5;

	// 7: [coarse-turbulence module]: this turbulence module warps the output
	// value from the mountain-and-valleys module, adding some coarse detail
	// to it.
	static protected Double mountain_base_def_tu0_frequency = 1337.0;
	static protected Double mountain_base_def_tu0_power_scalar0 = 1.0;
	static protected Double mountain_base_def_tu0_power_scalar1 = 6730.0 * mountains_twist;
	static protected Integer mountain_base_def_tu0_roughness = 4;

	// 8: [warped-mountains-and-valleys module]: this turbulence module warps
	// the output value from the coarse-turbulence module. this turbulence
	// has a higher frequency, but lower power, than the coarse-turbulence
	// module, adding some fine detail to it.
	static protected Double mountain_base_def_tu1_frequency = 21221.0;
	static protected Double mountain_base_def_tu1_power_scalar0 = 1.0;
	static protected Double mountain_base_def_tu1_power_scalar1 = 120157.0 * mountains_twist;
	static protected Integer mountain_base_def_tu1_roughness = 6;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: high mountainous terrain (5 noise modules)
	//
	// this subgroup generates the mountainous terrain that appears at high
	// elevations within the mountain ridges.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [mountain-basis-0 module]: this ridged-multifractal-noise module,
	// along with the mountain-basis-1 module, generates the individual
	// mountains.
	static protected Double mountainous_high_rm0_frequency = 2371.0;
	static protected Double mountainous_high_rm0_lacunarity = mountain_lacunarity;
	static protected Integer mountainous_high_rm0_octave_count = 3;

	// 2: [mountain-basis-1 module]: this ridged-multifractal-noise module,
	// along with the mountain-basis-0 module, generates the individual
	// mountains.
	static protected Double mountainous_high_rm1_frequency = 2341.0;
	static protected Double mountainous_high_rm1_lacunarity = mountain_lacunarity;
	static protected Integer mountainous_high_rm1_octave_count = 3;

	// 4: [warped-high-mountains module]: this turbulence module warps the
	// output value from the high-mountains module, adding some detail to it.
	static protected Double mountainous_high_tu_frequency = 31511.0;
	static protected Double mountainous_high_tu_scalar1 = 1.0;
	static protected Double mountainous_high_tu_scalar2 = 180371.0;
	static protected Double mountainous_high_tu_power = mountainous_high_tu_scalar1
			/ mountainous_high_tu_scalar2 * mountains_twist;
	static protected Integer mountainous_high_tu_roughness = 4;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: low mountainous terrain (4 noise modules)
	//
	// this subgroup generates the mountainous terrain that appears at low
	// elevations within the river valleys.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [lowland-basis-0 module]: this ridged-multifractal-noise module,
	// along with the lowland-basis-1 module, produces the low mountainous
	// terrain.

	static protected Double mountainous_low_rm0_frequency = 1381.0;
	static protected Double mountainous_low_rm0_lacunarity = mountain_lacunarity;
	static protected Integer mountainous_low_rm0_octave_count = 3;

	// 1: [lowland-basis-1 module]: this ridged-multifractal-noise module,
	// along with the lowland-basis-0 module, produces the low mountainous
	// terrain.
	static protected Double mountainous_low_rm1_frequency = 1427.0;
	static protected Double mountainous_low_rm1_lacunarity = mountain_lacunarity;
	static protected Integer mountainous_low_rm1_octave_count = 3;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: mountainous terrain (7 noise modules)
	//
	// this subgroup generates the final mountainous terrain by combining the
	// high-mountainous-terrain subgroup with the low-mountainous-terrain
	// subgroup.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [scaled-low-mountainous-terrain module]: first, this scale/bias module
	// scales the output value from the low-mountainous-terrain subgroup to a
	// very low value and biases it towards -1.0. this results in the low
	// mountainous areas becoming more-or-less flat with little variation.
	// this will also result in the low mountainous areas appearing at the
	// lowest elevations in this subgroup.
	static protected Double mountainous_terrain_sb0_scale = 0.03125;
	static protected Double mountainous_terrain_sb0_bias = -0.96875;

	// 2: [scaled-high-mountainous-terrain module]: next, this scale/bias module
	// scales the output value from the high-mountainous-terrain subgroup to
	// 1/4 of its initial value and biases it so that its output value is
	// usually positive.
	static protected Double mountainous_terrain_sb1_scale = 0.25;
	static protected Double mountainous_terrain_sb1_bias = 0.25;

	// 4: [combined-mountainous-terrain module]: note that at this point, the
	// entire terrain is covered in high mountainous terrain, even at the low
	// elevations. to make sure the mountains only appear at the higher
	// elevations, this selector module causes low mountainous terrain to
	// appear at the low elevations (within the valleys) and the high
	// mountainous terrain to appear at the high elevations (within the
	// ridges.) to do this, this noise module selects the output value from
	// the added-high-mountainous-terrain module if the output value from the
	// mountain-base-definition subgroup is higher than a set amount.
	// otherwise, this noise module selects the output value from the scaled-
	// low-mountainous-terrain module.

	// / sets the lower and upper bounds of the selection range.
	static protected Double mountainous_terrain_se_bounds_param_0 = -0.5;
	static protected Double mountainous_terrain_se_bounds_param_1 = 999.5;
	// / sets the falloff value at the edge transition.
	static protected Double mountainous_terrain_se_edge_falloff = 0.5;

	// 5: [scaled-mountainous-terrain-module]: this scale/bias module slightly
	// reduces the range of the output value from the combined-mountainous-
	// terrain module, decreasing the heights of the mountain peaks.
	static protected Double mountainous_terrain_sb2_scale = 0.8;
	static protected Double mountainous_terrain_sb2_bias = 0.0;

	protected static Double hilly_terrain_bi_frequency = 1663.0;
	protected static Double hilly_terrain_bi_persistence = 0.5;
	protected static Integer hilly_terrain_bi_octave_count = 3;

	// 2: [scaled-hills module]: next, a scale/bias module scales the output
	// value from the hills module so that its hilltops are not too high.
	// the reason for this is that these hills are eventually added to the
	// river valleys (see below.)
	static protected Double hilly_terrain_sb0_scale = 0.5;
	static protected Double hilly_terrain_sb0_bias = 0.5;

	// 3: [river-valley module]: this ridged-multifractal-noise module generates
	// the river valleys. it has a much lower frequency so that more hills
	// will appear in between the valleys. note that this noise module
	// generates ridged-multifractal noise using only one octave; this
	// information will be important in the next step.
	static protected Double hilly_terrain_rm_frequency = 367.5;
	static protected Integer hilly_terrain_rm_octave_count = 1;

	// 4: [scaled-river-valley module]: next, a scale/bias module applies a
	// scaling factor of -2.0 to the output value from the river-valley
	// module. this stretches the possible elevation values because one-
	// octave ridged-multifractal noise has a lower range of output values
	// than multiple-octave ridged-multifractal noise. the negative scaling
	// factor inverts the range of the output value, turning the ridges from
	// the river-valley module into valleys.
	static protected Double hilly_terrain_sb1_scale = -2.0;
	static protected Double hilly_terrain_sb1_bias = -0.5;

	// 7: [scaled-hills-and-valleys module]: this scale/bias module slightly
	// reduces the range of the output value from the hills-and-valleys
	// module, decreasing the heights of the hilltops.

	static protected Double hilly_terrain_sb2_scale = 0.75;
	static protected Double hilly_terrain_sb2_bias = -0.25;

	// 8: [increased-slope-hilly-terrain module]: to increase the hill slopes at
	// higher elevations, this exponential-curve module applies an
	// exponential curve to the output value the scaled-hills-and-valleys
	// module. this exponential-curve module expects the input value to
	// range from -1.0 to 1.0.
	static protected Double hilly_terrain_ex = 1.375;

	// 9: [coarse-turbulence module]: this turbulence module warps the output
	// value from the increased-slope-hilly-terrain module, adding some
	// coarse detail to it.
	static protected Double hilly_terrain_tu0_frequency = 1531.0;
	static protected Double hilly_terrain_tu0_scalar0 = 1.0;
	static protected Double hilly_terrain_tu0_scalar1 = 16921.0;
	static protected Integer hilly_terrain_tu0_roughness = 4;

	// 10: [warped-hilly-terrain module]: this turbulence module warps the
	// output value from the coarse-turbulence module. this turbulence has
	// a higher frequency, but lower power, than the coarse-turbulence
	// module, adding some fine detail to it.

	static protected Double hilly_terrain_tu1_frequency = 21617.0;
	static protected Double hilly_terrain_tu1_scalar0 = 1.0;
	static protected Double hilly_terrain_tu1_scalar1 = 117529.0;
	static protected Integer hilly_terrain_tu1_roughness = 6;

	// //////////////////////////////////////////////////////////////////////////
	// module group: plains terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: plains terrain (7 noise modules)
	//
	// this subgroup generates the plains terrain.
	//
	// because this subgroup will eventually be flattened considerably, the
	// types and combinations of noise modules that generate the plains are not
	// really that important; they only need to "look" interesting.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [plains-basis-0 module]: this billow-noise module, along with the
	// plains-basis-1 module, produces the plains.
	protected static Double plains_terrain_bi0_frequency = 1097.0;
	protected static Double plains_terrain_bi0_persistence = 0.5;
	protected static Integer plains_terrain_bi0_octave_count = 3;

	// 2: [positive-plains-basis-0 module]: this scale/bias module makes the
	// output value from the plains-basis-0 module positive since this output
	// value will be multiplied together with the positive-plains-basis-1
	// module.
	static protected Double plains_terrain_sb0_scale = 0.5;
	static protected Double plains_terrain_sb0_bias = 0.5;

	// 3: [plains-basis-1 module]: this billow-noise module, along with the
	// plains-basis-2 module, produces the plains.

	protected static Double plains_terrain_bi1_frequency = 1319.0;
	protected static Double plains_terrain_bi1_persistence = 0.5;
	protected static Integer plains_terrain_bi1_octave_count = 3;

	// 4: [positive-plains-basis-1 module]: this scale/bias module makes the
	// output value from the plains-basis-1 module positive since this output
	// value will be multiplied together with the positive-plains-basis-0
	// module.
	static protected Double plains_terrain_sb1_scale = 0.5;
	static protected Double plains_terrain_sb1_bias = 0.5;

	// 6: [rescaled-plains-basis module]: this scale/bias module maps the output
	// value that ranges from 0.0 to 1.0 back to a value that ranges from
	// -1.0 to +1.0.
	static protected Double plains_terrain_sb2_scale = 2.0;
	static protected Double plains_terrain_sb2_bias = -1.0;

	// //////////////////////////////////////////////////////////////////////////
	// module group: badlands terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: badlands sand (6 noise modules)
	//
	// this subgroup generates the sandy terrain for the badlands.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [sand-dunes module]: this ridged-multifractal-noise module generates
	// sand dunes. this ridged-multifractal noise is generated with a single
	// octave, which makes very smooth dunes.
	static protected Double badlands_sand_rm_frequency = 6163.5;
	static protected Integer badlands_sand_rm_octave_count = 1;

	// 2: [scaled-sand-dunes module]: this scale/bias module shrinks the dune
	// heights by a small amount. this is necessary so that the subsequent
	// noise modules in this subgroup can add some detail to the dunes.

	static protected Double badlands_sand_sb0_scale = 0.875;
	static protected Double badlands_sand_sb0_bias = 0.0;

	// 3: [dune-detail module]: this noise module uses voronoi polygons to
	// generate the detail to add to the dunes. by enabling the distance
	// algorithm, small polygonal pits are generated; the edges of the pits
	// are joined to the edges of nearby pits.

	// / the frequency determines the size of the voronoi cells and the
	// / distance between these cells.
	static protected Double badlands_sand_vo_frequency = 16183.25;
	// / this noise module assigns each voronoi cell with a random constant
	// / value from a coherent-noise function. the <i>displacement
	// / value</i> controls the range of random values to assign to each
	// / cell. the range of random values is +/- the displacement value.
	static protected Double badlands_sand_vo_displacemwnt = 0.0;

	// 4: [scaled-dune-detail module]: this scale/bias module shrinks the dune
	// details by a large amount. this is necessary so that the subsequent
	// noise modules in this subgroup can add this detail to the sand-dunes
	// module.
	static protected Double badlands_sand_sb1_scale = 0.25;
	static protected Double badlands_sand_sb1_bias = 0.25;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: badlands cliffs (7 noise modules)
	//
	// this subgroup generates the cliffs for the badlands.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [cliff-basis module]: this perlin-noise module generates some coherent
	// noise that will be used to generate the cliffs.
	static protected Double badlands_cliffs_pe_frequency = continent_frequency * 839;
	static protected Double badlands_cliffs_pe_persistence = 0.5;
	static protected Integer badlands_cliffs_pe_octave_count = 3;

	// 5: [coarse-turbulence module]: this turbulence module warps the output
	// value from the terraced-cliffs module, adding some coarse detail to
	// it.
	static protected Double badlands_cliffs_tu0_frequency = 16111.0;
	static protected Double badlands_cliffs_tu0_scalar0 = 1.0;
	static protected Double badlands_cliffs_tu0_scalar1 = 141539.0;
	static protected Integer badlands_cliffs_tu0_roughness = 3;

	// 6: [warped-cliffs module]: this turbulence module warps the output value
	// from the coarse-turbulence module. this turbulence has a higher
	// frequency, but lower power, than the coarse-turbulence module, adding
	// some fine detail to it.
	static protected Double badlands_cliffs_tu1_frequency = 36107.0;
	static protected Double badlands_cliffs_tu1_scalar0 = 1.0;
	static protected Double badlands_cliffs_tu1_scalar1 = 211543.0;
	static protected Integer badlands_cliffs_tu1_roughness = 3;
	
	static protected Double badlands_cliffs_cl_lower_bound = -999.125;
	static protected Double badlands_cliffs_cl_upper_bound = 0.875;
	

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: badlands terrain (3 noise modules)
	//
	// generates the final badlands terrain.
	//
	// using a scale/bias module, the badlands sand is flattened considerably,
	// then the sand elevations are lowered to around -1.0. the maximum value
	// from the flattened sand module and the cliff module contributes to the
	// final elevation. this causes sand to appear at the low elevations since
	// the sand is slightly higher than the cliff base.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [scaled-sand-dunes module]: this scale/bias module considerably
	// flattens the output value from the badlands-sands subgroup and lowers
	// this value to near -1.0.
	static protected Double badlands_terrain_sb_scale = 0.25;
	static protected Double badlands_terrain_sb_bias = -0.75;

	// //////////////////////////////////////////////////////////////////////////
	// module group: river positions
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: river positions (7 noise modules)
	//
	// this subgroup generates the river positions.
	//
	// -1.0 represents the lowest elevations and +1.0 represents the highest
	// elevations.
	//

	// 1: [large-river-basis module]: this ridged-multifractal-noise module
	// creates the large, deep rivers.
	static protected Double river_positions_rm0_frequency = 18.75;
	static protected Integer river_positions_rm0_octave_count = 1;

	// / 3: [small-river-basis module]: this ridged-multifractal-noise module
	// creates the small, shallow rivers.
	static protected Double river_positions_rm1_frequency = 43.25;
	static protected Integer river_positions_rm1_octave_count = 1;

	// 6: [warped-rivers module]: this turbulence module warps the output value
	// from the combined-rivers module, which twists the rivers. the high
	// roughness produces less-smooth rivers.
	static protected Double river_positions_tu_frequency = 9.25;
	static protected Double river_positions_tu_scalar0 = 1.0;
	static protected Double river_positions_tu_scalar1 = 57.75;
	static protected Integer river_positions_tu_roughness = 6;

	// //////////////////////////////////////////////////////////////////////////
	// module group: scaled mountainous terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: scaled mountainous terrain (6 noise modules)
	//
	// this subgroup scales the output value from the mountainous-terrain group
	// so that it can be added to the elevation defined by the continent-
	// definition group.
	//
	// this subgroup scales the output value such that it is almost always
	// positive. this is done so that a negative elevation does not get applied
	// to the continent-definition group, preventing parts of that group from
	// having negative terrain features "stamped" into it.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [base-scaled-mountainous-terrain module]: this scale/bias module
	// scales the output value from the mountainous-terrain group so that the
	// output value is measured in planetary elevation units.
	static protected Double scaled_mountainous_terrain_sb0_scale = 0.125;
	static protected Double scaled_mountainous_terrain_sb0_bias = 0.125;

	// 2: [base-peak-modulation module]: at this stage, most mountain peaks have
	// roughly the same elevation. this perlin-noise module generates some
	// random values that will be used by subsequent noise modules to
	// randomly change the elevations of the mountain peaks.
	static protected Double scaled_mountainous_terrain_pe_frequency = 14.5;
	static protected Double scaled_mountainous_terrain_pe_persistence = 0.5;
	static protected Integer scaled_mountainous_terrain_pe_octave_count = 3;

	// 3: [peak-modulation module]: this exponential-curve module applies an
	// exponential curve to the output value from the base-peak-modulation
	// module. this produces a small number of high values and a much larger
	// number of low values. this means there will be a few peaks with much
	// higher elevations than the majority of the peaks, making the terrain
	// features more varied.
	static protected Double scaled_mountainous_terrain_ex_exponent = 1.25;

	// 4: [scaled-peak-modulation module]: this scale/bias module modifies the
	// range of the output value from the peak-modulation module so that it
	// can be used as the modulator for the peak-height-multiplier module.
	// it is important that this output value is not much lower than 1.0.
	static protected Double scaled_mountainous_terrain_sb1_scale = 0.25;
	static protected Double scaled_mountainous_terrain_sb1_bias = 1.0;

	// //////////////////////////////////////////////////////////////////////////
	// module group: scaled hilly terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: scaled hilly terrain (6 noise modules)
	//
	// this subgroup scales the output value from the hilly-terrain group so
	// that it can be added to the elevation defined by the continent-
	// definition group. the scaling amount applied to the hills is one half of
	// the scaling amount applied to the scaled-mountainous-terrain group.
	//
	// this subgroup scales the output value such that it is almost always
	// positive. this is done so that negative elevations are not applied to
	// the continent-definition group, preventing parts of the continent-
	// definition group from having negative terrain features "stamped" into it.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [base-scaled-hilly-terrain module]: this scale/bias module scales the
	// output value from the hilly-terrain group so that this output value is
	// measured in planetary elevation units
	static protected Double scaled_hilly_terrain_sb0_scale = 0.0625;
	static protected Double scaled_hilly_terrain_sb0_bias = 0.0625;

	// 2: [base-hilltop-modulation module]: at this stage, most hilltops have
	// roughly the same elevation. this perlin-noise module generates some
	// random values that will be used by subsequent noise modules to
	// randomly change the elevations of the hilltops.
	static protected Double scaled_hilly_terrain_pe_frequency = 13.5;
	static protected Double scaled_hilly_terrain_pe_persistence = 0.5;
	static protected Integer scaled_hilly_terrain_pe_octave_count = 3;

	// 3: [hilltop-modulation module]: this exponential-curve module applies an
	// exponential curve to the output value from the base-hilltop-modulation
	// module. this produces a small number of high values and a much larger
	// number of low values. this means there will be a few hilltops with
	// much higher elevations than the majority of the hilltops, making the
	// terrain features more varied.
	static protected Double scaled_hilly_terrain_ex_exponent = 1.25;

	// 4: [scaled-hilltop-modulation module]: this scale/bias module modifies
	// the range of the output value from the hilltop-modulation module so
	// that it can be used as the modulator for the hilltop-height-multiplier
	// module. it is important that this output value is not much lower than
	// 1.0.
	static protected Double scaled_hilly_terrain_sb1_scale = 0.5;
	static protected Double scaled_hilly_terrain_sb1_bias = 1.5;

	// //////////////////////////////////////////////////////////////////////////
	// module group: scaled plains terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: scaled plains terrain (2 noise modules)
	//
	// this subgroup scales the output value from the plains-terrain group so
	// that it can be added to the elevations defined by the continent-
	// definition group.
	//
	// this subgroup scales the output value such that it is almost always
	// positive. this is done so that negative elevations are not applied to
	// the continent-definition group, preventing parts of the continent-
	// definition group from having negative terrain features "stamped" into it.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [scaled-plains-terrain module]: this scale/bias module greatly
	// flattens the output value from the plains terrain. this output value
	// is measured in planetary elevation units
	static protected Double scaled_plains_terrain_sb_scale = 0.00390625;
	static protected Double scaled_plains_terrain_sb_bias = 0.0078125;

	// //////////////////////////////////////////////////////////////////////////
	// module group: scaled badlands terrain
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: scaled badlands terrain (2 noise modules)
	//
	// this subgroup scales the output value from the badlands-terrain group so
	// that it can be added to the elevations defined by the continent-
	// definition group.
	//
	// this subgroup scales the output value such that it is almost always
	// positive. this is done so that negative elevations are not applied to
	// the continent-definition group, preventing parts of the continent-
	// definition group from having negative terrain features "stamped" into it.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [scaled-badlands-terrain module]: this scale/bias module scales the
	// output value from the badlands-terrain group so that it is measured
	// in planetary elevation units
	static protected Double scaled_badlands_terrain_scale = 0.0625;
	static protected Double scaled_badlands_terrain_bias = 0.0625;

	// //////////////////////////////////////////////////////////////////////////
	// module group: final planet
	// //////////////////////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: continental shelf (6 noise modules)
	//
	// this module subgroup creates the continental shelves.
	//
	// the output value from this module subgroup are measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [shelf-creator module]: this terracing module applies a terracing
	// curve to the continent-definition group at the specified shelf level.
	// this terrace becomes the continental shelf. note that this terracing
	// module also places another terrace below the continental shelf near
	// -1.0. the bottom of this terrace is defined as the bottom of the
	// ocean; subsequent noise modules will later add oceanic trenches to the
	// bottom of the ocean.
	static protected Double continental_shelf_te_lowest_control_point = -1.0;
	static protected Double continental_shelf_te_low_control_point = -0.75;
	static protected Double continental_shelf_te_high_control_point = 1.0;

	// 2: [oceanic-trench-basis module]: this ridged-multifractal-noise module
	// generates some coherent noise that will be used to generate the
	// oceanic trenches. the ridges represent the bottom of the trenches.
	static protected Double continental_shelf_frequency_scalar = 4.375;
	static protected Integer continental_shelf_frequency_octave_count = 3;

	// 3: [oceanic-trench module]: this scale/bias module inverts the ridges
	// from the oceanic-trench-basis-module so that the ridges become
	// trenches. this noise module also reduces the depth of the trenches so
	// that their depths are measured in planetary elevation units.
	static protected Double continental_shelf_sb_scale = -0.125;
	static protected Double continental_shelf_sb_bias = -0.125;

	// 4: [clamped-sea-bottom module]: this clamping module clamps the output
	// value from the shelf-creator module so that its possible range is
	// from the bottom of the ocean to sea level. this is done because this
	// subgroup is only concerned about the oceans.
	static protected Double continental_shelf_cl_bounds = -0.75;

	// //////////////////////////////////////////////////////////////////////////
	// module group: base continent elevations (3 noise modules)
	//
	// this subgroup generates the base elevations for the continents, before
	// terrain features are added.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [base-scaled-continent-elevations module]: this scale/bias module
	// scales the output value from the continent-definition group so that it
	// is measured in planetary elevation units
	static protected Double base_continent_elev_sb_bias = 0.0;

	// 2: [base-continent-with-oceans module]: this selector module applies the
	// elevations of the continental shelves to the base elevations of the
	// continent. it does this by selecting the output value from the
	// continental-shelf subgroup if the corresponding output value from the
	// continent-definition group is below the shelf level. otherwise, it
	// selects the output value from the base-scaled-continent-elevations
	// module.
	static protected Double base_continent_elev_se_bound_scalar = 1000.0;
	static protected Double base_continent_elev_se_edge_falloff = 0.03125;

	// 2: [select-high-elevations module]: this selector module ensures that
	// the hills only appear at higher elevations. it does this by selecting
	// the output value from the continent-with-hills module if the
	// corresponding output value from the terrain-type-defintion group is
	// above a certain value. otherwise, it selects the output value from the
	// continents-with-plains subgroup.
	static protected Double continents_with_hills_bounds_scalar0 = 1.0;
	static protected Double continents_with_hills_bounds_scalar1 = 1001.0;
	static protected Double continents_with_hills_edge_falloff = 0.25;

	// 4: [select-high-elevations module]: this selector module ensures that
	// mountains only appear at higher elevations. it does this by selecting
	// the output value from the continent-with-mountains module if the
	// corresponding output value from the terrain-type-defintion group is
	// above a certain value. otherwise, it selects the output value from
	// the continents-with-hills subgroup. note that the continents-with-
	// hills subgroup also contains the plains terrain.
	static protected Double continent_with_mountains_bounds_scalar0 = 1.0;
	static protected Double continent_with_mountains_bounds_scalar1 = 1001.0;
	static protected Double continent_with_mountains_edge_falloff = 0.25;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: continents with badlands (5 noise modules)
	//
	// this subgroup applies the scaled-badlands-terrain group to the
	// continents-with-mountains subgroup.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [badlands-positions module]: this perlin-noise module generates some
	// random noise, which is used by subsequent noise modules to specify the
	// locations of the badlands.
	static protected Double continents_with_badlands_pe_frequency = 16.5;
	static protected Double continents_with_badlands_pe_persistence = 0.5;
	static protected Integer continents_with_badlands_pe_octave_count = 2;

	// 3: [select-badlands-positions module]: this selector module places
	// badlands at random spots on the continents based on the perlin noise
	// generated by the badlands-positions module. to do this, it selects
	// the output value from the continents-and-badlands module if the
	// corresponding output value from the badlands-position module is
	// greater than a specified value. otherwise, this selector module
	// selects the output value from the continents-with-mountains subgroup.
	// there is also a wide transition between these two noise modules so
	// that the badlands can blend into the rest of the terrain on the
	// continents.
	static protected Double continents_with_badlands_se_bounds_param0 = 1.0;
	static protected Double continents_with_badlands_se_bounds_param1 = 1001.0;
	static protected Double continents_with_badlands_se_edge_falloff = 0.25;

	// //////////////////////////////////////////////////////////////////////////
	// module subgroup: continents with rivers (4 noise modules)
	//
	// this subgroup applies the river-positions group to the continents-with-
	// badlands subgroup.
	//
	// the output value from this module subgroup is measured in planetary
	// elevation units (-1.0 for the lowest underwater trenches and +1.0 for the
	// highest mountain peaks.)
	//

	// 1: [scaled-rivers module]: this scale/bias module scales the output value
	// from the river-positions group so that it is measured in planetary
	// elevation units and is negative; this is required for step 2.
	static protected Double continents_with_rivers_sb_scalar0 = 2.0;
	static protected Double continents_with_rivers_sb_scalar1 = 2.0;

	
}
