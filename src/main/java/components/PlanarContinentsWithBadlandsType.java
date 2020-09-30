package components;

import org.apache.log4j.Logger;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.PerlinBuilder;
import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Max;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.module.Select;

public class PlanarContinentsWithBadlandsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentsWithBadlandsType.class);
	
	Double continents_with_badlands_pe_freqeuncy;
	Double continents_with_badlands_pe_persistence;
	Integer continents_with_badlands_pe_octave_count;
	NoiseQuality noiseQuality;
	Double contient_lacunarity;
	
	Cached baseContinentElev;
	Cached scaledBadlandsTerrain;
	
	Double continents_with_badlands_se_bounds_param0;
	Double continents_with_badlands_se_bounds_param1;
	Double continents_with_badlands_edge_falloff;
	
	Cached continentsWithMountains;
	Double badlands_amount;
	
	Cached continentsWithBadlands;
	
	public PlanarContinentsWithBadlandsType(Double continents_with_badlands_pe_freqeuncy,
			Double continents_with_badlands_pe_persistence, Integer continents_with_badlands_pe_octave_count,
			NoiseQuality noiseQuality, Double contient_lacunarity, Cached baseContinentElev,
			Cached scaledBadlandsTerrain, Double continents_with_badlands_se_bounds_param0,
			Double continents_with_badlands_se_bounds_param1, Double continents_with_badlands_edge_falloff,
			Cached continentsWithMountains, Double badlands_amount) {
		super();
		this.continents_with_badlands_pe_freqeuncy = continents_with_badlands_pe_freqeuncy;
		this.continents_with_badlands_pe_persistence = continents_with_badlands_pe_persistence;
		this.continents_with_badlands_pe_octave_count = continents_with_badlands_pe_octave_count;
		this.noiseQuality = noiseQuality;
		this.contient_lacunarity = contient_lacunarity;
		this.baseContinentElev = baseContinentElev;
		this.scaledBadlandsTerrain = scaledBadlandsTerrain;
		this.continents_with_badlands_se_bounds_param0 = continents_with_badlands_se_bounds_param0;
		this.continents_with_badlands_se_bounds_param1 = continents_with_badlands_se_bounds_param1;
		this.continents_with_badlands_edge_falloff = continents_with_badlands_edge_falloff;
		this.continentsWithMountains = continentsWithMountains;
		this.badlands_amount = badlands_amount;
	}

	@Override
	public Cached build() {
		Perlin perlin = new PerlinBuilder().biuld(continents_with_badlands_pe_freqeuncy,
				continents_with_badlands_pe_persistence, contient_lacunarity, continents_with_badlands_pe_octave_count,
				noiseQuality);
		Add continentsWithBadlands_ad = new Add(baseContinentElev, scaledBadlandsTerrain);
		Select select = new SelectBuilder().build(continentsWithMountains, continentsWithBadlands_ad, perlin,
				continents_with_badlands_se_bounds_param0, continents_with_badlands_se_bounds_param1,
				continents_with_badlands_edge_falloff);
		Max continentsWithBadlands_ma = new Max(continentsWithMountains, select);
		this.continentsWithBadlands = new Cached(continentsWithBadlands_ma);
		logger.info(this.toString());
		return this.continentsWithBadlands;
	}

	public Double getContinents_with_badlands_pe_freqeuncy() {
		return continents_with_badlands_pe_freqeuncy;
	}

	public void setContinents_with_badlands_pe_freqeuncy(Double continents_with_badlands_pe_freqeuncy) {
		this.continents_with_badlands_pe_freqeuncy = continents_with_badlands_pe_freqeuncy;
	}

	public Double getContinents_with_badlands_pe_persistence() {
		return continents_with_badlands_pe_persistence;
	}

	public void setContinents_with_badlands_pe_persistence(Double continents_with_badlands_pe_persistence) {
		this.continents_with_badlands_pe_persistence = continents_with_badlands_pe_persistence;
	}

	public Integer getContinents_with_badlands_pe_octave_count() {
		return continents_with_badlands_pe_octave_count;
	}

	public void setContinents_with_badlands_pe_octave_count(Integer continents_with_badlands_pe_octave_count) {
		this.continents_with_badlands_pe_octave_count = continents_with_badlands_pe_octave_count;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	public void setNoiseQuality(NoiseQuality noiseQuality) {
		this.noiseQuality = noiseQuality;
	}

	public Double getContient_lacunarity() {
		return contient_lacunarity;
	}

	public void setContient_lacunarity(Double contient_lacunarity) {
		this.contient_lacunarity = contient_lacunarity;
	}

	public Cached getBaseContinentElev() {
		return baseContinentElev;
	}

	public void setBaseContinentElev(Cached baseContinentElev) {
		this.baseContinentElev = baseContinentElev;
	}

	public Cached getScaledBadlandsTerrain() {
		return scaledBadlandsTerrain;
	}

	public void setScaledBadlandsTerrain(Cached scaledBadlandsTerrain) {
		this.scaledBadlandsTerrain = scaledBadlandsTerrain;
	}

	public Double getContinents_with_badlands_se_bounds_param0() {
		return continents_with_badlands_se_bounds_param0;
	}

	public void setContinents_with_badlands_se_bounds_param0(Double continents_with_badlands_se_bounds_param0) {
		this.continents_with_badlands_se_bounds_param0 = continents_with_badlands_se_bounds_param0;
	}

	public Double getContinents_with_badlands_se_bounds_param1() {
		return continents_with_badlands_se_bounds_param1;
	}

	public void setContinents_with_badlands_se_bounds_param1(Double continents_with_badlands_se_bounds_param1) {
		this.continents_with_badlands_se_bounds_param1 = continents_with_badlands_se_bounds_param1;
	}

	public Double getContinents_with_badlands_edge_falloff() {
		return continents_with_badlands_edge_falloff;
	}

	public void setContinents_with_badlands_edge_falloff(Double continents_with_badlands_edge_falloff) {
		this.continents_with_badlands_edge_falloff = continents_with_badlands_edge_falloff;
	}

	public Cached getContinentsWithMountains() {
		return continentsWithMountains;
	}

	public void setContinentsWithMountains(Cached continentsWithMountains) {
		this.continentsWithMountains = continentsWithMountains;
	}

	public Double getBadlands_amount() {
		return badlands_amount;
	}

	public void setBadlands_amount(Double badlands_amount) {
		this.badlands_amount = badlands_amount;
	}

	@Override
	public String toString() {
		return "PlanarContinentsWithBadlandsType [continents_with_badlands_pe_freqeuncy="
				+ continents_with_badlands_pe_freqeuncy + ", continents_with_badlands_pe_persistence="
				+ continents_with_badlands_pe_persistence + ", continents_with_badlands_pe_octave_count="
				+ continents_with_badlands_pe_octave_count + ", noiseQuality=" + noiseQuality + ", contient_lacunarity="
				+ contient_lacunarity + ", continents_with_badlands_se_bounds_param0="
				+ continents_with_badlands_se_bounds_param0 + ", continents_with_badlands_se_bounds_param1="
				+ continents_with_badlands_se_bounds_param1 + ", continents_with_badlands_edge_falloff="
				+ continents_with_badlands_edge_falloff + ", badlands_amount=" + badlands_amount + "]";
	}

}
