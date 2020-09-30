package components;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.BillowBuilder;
import libnoiseforjava.domain.ConstBuilder;
import libnoiseforjava.domain.ExponentBuilder;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Billow;
import libnoiseforjava.module.Blend;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Const;
import libnoiseforjava.module.Exponent;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Turbulence;

public class PlanarHillType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarHillType.class);
	
	Double hilly_terrain_bi_freauency;
	Double hilly_terrain_bi_persistence;
	Double hills_lacunarity;
	Integer hilly_terrain_bi_octave_count;
	
	Double hilly_terrain_sb0_scale;
	Double hilly_terrain_sb0_bias;
	
	Double hilly_terrain_rm_frequency;
	Integer hilly_terrain_rm_octave_count;
	NoiseQuality noiseQuality;
	
	Double hilly_terrain_sb1_scale;
	Double hilly_terrain_sb1_bias;
	
	Double hilly_terrain_co;

	Double hilly_terrain_sb2_scale;
	Double hilly_terrain_sb2_bias;
	
	Double hilly_terrain_ex;
	
	Double hilly_terrain_tu0_frequency;
	Double hilly_terrain_tu0_scalar0;
	Double hilly_terrain_tu0_scalar1;
	Integer hilly_terrain_tu0_roughness;
	Double hills_twist;

	Double hilly_terrain_tu1_frequency;
	Double hilly_terrain_tu1_scalar0;
	Double hilly_terrain_tu1_scalar1;
	Integer hilly_terrain_tu1_roughness;
	
	Cached hilly_terrain;
	
	

	public PlanarHillType(Double hilly_terrain_bi_freauency, Double hilly_terrain_bi_persistence,
			Double hills_lacunarity, Integer hilly_terrain_bi_octave_count, Double hilly_terrain_sb0_scale,
			Double hilly_terrain_sb0_bias, Double hilly_terrain_rm_frequency, Integer hilly_terrain_rm_octave_count,
			NoiseQuality noiseQuality, Double hilly_terrain_sb1_scale, Double hilly_terrain_sb1_bias,
			Double hilly_terrain_co, Double hilly_terrain_sb2_scale, Double hilly_terrain_sb2_bias,
			Double hilly_terrain_ex, Double hilly_terrain_tu0_frequency, Double hilly_terrain_tu0_scalar0,
			Double hilly_terrain_tu0_scalar1, Integer hilly_terrain_tu0_roughness, Double hills_twist,
			Double hilly_terrain_tu1_frequency, Double hilly_terrain_tu1_scalar0, Double hilly_terrain_tu1_scalar1,
			Integer hilly_terrain_tu1_roughness) {
		super();
		this.hilly_terrain_bi_freauency = hilly_terrain_bi_freauency;
		this.hilly_terrain_bi_persistence = hilly_terrain_bi_persistence;
		this.hills_lacunarity = hills_lacunarity;
		this.hilly_terrain_bi_octave_count = hilly_terrain_bi_octave_count;
		this.hilly_terrain_sb0_scale = hilly_terrain_sb0_scale;
		this.hilly_terrain_sb0_bias = hilly_terrain_sb0_bias;
		this.hilly_terrain_rm_frequency = hilly_terrain_rm_frequency;
		this.hilly_terrain_rm_octave_count = hilly_terrain_rm_octave_count;
		this.noiseQuality = noiseQuality;
		this.hilly_terrain_sb1_scale = hilly_terrain_sb1_scale;
		this.hilly_terrain_sb1_bias = hilly_terrain_sb1_bias;
		this.hilly_terrain_co = hilly_terrain_co;
		this.hilly_terrain_sb2_scale = hilly_terrain_sb2_scale;
		this.hilly_terrain_sb2_bias = hilly_terrain_sb2_bias;
		this.hilly_terrain_ex = hilly_terrain_ex;
		this.hilly_terrain_tu0_frequency = hilly_terrain_tu0_frequency;
		this.hilly_terrain_tu0_scalar0 = hilly_terrain_tu0_scalar0;
		this.hilly_terrain_tu0_scalar1 = hilly_terrain_tu0_scalar1;
		this.hilly_terrain_tu0_roughness = hilly_terrain_tu0_roughness;
		this.hills_twist = hills_twist;
		this.hilly_terrain_tu1_frequency = hilly_terrain_tu1_frequency;
		this.hilly_terrain_tu1_scalar0 = hilly_terrain_tu1_scalar0;
		this.hilly_terrain_tu1_scalar1 = hilly_terrain_tu1_scalar1;
		this.hilly_terrain_tu1_roughness = hilly_terrain_tu1_roughness;
	}



	@Override
	public Cached build() {
		Billow billow = new BillowBuilder().build(hilly_terrain_bi_freauency, hilly_terrain_bi_persistence,
				hills_lacunarity, hilly_terrain_bi_octave_count, noiseQuality);
		ScaleBias scaleBias_0 = new ScaleBiasBuilder().build(hilly_terrain_sb0_scale, hilly_terrain_sb0_bias, billow);
		RidgedMulti ridgedMulti = new RidgedMultiBuilder().build(hilly_terrain_rm_frequency, hills_lacunarity,
				hilly_terrain_rm_octave_count, noiseQuality);
		ScaleBias scaleBias_1 = new ScaleBiasBuilder().build(hilly_terrain_sb1_scale, hilly_terrain_sb1_bias, ridgedMulti);
		Const const_0 = new ConstBuilder(hilly_terrain_co).build();
		Blend hillyTerrain_bl = new Blend(const_0,
				scaleBias_0, scaleBias_1);
		ScaleBias scaleBias_2 = new ScaleBiasBuilder().build(hilly_terrain_sb2_scale, hilly_terrain_sb2_bias, hillyTerrain_bl);
		Exponent exponent = new ExponentBuilder().build(hilly_terrain_ex, scaleBias_2);
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Double power_0 = hilly_terrain_tu0_scalar0 / hilly_terrain_tu0_scalar1 * hills_twist;
		Turbulence turbulence_0 = new TurbulenceBuilder().build(currSeed, hilly_terrain_tu0_frequency, power_0, hilly_terrain_tu0_roughness, exponent);
		Double power_1 = hilly_terrain_tu0_scalar1 / hilly_terrain_tu1_scalar1 * hills_twist;
		Turbulence turbulence_1 = new TurbulenceBuilder().build(currSeed, hilly_terrain_tu1_frequency, power_1, hilly_terrain_tu1_roughness, turbulence_0);
		hilly_terrain = new Cached(turbulence_1);
		logger.info(this.toString());
		return hilly_terrain;
		
	}



	public Double getHilly_terrain_bi_freauency() {
		return hilly_terrain_bi_freauency;
	}



	public void setHilly_terrain_bi_freauency(Double hilly_terrain_bi_freauency) {
		this.hilly_terrain_bi_freauency = hilly_terrain_bi_freauency;
	}



	public Double getHilly_terrain_bi_persistence() {
		return hilly_terrain_bi_persistence;
	}



	public void setHilly_terrain_bi_persistence(Double hilly_terrain_bi_persistence) {
		this.hilly_terrain_bi_persistence = hilly_terrain_bi_persistence;
	}



	public Double getHills_lacunarity() {
		return hills_lacunarity;
	}



	public void setHills_lacunarity(Double hills_lacunarity) {
		this.hills_lacunarity = hills_lacunarity;
	}



	public Integer getHilly_terrain_bi_octave_count() {
		return hilly_terrain_bi_octave_count;
	}



	public void setHilly_terrain_bi_octave_count(Integer hilly_terrain_bi_octave_count) {
		this.hilly_terrain_bi_octave_count = hilly_terrain_bi_octave_count;
	}



	public Double getHilly_terrain_sb0_scale() {
		return hilly_terrain_sb0_scale;
	}



	public void setHilly_terrain_sb0_scale(Double hilly_terrain_sb0_scale) {
		this.hilly_terrain_sb0_scale = hilly_terrain_sb0_scale;
	}



	public Double getHilly_terrain_sb0_bias() {
		return hilly_terrain_sb0_bias;
	}



	public void setHilly_terrain_sb0_bias(Double hilly_terrain_sb0_bias) {
		this.hilly_terrain_sb0_bias = hilly_terrain_sb0_bias;
	}



	public Double getHilly_terrain_rm_frequency() {
		return hilly_terrain_rm_frequency;
	}



	public void setHilly_terrain_rm_frequency(Double hilly_terrain_rm_frequency) {
		this.hilly_terrain_rm_frequency = hilly_terrain_rm_frequency;
	}



	public Integer getHilly_terrain_rm_octave_count() {
		return hilly_terrain_rm_octave_count;
	}



	public void setHilly_terrain_rm_octave_count(Integer hilly_terrain_rm_octave_count) {
		this.hilly_terrain_rm_octave_count = hilly_terrain_rm_octave_count;
	}



	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}



	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}



	public Double getHilly_terrain_sb1_scale() {
		return hilly_terrain_sb1_scale;
	}



	public void setHilly_terrain_sb1_scale(Double hilly_terrain_sb1_scale) {
		this.hilly_terrain_sb1_scale = hilly_terrain_sb1_scale;
	}



	public Double getHilly_terrain_sb1_bias() {
		return hilly_terrain_sb1_bias;
	}



	public void setHilly_terrain_sb1_bias(Double hilly_terrain_sb1_bias) {
		this.hilly_terrain_sb1_bias = hilly_terrain_sb1_bias;
	}



	public Double getHilly_terrain_co() {
		return hilly_terrain_co;
	}



	public void setHilly_terrain_co(Double hilly_terrain_co) {
		this.hilly_terrain_co = hilly_terrain_co;
	}



	public Double getHilly_terrain_sb2_scale() {
		return hilly_terrain_sb2_scale;
	}



	public void setHilly_terrain_sb2_scale(Double hilly_terrain_sb2_scale) {
		this.hilly_terrain_sb2_scale = hilly_terrain_sb2_scale;
	}



	public Double getHilly_terrain_sb2_bias() {
		return hilly_terrain_sb2_bias;
	}



	public void setHilly_terrain_sb2_bias(Double hilly_terrain_sb2_bias) {
		this.hilly_terrain_sb2_bias = hilly_terrain_sb2_bias;
	}



	public Double getHilly_terrain_ex() {
		return hilly_terrain_ex;
	}



	public void setHilly_terrain_ex(Double hilly_terrain_ex) {
		this.hilly_terrain_ex = hilly_terrain_ex;
	}



	public Double getHilly_terrain_tu0_frequency() {
		return hilly_terrain_tu0_frequency;
	}



	public void setHilly_terrain_tu0_frequency(Double hilly_terrain_tu0_frequency) {
		this.hilly_terrain_tu0_frequency = hilly_terrain_tu0_frequency;
	}



	public Double getHilly_terrain_tu0_scalar0() {
		return hilly_terrain_tu0_scalar0;
	}



	public void setHilly_terrain_tu0_scalar0(Double hilly_terrain_tu0_scalar0) {
		this.hilly_terrain_tu0_scalar0 = hilly_terrain_tu0_scalar0;
	}



	public Double getHilly_terrain_tu0_scalar1() {
		return hilly_terrain_tu0_scalar1;
	}



	public void setHilly_terrain_tu0_scalar1(Double hilly_terrain_tu0_scalar1) {
		this.hilly_terrain_tu0_scalar1 = hilly_terrain_tu0_scalar1;
	}



	public Integer getHilly_terrain_tu0_roughness() {
		return hilly_terrain_tu0_roughness;
	}



	public void setHilly_terrain_tu0_roughness(Integer hilly_terrain_tu0_roughness) {
		this.hilly_terrain_tu0_roughness = hilly_terrain_tu0_roughness;
	}



	public Double getHills_twist() {
		return hills_twist;
	}



	public void setHills_twist(Double hills_twist) {
		this.hills_twist = hills_twist;
	}



	public Double getHilly_terrain_tu1_frequency() {
		return hilly_terrain_tu1_frequency;
	}



	public void setHilly_terrain_tu1_frequency(Double hilly_terrain_tu1_frequency) {
		this.hilly_terrain_tu1_frequency = hilly_terrain_tu1_frequency;
	}



	public Double getHilly_terrain_tu1_scalar0() {
		return hilly_terrain_tu1_scalar0;
	}



	public void setHilly_terrain_tu1_scalar0(Double hilly_terrain_tu1_scalar0) {
		this.hilly_terrain_tu1_scalar0 = hilly_terrain_tu1_scalar0;
	}



	public Double getHilly_terrain_tu1_scalar1() {
		return hilly_terrain_tu1_scalar1;
	}



	public void setHilly_terrain_tu1_scalar1(Double hilly_terrain_tu1_scalar1) {
		this.hilly_terrain_tu1_scalar1 = hilly_terrain_tu1_scalar1;
	}



	public Integer getHilly_terrain_tu1_roughness() {
		return hilly_terrain_tu1_roughness;
	}



	public void setHilly_terrain_tu1_roughness(Integer hilly_terrain_tu1_roughness) {
		this.hilly_terrain_tu1_roughness = hilly_terrain_tu1_roughness;
	}



	@Override
	public String toString() {
		return "PlanarHillType [hilly_terrain_bi_freauency=" + hilly_terrain_bi_freauency
				+ ", hilly_terrain_bi_persistence=" + hilly_terrain_bi_persistence + ", hills_lacunarity="
				+ hills_lacunarity + ", hilly_terrain_bi_octave_count=" + hilly_terrain_bi_octave_count
				+ ", hilly_terrain_sb0_scale=" + hilly_terrain_sb0_scale + ", hilly_terrain_sb0_bias="
				+ hilly_terrain_sb0_bias + ", hilly_terrain_rm_frequency=" + hilly_terrain_rm_frequency
				+ ", hilly_terrain_rm_octave_count=" + hilly_terrain_rm_octave_count + ", noiseQuality=" + noiseQuality
				+ ", hilly_terrain_sb1_scale=" + hilly_terrain_sb1_scale + ", hilly_terrain_sb1_bias="
				+ hilly_terrain_sb1_bias + ", hilly_terrain_co=" + hilly_terrain_co + ", hilly_terrain_sb2_scale="
				+ hilly_terrain_sb2_scale + ", hilly_terrain_sb2_bias=" + hilly_terrain_sb2_bias + ", hilly_terrain_ex="
				+ hilly_terrain_ex + ", hilly_terrain_tu0_frequency=" + hilly_terrain_tu0_frequency
				+ ", hilly_terrain_tu0_scalar0=" + hilly_terrain_tu0_scalar0 + ", hilly_terrain_tu0_scalar1="
				+ hilly_terrain_tu0_scalar1 + ", hilly_terrain_tu0_roughness=" + hilly_terrain_tu0_roughness
				+ ", hills_twist=" + hills_twist + ", hilly_terrain_tu1_frequency=" + hilly_terrain_tu1_frequency
				+ ", hilly_terrain_tu1_scalar0=" + hilly_terrain_tu1_scalar0 + ", hilly_terrain_tu1_scalar1="
				+ hilly_terrain_tu1_scalar1 + ", hilly_terrain_tu1_roughness=" + hilly_terrain_tu1_roughness + "]";
	}

}
