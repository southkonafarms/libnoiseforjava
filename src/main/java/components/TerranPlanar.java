package components;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.Builder;
import libnoiseforjava.domain.RenderImageParameter;
import libnoiseforjava.module.Cached;
import libnoiseforjava.util.ImageCafe;
import libnoiseforjava.util.NoiseMap;
import libnoiseforjava.util.NoiseMapBuilderSphere;

public class TerranPlanar extends Planar implements PlanarTerranIF{
	
	
		
	// overrides static variables in abstract class
	protected static Double planet_circumference = 44236800.0;
	protected static Double meters_per_degree = planet_circumference / 360.0;
	protected static Double resinmeters = (degextent / gridextent) * meters_per_degree;
	protected static Double inverse_res_in_meters = 1.0 / resinmeters;

	protected static Double lightcontrast = new Double(1.0 / resinmeters);
	
	// width of elevation grid, in points
	protected static Integer grid_width = 2048;
	// height of elevation grid, in points
	protected static Integer grid_height = 1024;


	// implements PlanarTerranIF static variables
	
	class PlanarTerranImpl extends AbstractPlanarTerran{}
	
	protected static TerranPlanar terranPlanar = new TerranPlanar();
	protected static PlanarTerranImpl planarTerranImpl = terranPlanar.new PlanarTerranImpl();
	
	static Double scalar_divisor = 2.0;
	
	/**
	 * The documentation for all these invocations can be found in the ComplexPlanetOnly test.
	 * 
	 * 
	 * @param renderParameter
	 * @return
	 */

	public ImageCafe build(Boolean renderParameter) {

		PlanarBaseContinent planarBaseContinent = new PlanarBaseContinent(continent_frequency,
				base_continent_def_persistence_0, continent_lacunarity, base_continent_def_octave_count_pe0,
				controlPoints, base_continent_def_persistence_1, base_continent_def_octave_count_pe1,
				base_continent_def_scale, base_continent_def_bias, base_continent_def_clamp_lower_bound,
				base_continent_def_clamp_upper_bound, NoiseQuality.QUALITY_STD);
		Cached baseContinent = planarBaseContinent.build();
		PlanarContinent planarContinent = new PlanarContinent(null, Boolean.FALSE, tu0_frequency, tu1_frequency,
				tu2_frequency, tu0_power_scalar, tu1_power_scalar, tu2_power_scalar, tu0_roughness, tu1_roughness,
				tu2_roughness, continent_def_se_lower_bounds, continent_def_se_upper_bounds,
				continent_def_se_edge_falloff, baseContinent);
		Cached continent = planarContinent.build();

		PlanarTerrainType planarTerrainType = new PlanarTerrainType(continent, terrain_type_tu_frequency,
				terrain_type_tu_power, terrain_type_tu_roughness, terrain_type_def_low_control_point,
				terrain_type_def_mid_control_point_scalar, terrain_type_def_high_control_point, shelf_level, PlanarTerranIF.sea_level);
		Cached terrainType = planarTerrainType.build();
		
		PlanarMountanType planarMountanType = new PlanarMountanType(mountain_base_def_tu0_frequency,
				mountain_base_def_rm0_octave_count, NoiseQuality.QUALITY_STD, inverse_res_in_meters,
				mountain_base_def_sb0_scale, mountain_base_def_sb0_bias, mountain_base_def_sb1_scale,
				mountain_base_def_sb1_bias, mountain_base_def_rm1_frequency, mountain_base_def_rm1_octave_count,
				NoiseQuality.QUALITY_BEST, mountain_base_def_tu0_frequency, mountain_base_def_tu1_frequency,
				mountain_base_def_tu0_power_scalar0, mountain_base_def_tu1_power_scalar1,
				mountain_base_def_tu0_roughness, mountain_base_def_tu1_roughness, -1.0);
		
		Cached baseMountain = planarMountanType.build();
		
		PlanarHighMountainType planarHighMountainType = new PlanarHighMountainType(mountainous_high_rm0_frequency,
				mountainous_high_rm0_octave_count, mountainous_high_rm1_frequency, mountainous_high_rm1_octave_count,
				NoiseQuality.QUALITY_BEST, mountainous_high_rm0_lacunarity, mountainous_high_tu_frequency, mountainous_high_tu_scalar1,
				mountainous_high_tu_scalar2, mountainous_high_tu_roughness, mountains_twist);
		
		Cached highMountain = planarHighMountainType.build();
		
		PlanarLowMountainType planarLowMountainType = new PlanarLowMountainType(mountainous_low_rm0_frequency,
				mountainous_low_rm0_octave_count, mountainous_low_rm1_frequency, mountainous_low_rm1_octave_count,
				mountainous_low_rm0_lacunarity, NoiseQuality.QUALITY_BEST);
		
		Cached lowMountain = planarLowMountainType.build();
		
		PlanarMountainTerrainType mountainTerrainType = new PlanarMountainTerrainType(mountainous_terrain_sb0_scale,
				mountainous_terrain_sb0_bias, mountainous_terrain_sb1_scale, mountainous_terrain_sb1_bias,
				mountainous_terrain_sb2_scale, mountainous_terrain_sb2_bias, lowMountain, highMountain, baseMountain,
				mountainous_terrain_se_bounds_param_0, mountainous_terrain_se_bounds_param_1,
				mountainous_terrain_se_edge_falloff, mountain_glaciation);
		
		Cached mountainTerrain = mountainTerrainType.build();
		
		PlanarHillType planarHillType = new PlanarHillType(hilly_terrain_bi_frequency, inverse_res_in_meters,
				inverse_res_in_meters, hilly_terrain_bi_octave_count, inverse_res_in_meters, inverse_res_in_meters,
				inverse_res_in_meters, hilly_terrain_rm_octave_count, NoiseQuality.QUALITY_BEST, inverse_res_in_meters,
				inverse_res_in_meters, -1.0, inverse_res_in_meters, inverse_res_in_meters,
				inverse_res_in_meters, inverse_res_in_meters, inverse_res_in_meters, resinmeters,
				hilly_terrain_tu0_roughness, planet_circumference, meters_per_degree, lightcontrast,
				inverse_res_in_meters, hilly_terrain_tu1_roughness);
		
		Cached hillTerrain = planarHillType.build();
		
		PlanarPlainsType planarPlainsType = new PlanarPlainsType(plains_lacunarity, plains_terrain_bi0_frequency,
				plains_terrain_bi0_persistence, plains_terrain_bi0_octave_count, NoiseQuality.QUALITY_BEST,
				plains_terrain_sb0_bias, plains_terrain_sb0_scale, plains_terrain_bi1_frequency,
				plains_terrain_bi1_persistence, plains_terrain_bi1_octave_count, plains_terrain_sb1_bias,
				plains_terrain_sb1_scale, plains_terrain_sb2_bias, plains_terrain_sb2_scale);
		
		Cached plainsTerrain = planarPlainsType.build();
		
		PlanarBadlandSandType planarBadlandSandType = new PlanarBadlandSandType(badlands_lacunarity,
				NoiseQuality.QUALITY_BEST, badlands_sand_rm_frequency, badlands_sand_rm_octave_count,
				badlands_sand_sb0_scale, badlands_sand_sb0_bias, badlands_sand_vo_frequency,
				badlands_sand_vo_displacemwnt, Boolean.TRUE, badlands_sand_sb1_scale, badlands_sand_sb1_bias);

		Cached badlandSand = planarBadlandSandType.build();
		
		PlanarBadlandCliffType planarBadlandCliffType = new PlanarBadlandCliffType(badlands_lacunarity, badlands_twist,
				badlands_cliffs_pe_frequency, continent_frequency, badlands_cliffs_pe_persistence,
				badlands_cliffs_pe_octave_count, badlands_cliffs_cl_lower_bound, badlands_cliffs_cl_upper_bound,
				badlands_cliffs_tu0_frequency, badlands_cliffs_tu0_scalar0, badlands_cliffs_tu0_scalar1,
				badlands_cliffs_tu0_roughness, badlands_cliffs_tu1_frequency, badlands_cliffs_tu1_scalar0,
				badlands_cliffs_tu1_scalar1, badlands_cliffs_tu1_roughness, badLandCLiffsControlPoints,
				badLandsTerraceControlPoints, NoiseQuality.QUALITY_BEST);
		
		Cached badlandCliffs = planarBadlandCliffType.build();
		
		PlanarBadlandsDunesType planarBadlandsDunesType = new PlanarBadlandsDunesType(badlands_terrain_sb_scale,
				badlands_terrain_sb_bias, badlandSand, badlandCliffs);

		Cached badlandDunes = planarBadlandsDunesType.build();

		PlanarRiverPositionsType planarRiverPositionsType = new PlanarRiverPositionsType(river_positions_rm0_frequency,
				river_positions_rm0_octave_count, river_positions_rm1_frequency, river_positions_rm1_octave_count,
				river_positions_tu_frequency, river_positions_tu_scalar0, river_positions_tu_scalar1,
				river_positions_tu_roughness, continent_lacunarity, NoiseQuality.QUALITY_BEST,
				riverPositionControlPoints0, riverPositionControlPoints1);

		Cached riverPositions = planarRiverPositionsType.build();
		
		PlanarScaledMountainTerrainType planarScaledMountainTerrain = new PlanarScaledMountainTerrainType(
				scaled_mountainous_terrain_sb0_scale, scaled_mountainous_terrain_sb0_bias,
				scaled_mountainous_terrain_sb1_scale, scaled_mountainous_terrain_sb1_bias, mountainTerrain,
				scaled_mountainous_terrain_pe_frequency, scaled_mountainous_terrain_pe_persistence, mountain_lacunarity,
				scaled_mountainous_terrain_pe_octave_count, NoiseQuality.QUALITY_STD,
				scaled_mountainous_terrain_ex_exponent);
		
		Cached scaledMountainTerrain = planarScaledMountainTerrain.build();
		
		PlanarScaledHillTerrainType planarScaledHillTerrain = new PlanarScaledHillTerrainType(scaled_hilly_terrain_sb0_scale,
				scaled_hilly_terrain_sb0_bias, scaled_hilly_terrain_sb1_scale, scaled_hilly_terrain_sb1_bias,
				hillTerrain, scaled_hilly_terrain_pe_frequency, scaled_hilly_terrain_pe_persistence, hills_lacunarity,
				scaled_hilly_terrain_pe_octave_count, NoiseQuality.QUALITY_STD, scaled_hilly_terrain_ex_exponent);
		
		Cached scaledHillTerrain = planarScaledHillTerrain.build();
		
		PlanarScaledPlainsTerrainType planarScaledPlainsTerrain = new PlanarScaledPlainsTerrainType(plainsTerrain,
				scaled_plains_terrain_sb_scale, scaled_plains_terrain_sb_bias);

		Cached scaledPlainsTerrain = planarScaledPlainsTerrain.build();
		
		PlanarScaledBadlandsTerrainType planarScaledBadlandsTerrain = new PlanarScaledBadlandsTerrainType(badlandDunes,
				badlands_terrain_sb_scale, badlands_terrain_sb_bias);	
		
		Cached scaledBadlandsTerrain = planarScaledBadlandsTerrain.build();
		
		PlanarContinentalShelfType planarContinentalShelfType = new PlanarContinentalShelfType(
				continental_shelf_te_lowest_control_point, continental_shelf_te_low_control_point,
				continental_shelf_te_high_control_point, shelf_level, continent, continental_shelf_frequency_scalar,
				continent_lacunarity, continental_shelf_frequency_octave_count, NoiseQuality.QUALITY_BEST,
				continental_shelf_sb_scale, continental_shelf_sb_bias, continental_shelf_cl_bounds, PlanarTerranIF.sea_level);
		
		Cached continentalShelf = planarContinentalShelfType.build();
		
		PlanarBaseContinentElevationType planarBaseContinentElevationType = new PlanarBaseContinentElevationType(
				base_continent_elev_sb_bias, continent_height_scale, base_continent_elev_se_bound_scalar,
				base_continent_elev_se_edge_falloff, shelf_level, continentalShelf, continent);
		
		Cached baseContinentElevation = planarBaseContinentElevationType.build();
		
		PlanarContinentsWithPlainsType planarContinentsWithPlainsType = new PlanarContinentsWithPlainsType(baseContinentElevation, scaledPlainsTerrain);
		
		Cached continentsWithPlains = planarContinentsWithPlainsType.build();
		
		PlanarContinentsWithHillsType planarContinentsWithHillsType = new PlanarContinentsWithHillsType(
				baseContinentElevation, scaledHillTerrain, continents_with_hills_bounds_scalar0,
				continents_with_hills_bounds_scalar1, hills_amount, continents_with_hills_edge_falloff,
				continentsWithPlains, terrainType);
		
		Cached continentsWithHills = planarContinentsWithHillsType.build();
		
		PlanarContinentsWithMountainsType planarContinentsWithMountainsType = new PlanarContinentsWithMountainsType(
				baseContinentElevation, scaledMountainTerrain, continent, continentsMountainsControlPoints,
				continent_with_mountains_bounds_scalar0, continent_with_mountains_bounds_scalar1,
				continent_with_mountains_edge_falloff, continentsWithHills, terrainType, PlanarTerranIF.mountains_amount);
		
		Cached continentsWithMountains = planarContinentsWithMountainsType.build();
		
		PlanarContinentsWithBadlandsType planarContinentsWithBadlandsType = new PlanarContinentsWithBadlandsType(
				continents_with_badlands_pe_frequency, continents_with_badlands_pe_persistence,
				continents_with_badlands_pe_octave_count, NoiseQuality.QUALITY_STD, continent_lacunarity,
				baseContinentElevation, scaledBadlandsTerrain, continents_with_badlands_se_bounds_param0,
				continents_with_badlands_se_bounds_param1, continents_with_badlands_se_edge_falloff,
				continentsWithMountains, badlands_amount);	
		
		Cached continentsWithBadlands = planarContinentsWithBadlandsType.build();
		
		PlanarContinentsWithRiversType planarContinentsWithRiversType = new PlanarContinentsWithRiversType(
				continents_with_rivers_sb_scalar0, continents_with_rivers_sb_scalar1, river_depth, riverPositions,
				continentsWithBadlands, PlanarTerranIF.sea_level, continent_height_scale);
		
		Cached continentsWithRivers = planarContinentsWithRiversType.build();
		
		PlanarFinalType planarFinalType = new PlanarFinalType(PlanarTerranIF.max_elev, PlanarTerranIF.min_elev, scalar_divisor, continentsWithRivers);
		
		Cached finalPlanet = planarFinalType.build();

		/**
		 * build the planet
		 */

		NoiseMapBuilderSphere planet = new NoiseMapBuilderSphere();
		NoiseMap elevGrid = new NoiseMap(grid_width, grid_height);

		planet.setBounds(south_coord, north_coord, west_coord, east_coord);
		planet.setDestSize(grid_width, grid_height);

		planet.setSourceModule(finalPlanet);
		planet.setDestNoiseMap(elevGrid);
		planet.build();
		RenderImageParameter renderImageParameter = new RenderImageParameter(PlanarTerranIF.gradientPointList, elevGrid, renderParameter,
				lightcontrast, lightcontrast);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);

		return imageCafe;
	}
}
