package celestia.domain;

public class ColorRGB {
	
	private Double colorR;
	private Double colorG;
	private Double colorB;
	
	public ColorRGB(){}

	public ColorRGB(Double colorR, Double colorG, Double colorB) {
		super();
		this.colorR = colorR;
		this.colorG = colorG;
		this.colorB = colorB;
	}

	public Double getColorR() {
		return colorR;
	}

	public void setColorR(Double colorR) {
		this.colorR = colorR;
	}

	public Double getColorG() {
		return colorG;
	}

	public void setColorG(Double colorG) {
		this.colorG = colorG;
	}

	public Double getColorB() {
		return colorB;
	}

	public void setColorB(Double colorB) {
		this.colorB = colorB;
	}

	@Override
	public String toString() {
		return "ColorRGB [colorR=" + colorR + ", colorG=" + colorG + ", colorB=" + colorB + "]";
	}
	
	

}
