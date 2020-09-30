package libnoiseforjava.domain;

import libnoiseforjava.module.ModuleBase;
import libnoiseforjava.module.Select;

public class SelectBuilder {
	
	Double lowerBounds;
	Double upperBounds;
	Double falloff;
	Select select;
	
	public Select build(ModuleBase module0, ModuleBase module1, ModuleBase module2, Double lowerBounds, Double upperBounds, Double falloff){
		this.lowerBounds = lowerBounds;
		this.upperBounds = upperBounds;
		this.falloff = falloff;
		this.select = new Select(module0, module1, module2);
		this.select.setBounds(lowerBounds, upperBounds);
		this.select.setEdgeFalloff(falloff);
		return this.select;
	}

	public Double getLowerBounds() {
		return lowerBounds;
	}

	public Double getUpperBounds() {
		return upperBounds;
	}

	public Double getFalloff() {
		return falloff;
	}

	@Override
	public String toString() {
		return "SelectBuilder [lowerBounds=" + lowerBounds + ", upperBounds=" + upperBounds + ", falloff=" + falloff
				+ "]";
	}

}
