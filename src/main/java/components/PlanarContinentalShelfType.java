package components;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ClampBuilder;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.TerraceBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Clamp;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Terrace;

public class PlanarContinentalShelfType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentalShelfType.class);
	
	Double continental_shelf_te_lowest_control_point;
	Double continental_shelf_te_low_control_point;
	Double continental_shelf_te_high_control_point;
	Double shelf_level;
	Cached continentDef;
	
	Double continental_shelf_frequency_scalar;
	Double continent_lacunarity;
	Integer continental_shelf_octave_count;
	NoiseQuality noiseQuality;
	
	Double continental_shelf_sb_scale;
	Double continental_shelf_sb_bias;

	Double continental_shelf_cl_bounds;
	Double sea_level;
	
	Cached continentalShelf;
	
	public PlanarContinentalShelfType(Double continental_shelf_te_lowest_control_point,
			Double continental_shelf_te_low_control_point, Double continental_shelf_te_high_control_point,
			Double shelf_level, Cached continentDef, Double continental_shelf_frequency_scalar,
			Double continent_lacunarity, Integer continental_shelf_octave_count, NoiseQuality noiseQuality,
			Double continental_shelf_sb_scale, Double continental_shelf_sb_bias, Double continental_shelf_cl_bounds,
			Double sea_level) {
		super();
		this.continental_shelf_te_lowest_control_point = continental_shelf_te_lowest_control_point;
		this.continental_shelf_te_low_control_point = continental_shelf_te_low_control_point;
		this.continental_shelf_te_high_control_point = continental_shelf_te_high_control_point;
		this.shelf_level = shelf_level;
		this.continentDef = continentDef;
		this.continental_shelf_frequency_scalar = continental_shelf_frequency_scalar;
		this.continent_lacunarity = continent_lacunarity;
		this.continental_shelf_octave_count = continental_shelf_octave_count;
		this.noiseQuality = noiseQuality;
		this.continental_shelf_sb_scale = continental_shelf_sb_scale;
		this.continental_shelf_sb_bias = continental_shelf_sb_bias;
		this.continental_shelf_cl_bounds = continental_shelf_cl_bounds;
		this.sea_level = sea_level;
	}

	@Override
	public Cached build() {
		List<Double> controlPoints = new ArrayList<Double>();
		controlPoints.add(continental_shelf_te_lowest_control_point);
		controlPoints.add(continental_shelf_te_low_control_point);
		controlPoints.add(shelf_level);
		controlPoints.add(continental_shelf_te_high_control_point);
		Terrace terrace = new TerraceBuilder().build(controlPoints, continentDef);
		
		RidgedMulti ridgedMulti = new RidgedMultiBuilder().build(continental_shelf_frequency_scalar,
				continent_lacunarity, continental_shelf_octave_count, noiseQuality);
		ScaleBias scaleBias = new ScaleBiasBuilder().build(continental_shelf_sb_scale, continental_shelf_sb_bias,
				ridgedMulti);
		
		Clamp clamp = new ClampBuilder().build(scaleBias, continental_shelf_cl_bounds, sea_level);
		Add continentalShelf_ad = new Add(scaleBias, clamp);
		this.continentalShelf = new Cached(continentalShelf_ad);
		logger.info(this.toString());
		return this.continentalShelf;
	}

	public Double getContinental_shelf_te_lowest_control_point() {
		return continental_shelf_te_lowest_control_point;
	}

	public void setContinental_shelf_te_lowest_control_point(Double continental_shelf_te_lowest_control_point) {
		this.continental_shelf_te_lowest_control_point = continental_shelf_te_lowest_control_point;
	}

	public Double getContinental_shelf_te_low_control_point() {
		return continental_shelf_te_low_control_point;
	}

	public void setContinental_shelf_te_low_control_point(Double continental_shelf_te_low_control_point) {
		this.continental_shelf_te_low_control_point = continental_shelf_te_low_control_point;
	}

	public Double getContinental_shelf_te_high_control_point() {
		return continental_shelf_te_high_control_point;
	}

	public void setContinental_shelf_te_high_control_point(Double continental_shelf_te_high_control_point) {
		this.continental_shelf_te_high_control_point = continental_shelf_te_high_control_point;
	}

	public Double getShelf_level() {
		return shelf_level;
	}

	public void setShelf_level(Double shelf_level) {
		this.shelf_level = shelf_level;
	}

	public Cached getContinentDef() {
		return continentDef;
	}

	public void setContinentDef(Cached continentDef) {
		this.continentDef = continentDef;
	}

	public Double getContinental_shelf_frequency_scalar() {
		return continental_shelf_frequency_scalar;
	}

	public void setContinental_shelf_frequency_scalar(Double continental_shelf_frequency_scalar) {
		this.continental_shelf_frequency_scalar = continental_shelf_frequency_scalar;
	}

	public Double getContinent_lacunarity() {
		return continent_lacunarity;
	}

	public void setContinent_lacunarity(Double continent_lacunarity) {
		this.continent_lacunarity = continent_lacunarity;
	}

	public Integer getContinental_shelf_octave_count() {
		return continental_shelf_octave_count;
	}

	public void setContinental_shelf_octave_count(Integer continental_shelf_octave_count) {
		this.continental_shelf_octave_count = continental_shelf_octave_count;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public Double getContinental_shelf_sb_scale() {
		return continental_shelf_sb_scale;
	}

	public void setContinental_shelf_sb_scale(Double continental_shelf_sb_scale) {
		this.continental_shelf_sb_scale = continental_shelf_sb_scale;
	}

	public Double getContinental_shelf_sb_bias() {
		return continental_shelf_sb_bias;
	}

	public void setContinental_shelf_sb_bias(Double continental_shelf_sb_bias) {
		this.continental_shelf_sb_bias = continental_shelf_sb_bias;
	}

	public Double getContinental_shelf_cl_bounds() {
		return continental_shelf_cl_bounds;
	}

	public void setContinental_shelf_cl_bounds(Double continental_shelf_cl_bounds) {
		this.continental_shelf_cl_bounds = continental_shelf_cl_bounds;
	}

	public Double getSea_level() {
		return sea_level;
	}

	public void setSea_level(Double sea_level) {
		this.sea_level = sea_level;
	}

	@Override
	public String toString() {
		return "PlanarContinentalShelfType [continental_shelf_te_lowest_control_point="
				+ continental_shelf_te_lowest_control_point + ", continental_shelf_te_low_control_point="
				+ continental_shelf_te_low_control_point + ", continental_shelf_te_high_control_point="
				+ continental_shelf_te_high_control_point + ", shelf_level=" + shelf_level
				+ ", continental_shelf_frequency_scalar=" + continental_shelf_frequency_scalar
				+ ", continent_lacunarity=" + continent_lacunarity + ", continental_shelf_octave_count="
				+ continental_shelf_octave_count + ", noiseQuality=" + noiseQuality + ", continental_shelf_sb_scale="
				+ continental_shelf_sb_scale + ", continental_shelf_sb_bias=" + continental_shelf_sb_bias
				+ ", continental_shelf_cl_bounds=" + continental_shelf_cl_bounds + ", sea_level=" + sea_level + "]";
	}

}
