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

public class PlanarScaledMountainTerrainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarScaledMountainTerrainType.class);
	
	Double scaled_mountainous_terrain_sb0_scale;
	Double scaled_mountainous_terrain_sb0_bias;
	Double scaled_mountainous_terrain_sb1_scale;
	Double scaled_mountainous_terrain_sb1_bias;

	Cached mountainous_terrain;
	
	Double scaled_mountainous_terrain_pe_frequency;
	Double scaled_mountainous_terrain_pe_persistence;
	Double mountain_lacunarity;
	Integer scaled_mountainous_terrain_pe_octave_count;
	NoiseQuality noiseQuality;
	
	Double scaled_mountainous_terrain_ex_exponent;
	
	Cached scaledMountainousTerrain;
	
	

	public PlanarScaledMountainTerrainType(Double scaled_mountainous_terrain_sb0_scale,
			Double scaled_mountainous_terrain_sb0_bias, Double scaled_mountainous_terrain_sb1_scale,
			Double scaled_mountainous_terrain_sb1_bias, Cached mountainous_terrain,
			Double scaled_mountainous_terrain_pe_frequency, Double scaled_mountainous_terrain_pe_persistence,
			Double mountain_lacunarity, Integer scaled_mountainous_terrain_pe_octave_count, NoiseQuality noiseQuality,
			Double scaled_mountainous_terrain_ex_exponent) {
		super();
		this.scaled_mountainous_terrain_sb0_scale = scaled_mountainous_terrain_sb0_scale;
		this.scaled_mountainous_terrain_sb0_bias = scaled_mountainous_terrain_sb0_bias;
		this.scaled_mountainous_terrain_sb1_scale = scaled_mountainous_terrain_sb1_scale;
		this.scaled_mountainous_terrain_sb1_bias = scaled_mountainous_terrain_sb1_bias;
		this.mountainous_terrain = mountainous_terrain;
		this.scaled_mountainous_terrain_pe_frequency = scaled_mountainous_terrain_pe_frequency;
		this.scaled_mountainous_terrain_pe_persistence = scaled_mountainous_terrain_pe_persistence;
		this.mountain_lacunarity = mountain_lacunarity;
		this.scaled_mountainous_terrain_pe_octave_count = scaled_mountainous_terrain_pe_octave_count;
		this.noiseQuality = noiseQuality;
		this.scaled_mountainous_terrain_ex_exponent = scaled_mountainous_terrain_ex_exponent;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias_0 = new ScaleBiasBuilder().build(scaled_mountainous_terrain_sb0_scale,
				scaled_mountainous_terrain_sb0_bias, mountainous_terrain);
		Perlin perlin = new PerlinBuilder().biuld(scaled_mountainous_terrain_pe_frequency,
				scaled_mountainous_terrain_pe_persistence, mountain_lacunarity,
				scaled_mountainous_terrain_pe_octave_count, noiseQuality);
		Exponent exponent = new ExponentBuilder().build(scaled_mountainous_terrain_ex_exponent, perlin);
		ScaleBias scaleBias_1 = new ScaleBiasBuilder().build(scaled_mountainous_terrain_sb1_scale,
				scaled_mountainous_terrain_sb1_bias, exponent);
		Multiply scaledMountainousTerrain_mu = new Multiply(scaleBias_0, scaleBias_1);
		this.scaledMountainousTerrain = new Cached(scaledMountainousTerrain_mu);
		logger.info(this.toString());
		return this.scaledMountainousTerrain;
	}

	public Double getScaled_mountainous_terrain_sb0_scale() {
		return scaled_mountainous_terrain_sb0_scale;
	}

	public void setScaled_mountainous_terrain_sb0_scale(Double scaled_mountainous_terrain_sb0_scale) {
		this.scaled_mountainous_terrain_sb0_scale = scaled_mountainous_terrain_sb0_scale;
	}

	public Double getScaled_mountainous_terrain_sb0_bias() {
		return scaled_mountainous_terrain_sb0_bias;
	}

	public void setScaled_mountainous_terrain_sb0_bias(Double scaled_mountainous_terrain_sb0_bias) {
		this.scaled_mountainous_terrain_sb0_bias = scaled_mountainous_terrain_sb0_bias;
	}

	public Double getScaled_mountainous_terrain_sb1_scale() {
		return scaled_mountainous_terrain_sb1_scale;
	}

	public void setScaled_mountainous_terrain_sb1_scale(Double scaled_mountainous_terrain_sb1_scale) {
		this.scaled_mountainous_terrain_sb1_scale = scaled_mountainous_terrain_sb1_scale;
	}

	public Double getScaled_mountainous_terrain_sb1_bias() {
		return scaled_mountainous_terrain_sb1_bias;
	}

	public void setScaled_mountainous_terrain_sb1_bias(Double scaled_mountainous_terrain_sb1_bias) {
		this.scaled_mountainous_terrain_sb1_bias = scaled_mountainous_terrain_sb1_bias;
	}

	public Cached getMountainous_terrain() {
		return mountainous_terrain;
	}

	public void setMountainous_terrain(Cached mountainous_terrain) {
		this.mountainous_terrain = mountainous_terrain;
	}

	public Double getScaled_mountainous_terrain_pe_frequency() {
		return scaled_mountainous_terrain_pe_frequency;
	}

	public void setScaled_mountainous_terrain_pe_frequency(Double scaled_mountainous_terrain_pe_frequency) {
		this.scaled_mountainous_terrain_pe_frequency = scaled_mountainous_terrain_pe_frequency;
	}

	public Double getScaled_mountainous_terrain_pe_persistence() {
		return scaled_mountainous_terrain_pe_persistence;
	}

	public void setScaled_mountainous_terrain_pe_persistence(Double scaled_mountainous_terrain_pe_persistence) {
		this.scaled_mountainous_terrain_pe_persistence = scaled_mountainous_terrain_pe_persistence;
	}

	public Double getMountain_lacunarity() {
		return mountain_lacunarity;
	}

	public void setMountain_lacunarity(Double mountain_lacunarity) {
		this.mountain_lacunarity = mountain_lacunarity;
	}

	public Integer getScaled_mountainous_terrain_pe_octave_count() {
		return scaled_mountainous_terrain_pe_octave_count;
	}

	public void setScaled_mountainous_terrain_pe_octave_count(Integer scaled_mountainous_terrain_pe_octave_count) {
		this.scaled_mountainous_terrain_pe_octave_count = scaled_mountainous_terrain_pe_octave_count;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public Double getScaled_mountainous_terrain_ex_exponent() {
		return scaled_mountainous_terrain_ex_exponent;
	}

	public void setScaled_mountainous_terrain_ex_exponent(Double scaled_mountainous_terrain_ex_exponent) {
		this.scaled_mountainous_terrain_ex_exponent = scaled_mountainous_terrain_ex_exponent;
	}

	@Override
	public String toString() {
		return "PlanarScaledMountainTerrain [scaled_mountainous_terrain_sb0_scale="
				+ scaled_mountainous_terrain_sb0_scale + ", scaled_mountainous_terrain_sb0_bias="
				+ scaled_mountainous_terrain_sb0_bias + ", scaled_mountainous_terrain_sb1_scale="
				+ scaled_mountainous_terrain_sb1_scale + ", scaled_mountainous_terrain_sb1_bias="
				+ scaled_mountainous_terrain_sb1_bias + ", scaled_mountainous_terrain_pe_frequency="
				+ scaled_mountainous_terrain_pe_frequency + ", scaled_mountainous_terrain_pe_persistence="
				+ scaled_mountainous_terrain_pe_persistence + ", mountain_lacunarity=" + mountain_lacunarity
				+ ", scaled_mountainous_terrain_pe_octave_count=" + scaled_mountainous_terrain_pe_octave_count
				+ ", noiseQuality=" + noiseQuality + ", scaled_mountainous_terrain_ex_exponent="
				+ scaled_mountainous_terrain_ex_exponent + "]";
	}

	
}
