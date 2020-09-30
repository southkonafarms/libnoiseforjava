package libnoiseforjava.domain;

import libnoiseforjava.module.Perlin;
import libnoiseforjava.util.NoiseMap;

public class BuilderPlaneParameters {
	
	private Perlin perlin;
	private NoiseMap noiseMap;
	private Integer destWidth;
	private Integer destHeight;
	private Double lowerXBound;
	private Double upperXBound;
	private Double lowerZBound;
	private Double upperZBound;
	
	
	
	public BuilderPlaneParameters(Perlin perlin, NoiseMap noiseMap,
			Integer destWidth, Integer destHeight, Double lowerXBound,
			Double upperXBound, Double lowerZBound, Double upperZBound) {
		super();
		this.perlin = perlin;
		this.noiseMap = noiseMap;
		this.destWidth = destWidth;
		this.destHeight = destHeight;
		this.lowerXBound = lowerXBound;
		this.upperXBound = upperXBound;
		this.lowerZBound = lowerZBound;
		this.upperZBound = upperZBound;
	}
	public Perlin getPerlin() {
		return perlin;
	}
	public void setPerlin(Perlin perlin) {
		this.perlin = perlin;
	}
	public NoiseMap getNoiseMap() {
		return noiseMap;
	}
	public void setNoiseMap(NoiseMap noiseMap) {
		this.noiseMap = noiseMap;
	}
	public Integer getDestWidth() {
		return destWidth;
	}
	public void setDestWidth(Integer destWidth) {
		this.destWidth = destWidth;
	}
	public Integer getDestHeight() {
		return destHeight;
	}
	public void setDestHeight(Integer destHeight) {
		this.destHeight = destHeight;
	}
	public Double getLowerXBound() {
		return lowerXBound;
	}
	public void setLowerXBound(Double lowerXBound) {
		this.lowerXBound = lowerXBound;
	}
	public Double getUpperXBound() {
		return upperXBound;
	}
	public void setUpperXBound(Double upperXBound) {
		this.upperXBound = upperXBound;
	}
	public Double getLowerZBound() {
		return lowerZBound;
	}
	public void setLowerZBound(Double lowerZBound) {
		this.lowerZBound = lowerZBound;
	}
	public Double getUpperZBound() {
		return upperZBound;
	}
	public void setUpperZBound(Double upperZBound) {
		this.upperZBound = upperZBound;
	}
	@Override
	public String toString() {
		return "BuilderPlaneParameters [perlin=" + perlin + ", noiseMap="
				+ noiseMap + ", destWidth=" + destWidth + ", destHeight="
				+ destHeight + ", lowerXBound=" + lowerXBound
				+ ", upperXBound=" + upperXBound + ", lowerZBound="
				+ lowerZBound + ", upperZBound=" + upperZBound + "]";
	}
	
	
	
}
