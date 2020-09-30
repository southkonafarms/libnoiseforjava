package components;

import java.util.List;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.ClampBuilder;
import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.CurveBuilder;
import libnoiseforjava.domain.PerlinBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.SpheresBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Clamp;
import libnoiseforjava.module.Curve;
import libnoiseforjava.module.Min;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Spheres;

public class PlanarBaseContinent implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarBaseContinent.class);

	private Double continent_frequency;
	private Double base_continent_persistence_0;
	private Double base_continent_persistence_1;
	private Double continent_lacunarity;
	private Integer base_continent_octive_count0;
	private Integer base_continent_octive_count1;
	private List<ControlPoint> controlPoints;
	private Double spheres_scalar;
	private Boolean genSpheres = Boolean.FALSE;
	private NoiseQuality noiseQuality;
	private Double p_level = new Double(0);
	private Double base_continent_def_scale;
	private Double base_continent_def_bias;
	private Double base_contenent_def_lower_bound;
	private Double base_contenent_def_upper_bound;
	private Cached cache;

	// no arg CTOR
	public PlanarBaseContinent() {
	}

	/**
	 * 
	 * @param continent_frequency
	 * @param base_continent_persistence_0
	 * @param continent_lacunarity
	 * @param base_continent_octive_count0
	 * @param controlPoints
	 * @param base_continent_persistence_1
	 * @param base_continent_octive_count1
	 * @param base_continent_def_scale
	 * @param base_continent_def_bias
	 * @param noiseQuality
	 */
	public PlanarBaseContinent(Double continent_frequency, Double base_continent_persistence_0,
			Double continent_lacunarity, Integer base_continent_octive_count0, List<ControlPoint> controlPoints,
			Double base_continent_persistence_1, Integer base_continent_octive_count1, Double base_continent_def_scale,
			Double base_continent_def_bias, Double base_contenent_def_lower_bound,
			Double base_contenent_def_upper_bound, NoiseQuality noiseQuality) {
		super();
		this.continent_frequency = continent_frequency;
		this.base_continent_persistence_0 = base_continent_persistence_0;
		this.continent_lacunarity = continent_lacunarity;
		this.base_continent_octive_count0 = base_continent_octive_count0;
		this.controlPoints = controlPoints;
		this.base_continent_persistence_1 = base_continent_persistence_1;
		this.base_continent_octive_count1 = base_continent_octive_count1;
		this.base_continent_def_scale = base_continent_def_scale;
		this.base_continent_def_bias = base_continent_def_bias;
		this.base_contenent_def_lower_bound = base_contenent_def_lower_bound;
		this.base_contenent_def_upper_bound = base_contenent_def_upper_bound;
		this.noiseQuality = noiseQuality;

	}

	public void setContinent_frequency(Double continent_frequency) {
		this.continent_frequency = continent_frequency;
	}

	public void setBase_continent_persistence_0(Double base_continent_persistence_0) {
		this.base_continent_persistence_0 = base_continent_persistence_0;
	}

	public void setBase_continent_persistence_1(Double base_continent_persistence_1) {
		this.base_continent_persistence_1 = base_continent_persistence_1;
	}

	public void setContinent_lacunarity(Double continent_lacunarity) {
		this.continent_lacunarity = continent_lacunarity;
	}

	public void setBase_continent_octive_count0(Integer base_continent_octive_count0) {
		this.base_continent_octive_count0 = base_continent_octive_count0;
	}

	public void setControlPoints(List<ControlPoint> controlPoints) {
		this.controlPoints = controlPoints;
	}

	public void setSpheres_scalar(Double spheres_scalar) {
		this.spheres_scalar = spheres_scalar;
	}

	public void setGenSpheres(Boolean genSpheres) {
		this.genSpheres = genSpheres;
	}

	public Double getContinent_frequency() {
		return continent_frequency;
	}

	public Double getBase_continent_persistence_0() {
		return base_continent_persistence_0;
	}

	public Double getContinent_lacunarity() {
		return continent_lacunarity;
	}

	public Integer getBase_continent_octive_count0() {
		return base_continent_octive_count0;
	}

	public List<ControlPoint> getControlPoints() {
		return controlPoints;
	}

	public Double getSpheres_scalar() {
		return spheres_scalar;
	}

	public Boolean getGenSpheres() {
		return genSpheres;
	}

	public Cached getCache() {
		return cache;
	}

	public Integer getBase_continent_octive_count1() {
		return base_continent_octive_count1;
	}

	public void setBase_continent_octive_count1(Integer base_continent_octive_count1) {
		this.base_continent_octive_count1 = base_continent_octive_count1;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public Double getBase_continent_persistence_1() {
		return base_continent_persistence_1;
	}
	
	public Double getP_Level() {
		return p_level;
	}

	public void setP_Level(Double p_Level) {
		p_level = p_Level;
	}

	public Double getP_level() {
		return p_level;
	}

	public void setP_level(Double p_level) {
		this.p_level = p_level;
	}

	public Double getBase_continent_def_scale() {
		return base_continent_def_scale;
	}

	public void setBase_continent_def_scale(Double base_continent_def_scale) {
		this.base_continent_def_scale = base_continent_def_scale;
	}

	public Double getBase_continent_def_bias() {
		return base_continent_def_bias;
	}

	public void setBase_continent_def_bias(Double base_continent_def_bias) {
		this.base_continent_def_bias = base_continent_def_bias;
	}

	public Double getBase_contenent_def_lower_bound() {
		return base_contenent_def_lower_bound;
	}

	public void setBase_contenent_def_lower_bound(Double base_contenent_def_lower_bound) {
		this.base_contenent_def_lower_bound = base_contenent_def_lower_bound;
	}

	public Double getBase_contenent_def_upper_bound() {
		return base_contenent_def_upper_bound;
	}

	public void setBase_contenent_def_upper_bound(Double base_contenent_def_upper_bound) {
		this.base_contenent_def_upper_bound = base_contenent_def_upper_bound;
	}

	public void setCache(Cached cache) {
		this.cache = cache;
	}

	public Cached build() {
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Perlin baseContinentDef_pe0 = new PerlinBuilder().biuld(currSeed, continent_frequency,
				base_continent_persistence_0, continent_lacunarity, base_continent_octive_count0, noiseQuality);
		Curve baseContinentDef_cu = new CurveBuilder().builder(baseContinentDef_pe0, p_level, controlPoints);
		Perlin baseContinentDef_pe1 = new PerlinBuilder().biuld(currSeed +1, continent_frequency,
				base_continent_persistence_1, continent_lacunarity, base_continent_octive_count1, noiseQuality);
		ScaleBias scaleBias = new ScaleBiasBuilder().build(base_continent_def_scale, base_continent_def_bias, baseContinentDef_pe1);
		Cached baseContinentDef = null;
		Min baseContinentDef_mi = new Min(scaleBias, baseContinentDef_cu);
		Clamp baseContinentDef_cl = new ClampBuilder().build(baseContinentDef_mi, base_contenent_def_lower_bound,
				base_contenent_def_upper_bound);

		if(genSpheres){
			Spheres pools = new SpheresBuilder().build(spheres_scalar);
			Add baseContinent_ad = new Add(pools, baseContinentDef_cl);
			baseContinentDef = new Cached(baseContinent_ad);

		}
		else{
			baseContinentDef = new Cached(baseContinentDef_cl);
		}
		logger.info(this.toString());
		return baseContinentDef;
	}

	@Override
	public String toString() {
		return "PlanarBaseContinent [continent_frequency=" + continent_frequency + ", base_continent_persistence_0="
				+ base_continent_persistence_0 + ", base_continent_persistence_1=" + base_continent_persistence_1
				+ ", continent_lacunarity=" + continent_lacunarity + ", base_continent_octive_count0="
				+ base_continent_octive_count0 + ", base_continent_octive_count1=" + base_continent_octive_count1
				+ ", controlPoints=" + controlPoints + ", spheres_scalar=" + spheres_scalar + ", genSpheres="
				+ genSpheres + ", noiseQuality=" + noiseQuality + ", p_level=" + p_level + ", base_continent_def_scale="
				+ base_continent_def_scale + ", base_continent_def_bias=" + base_continent_def_bias
				+ ", base_contenent_def_lower_bound=" + base_contenent_def_lower_bound
				+ ", base_contenent_def_upper_bound=" + base_contenent_def_upper_bound + "]";
	}

}
