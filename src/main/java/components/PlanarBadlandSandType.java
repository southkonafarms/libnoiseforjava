package components;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.VoronoiBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Voronoi;

public class PlanarBadlandSandType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarBadlandSandType.class);
	
	Double badlands_lacunarity;
	
	NoiseQuality noiseQuality;
	
	Double badlands_sand_rm_frequency;
	Integer badlands_sand_rm_octave_count;
	
	Double badlands_sand_sb0_scale;
	Double badlands_sand_sb0_bias;
	
	Double badlands_sand_vo_frequency;
	Double badlands_sand_vo_displacement;	
	Boolean enableDistance;
	
	Double badlands_sand_sb1_scale;
	Double badlands_sand_sb1_bias;
	
	Cached cached;

	

	public PlanarBadlandSandType(Double badlands_lacunarity, NoiseQuality noiseQuality,
			Double badlands_sand_rm_frequency, Integer badlands_sand_rm_octave_count, Double badlands_sand_sb0_scale,
			Double badlands_sand_sb0_bias, Double badlands_sand_vo_frequency, Double badlands_sand_vo_displacement,
			Boolean enableDistance, Double badlands_sand_sb1_scale, Double badlands_sand_sb1_bias) {
		super();
		this.badlands_lacunarity = badlands_lacunarity;
		this.noiseQuality = noiseQuality;
		this.badlands_sand_rm_frequency = badlands_sand_rm_frequency;
		this.badlands_sand_rm_octave_count = badlands_sand_rm_octave_count;
		this.badlands_sand_sb0_scale = badlands_sand_sb0_scale;
		this.badlands_sand_sb0_bias = badlands_sand_sb0_bias;
		this.badlands_sand_vo_frequency = badlands_sand_vo_frequency;
		this.badlands_sand_vo_displacement = badlands_sand_vo_displacement;
		this.enableDistance = enableDistance;
		this.badlands_sand_sb1_scale = badlands_sand_sb1_scale;
		this.badlands_sand_sb1_bias = badlands_sand_sb1_bias;
	}



	@Override
	public Cached build() {
		RidgedMulti ridgedMulti = new RidgedMultiBuilder().build(badlands_sand_rm_frequency, badlands_lacunarity, badlands_sand_rm_octave_count, noiseQuality);
		ScaleBias scaleBias_0 = new ScaleBiasBuilder().build(badlands_sand_sb0_scale, badlands_sand_sb0_bias, ridgedMulti);
		Voronoi voronoi = new VoronoiBuilder().build(badlands_sand_vo_frequency, badlands_sand_vo_displacement, enableDistance);
		ScaleBias scaleBias_1 = new ScaleBiasBuilder().build(badlands_sand_sb1_scale, badlands_sand_sb1_bias, voronoi);
		Add badlandsSand_ad = new Add(scaleBias_0,	scaleBias_1);
		this.cached = new Cached(badlandsSand_ad);
		logger.info(this.toString());
		return this.cached;
	}



	public Double getBadlands_lacunarity() {
		return badlands_lacunarity;
	}



	public void setBadlands_lacunarity(Double badlands_lacunarity) {
		this.badlands_lacunarity = badlands_lacunarity;
	}



	public Double getBadlands_sand_rm_frequency() {
		return badlands_sand_rm_frequency;
	}



	public void setBadlands_sand_rm_frequency(Double badlands_sand_rm_frequency) {
		this.badlands_sand_rm_frequency = badlands_sand_rm_frequency;
	}



	public Integer getBadlands_sand_rm_octave_count() {
		return badlands_sand_rm_octave_count;
	}



	public void setBadlands_sand_rm_octave_count(Integer badlands_sand_rm_octave_count) {
		this.badlands_sand_rm_octave_count = badlands_sand_rm_octave_count;
	}



	public Double getBadlands_sand_sb0_scale() {
		return badlands_sand_sb0_scale;
	}



	public void setBadlands_sand_sb0_scale(Double badlands_sand_sb0_scale) {
		this.badlands_sand_sb0_scale = badlands_sand_sb0_scale;
	}



	public Double getBadlands_sand_sb0_bias() {
		return badlands_sand_sb0_bias;
	}



	public void setBadlands_sand_sb0_bias(Double badlands_sand_sb0_bias) {
		this.badlands_sand_sb0_bias = badlands_sand_sb0_bias;
	}



	public Double getBadlands_sand_vo_frequency() {
		return badlands_sand_vo_frequency;
	}



	public void setBadlands_sand_vo_frequency(Double badlands_sand_vo_frequency) {
		this.badlands_sand_vo_frequency = badlands_sand_vo_frequency;
	}



	public Double getBadlands_sand_vo_displacement() {
		return badlands_sand_vo_displacement;
	}



	public void setBadlands_sand_vo_displacement(Double badlands_sand_vo_displacement) {
		this.badlands_sand_vo_displacement = badlands_sand_vo_displacement;
	}



	public Boolean getEnableDistance() {
		return enableDistance;
	}



	public void setEnableDistance(Boolean enableDistance) {
		this.enableDistance = enableDistance;
	}



	public Double getBadlands_sand_sb1_scale() {
		return badlands_sand_sb1_scale;
	}



	public void setBadlands_sand_sb1_scale(Double badlands_sand_sb1_scale) {
		this.badlands_sand_sb1_scale = badlands_sand_sb1_scale;
	}



	public Double getBadlands_sand_sb1_bias() {
		return badlands_sand_sb1_bias;
	}



	public void setBadlands_sand_sb1_bias(Double badlands_sand_sb1_bias) {
		this.badlands_sand_sb1_bias = badlands_sand_sb1_bias;
	}



	public Cached getCached() {
		return cached;
	}



	public void setCached(Cached cached) {
		this.cached = cached;
	}

	@Override
	public String toString() {
		return "PlanarBadlandSandType [badlands_lacunarity=" + badlands_lacunarity + ", noiseQuality=" + noiseQuality
				+ ", badlands_sand_rm_frequency=" + badlands_sand_rm_frequency + ", badlands_sand_rm_octave_count="
				+ badlands_sand_rm_octave_count + ", badlands_sand_sb0_scale=" + badlands_sand_sb0_scale
				+ ", badlands_sand_sb0_bias=" + badlands_sand_sb0_bias + ", badlands_sand_vo_frequency="
				+ badlands_sand_vo_frequency + ", badlands_sand_vo_displacement=" + badlands_sand_vo_displacement
				+ ", enableDistance=" + enableDistance + ", badlands_sand_sb1_scale=" + badlands_sand_sb1_scale
				+ ", badlands_sand_sb1_bias=" + badlands_sand_sb1_bias + "]";
	}

}
