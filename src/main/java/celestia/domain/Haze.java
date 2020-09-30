package celestia.domain;

public class Haze {
	
	private ColorRGB hazeColor;
	private Double hazeDensity;
	
	public Haze(ColorRGB hazeColor, Double hazeDensity) {
		super();
		this.hazeColor = hazeColor;
		this.hazeDensity = hazeDensity;
	}

	public ColorRGB getHazeColor() {
		return hazeColor;
	}

	public void setHazeColor(ColorRGB hazeColor) {
		this.hazeColor = hazeColor;
	}

	public Double getHazeDensity() {
		return hazeDensity;
	}

	public void setHazeDensity(Double hazeDensity) {
		this.hazeDensity = hazeDensity;
	}

	@Override
	public String toString() {
		return "Haze [hazeColor=" + hazeColor + ", hazeDensity=" + hazeDensity + "]";
	}

}
