package components;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.BillowBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.module.Billow;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Multiply;
import libnoiseforjava.module.ScaleBias;

public class PlanarPlainsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarPlainsType.class);
	
	Double plains_lacunarity;
	
	Double plains_terrain_bi0_frequency;
	Double plains_terrain_bi0_persistence;
	Integer plains_terrain_bi0_octave_count;
	
	NoiseQuality noiseQuality;
	
	Double plains_terrain_sb0_scale;
	Double plains_terrain_sb0_bias;
	
	Double plains_terrain_bi1_frequency;
	Double plains_terrain_bi1_persistence;
	Integer plains_terrain_bi1_octave_count;

	Double plains_terrain_sb1_scale;
	Double plains_terrain_sb1_bias;
	
	Double plains_terrain_sb2_scale;
	Double plains_terrain_sb2_bias;
	
	Cached plainsTerrain;
	
	public PlanarPlainsType(Double plains_lacunarity, Double plains_terrain_bi0_frequency,
			Double plains_terrain_bi0_persistence, Integer plains_terrain_bi0_octave_count, NoiseQuality noiseQuality,
			Double plains_terrain_sb0_scale, Double plains_terrain_sb0_bias, Double plains_terrain_bi1_frequency,
			Double plains_terrain_bi1_persistence, Integer plains_terrain_bi1_octave_count,
			Double plains_terrain_sb1_scale, Double plains_terrain_sb1_bias, Double plains_terrain_sb2_scale,
			Double plains_terrain_sb2_bias) {
		super();
		this.plains_lacunarity = plains_lacunarity;
		this.plains_terrain_bi0_frequency = plains_terrain_bi0_frequency;
		this.plains_terrain_bi0_persistence = plains_terrain_bi0_persistence;
		this.plains_terrain_bi0_octave_count = plains_terrain_bi0_octave_count;
		this.noiseQuality = noiseQuality;
		this.plains_terrain_sb0_scale = plains_terrain_sb0_scale;
		this.plains_terrain_sb0_bias = plains_terrain_sb0_bias;
		this.plains_terrain_bi1_frequency = plains_terrain_bi1_frequency;
		this.plains_terrain_bi1_persistence = plains_terrain_bi1_persistence;
		this.plains_terrain_bi1_octave_count = plains_terrain_bi1_octave_count;
		this.plains_terrain_sb1_scale = plains_terrain_sb1_scale;
		this.plains_terrain_sb1_bias = plains_terrain_sb1_bias;
		this.plains_terrain_sb2_scale = plains_terrain_sb2_scale;
		this.plains_terrain_sb2_bias = plains_terrain_sb2_bias;
	}



	@Override
	public Cached build() {
		Billow billow0 = new BillowBuilder().build(plains_terrain_bi0_frequency, plains_terrain_bi0_persistence,
				plains_lacunarity, plains_terrain_bi0_octave_count, noiseQuality);
		ScaleBias scaleBias0 = new ScaleBiasBuilder().build(plains_terrain_sb0_scale, plains_terrain_sb0_bias, billow0);
		Billow billow1 = new BillowBuilder().build(plains_terrain_bi1_frequency, plains_terrain_bi1_persistence,
				plains_lacunarity, plains_terrain_bi1_octave_count, noiseQuality);
		ScaleBias scaleBias1 = new ScaleBiasBuilder().build(plains_terrain_sb1_scale, plains_terrain_sb1_bias, billow1);
		Multiply plainsTerrain_mu = new Multiply(scaleBias0, scaleBias1);
		ScaleBias scaleBias2 = new ScaleBiasBuilder().build(plains_terrain_sb2_scale, plains_terrain_sb2_bias,
				plainsTerrain_mu);
		this.plainsTerrain = new Cached(scaleBias2);
		logger.info(this.toString());
		return this.plainsTerrain;
	}



	public Double getPlains_lacunarity() {
		return plains_lacunarity;
	}



	public void setPlains_lacunarity(Double plains_lacunarity) {
		this.plains_lacunarity = plains_lacunarity;
	}



	public Double getPlains_terrain_bi0_frequency() {
		return plains_terrain_bi0_frequency;
	}



	public void setPlains_terrain_bi0_frequency(Double plains_terrain_bi0_frequency) {
		this.plains_terrain_bi0_frequency = plains_terrain_bi0_frequency;
	}



	public Double getPlains_terrain_bi0_persistence() {
		return plains_terrain_bi0_persistence;
	}



	public void setPlains_terrain_bi0_persistence(Double plains_terrain_bi0_persistence) {
		this.plains_terrain_bi0_persistence = plains_terrain_bi0_persistence;
	}



	public Integer getPlains_terrain_bi0_octave_count() {
		return plains_terrain_bi0_octave_count;
	}



	public void setPlains_terrain_bi0_octave_count(Integer plains_terrain_bi0_octave_count) {
		this.plains_terrain_bi0_octave_count = plains_terrain_bi0_octave_count;
	}



	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}



	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}



	public Double getPlains_terrain_sb0_scale() {
		return plains_terrain_sb0_scale;
	}



	public void setPlains_terrain_sb0_scale(Double plains_terrain_sb0_scale) {
		this.plains_terrain_sb0_scale = plains_terrain_sb0_scale;
	}



	public Double getPlains_terrain_sb0_bias() {
		return plains_terrain_sb0_bias;
	}



	public void setPlains_terrain_sb0_bias(Double plains_terrain_sb0_bias) {
		this.plains_terrain_sb0_bias = plains_terrain_sb0_bias;
	}



	public Double getPlains_terrain_bi1_frequency() {
		return plains_terrain_bi1_frequency;
	}



	public void setPlains_terrain_bi1_frequency(Double plains_terrain_bi1_frequency) {
		this.plains_terrain_bi1_frequency = plains_terrain_bi1_frequency;
	}



	public Double getPlains_terrain_bi1_persistence() {
		return plains_terrain_bi1_persistence;
	}



	public void setPlains_terrain_bi1_persistence(Double plains_terrain_bi1_persistence) {
		this.plains_terrain_bi1_persistence = plains_terrain_bi1_persistence;
	}



	public Integer getPlains_terrain_bi1_octave_count() {
		return plains_terrain_bi1_octave_count;
	}



	public void setPlains_terrain_bi1_octave_count(Integer plains_terrain_bi1_octave_count) {
		this.plains_terrain_bi1_octave_count = plains_terrain_bi1_octave_count;
	}



	public Double getPlains_terrain_sb1_scale() {
		return plains_terrain_sb1_scale;
	}



	public void setPlains_terrain_sb1_scale(Double plains_terrain_sb1_scale) {
		this.plains_terrain_sb1_scale = plains_terrain_sb1_scale;
	}



	public Double getPlains_terrain_sb1_bias() {
		return plains_terrain_sb1_bias;
	}



	public void setPlains_terrain_sb1_bias(Double plains_terrain_sb1_bias) {
		this.plains_terrain_sb1_bias = plains_terrain_sb1_bias;
	}



	public Double getPlains_terrain_sb2_scale() {
		return plains_terrain_sb2_scale;
	}



	public void setPlains_terrain_sb2_scale(Double plains_terrain_sb2_scale) {
		this.plains_terrain_sb2_scale = plains_terrain_sb2_scale;
	}



	public Double getPlains_terrain_sb2_bias() {
		return plains_terrain_sb2_bias;
	}



	public void setPlains_terrain_sb2_bias(Double plains_terrain_sb2_bias) {
		this.plains_terrain_sb2_bias = plains_terrain_sb2_bias;
	}



	@Override
	public String toString() {
		return "PlanarPlainsType [plains_lacunarity=" + plains_lacunarity + ", plains_terrain_bi0_frequency="
				+ plains_terrain_bi0_frequency + ", plains_terrain_bi0_persistence=" + plains_terrain_bi0_persistence
				+ ", plains_terrain_bi0_octave_count=" + plains_terrain_bi0_octave_count + ", noiseQuality="
				+ noiseQuality + ", plains_terrain_sb0_scale=" + plains_terrain_sb0_scale + ", plains_terrain_sb0_bias="
				+ plains_terrain_sb0_bias + ", plains_terrain_bi1_frequency=" + plains_terrain_bi1_frequency
				+ ", plains_terrain_bi1_persistence=" + plains_terrain_bi1_persistence
				+ ", plains_terrain_bi1_octave_count=" + plains_terrain_bi1_octave_count + ", plains_terrain_sb1_scale="
				+ plains_terrain_sb1_scale + ", plains_terrain_sb1_bias=" + plains_terrain_sb1_bias
				+ ", plains_terrain_sb2_scale=" + plains_terrain_sb2_scale + ", plains_terrain_sb2_bias="
				+ plains_terrain_sb2_bias + "]";
	}

	
}
