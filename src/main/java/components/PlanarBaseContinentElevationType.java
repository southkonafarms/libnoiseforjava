package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Select;

public class PlanarBaseContinentElevationType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarBaseContinentElevationType.class);
	
	Double base_continent_elev_sb_bias;
	Double continent_height_scale;
	
	Double base_continent_elev_se_bound_scalar;
	Double base_continent_elev_se_edge_falloff;
	Double shelf_level;
	Cached continentalShelf;
	Cached continentDef;
	
	Cached baseContinentElev;
	
	public PlanarBaseContinentElevationType(Double base_continent_elev_sb_bias, Double continent_height_scale,
			Double base_continent_elev_se_bound_scalar, Double base_continent_elev_se_edge_falloff, Double shelf_level,
			Cached continentalShelf, Cached continentDef) {
		super();
		this.base_continent_elev_sb_bias = base_continent_elev_sb_bias;
		this.continent_height_scale = continent_height_scale;
		this.base_continent_elev_se_bound_scalar = base_continent_elev_se_bound_scalar;
		this.base_continent_elev_se_edge_falloff = base_continent_elev_se_edge_falloff;
		this.shelf_level = shelf_level;
		this.continentalShelf = continentalShelf;
		this.continentDef = continentDef;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias = new ScaleBiasBuilder().build(base_continent_elev_sb_bias, continent_height_scale,
				continentDef);
		Select select = new SelectBuilder().build(scaleBias, continentalShelf, continentDef,
				shelf_level - base_continent_elev_se_bound_scalar, shelf_level, base_continent_elev_se_edge_falloff);
		this.baseContinentElev = new Cached(select);
		logger.info(this.toString());
		return this.baseContinentElev;
	}

	public Double getBase_continent_elev_sb_bias() {
		return base_continent_elev_sb_bias;
	}

	public void setBase_continent_elev_sb_bias(Double base_continent_elev_sb_bias) {
		this.base_continent_elev_sb_bias = base_continent_elev_sb_bias;
	}

	public Double getContinent_height_scale() {
		return continent_height_scale;
	}

	public void setContinent_height_scale(Double continent_height_scale) {
		this.continent_height_scale = continent_height_scale;
	}

	public Double getBase_continent_elev_se_bound_scalar() {
		return base_continent_elev_se_bound_scalar;
	}

	public void setBase_continent_elev_se_bound_scalar(Double base_continent_elev_se_bound_scalar) {
		this.base_continent_elev_se_bound_scalar = base_continent_elev_se_bound_scalar;
	}

	public Double getBase_continent_elev_se_edge_falloff() {
		return base_continent_elev_se_edge_falloff;
	}

	public void setBase_continent_elev_se_edge_falloff(Double base_continent_elev_se_edge_falloff) {
		this.base_continent_elev_se_edge_falloff = base_continent_elev_se_edge_falloff;
	}

	public Double getShelf_level() {
		return shelf_level;
	}

	public void setShelf_level(Double shelf_level) {
		this.shelf_level = shelf_level;
	}

	public Cached getContinentalShelf() {
		return continentalShelf;
	}

	public void setContinentalShelf(Cached continentalShelf) {
		this.continentalShelf = continentalShelf;
	}

	public Cached getContinentDef() {
		return continentDef;
	}

	public void setContinentDef(Cached continentDef) {
		this.continentDef = continentDef;
	}

	@Override
	public String toString() {
		return "PlanarBaseContinentElevationType [base_continent_elev_sb_bias=" + base_continent_elev_sb_bias
				+ ", continent_height_scale=" + continent_height_scale + ", base_continent_elev_se_bound_scalar="
				+ base_continent_elev_se_bound_scalar + ", base_continent_elev_se_edge_falloff="
				+ base_continent_elev_se_edge_falloff + ", shelf_level=" + shelf_level + "]";
	}

}
