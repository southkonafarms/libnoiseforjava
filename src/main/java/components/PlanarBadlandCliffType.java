package components;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ClampBuilder;
import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.CurveBuilder;
import libnoiseforjava.domain.PerlinBuilder;
import libnoiseforjava.domain.TerraceBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Clamp;
import libnoiseforjava.module.Curve;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.module.Terrace;
import libnoiseforjava.module.Turbulence;

public class PlanarBadlandCliffType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarBadlandCliffType.class);
	
	Double badlands_lucanarity;
	Double badlands_twist;
	
	Double badlands_cliffs_pe_frequency;
	Double continent_frequency;
	Double badlands_cliffs_pe_persistence;
	Integer badlands_cliffs_pe_octave_count;
	
	Double badlands_cliffs_cl_lower_bound;
	Double badlands_cliffs_cl_upper_bound;
	
	Double badlands_cliffs_tu0_frequency;
	Double badlands_cliffs_tu0_scalar0;
	Double badlands_cliffs_tu0_scalar1;
	Integer badlands_cliffs_tu0_roughness;

	Double badlands_cliffs_tu1_frequency;
	Double badlands_cliffs_tu1_scalar0;
	Double badlands_cliffs_tu1_scalar1;
	Integer badlands_cliffs_tu1_roughness;
	

	
	List<ControlPoint> badlands_cliffs_control_points;
	List<Double> badlands_terrace_control_points;
	NoiseQuality noiseQuality;
	
	Cached badlandCliffs;

	
	
	public PlanarBadlandCliffType(Double badlands_lucanarity, Double badlands_twist,
			Double badlands_cliffs_pe_frequency, Double continent_frequency, Double badlands_cliffs_pe_persistence,
			Integer badlands_cliffs_pe_octave_count, Double badlands_cliffs_cl_lower_bound,
			Double badlands_cliffs_cl_upper_bound, Double badlands_cliffs_tu0_frequency,
			Double badlands_cliffs_tu0_scalar0, Double badlands_cliffs_tu0_scalar1,
			Integer badlands_cliffs_tu0_roughness, Double badlands_cliffs_tu1_frequency,
			Double badlands_cliffs_tu1_scalar0, Double badlands_cliffs_tu1_scalar1,
			Integer badlands_cliffs_tu1_roughness, List<ControlPoint> badlands_cliffs_control_points,
			List<Double> badlands_terrace_control_points, NoiseQuality noiseQuality) {
		super();
		this.badlands_lucanarity = badlands_lucanarity;
		this.badlands_twist = badlands_twist;
		this.badlands_cliffs_pe_frequency = badlands_cliffs_pe_frequency;
		this.continent_frequency = continent_frequency;
		this.badlands_cliffs_pe_persistence = badlands_cliffs_pe_persistence;
		this.badlands_cliffs_pe_octave_count = badlands_cliffs_pe_octave_count;
		this.badlands_cliffs_cl_lower_bound = badlands_cliffs_cl_lower_bound;
		this.badlands_cliffs_cl_upper_bound = badlands_cliffs_cl_upper_bound;
		this.badlands_cliffs_tu0_frequency = badlands_cliffs_tu0_frequency;
		this.badlands_cliffs_tu0_scalar0 = badlands_cliffs_tu0_scalar0;
		this.badlands_cliffs_tu0_scalar1 = badlands_cliffs_tu0_scalar1;
		this.badlands_cliffs_tu0_roughness = badlands_cliffs_tu0_roughness;
		this.badlands_cliffs_tu1_frequency = badlands_cliffs_tu1_frequency;
		this.badlands_cliffs_tu1_scalar0 = badlands_cliffs_tu1_scalar0;
		this.badlands_cliffs_tu1_scalar1 = badlands_cliffs_tu1_scalar1;
		this.badlands_cliffs_tu1_roughness = badlands_cliffs_tu1_roughness;
		this.badlands_cliffs_control_points = badlands_cliffs_control_points;
		this.badlands_terrace_control_points = badlands_terrace_control_points;
		this.noiseQuality = noiseQuality;
	}



	@Override
	public Cached build() {
		Perlin perlin = new PerlinBuilder().biuld(badlands_cliffs_pe_frequency, badlands_cliffs_pe_persistence,
				badlands_lucanarity, badlands_cliffs_pe_octave_count, noiseQuality);
		Curve curve_0 = new CurveBuilder().builder(perlin, 0.0, badlands_cliffs_control_points);
		Clamp clamp = new ClampBuilder().build(curve_0, badlands_cliffs_cl_lower_bound, badlands_cliffs_cl_upper_bound);
		Terrace terrace = new TerraceBuilder().build(badlands_terrace_control_points, clamp);
		Turbulence turbulence_0 = new TurbulenceBuilder().build(badlands_cliffs_tu0_frequency,
				badlands_cliffs_tu0_scalar0 / badlands_cliffs_tu0_scalar1 * badlands_twist,
				badlands_cliffs_tu0_roughness, terrace);
		Turbulence turbulence_1 = new TurbulenceBuilder().build(badlands_cliffs_tu1_frequency,
				badlands_cliffs_tu1_scalar0 / badlands_cliffs_tu1_scalar1 * badlands_twist,
				badlands_cliffs_tu1_roughness, turbulence_0);
		this.badlandCliffs = new Cached(turbulence_1);
		logger.info(this.toString());
		return this.badlandCliffs;
	}



	public Double getBadlands_lucanarity() {
		return badlands_lucanarity;
	}



	public void setBadlands_lucanarity(Double badlands_lucanarity) {
		this.badlands_lucanarity = badlands_lucanarity;
	}



	public Double getBadlands_twist() {
		return badlands_twist;
	}



	public void setBadlands_twist(Double badlands_twist) {
		this.badlands_twist = badlands_twist;
	}



	public Double getBadlands_cliffs_pe_frequency() {
		return badlands_cliffs_pe_frequency;
	}



	public void setBadlands_cliffs_pe_frequency(Double badlands_cliffs_pe_frequency) {
		this.badlands_cliffs_pe_frequency = badlands_cliffs_pe_frequency;
	}



	public Double getContinent_frequency() {
		return continent_frequency;
	}



	public void setContinent_frequency(Double continent_frequency) {
		this.continent_frequency = continent_frequency;
	}



	public Double getBadlands_cliffs_pe_persistence() {
		return badlands_cliffs_pe_persistence;
	}



	public void setBadlands_cliffs_pe_persistence(Double badlands_cliffs_pe_persistence) {
		this.badlands_cliffs_pe_persistence = badlands_cliffs_pe_persistence;
	}



	public Integer getBadlands_cliffs_pe_octave_count() {
		return badlands_cliffs_pe_octave_count;
	}



	public void setBadlands_cliffs_pe_octave_count(Integer badlands_cliffs_pe_octave_count) {
		this.badlands_cliffs_pe_octave_count = badlands_cliffs_pe_octave_count;
	}



	public Double getBadlands_cliffs_cl_lower_bound() {
		return badlands_cliffs_cl_lower_bound;
	}



	public void setBadlands_cliffs_cl_lower_bound(Double badlands_cliffs_cl_lower_bound) {
		this.badlands_cliffs_cl_lower_bound = badlands_cliffs_cl_lower_bound;
	}



	public Double getBadlands_cliffs_cl_upper_bound() {
		return badlands_cliffs_cl_upper_bound;
	}



	public void setBadlands_cliffs_cl_upper_bound(Double badlands_cliffs_cl_upper_bound) {
		this.badlands_cliffs_cl_upper_bound = badlands_cliffs_cl_upper_bound;
	}



	public Double getBadlands_cliffs_tu0_frequency() {
		return badlands_cliffs_tu0_frequency;
	}



	public void setBadlands_cliffs_tu0_frequency(Double badlands_cliffs_tu0_frequency) {
		this.badlands_cliffs_tu0_frequency = badlands_cliffs_tu0_frequency;
	}



	public Double getBadlands_cliffs_tu0_scalar0() {
		return badlands_cliffs_tu0_scalar0;
	}



	public void setBadlands_cliffs_tu0_scalar0(Double badlands_cliffs_tu0_scalar0) {
		this.badlands_cliffs_tu0_scalar0 = badlands_cliffs_tu0_scalar0;
	}



	public Double getBadlands_cliffs_tu0_scalar1() {
		return badlands_cliffs_tu0_scalar1;
	}



	public void setBadlands_cliffs_tu0_scalar1(Double badlands_cliffs_tu0_scalar1) {
		this.badlands_cliffs_tu0_scalar1 = badlands_cliffs_tu0_scalar1;
	}



	public Integer getBadlands_cliffs_tu0_roughness() {
		return badlands_cliffs_tu0_roughness;
	}



	public void setBadlands_cliffs_tu0_roughness(Integer badlands_cliffs_tu0_roughness) {
		this.badlands_cliffs_tu0_roughness = badlands_cliffs_tu0_roughness;
	}



	public Double getBadlands_cliffs_tu1_frequency() {
		return badlands_cliffs_tu1_frequency;
	}



	public void setBadlands_cliffs_tu1_frequency(Double badlands_cliffs_tu1_frequency) {
		this.badlands_cliffs_tu1_frequency = badlands_cliffs_tu1_frequency;
	}



	public Double getBadlands_cliffs_tu1_scalar0() {
		return badlands_cliffs_tu1_scalar0;
	}



	public void setBadlands_cliffs_tu1_scalar0(Double badlands_cliffs_tu1_scalar0) {
		this.badlands_cliffs_tu1_scalar0 = badlands_cliffs_tu1_scalar0;
	}



	public Double getBadlands_cliffs_tu1_scalar1() {
		return badlands_cliffs_tu1_scalar1;
	}



	public void setBadlands_cliffs_tu1_scalar1(Double badlands_cliffs_tu1_scalar1) {
		this.badlands_cliffs_tu1_scalar1 = badlands_cliffs_tu1_scalar1;
	}



	public Integer getBadlands_cliffs_tu1_roughness() {
		return badlands_cliffs_tu1_roughness;
	}



	public void setBadlands_cliffs_tu1_roughness(Integer badlands_cliffs_tu1_roughness) {
		this.badlands_cliffs_tu1_roughness = badlands_cliffs_tu1_roughness;
	}



	public List<ControlPoint> getBadlands_cliffs_control_points() {
		return badlands_cliffs_control_points;
	}



	public void setBadlands_cliffs_control_points(List<ControlPoint> badlands_cliffs_control_points) {
		this.badlands_cliffs_control_points = badlands_cliffs_control_points;
	}



	public List<Double> getBadlands_terrace_control_points() {
		return badlands_terrace_control_points;
	}



	public void setBadlands_terrace_control_points(List<Double> badlands_terrace_control_points) {
		this.badlands_terrace_control_points = badlands_terrace_control_points;
	}



	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}



	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}



	@Override
	public String toString() {
		return "PlanarBadlandCliffType [badlands_lucanarity=" + badlands_lucanarity + ", badlands_twist="
				+ badlands_twist + ", badlands_cliffs_pe_frequency=" + badlands_cliffs_pe_frequency
				+ ", continent_frequency=" + continent_frequency + ", badlands_cliffs_pe_persistence="
				+ badlands_cliffs_pe_persistence + ", badlands_cliffs_pe_octave_count="
				+ badlands_cliffs_pe_octave_count + ", badlands_cliffs_cl_lower_bound=" + badlands_cliffs_cl_lower_bound
				+ ", badlands_cliffs_cl_upper_bound=" + badlands_cliffs_cl_upper_bound
				+ ", badlands_cliffs_tu0_frequency=" + badlands_cliffs_tu0_frequency + ", badlands_cliffs_tu0_scalar0="
				+ badlands_cliffs_tu0_scalar0 + ", badlands_cliffs_tu0_scalar1=" + badlands_cliffs_tu0_scalar1
				+ ", badlands_cliffs_tu0_roughness=" + badlands_cliffs_tu0_roughness
				+ ", badlands_cliffs_tu1_frequency=" + badlands_cliffs_tu1_frequency + ", badlands_cliffs_tu1_scalar0="
				+ badlands_cliffs_tu1_scalar0 + ", badlands_cliffs_tu1_scalar1=" + badlands_cliffs_tu1_scalar1
				+ ", badlands_cliffs_tu1_roughness=" + badlands_cliffs_tu1_roughness
				+ ", badlands_cliffs_control_points=" + badlands_cliffs_control_points
				+ ", badlands_terrace_control_points=" + badlands_terrace_control_points + ", noiseQuality="
				+ noiseQuality + "]";
	}

	
}
