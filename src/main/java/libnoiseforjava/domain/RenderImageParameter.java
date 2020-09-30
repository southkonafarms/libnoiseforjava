package libnoiseforjava.domain;

import java.util.List;

import libnoiseforjava.util.NoiseMap;

public class RenderImageParameter {

	private List<GradientPointParameter> gradientPointList;
	private NoiseMap noiseMap;
	private Boolean lightEnable;;
	private Double lightContrast;
	private Double lightBrightness;
	
	public RenderImageParameter(List<GradientPointParameter> gradientPointList,
			NoiseMap noiseMap, Boolean lightEnable, Double lightContrast,
			Double lightBrightness) {
		super();
		this.gradientPointList = gradientPointList;
		this.noiseMap = noiseMap;
		this.lightEnable = lightEnable;
		this.lightContrast = lightContrast;
		this.lightBrightness = lightBrightness;
	}

	public List<GradientPointParameter> getGradientPointList() {
		return gradientPointList;
	}

	public void setGradientPointList(List<GradientPointParameter> gradientPointList) {
		this.gradientPointList = gradientPointList;
	}

	public NoiseMap getNoiseMap() {
		return noiseMap;
	}

	public void setNoiseMap(NoiseMap noiseMap) {
		this.noiseMap = noiseMap;
	}

	public Boolean getLightEnable() {
		return lightEnable;
	}

	public void setLightEnable(Boolean lightEnable) {
		this.lightEnable = lightEnable;
	}

	public Double getLightContrast() {
		return lightContrast;
	}

	public void setLightContrast(Double lightContrast) {
		this.lightContrast = lightContrast;
	}

	public Double getLightBrightness() {
		return lightBrightness;
	}

	public void setLightBrightness(Double lightBrightness) {
		this.lightBrightness = lightBrightness;
	}

	@Override
	public String toString() {
		return "RenderImageParameter [gradientPointList=" + gradientPointList
				+ ", noiseMap=" + noiseMap + ", lightEnable=" + lightEnable
				+ ", lightContrast=" + lightContrast + ", lightBrightness="
				+ lightBrightness + "]";
	}
	
	
	
}
