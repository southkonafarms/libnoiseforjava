package components;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Max;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.Turbulence;

public class PlanarHighMountainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarHighMountainType.class);
	
	private Double mountain_high_freqeuncy_0;
	private Integer mountain_high_octave_count_0;
	private Double mountain_high_freqeuncy_1;
	private Integer mountain_high_octave_count_1;
	
	private NoiseQuality noiseQuality;
	private Double mountain_lacunarity;
	
	private Double turbulenceFrequency_0;
	private Double turbulencePowerScalar_0;
	private Double turbulencePowerScalar_1;
	private Integer turbulenceRoughness_0;
	private Double twist;
	
	private Cached mountainousHigh;

	public PlanarHighMountainType(Double mountain_high_freqeuncy_0, Integer mountain_high_octave_count_0,
			Double mountain_high_freqeuncy_1, Integer mountain_high_octave_count_1, NoiseQuality noiseQuality,
			Double mountain_lacunarity, Double turbulenceFrequency_0, Double turbulencePowerScalar_0,
			Double turbulencePowerScalar_1, Integer turbulenceRoughness_0, Double twist) {
		super();
		this.mountain_high_freqeuncy_0 = mountain_high_freqeuncy_0;
		this.mountain_high_octave_count_0 = mountain_high_octave_count_0;
		this.mountain_high_freqeuncy_1 = mountain_high_freqeuncy_1;
		this.mountain_high_octave_count_1 = mountain_high_octave_count_1;
		this.noiseQuality = noiseQuality;
		this.mountain_lacunarity = mountain_lacunarity;
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
		this.twist = twist;
	}




	@Override
	public Cached build() {
		RidgedMulti ridgedMulti_0 = new RidgedMultiBuilder().build(mountain_high_freqeuncy_0, mountain_lacunarity,
				mountain_high_octave_count_0, noiseQuality);
		RidgedMulti ridgedMulti_1 = new RidgedMultiBuilder().build(mountain_high_freqeuncy_1, mountain_lacunarity,
				mountain_high_octave_count_1, noiseQuality);
		Max mountainousHigh_ma = new Max(ridgedMulti_0, ridgedMulti_1);
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Double power = turbulencePowerScalar_0 / turbulencePowerScalar_1 * twist;
		Turbulence turbulence = new TurbulenceBuilder().build(currSeed, turbulenceFrequency_0, power,
				turbulenceRoughness_0, mountainousHigh_ma);
		this.mountainousHigh = new Cached(turbulence);
		logger.info(this.toString());
		return this.mountainousHigh;
	}




	public Double getMountain_high_freqeuncy_0() {
		return mountain_high_freqeuncy_0;
	}




	public void setMountain_high_freqeuncy_0(Double mountain_high_freqeuncy_0) {
		this.mountain_high_freqeuncy_0 = mountain_high_freqeuncy_0;
	}




	public Integer getMountain_high_octave_count_0() {
		return mountain_high_octave_count_0;
	}




	public void setMountain_high_octave_count_0(Integer mountain_high_octave_count_0) {
		this.mountain_high_octave_count_0 = mountain_high_octave_count_0;
	}




	public Double getMountain_high_freqeuncy_1() {
		return mountain_high_freqeuncy_1;
	}




	public void setMountain_high_freqeuncy_1(Double mountain_high_freqeuncy_1) {
		this.mountain_high_freqeuncy_1 = mountain_high_freqeuncy_1;
	}




	public Integer getMountain_high_octave_count_1() {
		return mountain_high_octave_count_1;
	}




	public void setMountain_high_octave_count_1(Integer mountain_high_octave_count_1) {
		this.mountain_high_octave_count_1 = mountain_high_octave_count_1;
	}




	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}




	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}




	public Double getMountain_lacunarity() {
		return mountain_lacunarity;
	}




	public void setMountain_lacunarity(Double mountain_lacunarity) {
		this.mountain_lacunarity = mountain_lacunarity;
	}




	public Double getTurbulenceFrequency_0() {
		return turbulenceFrequency_0;
	}




	public void setTurbulenceFrequency_0(Double turbulenceFrequency_0) {
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
	}




	public Double getTurbulencePowerScalar_0() {
		return turbulencePowerScalar_0;
	}




	public void setTurbulencePowerScalar_0(Double turbulencePowerScalar_0) {
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
	}




	public Double getTurbulencePowerScalar_1() {
		return turbulencePowerScalar_1;
	}




	public void setTurbulencePowerScalar_1(Double turbulencePowerScalar_1) {
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
	}




	public Integer getTurbulenceRoughness_0() {
		return turbulenceRoughness_0;
	}




	public void setTurbulenceRoughness_0(Integer turbulenceRoughness_0) {
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
	}




	public Double getTwist() {
		return twist;
	}




	public void setTwist(Double twist) {
		this.twist = twist;
	}




	@Override
	public String toString() {
		return "PlanarHighMountainType [mountain_high_freqeuncy_0=" + mountain_high_freqeuncy_0
				+ ", mountain_high_octave_count_0=" + mountain_high_octave_count_0 + ", mountain_high_freqeuncy_1="
				+ mountain_high_freqeuncy_1 + ", mountain_high_octave_count_1=" + mountain_high_octave_count_1
				+ ", noiseQuality=" + noiseQuality + ", mountain_lacunarity=" + mountain_lacunarity
				+ ", turbulenceFrequency_0=" + turbulenceFrequency_0 + ", turbulencePowerScalar_0="
				+ turbulencePowerScalar_0 + ", turbulencePowerScalar_1=" + turbulencePowerScalar_1
				+ ", turbulenceRoughness_0=" + turbulenceRoughness_0 + ", twist=" + twist + "]";
	}

	
}
