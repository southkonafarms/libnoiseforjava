package components;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Multiply;
import libnoiseforjava.module.RidgedMulti;

public class PlanarLowMountainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarLowMountainType.class);
	
	private Double mountain_low_freqeuncy_0;
	private Integer mountain_low_octave_count_0;
	private Double mountain_low_freqeuncy_1;
	private Integer mountain_low_octave_count_1;	
	private Double mountain_lacunarity;
	private NoiseQuality noise_quality;
	
	private Cached mountainousLow;

	

	public PlanarLowMountainType(Double mountain_low_freqeuncy_0, Integer mountain_low_octave_count_0,
			Double mountain_low_freqeuncy_1, Integer mountain_low_octave_count_1, Double mountain_lacunarity, NoiseQuality noiseQuality) {
		super();
		this.mountain_low_freqeuncy_0 = mountain_low_freqeuncy_0;
		this.mountain_low_octave_count_0 = mountain_low_octave_count_0;
		this.mountain_low_freqeuncy_1 = mountain_low_freqeuncy_1;
		this.mountain_low_octave_count_1 = mountain_low_octave_count_1;
		this.mountain_lacunarity = mountain_lacunarity;
		this.noise_quality = noiseQuality;
	}



	@Override
	public Cached build() {
		RidgedMulti ridgedMulti_0 = new RidgedMultiBuilder().build(mountain_low_freqeuncy_0, mountain_lacunarity, mountain_low_octave_count_0, noise_quality);
		RidgedMulti ridgedMulti_1 = new RidgedMultiBuilder().build(mountain_low_freqeuncy_1, mountain_lacunarity, mountain_low_octave_count_1, noise_quality);
		Multiply mountainousLow_mu = new Multiply(
				ridgedMulti_0, ridgedMulti_1);
		this.mountainousLow = new Cached(mountainousLow_mu);
		logger.info(this.toString());
		return this.mountainousLow;
	}



	public Double getMountain_low_freqeuncy_0() {
		return mountain_low_freqeuncy_0;
	}



	public void setMountain_low_freqeuncy_0(Double mountain_low_freqeuncy_0) {
		this.mountain_low_freqeuncy_0 = mountain_low_freqeuncy_0;
	}



	public Integer getMountain_low_octave_count_0() {
		return mountain_low_octave_count_0;
	}



	public void setMountain_low_octave_count_0(Integer mountain_low_octave_count_0) {
		this.mountain_low_octave_count_0 = mountain_low_octave_count_0;
	}



	public Double getMountain_low_freqeuncy_1() {
		return mountain_low_freqeuncy_1;
	}



	public void setMountain_low_freqeuncy_1(Double mountain_low_freqeuncy_1) {
		this.mountain_low_freqeuncy_1 = mountain_low_freqeuncy_1;
	}



	public Integer getMountain_low_octave_count_1() {
		return mountain_low_octave_count_1;
	}



	public void setMountain_low_octave_count_1(Integer mountain_low_octave_count_1) {
		this.mountain_low_octave_count_1 = mountain_low_octave_count_1;
	}



	public Double getMountain_lacunarity() {
		return mountain_lacunarity;
	}



	public void setMountain_lacunarity(Double mountain_lacunarity) {
		this.mountain_lacunarity = mountain_lacunarity;
	}



	public NoiseQuality getNoise_quality() {
		return noise_quality;
	}



	public void setNoise_quality(NoiseQuality noise_quality) {
		this.noise_quality = noise_quality;
	}



	@Override
	public String toString() {
		return "PlanarLowMountainType [mountain_low_freqeuncy_0=" + mountain_low_freqeuncy_0
				+ ", mountain_low_octave_count_0=" + mountain_low_octave_count_0 + ", mountain_low_freqeuncy_1="
				+ mountain_low_freqeuncy_1 + ", mountain_low_octave_count_1=" + mountain_low_octave_count_1
				+ ", mountain_lacunarity=" + mountain_lacunarity + ", noise_quality=" + noise_quality + "]";
	}

	
}
