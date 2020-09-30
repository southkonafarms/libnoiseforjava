package components;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ConstBuilder;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Blend;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Const;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Turbulence;

public class PlanarMountanType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarMountanType.class);
	
	private Double mountain_base_freqeuncy_0;
	private Integer mountain_base_octave_count_0;
	private NoiseQuality noiseQuality_0;
	
	private Double mountain_lacunarity;
	
	private Cached base_mountain_def_0;
	private Double mountain_base_scale_0;
	private Double mountain_base_bias_0;
	
	private Cached base_mountain_def_1;
	private Double mountain_base_scale_1;
	private Double mountain_base_bias_1;

	private Double mountain_base_freqeuncy_1;
	private Integer mountain_base_octave_count_1;
	private NoiseQuality noiseQuality_1;
	
	private Double turbulenceFrequency_0;
	private Double turbulenceFrequency_1;
	private Double turbulencePowerScalar_0;
	private Double turbulencePowerScalar_1;
	private Integer turbulenceRoughness_0;
	private Integer turbulenceRoughness_1;
	
	private Cached mountainBaseDef;

	private Double constant;
	
	private Blend blend;

 	public PlanarMountanType(Double mountain_base_freqeuncy_0, Integer mountain_base_octave_count_0,
			NoiseQuality noiseQuality_0, Double mountain_lacunarity, Double mountain_base_scale_0,
			Double mountain_base_bias_0, Double mountain_base_scale_1, Double mountain_base_bias_1,
			Double mountain_base_freqeuncy_1, Integer mountain_base_octave_count_1, NoiseQuality noiseQuality_1,
			Double turbulenceFrequency_0, Double turbulenceFrequency_1, Double turbulencePowerScalar_0,
			Double turbulencePowerScalar_1, Integer turbulenceRoughness_0, Integer turbulenceRoughness_1,
			Double constant) {
		super();
		this.mountain_base_freqeuncy_0 = mountain_base_freqeuncy_0;
		this.mountain_base_octave_count_0 = mountain_base_octave_count_0;
		this.noiseQuality_0 = noiseQuality_0;
		this.mountain_lacunarity = mountain_lacunarity;
		this.mountain_base_scale_0 = mountain_base_scale_0;
		this.mountain_base_bias_0 = mountain_base_bias_0;
		this.mountain_base_scale_1 = mountain_base_scale_1;
		this.mountain_base_bias_1 = mountain_base_bias_1;
		this.mountain_base_freqeuncy_1 = mountain_base_freqeuncy_1;
		this.mountain_base_octave_count_1 = mountain_base_octave_count_1;
		this.noiseQuality_1 = noiseQuality_1;
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
		this.turbulenceFrequency_1 = turbulenceFrequency_1;
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
		this.turbulenceRoughness_1 = turbulenceRoughness_1;
		this.constant = constant;
	}



	@Override
	public Cached build() {
		
		RidgedMulti ridgedMulti = new RidgedMultiBuilder().build(mountain_base_freqeuncy_0, mountain_lacunarity,
				mountain_base_octave_count_0, noiseQuality_0);
		base_mountain_def_0 = new Cached(ridgedMulti);
		
		ScaleBias scaleBias_0 = new ScaleBiasBuilder().build(mountain_base_scale_0, mountain_base_bias_0, base_mountain_def_0);
		
		ridgedMulti = new RidgedMultiBuilder().build(mountain_base_freqeuncy_1, mountain_lacunarity,
				mountain_base_octave_count_1, noiseQuality_1);
		base_mountain_def_1 = new Cached(ridgedMulti);
	
		ScaleBias scaleBias_1 = new ScaleBiasBuilder().build(mountain_base_scale_1, mountain_base_bias_1, base_mountain_def_1);
		
		Const const1 = new ConstBuilder(constant).build();
		
		Blend blend = new Blend(const1, base_mountain_def_0, base_mountain_def_1);
		
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Turbulence turbulence_0 = new TurbulenceBuilder().build(currSeed, turbulenceFrequency_0, turbulencePowerScalar_0, turbulenceRoughness_0, blend);
		currSeed = GenRandomRolls.Instance().getD1000();
		Turbulence turbulence_1 = new TurbulenceBuilder().build(currSeed, turbulenceFrequency_1, turbulencePowerScalar_1, turbulenceRoughness_1, turbulence_0);
		this.mountainBaseDef = new Cached(turbulence_1);
		logger.info(this.toString());
		return this.mountainBaseDef;
	}



	public Double getMountain_base_freqeuncy_0() {
		return mountain_base_freqeuncy_0;
	}



	public Integer getMountain_base_octave_count_0() {
		return mountain_base_octave_count_0;
	}



	public NoiseQuality getNoiseQuality_0() {
		return noiseQuality_0;
	}



	public Double getMountain_lacunarity() {
		return mountain_lacunarity;
	}



	public Cached getBase_mountain_def_0() {
		return base_mountain_def_0;
	}



	public Double getMountain_base_scale_0() {
		return mountain_base_scale_0;
	}



	public Double getMountain_base_bias_0() {
		return mountain_base_bias_0;
	}



	public Cached getBase_mountain_def_1() {
		return base_mountain_def_1;
	}



	public Double getMountain_base_scale_1() {
		return mountain_base_scale_1;
	}



	public Double getMountain_base_bias_1() {
		return mountain_base_bias_1;
	}



	public Double getMountain_base_freqeuncy_1() {
		return mountain_base_freqeuncy_1;
	}



	public Integer getMountain_base_octave_count_1() {
		return mountain_base_octave_count_1;
	}



	public NoiseQuality getNoiseQuality_1() {
		return noiseQuality_1;
	}



	public Double getTurbulenceFrequency_0() {
		return turbulenceFrequency_0;
	}



	public Double getTurbulenceFrequency_1() {
		return turbulenceFrequency_1;
	}



	public Double getTurbulencePowerScalar_0() {
		return turbulencePowerScalar_0;
	}



	public Double getTurbulencePowerScalar_1() {
		return turbulencePowerScalar_1;
	}



	public Integer getTurbulenceRoughness_0() {
		return turbulenceRoughness_0;
	}



	public Integer getTurbulenceRoughness_1() {
		return turbulenceRoughness_1;
	}



	public Cached getMountainBaseDef() {
		return mountainBaseDef;
	}



	public Double getConstant() {
		return constant;
	}



	public Blend getBlend() {
		return blend;
	}



	public void setMountain_base_freqeuncy_0(Double mountain_base_freqeuncy_0) {
		this.mountain_base_freqeuncy_0 = mountain_base_freqeuncy_0;
	}



	public void setMountain_base_octave_count_0(Integer mountain_base_octave_count_0) {
		this.mountain_base_octave_count_0 = mountain_base_octave_count_0;
	}



	public void setNoiseQuality_0(NoiseQuality noiseQuality_0) {
		this.noiseQuality_0 = noiseQuality_0;
	}



	public void setMountain_lacunarity(Double mountain_lacunarity) {
		this.mountain_lacunarity = mountain_lacunarity;
	}


	public void setMountain_base_scale_0(Double mountain_base_scale_0) {
		this.mountain_base_scale_0 = mountain_base_scale_0;
	}



	public void setMountain_base_bias_0(Double mountain_base_bias_0) {
		this.mountain_base_bias_0 = mountain_base_bias_0;
	}

	public void setMountain_base_scale_1(Double mountain_base_scale_1) {
		this.mountain_base_scale_1 = mountain_base_scale_1;
	}



	public void setMountain_base_bias_1(Double mountain_base_bias_1) {
		this.mountain_base_bias_1 = mountain_base_bias_1;
	}



	public void setMountain_base_freqeuncy_1(Double mountain_base_freqeuncy_1) {
		this.mountain_base_freqeuncy_1 = mountain_base_freqeuncy_1;
	}



	public void setMountain_base_octave_count_1(Integer mountain_base_octave_count_1) {
		this.mountain_base_octave_count_1 = mountain_base_octave_count_1;
	}



	public void setNoiseQuality_1(NoiseQuality noiseQuality_1) {
		this.noiseQuality_1 = noiseQuality_1;
	}



	public void setTurbulenceFrequency_0(Double turbulenceFrequency_0) {
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
	}



	public void setTurbulenceFrequency_1(Double turbulenceFrequency_1) {
		this.turbulenceFrequency_1 = turbulenceFrequency_1;
	}



	public void setTurbulencePowerScalar_0(Double turbulencePowerScalar_0) {
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
	}



	public void setTurbulencePowerScalar_1(Double turbulencePowerScalar_1) {
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
	}



	public void setTurbulenceRoughness_0(Integer turbulenceRoughness_0) {
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
	}



	public void setTurbulenceRoughness_1(Integer turbulenceRoughness_1) {
		this.turbulenceRoughness_1 = turbulenceRoughness_1;
	}



	@Override
	public String toString() {
		return "PlanarMountanType [mountain_base_freqeuncy_0=" + mountain_base_freqeuncy_0
				+ ", mountain_base_octave_count_0=" + mountain_base_octave_count_0 + ", noiseQuality_0="
				+ noiseQuality_0 + ", mountain_lacunarity=" + mountain_lacunarity + ", mountain_base_scale_0="
				+ mountain_base_scale_0 + ", mountain_base_bias_0=" + mountain_base_bias_0 + ", mountain_base_scale_1="
				+ mountain_base_scale_1 + ", mountain_base_bias_1=" + mountain_base_bias_1
				+ ", mountain_base_freqeuncy_1=" + mountain_base_freqeuncy_1 + ", mountain_base_octave_count_1="
				+ mountain_base_octave_count_1 + ", noiseQuality_1=" + noiseQuality_1 + ", turbulenceFrequency_0="
				+ turbulenceFrequency_0 + ", turbulenceFrequency_1=" + turbulenceFrequency_1
				+ ", turbulencePowerScalar_0=" + turbulencePowerScalar_0 + ", turbulencePowerScalar_1="
				+ turbulencePowerScalar_1 + ", turbulenceRoughness_0=" + turbulenceRoughness_0
				+ ", turbulenceRoughness_1=" + turbulenceRoughness_1 + "]";
	}

	
}
