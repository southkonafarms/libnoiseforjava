package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.ScaleBias;

public class PlanarScaledPlainsTerrainType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarScaledPlainsTerrainType.class);
	
	Cached plainsTerrain;
	Double scaled_plains_terrain_sb_scale;
	Double scaled_plains_terrain_sb_bias;
	Cached scaled_plains_terrain;
	
	

	public PlanarScaledPlainsTerrainType(Cached plainsTerrain, Double scaled_plains_terrain_sb_scale,
			Double scaled_plains_terrain_sb_bias) {
		super();
		this.plainsTerrain = plainsTerrain;
		this.scaled_plains_terrain_sb_scale = scaled_plains_terrain_sb_scale;
		this.scaled_plains_terrain_sb_bias = scaled_plains_terrain_sb_bias;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias = new ScaleBiasBuilder().build(scaled_plains_terrain_sb_scale, scaled_plains_terrain_sb_bias, plainsTerrain);
		this.scaled_plains_terrain = new Cached(scaleBias);
		logger.info(this.toString());
		return this.scaled_plains_terrain;
	}

	public Cached getPlainsTerrain() {
		return plainsTerrain;
	}

	public void setPlainsTerrain(Cached plainsTerrain) {
		this.plainsTerrain = plainsTerrain;
	}

	public Double getScaled_plains_terrain_sb_scale() {
		return scaled_plains_terrain_sb_scale;
	}

	public void setScaled_plains_terrain_sb_scale(Double scaled_plains_terrain_sb_scale) {
		this.scaled_plains_terrain_sb_scale = scaled_plains_terrain_sb_scale;
	}

	public Double getScaled_plains_terrain_sb_bias() {
		return scaled_plains_terrain_sb_bias;
	}

	public void setScaled_plains_terrain_sb_bias(Double scaled_plains_terrain_sb_bias) {
		this.scaled_plains_terrain_sb_bias = scaled_plains_terrain_sb_bias;
	}

	@Override
	public String toString() {
		return "PlanarScaledPlainsTerrain [scaled_plains_terrain_sb_scale=" + scaled_plains_terrain_sb_scale
				+ ", scaled_plains_terrain_sb_bias=" + scaled_plains_terrain_sb_bias + "]";
	}

	
}
