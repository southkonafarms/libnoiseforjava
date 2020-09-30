package libnoiseforjava.domain;

import libnoiseforjava.module.Clamp;
import libnoiseforjava.module.ModuleBase;

public class ClampBuilder {

	Double lowerBound;
	Double upperBound;
	Clamp clamp;
	
	
	public Clamp build(ModuleBase moduleBase, Double lowerBound, Double upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.clamp = new Clamp(moduleBase);
		this.clamp.setBounds(lowerBound, upperBound);
		return this.clamp;
	}


	public Double getLowerBound() {
		return lowerBound;
	}


	public Double getUpperBound() {
		return upperBound;
	}


	public Clamp getClamp() {
		return clamp;
	}


	@Override
	public String toString() {
		return "ClampBuilder [lowerBound=" + lowerBound + ", upperBound=" + upperBound + "]";
	}
	
	
}
