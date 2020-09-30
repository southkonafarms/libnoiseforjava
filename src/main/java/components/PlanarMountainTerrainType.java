package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ExponentBuilder;
import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Exponent;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Select;

public class PlanarMountainTerrainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarMountainTerrainType.class);

	private Double mountain_terrain_scale_0;
	private Double mountain_terrain_bias_0;
	private Double mountain_terrain_scale_1;
	private Double mountain_terrain_bias_1;
	private Double mountain_terrain_scale_2;
	private Double mountain_terrain_bias_2;
	private Cached low_mountain_def;
	private Cached high_mountain_def;
	private Cached base_mountain_def;
	private Double terrain_bounds_param_0;
	private Double terrain_bounds_param_1;
	private Double edge_falloff;
	private Double glaciation;
	private Cached mountain_terrain;

	public PlanarMountainTerrainType(Double mountain_terrain_scale_0, Double mountain_terrain_bias_0,
			Double mountain_terrain_scale_1, Double mountain_terrain_bias_1, Double mountain_terrain_scale_2,
			Double mountain_terrain_bias_2, Cached low_mountain_def, Cached high_mountain_def, Cached base_mountain_def,
			Double terrain_bounds_param_0, Double terrain_bounds_param_1, Double edge_falloff, Double glaciation) {
		super();
		this.mountain_terrain_scale_0 = mountain_terrain_scale_0;
		this.mountain_terrain_bias_0 = mountain_terrain_bias_0;
		this.mountain_terrain_scale_1 = mountain_terrain_scale_1;
		this.mountain_terrain_bias_1 = mountain_terrain_bias_1;
		this.mountain_terrain_scale_2 = mountain_terrain_scale_2;
		this.mountain_terrain_bias_2 = mountain_terrain_bias_2;
		this.low_mountain_def = low_mountain_def;
		this.high_mountain_def = high_mountain_def;
		this.base_mountain_def = base_mountain_def;
		this.terrain_bounds_param_0 = terrain_bounds_param_0;
		this.terrain_bounds_param_1 = terrain_bounds_param_1;
		this.edge_falloff = edge_falloff;
		this.glaciation = glaciation;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias0 = new ScaleBiasBuilder().build(mountain_terrain_scale_0, mountain_terrain_bias_0,
				low_mountain_def);
		ScaleBias scaleBias1 = new ScaleBiasBuilder().build(mountain_terrain_scale_1, mountain_terrain_bias_1,
				high_mountain_def);
		Add mountaineousAdd = new Add(scaleBias1, base_mountain_def);
		Select select = new SelectBuilder().build(scaleBias1, mountaineousAdd, base_mountain_def,
				terrain_bounds_param_0, terrain_bounds_param_1, edge_falloff);
		ScaleBias scaleBias2 = new ScaleBiasBuilder().build(mountain_terrain_scale_2, mountain_terrain_bias_2, select);
		Exponent exponent = new ExponentBuilder().build(glaciation, scaleBias2);
		mountain_terrain = new Cached(exponent);
		logger.info(this.toString());
		return mountain_terrain;
	}

	public Double getMountain_terrain_scale_0() {
		return mountain_terrain_scale_0;
	}

	public void setMountain_terrain_scale_0(Double mountain_terrain_scale_0) {
		this.mountain_terrain_scale_0 = mountain_terrain_scale_0;
	}

	public Double getMountain_terrain_bias_0() {
		return mountain_terrain_bias_0;
	}

	public void setMountain_terrain_bias_0(Double mountain_terrain_bias_0) {
		this.mountain_terrain_bias_0 = mountain_terrain_bias_0;
	}

	public Double getMountain_terrain_scale_1() {
		return mountain_terrain_scale_1;
	}

	public void setMountain_terrain_scale_1(Double mountain_terrain_scale_1) {
		this.mountain_terrain_scale_1 = mountain_terrain_scale_1;
	}

	public Double getMountain_terrain_bias_1() {
		return mountain_terrain_bias_1;
	}

	public void setMountain_terrain_bias_1(Double mountain_terrain_bias_1) {
		this.mountain_terrain_bias_1 = mountain_terrain_bias_1;
	}

	public Double getMountain_terrain_scale_2() {
		return mountain_terrain_scale_2;
	}

	public void setMountain_terrain_scale_2(Double mountain_terrain_scale_2) {
		this.mountain_terrain_scale_2 = mountain_terrain_scale_2;
	}

	public Double getMountain_terrain_bias_2() {
		return mountain_terrain_bias_2;
	}

	public void setMountain_terrain_bias_2(Double mountain_terrain_bias_2) {
		this.mountain_terrain_bias_2 = mountain_terrain_bias_2;
	}

	public Cached getLow_mountain_def() {
		return low_mountain_def;
	}

	public void setLow_mountain_def(Cached low_mountain_def) {
		this.low_mountain_def = low_mountain_def;
	}

	public Cached getHigh_mountain_def() {
		return high_mountain_def;
	}

	public void setHigh_mountain_def(Cached high_mountain_def) {
		this.high_mountain_def = high_mountain_def;
	}

	public Cached getBase_mountain_def() {
		return base_mountain_def;
	}

	public void setBase_mountain_def(Cached base_mountain_def) {
		this.base_mountain_def = base_mountain_def;
	}

	public Double getTerrain_bounds_param_0() {
		return terrain_bounds_param_0;
	}

	public void setTerrain_bounds_param_0(Double terrain_bounds_param_0) {
		this.terrain_bounds_param_0 = terrain_bounds_param_0;
	}

	public Double getTerrain_bounds_param_1() {
		return terrain_bounds_param_1;
	}

	public void setTerrain_bounds_param_1(Double terrain_bounds_param_1) {
		this.terrain_bounds_param_1 = terrain_bounds_param_1;
	}

	public Double getEdge_falloff() {
		return edge_falloff;
	}

	public void setEdge_falloff(Double edge_falloff) {
		this.edge_falloff = edge_falloff;
	}

	public Double getGlaciation() {
		return glaciation;
	}

	public void setGlaciation(Double glaciation) {
		this.glaciation = glaciation;
	}

	@Override
	public String toString() {
		return "MountainTerrainType [mountain_terrain_scale_0=" + mountain_terrain_scale_0
				+ ", mountain_terrain_bias_0=" + mountain_terrain_bias_0 + ", mountain_terrain_scale_1="
				+ mountain_terrain_scale_1 + ", mountain_terrain_bias_1=" + mountain_terrain_bias_1
				+ ", mountain_terrain_scale_2=" + mountain_terrain_scale_2 + ", mountain_terrain_bias_2="
				+ mountain_terrain_bias_2 + ", mountain_terrain_scalar_0=" + ", terrain_bounds_param_0="
				+ terrain_bounds_param_0 + ", terrain_bounds_param_1=" + terrain_bounds_param_1 + ", edge_falloff="
				+ edge_falloff + ", glaciation=" + glaciation + "]";
	}

}
