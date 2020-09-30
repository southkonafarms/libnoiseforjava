package libnoiseforjava.domain;

import libnoiseforjava.module.Spheres;

public class SpheresBuilder {
	
	Double frequency;
	Spheres spheres;

	public Spheres build(Double frequency){
		this.frequency = frequency;
		this.spheres = new Spheres();
		this.spheres.setFrequency(frequency);
		return this.spheres;
	}

	public Double getFrequency() {
		return frequency;
	}

	public Spheres getSpheres() {
		return spheres;
	}

	@Override
	public String toString() {
		return "SpheresBuilder [frequency=" + frequency + "]";
	}
	
	
}
