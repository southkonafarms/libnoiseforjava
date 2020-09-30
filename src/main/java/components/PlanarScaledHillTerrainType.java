package components;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ExponentBuilder;
import libnoiseforjava.domain.PerlinBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Exponent;
import libnoiseforjava.module.Multiply;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.module.ScaleBias;

public class PlanarScaledHillTerrainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarScaledHillTerrainType.class);
	
	Double scaled_hilly_terrain_sb0_scale;
	Double scaled_hilly_terrain_sb0_bias;
	Double scaled_hilly_terrain_sb1_scale;
	Double scaled_hilly_terrain_sb1_bias;
	
	Cached hilly_terrain;
	
	Double scaled_hilly_terrain_pe_frequency;
	Double scaled_hilly_terrain_pe_persistence;
	Double hills_lacunarity;
	Integer scaled_hilly_terrain_octave_count;
	
	NoiseQuality noiseQuality;
	
	Double scaled_hilly_terrain_ex_exponent;
	
	Cached scaled_hilly_terrain;
	
	public PlanarScaledHillTerrainType(Double scaled_hilly_terrain_sb0_scale, Double scaled_hilly_terrain_sb0_bias,
			Double scaled_hilly_terrain_sb1_scale, Double scaled_hilly_terrain_sb1_bias, Cached hilly_terrain,
			Double scaled_hilly_terrain_pe_frequency, Double scaled_hilly_terrain_pe_persistence,
			Double hills_lacunarity, Integer scaled_hilly_terrain_octave_count, NoiseQuality noiseQuality,
			Double scaled_hilly_terrain_ex_exponent) {
		super();
		this.scaled_hilly_terrain_sb0_scale = scaled_hilly_terrain_sb0_scale;
		this.scaled_hilly_terrain_sb0_bias = scaled_hilly_terrain_sb0_bias;
		this.scaled_hilly_terrain_sb1_scale = scaled_hilly_terrain_sb1_scale;
		this.scaled_hilly_terrain_sb1_bias = scaled_hilly_terrain_sb1_bias;
		this.hilly_terrain = hilly_terrain;
		this.scaled_hilly_terrain_pe_frequency = scaled_hilly_terrain_pe_frequency;
		this.scaled_hilly_terrain_pe_persistence = scaled_hilly_terrain_pe_persistence;
		this.hills_lacunarity = hills_lacunarity;
		this.scaled_hilly_terrain_octave_count = scaled_hilly_terrain_octave_count;
		this.noiseQuality = noiseQuality;
		this.scaled_hilly_terrain_ex_exponent = scaled_hilly_terrain_ex_exponent;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias_0 = new ScaleBiasBuilder().build(scaled_hilly_terrain_sb0_scale, scaled_hilly_terrain_sb0_bias, hilly_terrain);
		Perlin perlin = new PerlinBuilder().biuld(scaled_hilly_terrain_pe_frequency, scaled_hilly_terrain_pe_persistence, hills_lacunarity, scaled_hilly_terrain_octave_count, noiseQuality);
		Exponent exponent = new ExponentBuilder().build(scaled_hilly_terrain_ex_exponent, perlin);
		ScaleBias scaleBias_1 = new ScaleBiasBuilder().build(scaled_hilly_terrain_sb1_scale, scaled_hilly_terrain_sb1_bias, hilly_terrain);
		Multiply scaledHillyTerrain_mu = new Multiply(
				scaleBias_0, scaleBias_1);
		this.scaled_hilly_terrain = new Cached(scaledHillyTerrain_mu);
		logger.info(this.toString());
		return this.scaled_hilly_terrain;
	}

	public Double getScaled_hilly_terrain_sb0_scale() {
		return scaled_hilly_terrain_sb0_scale;
	}

	public void setScaled_hilly_terrain_sb0_scale(Double scaled_hilly_terrain_sb0_scale) {
		this.scaled_hilly_terrain_sb0_scale = scaled_hilly_terrain_sb0_scale;
	}

	public Double getScaled_hilly_terrain_sb0_bias() {
		return scaled_hilly_terrain_sb0_bias;
	}

	public void setScaled_hilly_terrain_sb0_bias(Double scaled_hilly_terrain_sb0_bias) {
		this.scaled_hilly_terrain_sb0_bias = scaled_hilly_terrain_sb0_bias;
	}

	public Double getScaled_hilly_terrain_sb1_scale() {
		return scaled_hilly_terrain_sb1_scale;
	}

	public void setScaled_hilly_terrain_sb1_scale(Double scaled_hilly_terrain_sb1_scale) {
		this.scaled_hilly_terrain_sb1_scale = scaled_hilly_terrain_sb1_scale;
	}

	public Double getScaled_hilly_terrain_sb1_bias() {
		return scaled_hilly_terrain_sb1_bias;
	}

	public void setScaled_hilly_terrain_sb1_bias(Double scaled_hilly_terrain_sb1_bias) {
		this.scaled_hilly_terrain_sb1_bias = scaled_hilly_terrain_sb1_bias;
	}

	public Cached getHilly_terrain() {
		return hilly_terrain;
	}

	public void setHilly_terrain(Cached hilly_terrain) {
		this.hilly_terrain = hilly_terrain;
	}

	public Double getScaled_hilly_terrain_pe_frequency() {
		return scaled_hilly_terrain_pe_frequency;
	}

	public void setScaled_hilly_terrain_pe_frequency(Double scaled_hilly_terrain_pe_frequency) {
		this.scaled_hilly_terrain_pe_frequency = scaled_hilly_terrain_pe_frequency;
	}

	public Double getScaled_hilly_terrain_pe_persistence() {
		return scaled_hilly_terrain_pe_persistence;
	}

	public void setScaled_hilly_terrain_pe_persistence(Double scaled_hilly_terrain_pe_persistence) {
		this.scaled_hilly_terrain_pe_persistence = scaled_hilly_terrain_pe_persistence;
	}

	public Double getHills_lacunarity() {
		return hills_lacunarity;
	}

	public void setHills_lacunarity(Double hills_lacunarity) {
		this.hills_lacunarity = hills_lacunarity;
	}

	public Integer getScaled_hilly_terrain_octave_count() {
		return scaled_hilly_terrain_octave_count;
	}

	public void setScaled_hilly_terrain_octave_count(Integer scaled_hilly_terrain_octave_count) {
		this.scaled_hilly_terrain_octave_count = scaled_hilly_terrain_octave_count;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public Double getScaled_hilly_terrain_ex_exponent() {
		return scaled_hilly_terrain_ex_exponent;
	}

	public void setScaled_hilly_terrain_ex_exponent(Double scaled_hilly_terrain_ex_exponent) {
		this.scaled_hilly_terrain_ex_exponent = scaled_hilly_terrain_ex_exponent;
	}

	@Override
	public String toString() {
		return "PlanarScaledHillTerrain [scaled_hilly_terrain_sb0_scale=" + scaled_hilly_terrain_sb0_scale
				+ ", scaled_hilly_terrain_sb0_bias=" + scaled_hilly_terrain_sb0_bias
				+ ", scaled_hilly_terrain_sb1_scale=" + scaled_hilly_terrain_sb1_scale
				+ ", scaled_hilly_terrain_sb1_bias=" + scaled_hilly_terrain_sb1_bias
				+ ", scaled_hilly_terrain_pe_frequency=" + scaled_hilly_terrain_pe_frequency
				+ ", scaled_hilly_terrain_pe_persistence=" + scaled_hilly_terrain_pe_persistence + ", hills_lacunarity="
				+ hills_lacunarity + ", scaled_hilly_terrain_octave_count=" + scaled_hilly_terrain_octave_count
				+ ", noiseQuality=" + noiseQuality + ", scaled_hilly_terrain_ex_exponent="
				+ scaled_hilly_terrain_ex_exponent + "]";
	}

}
