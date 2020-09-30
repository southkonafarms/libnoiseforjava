package components;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ScaleBiasBuilder;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.ScaleBias;

public class PlanarFinalType implements CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarFinalType.class);
	
	Double max_elev;
	Double min_elev;
	Double scalar_divisor;
	Cached unscaled_planet;
	
	Cached final_planet;
	
	public PlanarFinalType(Double max_elev, Double min_elev, Double scalar_divisor, Cached unscaled_planet) {
		super();
		this.max_elev = max_elev;
		this.min_elev = min_elev;
		this.scalar_divisor = scalar_divisor;
		this.unscaled_planet = unscaled_planet;
	}

	@Override
	public Cached build() {
		ScaleBias scaleBias = new ScaleBiasBuilder().build(max_elev - min_elev / scalar_divisor,
				min_elev + ((max_elev - min_elev / scalar_divisor)), unscaled_planet);
		this.final_planet = new Cached(scaleBias);
		logger.info(this.toString());
		return this.final_planet;
	}

	public Double getMax_elev() {
		return max_elev;
	}

	public void setMax_elev(Double max_elev) {
		this.max_elev = max_elev;
	}

	public Double getMin_elev() {
		return min_elev;
	}

	public void setMin_elev(Double min_elev) {
		this.min_elev = min_elev;
	}

	public Double getScalar_divisor() {
		return scalar_divisor;
	}

	public void setScalar_divisor(Double scalar_divisor) {
		this.scalar_divisor = scalar_divisor;
	}

	public Cached getUnscaled_planet() {
		return unscaled_planet;
	}

	public void setUnscaled_planet(Cached unscaled_planet) {
		this.unscaled_planet = unscaled_planet;
	}

	@Override
	public String toString() {
		return "PlanarFinalType [max_elev=" + max_elev + ", min_elev=" + min_elev + ", scalar_divisor=" + scalar_divisor
				+ "]";
	}

}
