package components;

import java.util.List;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.CurveBuilder;
import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Curve;
import libnoiseforjava.module.Select;

public class PlanarContinentsWithMountainsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentsWithMountainsType.class);
	
	Cached baseContinentElev; 
	Cached scaledMountainousTerrain;
	
	Cached continentDef;
	List<ControlPoint> continentsMountainsControlPoints;
	
	Double continent_with_mountains_bounds_scalar0;
	Double continent_with_mountains_bounds_scalar1;
	Double continent_with_mountains_edge_falloff;
	
	Cached continentsWithHills;
	Cached terrainTypeDef;
	
	Double mountains_amount;
	
	Cached continentsWithMountains;

	public PlanarContinentsWithMountainsType(Cached baseContinentElev, Cached scaledMountainousTerrain,
			Cached continentDef, List<ControlPoint> continentsMountainsControlPoints,
			Double continent_with_mountains_bounds_scalar0, Double continent_with_mountains_bounds_scalar1,
			Double continent_with_mountains_edge_falloff, Cached continentsWithHills, Cached terrainTypeDef,
			Double mountains_amount) {
		super();
		this.baseContinentElev = baseContinentElev;
		this.scaledMountainousTerrain = scaledMountainousTerrain;
		this.continentDef = continentDef;
		this.continentsMountainsControlPoints = continentsMountainsControlPoints;
		this.continent_with_mountains_bounds_scalar0 = continent_with_mountains_bounds_scalar0;
		this.continent_with_mountains_bounds_scalar1 = continent_with_mountains_bounds_scalar1;
		this.continent_with_mountains_edge_falloff = continent_with_mountains_edge_falloff;
		this.continentsWithHills = continentsWithHills;
		this.terrainTypeDef = terrainTypeDef;
		this.mountains_amount = mountains_amount;
	}



	@Override
	public Cached build() {
		Add continentsWithMountains_ad0 = new Add(baseContinentElev, scaledMountainousTerrain);
		Curve curve = new CurveBuilder().builder(continentDef, 0.0, continentsMountainsControlPoints);
		Add continentsWithMountains_ad1 = new Add(continentsWithMountains_ad0, curve);
		Select select = new SelectBuilder().build(continentsWithHills, continentsWithMountains_ad1, terrainTypeDef,
				continent_with_mountains_bounds_scalar0, continent_with_mountains_bounds_scalar1,
				continent_with_mountains_edge_falloff);
		this.continentsWithMountains = new Cached(select);
		logger.info(this.toString());
		return this.continentsWithMountains;
	}



	public Cached getBaseContinentElev() {
		return baseContinentElev;
	}



	public void setBaseContinentElev(Cached baseContinentElev) {
		this.baseContinentElev = baseContinentElev;
	}



	public Cached getScaledMountainousTerrain() {
		return scaledMountainousTerrain;
	}



	public void setScaledMountainousTerrain(Cached scaledMountainousTerrain) {
		this.scaledMountainousTerrain = scaledMountainousTerrain;
	}



	public Cached getContinentDef() {
		return continentDef;
	}



	public void setContinentDef(Cached continentDef) {
		this.continentDef = continentDef;
	}



	public List<ControlPoint> getContinentsMountainsControlPoints() {
		return continentsMountainsControlPoints;
	}



	public void setContinentsMountainsControlPoints(List<ControlPoint> continentsMountainsControlPoints) {
		this.continentsMountainsControlPoints = continentsMountainsControlPoints;
	}



	public Double getContinent_with_mountains_bounds_scalar0() {
		return continent_with_mountains_bounds_scalar0;
	}



	public void setContinent_with_mountains_bounds_scalar0(Double continent_with_mountains_bounds_scalar0) {
		this.continent_with_mountains_bounds_scalar0 = continent_with_mountains_bounds_scalar0;
	}



	public Double getContinent_with_mountains_bounds_scalar1() {
		return continent_with_mountains_bounds_scalar1;
	}



	public void setContinent_with_mountains_bounds_scalar1(Double continent_with_mountains_bounds_scalar1) {
		this.continent_with_mountains_bounds_scalar1 = continent_with_mountains_bounds_scalar1;
	}



	public Double getContinent_with_mountains_edge_falloff() {
		return continent_with_mountains_edge_falloff;
	}



	public void setContinent_with_mountains_edge_falloff(Double continent_with_mountains_edge_falloff) {
		this.continent_with_mountains_edge_falloff = continent_with_mountains_edge_falloff;
	}



	public Cached getContinentsWithHills() {
		return continentsWithHills;
	}



	public void setContinentsWithHills(Cached continentsWithHills) {
		this.continentsWithHills = continentsWithHills;
	}



	public Cached getTerrainTypeDef() {
		return terrainTypeDef;
	}



	public void setTerrainTypeDef(Cached terrainTypeDef) {
		this.terrainTypeDef = terrainTypeDef;
	}



	public Double getMountains_amount() {
		return mountains_amount;
	}



	public void setMountains_amount(Double mountains_amount) {
		this.mountains_amount = mountains_amount;
	}

	@Override
	public String toString() {
		return "PlanarContinentsWithMountainsType [continentsMountainsControlPoints=" + continentsMountainsControlPoints
				+ ", continent_with_mountains_bounds_scalar0=" + continent_with_mountains_bounds_scalar0
				+ ", continent_with_mountains_bounds_scalar1=" + continent_with_mountains_bounds_scalar1
				+ ", continent_with_mountains_edge_falloff=" + continent_with_mountains_edge_falloff
				+ ", mountains_amount=" + mountains_amount + "]";
	}

}
