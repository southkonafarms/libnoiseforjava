package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.ScaleBias;
import libnoiseforjava.module.Select;

public class PlanarContinentsWithRiversType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentsWithRiversType.class);
	
	Double continents_with_rivers_sb_scalar0;
	Double continents_with_rivers_sb_scalar1;
	Double river_depth;
	Cached riverPositions;
	
	Cached continentsWithBadlands;
	
	Double sea_level;
	Double continent_height_scale;
	
	Cached continentsWithRivers;

	public PlanarContinentsWithRiversType(Double continents_with_rivers_sb_scalar0,
			Double continents_with_rivers_sb_scalar1, Double river_depth, Cached riverPositions,
			Cached continentsWithBadlands, Double sea_level, Double continent_height_scale) {
		super();
		this.continents_with_rivers_sb_scalar0 = continents_with_rivers_sb_scalar0;
		this.continents_with_rivers_sb_scalar1 = continents_with_rivers_sb_scalar1;
		this.river_depth = river_depth;
		this.riverPositions = riverPositions;
		this.continentsWithBadlands = continentsWithBadlands;
		this.sea_level = sea_level;
		this.continent_height_scale = continent_height_scale;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias = new ScaleBiasBuilder().build(river_depth / continents_with_rivers_sb_scalar0,
				river_depth / continents_with_rivers_sb_scalar1, riverPositions);
		Add continentsWithRivers_ad = new Add(continentsWithBadlands, scaleBias);
		Select select = new SelectBuilder().build(continentsWithBadlands, continentsWithRivers_ad,
				continentsWithBadlands, sea_level, continent_height_scale - sea_level, 0.0);
		this.continentsWithRivers = new Cached(select);
		logger.info(this.toString());
		return this.continentsWithRivers;
	}

	public Double getContinents_with_rivers_sb_scalar0() {
		return continents_with_rivers_sb_scalar0;
	}

	public void setContinents_with_rivers_sb_scalar0(Double continents_with_rivers_sb_scalar0) {
		this.continents_with_rivers_sb_scalar0 = continents_with_rivers_sb_scalar0;
	}

	public Double getContinents_with_rivers_sb_scalar1() {
		return continents_with_rivers_sb_scalar1;
	}

	public void setContinents_with_rivers_sb_scalar1(Double continents_with_rivers_sb_scalar1) {
		this.continents_with_rivers_sb_scalar1 = continents_with_rivers_sb_scalar1;
	}

	public Double getRiver_depth() {
		return river_depth;
	}

	public void setRiver_depth(Double river_depth) {
		this.river_depth = river_depth;
	}

	public Cached getRiverPositions() {
		return riverPositions;
	}

	public void setRiverPositions(Cached riverPositions) {
		this.riverPositions = riverPositions;
	}

	public Cached getContinentsWithBadlands() {
		return continentsWithBadlands;
	}

	public void setContinentsWithBadlands(Cached continentsWithBadlands) {
		this.continentsWithBadlands = continentsWithBadlands;
	}

	public Double getSea_level() {
		return sea_level;
	}

	public void setSea_level(Double sea_level) {
		this.sea_level = sea_level;
	}

	public Double getContinent_height_scale() {
		return continent_height_scale;
	}

	public void setContinent_height_scale(Double continent_height_scale) {
		this.continent_height_scale = continent_height_scale;
	}

	@Override
	public String toString() {
		return "PlanarContinentsWithRiversType [continents_with_rivers_sb_scalar0=" + continents_with_rivers_sb_scalar0
				+ ", continents_with_rivers_sb_scalar1=" + continents_with_rivers_sb_scalar1 + ", river_depth="
				+ river_depth + ", sea_level=" + sea_level + ", continent_height_scale=" + continent_height_scale + "]";
	}

}
