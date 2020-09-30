package libnoiseforjava.domain;

import libnoiseforjava.util.ColorCafe;

public class GradientPointParameter {
	
	private Double gradientPosition;
	private ColorCafe colorCafe;
	
	
	
	public GradientPointParameter(Double gradientPosition, ColorCafe colorCafe) {
		super();
		this.gradientPosition = gradientPosition;
		this.colorCafe = colorCafe;
	}
	
	public Double getGradientPosition() {
		return gradientPosition;
	}
	public void setGradientPosition(Double gradientPosition) {
		this.gradientPosition = gradientPosition;
	}
	public ColorCafe getColorCafe() {
		return colorCafe;
	}
	public void setColorCafe(ColorCafe colorCafe) {
		this.colorCafe = colorCafe;
	}

	@Override
	public String toString() {
		return "GradientPointParameter [gradientPosition=" + gradientPosition
				+ ", colorCafe=" + colorCafe + "]";
	}
	
	
	

}
