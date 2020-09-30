package components;

import libnoiseforjava.module.Cached;
/**
 * 
 * @author jredden
 * 
 * some confusion over names, same class as PlanarBadlandsDunesType
 *
 */
public class PlanarBadlandsTerrain extends PlanarBadlandsDunesType{

	public PlanarBadlandsTerrain(Double badlands_terrain_sb_scale, Double badlands_terrain_sb_bias,
			Cached badlands_sand, Cached badlands_cliffs) {
		super(badlands_terrain_sb_scale, badlands_terrain_sb_bias, badlands_sand, badlands_cliffs);
	}
	
}
