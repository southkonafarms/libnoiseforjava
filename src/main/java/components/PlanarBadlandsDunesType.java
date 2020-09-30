package components;
import org.apache.log4j.Logger;

import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Max;
import libnoiseforjava.module.ModuleBase;
import libnoiseforjava.module.ScaleBias;

public class PlanarBadlandsDunesType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarBadlandsDunesType.class);
	
	Double badlands_terrain_sb_scale;
	Double badlands_terrain_sb_bias;
	Cached badlands_sand;
	Cached badland_cliffs;
	
	Cached badland_dunes;

	

	public PlanarBadlandsDunesType(Double badlands_terrain_sb_scale, Double badlands_terrain_sb_bias,
			Cached badlands_sand, Cached badlands_cliffs) {
		super();
		this.badlands_terrain_sb_scale = badlands_terrain_sb_scale;
		this.badlands_terrain_sb_bias = badlands_terrain_sb_bias;
		this.badlands_sand = badlands_sand;
		this.badland_cliffs = badlands_cliffs;
	}



	@Override
	public Cached build() {
		ScaleBias scaleBias = new ScaleBiasBuilder().build(badlands_terrain_sb_scale, badlands_terrain_sb_bias, badlands_sand);
		Max badlandsTerrain_ma = new Max(badland_cliffs, scaleBias);
		this.badland_dunes = new Cached(badlandsTerrain_ma);
		logger.info(this.toString());
		return this.badland_dunes;
	}



	public Double getBadlands_terrain_sb_scale() {
		return badlands_terrain_sb_scale;
	}



	public void setBadlands_terrain_sb_scale(Double badlands_terrain_sb_scale) {
		this.badlands_terrain_sb_scale = badlands_terrain_sb_scale;
	}



	public Double getBadlands_terrain_sb_bias() {
		return badlands_terrain_sb_bias;
	}



	public void setBadlands_terrain_sb_bias(Double badlands_terrain_sb_bias) {
		this.badlands_terrain_sb_bias = badlands_terrain_sb_bias;
	}



	@Override
	public String toString() {
		return "PlanarBadlandsDunes [badlands_terrain_sb_scale=" + badlands_terrain_sb_scale
				+ ", badlands_terrain_sb_bias=" + badlands_terrain_sb_bias + "]";
	}

}
