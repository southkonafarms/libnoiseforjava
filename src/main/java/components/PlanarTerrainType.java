package components;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.domain.TerraceBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Terrace;
import libnoiseforjava.module.Turbulence;

public class PlanarTerrainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarTerrainType.class);
	
	Cached continentDef;
	Double terrainTypeFrequency;
	Double terrainTypePower;
	Integer terainTypeRoughness;
	Double terrainTypeLowControlPoint;
	Double terrainTypeMidControlPoint;
	Double terrainTypeHighControlPoint;
	Double shelfLevel;
	Double planarLevel;
	Cached terrainTypeDef;

	
	
	public PlanarTerrainType(Cached continentDef, Double terrainTypeFrequency, Double terrainTypePower,
			Integer terainTypeRoughness, Double terrainTypeLowControlPoint, Double terrainTypeMidControlPoint,
			Double terrainTypeHighControlPoint, Double shelfLevel, Double planarLevel) {
		super();
		this.continentDef = continentDef;
		this.terrainTypeFrequency = terrainTypeFrequency;
		this.terrainTypePower = terrainTypePower;
		this.terainTypeRoughness = terainTypeRoughness;
		this.terrainTypeLowControlPoint = terrainTypeLowControlPoint;
		this.terrainTypeMidControlPoint = terrainTypeMidControlPoint;
		this.terrainTypeHighControlPoint = terrainTypeHighControlPoint;
		this.shelfLevel = shelfLevel;
		this.planarLevel = planarLevel;
	}



	@Override
	public Cached build() {
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Turbulence turbulence = new TurbulenceBuilder().build(currSeed, terrainTypeFrequency, terrainTypePower,
				terainTypeRoughness, continentDef);
		Cached cachedTurbulence = new Cached(turbulence);  // subtle nasty bug fixed.
		Terrace terrace = new TerraceBuilder().build(terrainTypeLowControlPoint, terrainTypeMidControlPoint,
				terrainTypeHighControlPoint, planarLevel, shelfLevel, cachedTurbulence);
		this.terrainTypeDef = new Cached(terrace);
		logger.info(this.toString());
		return this.terrainTypeDef;
	}


	public Cached getContinentDef() {
		return continentDef;
	}



	public void setContinentDef(Cached continentDef) {
		this.continentDef = continentDef;
	}



	public Double getTerrainTypeFrequency() {
		return terrainTypeFrequency;
	}



	public void setTerrainTypeFrequency(Double terrainTypeFrequency) {
		this.terrainTypeFrequency = terrainTypeFrequency;
	}



	public Double getTerrainTypePower() {
		return terrainTypePower;
	}



	public void setTerrainTypePower(Double terrainTypePower) {
		this.terrainTypePower = terrainTypePower;
	}



	public Integer getTerainTypeRoughness() {
		return terainTypeRoughness;
	}



	public void setTerainTypeRoughness(Integer terainTypeRoughness) {
		this.terainTypeRoughness = terainTypeRoughness;
	}



	public Double getTerrainTypeLowControlPoint() {
		return terrainTypeLowControlPoint;
	}



	public void setTerrainTypeLowControlPoint(Double terrainTypeLowControlPoint) {
		this.terrainTypeLowControlPoint = terrainTypeLowControlPoint;
	}



	public Double getTerrainTypeMidControlPoint() {
		return terrainTypeMidControlPoint;
	}



	public void setTerrainTypeMidControlPoint(Double terrainTypeMidControlPoint) {
		this.terrainTypeMidControlPoint = terrainTypeMidControlPoint;
	}



	public Double getTerrainTypeHighControlPoint() {
		return terrainTypeHighControlPoint;
	}



	public void setTerrainTypeHighControlPoint(Double terrainTypeHighControlPoint) {
		this.terrainTypeHighControlPoint = terrainTypeHighControlPoint;
	}



	public Double getShelfLevel() {
		return shelfLevel;
	}



	public void setShelfLevel(Double shelfLevel) {
		this.shelfLevel = shelfLevel;
	}



	public Double getPlanarLevel() {
		return planarLevel;
	}



	public void setPlanarLevel(Double planarLevel) {
		this.planarLevel = planarLevel;
	}



	public Cached getTerrainTypeDef() {
		return terrainTypeDef;
	}



	public void setTerrainTypeDef(Cached terrainTypeDef) {
		this.terrainTypeDef = terrainTypeDef;
	}



	@Override
	public String toString() {
		return "PlanarTerrainType [terrainTypeFrequency=" + terrainTypeFrequency + ", terrainTypePower="
				+ terrainTypePower + ", terainTypeRoughness=" + terainTypeRoughness + ", terrainTypeLowControlPoint="
				+ terrainTypeLowControlPoint + ", terrainTypeMidControlPoint=" + terrainTypeMidControlPoint
				+ ", terrainTypeHighControlPoint=" + terrainTypeHighControlPoint + ", shelfLevel=" + shelfLevel
				+ ", planarLevel=" + planarLevel + "]";
	}

	
}
