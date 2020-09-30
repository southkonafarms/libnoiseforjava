package components;

import org.apache.log4j.Logger;

import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;

public class PlanarContinentsWithPlainsType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinentsWithPlainsType.class);
	
	Cached baseContinentElev;
	Cached scaledPlainsTerrain;
	
	Cached continentsWithPlains;
	
	public PlanarContinentsWithPlainsType(Cached baseContinentElev, Cached scaledPlainsTerrain) {
		super();
		this.baseContinentElev = baseContinentElev;
		this.scaledPlainsTerrain = scaledPlainsTerrain;
	}

	@Override
	public Cached build() {
		Add add = new Add(baseContinentElev, scaledPlainsTerrain);
		this.continentsWithPlains = new Cached(add);
		logger.info("end " + this.getClass().getSimpleName());
		return this.continentsWithPlains;
	}

	public Cached getBaseContinentElev() {
		return baseContinentElev;
	}

	public void setBaseContinentElev(Cached baseContinentElev) {
		this.baseContinentElev = baseContinentElev;
	}

	public Cached getScaledPlainsTerrain() {
		return scaledPlainsTerrain;
	}

	public void setScaledPlainsTerrain(Cached scaledPlainsTerrain) {
		this.scaledPlainsTerrain = scaledPlainsTerrain;
	}

}
