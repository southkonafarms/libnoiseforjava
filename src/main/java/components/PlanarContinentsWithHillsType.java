package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Select;

public class PlanarContinentsWithHillsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentsWithHillsType.class);
	
	Cached baseContinentElev, scaledHillyTerrain;
	
	Double continents_with_hills_bounds_scalar0;
	Double continents_with_hills_bounds_scalar1;
	Double hills_amount;
	Double continents_with_hills_edge_falloff;
	Cached continentsWithPlains, continentsWithHills_ad, terrainTypeDef;
	
	Cached continentsWithHills;
	
	public PlanarContinentsWithHillsType(Cached baseContinentElev, Cached scaledHillyTerrain, Double continents_with_hills_bounds_scalar0,
			Double continents_with_hills_bounds_scalar1, Double hills_amount, Double continents_with_hills_edge_falloff,
			Cached continentsWithPlains, Cached terrainTypeDef) {
		super();
		this.baseContinentElev = baseContinentElev;
		this.scaledHillyTerrain = scaledHillyTerrain;
		this.continents_with_hills_bounds_scalar0 = continents_with_hills_bounds_scalar0;
		this.continents_with_hills_bounds_scalar1 = continents_with_hills_bounds_scalar1;
		this.hills_amount = hills_amount;
		this.continents_with_hills_edge_falloff = continents_with_hills_edge_falloff;
		this.continentsWithPlains = continentsWithPlains;
		this.continentsWithHills_ad = continentsWithHills_ad;
		this.terrainTypeDef = terrainTypeDef;
	}

	@Override
	public Cached build() {
		Add continentsWithHills_ad = new Add(baseContinentElev,
				scaledHillyTerrain);
		
		Select select = new SelectBuilder().build(continentsWithPlains, continentsWithHills_ad, terrainTypeDef,
				continents_with_hills_bounds_scalar0 - hills_amount,
				continents_with_hills_bounds_scalar1 - hills_amount, continents_with_hills_edge_falloff);
		this.continentsWithHills = new Cached(select);
		logger.info(this.toString());
		return this.continentsWithHills;
	}

	public Double getContinents_with_hills_bounds_scalar0() {
		return continents_with_hills_bounds_scalar0;
	}

	public void setContinents_with_hills_bounds_scalar0(Double continents_with_hills_bounds_scalar0) {
		this.continents_with_hills_bounds_scalar0 = continents_with_hills_bounds_scalar0;
	}

	public Double getContinents_with_hills_bounds_scalar1() {
		return continents_with_hills_bounds_scalar1;
	}

	public void setContinents_with_hills_bounds_scalar1(Double continents_with_hills_bounds_scalar1) {
		this.continents_with_hills_bounds_scalar1 = continents_with_hills_bounds_scalar1;
	}

	public Double getHills_amount() {
		return hills_amount;
	}

	public void setHills_amount(Double hills_amount) {
		this.hills_amount = hills_amount;
	}

	public Double getContinents_with_hills_edge_falloff() {
		return continents_with_hills_edge_falloff;
	}

	public void setContinents_with_hills_edge_falloff(Double continents_with_hills_edge_falloff) {
		this.continents_with_hills_edge_falloff = continents_with_hills_edge_falloff;
	}

	public Cached getContinentsWithPlains() {
		return continentsWithPlains;
	}

	public void setContinentsWithPlains(Cached continentsWithPlains) {
		this.continentsWithPlains = continentsWithPlains;
	}

	public Cached getContinentsWithHills_ad() {
		return continentsWithHills_ad;
	}

	public void setContinentsWithHills_ad(Cached continentsWithHills_ad) {
		this.continentsWithHills_ad = continentsWithHills_ad;
	}

	public Cached getTerrainTypeDef() {
		return terrainTypeDef;
	}

	public void setTerrainTypeDef(Cached terrainTypeDef) {
		this.terrainTypeDef = terrainTypeDef;
	}
	
	

	public Cached getBaseContinentElev() {
		return baseContinentElev;
	}

	public void setBaseContinentElev(Cached baseContinentElev) {
		this.baseContinentElev = baseContinentElev;
	}

	public Cached getScaledHillyTerrain() {
		return scaledHillyTerrain;
	}

	public void setScaledHillyTerrain(Cached scaledHillyTerrain) {
		this.scaledHillyTerrain = scaledHillyTerrain;
	}

	@Override
	public String toString() {
		return "PlanarContinentsWithHillsType [continents_with_hills_bounds_scalar0="
				+ continents_with_hills_bounds_scalar0 + ", continents_with_hills_bounds_scalar1="
				+ continents_with_hills_bounds_scalar1 + ", hills_amount=" + hills_amount
				+ ", continents_with_hills_edge_falloff=" + continents_with_hills_edge_falloff + "]";
	}

}
