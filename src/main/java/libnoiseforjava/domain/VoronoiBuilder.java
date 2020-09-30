package libnoiseforjava.domain;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.module.Voronoi;

public class VoronoiBuilder {

	Double frequency;
	Double displacement;
	Boolean enableDistance;
	Voronoi voronoi;
	
	public Voronoi build(Double frequency, Double displacement, Boolean enableDistance) {
		this.frequency = frequency;
		this.displacement = displacement;
		this.enableDistance = enableDistance;
		this.voronoi = new Voronoi();
		this.voronoi.setDisplacement(displacement);
		this.voronoi.setFrequency(frequency);
		this.voronoi.enableDistance(enableDistance);
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		this.voronoi.setSeed(currSeed);
		return this.voronoi;
	}

	public Double getFrequency() {
		return frequency;
	}

	public Double getDisplacement() {
		return displacement;
	}

	public Boolean getEnableDistance() {
		return enableDistance;
	}

	@Override
	public String toString() {
		return "VoronoiBuilder [frequency=" + frequency + ", displacement=" + displacement + ", enableDistance="
				+ enableDistance + "]";
	}
		
}
