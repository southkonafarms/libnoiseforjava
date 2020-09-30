package components;

import java.util.List;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.CurveBuilder;
import libnoiseforjava.domain.RidgedMultiBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Curve;
import libnoiseforjava.module.Min;
import libnoiseforjava.module.RidgedMulti;
import libnoiseforjava.module.Turbulence;

public class PlanarRiverPositionsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarRiverPositionsType.class);
	
	Double river_positions_rm0_frequency;
	Integer river_positions_rm0_octave_count;

	Double river_positions_rm1_frequency;
	Integer river_positions_rm1_octave_count;
	
	Double river_positions_tu_frequency;
	Double river_positions_tu_scalar0;
	Double river_positions_tu_scalar1;
	Integer river_positions_tu_roughness;

	Double continent_lacunarity;
	
	NoiseQuality noiseQuality;
	
	List<ControlPoint> river_positions_0;
	List<ControlPoint> river_positions_1;
	
	Cached riverPositions;

	public PlanarRiverPositionsType(Double river_positions_rm0_frequency, Integer river_positions_rm0_octave_count,
			Double river_positions_rm1_frequency, Integer river_positions_rm1_octave_count,
			Double river_positions_tu_frequency, Double river_positions_tu_scalar0, Double river_positions_tu_scalar1,
			Integer river_positions_tu_roughness, Double continent_lacunarity, NoiseQuality noiseQuality,
			List<ControlPoint> river_positions_0, List<ControlPoint> river_positions_1) {
		super();
		this.river_positions_rm0_frequency = river_positions_rm0_frequency;
		this.river_positions_rm0_octave_count = river_positions_rm0_octave_count;
		this.river_positions_rm1_frequency = river_positions_rm1_frequency;
		this.river_positions_rm1_octave_count = river_positions_rm1_octave_count;
		this.river_positions_tu_frequency = river_positions_tu_frequency;
		this.river_positions_tu_scalar0 = river_positions_tu_scalar0;
		this.river_positions_tu_scalar1 = river_positions_tu_scalar1;
		this.river_positions_tu_roughness = river_positions_tu_roughness;
		this.continent_lacunarity = continent_lacunarity;
		this.noiseQuality = noiseQuality;
		this.river_positions_0 = river_positions_0;
		this.river_positions_1 = river_positions_1;
	}

	@Override
	public Cached build() {
		RidgedMulti ridgedMulti_0 = new RidgedMultiBuilder().build(river_positions_rm0_frequency, continent_lacunarity,
				river_positions_rm0_octave_count, noiseQuality);
		Curve curve_0 = new CurveBuilder().builder(ridgedMulti_0, 0.0, river_positions_0);
		RidgedMulti ridgedMulti_1 = new RidgedMultiBuilder().build(river_positions_rm1_frequency, continent_lacunarity,
				river_positions_rm1_octave_count, noiseQuality);
		Curve curve_1 = new CurveBuilder().builder(ridgedMulti_1, 0.0, river_positions_1);
		Min riverPositions_mi = new Min(curve_0, curve_1);
		Turbulence turbulence = new TurbulenceBuilder().build(river_positions_tu_frequency,
				river_positions_tu_scalar0 / river_positions_tu_scalar1, river_positions_tu_roughness,
				riverPositions_mi);
		this.riverPositions = new Cached(turbulence);
		logger.info(this.toString());
		return this.riverPositions;
	}

	public Double getRiver_positions_rm0_frequency() {
		return river_positions_rm0_frequency;
	}

	public void setRiver_positions_rm0_frequency(Double river_positions_rm0_frequency) {
		this.river_positions_rm0_frequency = river_positions_rm0_frequency;
	}

	public Integer getRiver_positions_rm0_octave_count() {
		return river_positions_rm0_octave_count;
	}

	public void setRiver_positions_rm0_octave_count(Integer river_positions_rm0_octave_count) {
		this.river_positions_rm0_octave_count = river_positions_rm0_octave_count;
	}

	public Double getRiver_positions_rm1_frequency() {
		return river_positions_rm1_frequency;
	}

	public void setRiver_positions_rm1_frequency(Double river_positions_rm1_frequency) {
		this.river_positions_rm1_frequency = river_positions_rm1_frequency;
	}

	public Integer getRiver_positions_rm1_octave_count() {
		return river_positions_rm1_octave_count;
	}

	public void setRiver_positions_rm1_octave_count(Integer river_positions_rm1_octave_count) {
		this.river_positions_rm1_octave_count = river_positions_rm1_octave_count;
	}

	public Double getRiver_positions_tu_frequency() {
		return river_positions_tu_frequency;
	}

	public void setRiver_positions_tu_frequency(Double river_positions_tu_frequency) {
		this.river_positions_tu_frequency = river_positions_tu_frequency;
	}

	public Double getRiver_positions_tu_scalar0() {
		return river_positions_tu_scalar0;
	}

	public void setRiver_positions_tu_scalar0(Double river_positions_tu_scalar0) {
		this.river_positions_tu_scalar0 = river_positions_tu_scalar0;
	}

	public Double getRiver_positions_tu_scalar1() {
		return river_positions_tu_scalar1;
	}

	public void setRiver_positions_tu_scalar1(Double river_positions_tu_scalar1) {
		this.river_positions_tu_scalar1 = river_positions_tu_scalar1;
	}

	public Integer getRiver_positions_tu_roughness() {
		return river_positions_tu_roughness;
	}

	public void setRiver_positions_tu_roughness(Integer river_positions_tu_roughness) {
		this.river_positions_tu_roughness = river_positions_tu_roughness;
	}

	public Double getContinent_lacunarity() {
		return continent_lacunarity;
	}

	public void setContinent_lacunarity(Double continent_lacunarity) {
		this.continent_lacunarity = continent_lacunarity;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public List<ControlPoint> getRiver_positions_0() {
		return river_positions_0;
	}

	public void setRiver_positions_0(List<ControlPoint> river_positions_0) {
		this.river_positions_0 = river_positions_0;
	}

	public List<ControlPoint> getRiver_positions_1() {
		return river_positions_1;
	}

	public void setRiver_positions_1(List<ControlPoint> river_positions_1) {
		this.river_positions_1 = river_positions_1;
	}

	@Override
	public String toString() {
		return "PlanarRiverPositionsType [river_positions_rm0_frequency=" + river_positions_rm0_frequency
				+ ", river_positions_rm0_octave_count=" + river_positions_rm0_octave_count
				+ ", river_positions_rm1_frequency=" + river_positions_rm1_frequency
				+ ", river_positions_rm1_octave_count=" + river_positions_rm1_octave_count
				+ ", river_positions_tu_frequency=" + river_positions_tu_frequency + ", river_positions_tu_scalar0="
				+ river_positions_tu_scalar0 + ", river_positions_tu_scalar1=" + river_positions_tu_scalar1
				+ ", river_positions_tu_roughness=" + river_positions_tu_roughness + ", continent_lacunarity="
				+ continent_lacunarity + ", noiseQuality=" + noiseQuality + ", river_positions_0=" + river_positions_0
				+ ", river_positions_1=" + river_positions_1 + "]";
	}

	
}
