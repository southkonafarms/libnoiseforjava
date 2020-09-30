package libnoiseforjava.domain;

import java.util.List;

import libnoiseforjava.util.NoiseMap;
import libnoiseforjava.util.NoiseMapBuilderSphere;

public class RenderImageSphereParameter {

	private List<GradientPointParameter> gradientPointList;
	private NoiseMap noiseMap;
	private Boolean lightEnable;;
	private Double lightContrast;
	private Double lightBrightness;
	private Double lightElevation;
	private Double lightAzumeth;
	
	public RenderImageSphereParameter(List<GradientPointParameter> gradientPointList,
			NoiseMap noiseMap, Boolean lightEnable, Double lightContrast,
			Double lightBrightness, Double lightElevation, Double lightAzumeth) {
		super();
		this.gradientPointList = gradientPointList;
		this.noiseMap = noiseMap;
		this.lightEnable = lightEnable;
		this.lightContrast = lightContrast;
		this.lightBrightness = lightBrightness;
		this.lightElevation = lightElevation;
		this.lightAzumeth = lightAzumeth;
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

	public Double getLightElevation() {
		return lightElevation;
	}

	public void setLightElevation(Double lightElevation) {
		this.lightElevation = lightElevation;
	}

	public Double getLightAzumeth() {
		return lightAzumeth;
	}

	public void setLightAzumeth(Double lightAzumeth) {
		this.lightAzumeth = lightAzumeth;
	}

	@Override
	public String toString() {
		return "RenderImageSphereParameter [gradientPointList="
				+ gradientPointList + ", noiseMap=" + noiseMap
				+ ", lightEnable=" + lightEnable + ", lightContrast="
				+ lightContrast + ", lightBrightness=" + lightBrightness
				+ ", lightElevation=" + lightElevation + ", lightAzumeth="
				+ lightAzumeth + "]";
	}
	
	
	
}
