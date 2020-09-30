package celestia.domain;

public class CelestAtmosphere {

	private Integer height;
	private ColorRGB lower;
	private ColorRGB upper;
	private ColorRGB sky;
	private Integer cloudHeight;
	private Integer cloudSpeed;
	private String cloudMap;
	
	public CelestAtmosphere(){}
	
	public CelestAtmosphere(Integer height, ColorRGB lower, ColorRGB upper, ColorRGB sky, Integer cloudHeight,
			Integer cloudSpeed, String cloudMap) {
		super();
		this.height = height;
		this.lower = lower;
		this.upper = upper;
		this.sky = sky;
		this.cloudHeight = cloudHeight;
		this.cloudSpeed = cloudSpeed;
		this.cloudMap = cloudMap;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public ColorRGB getLower() {
		return lower;
	}

	public void setLower(ColorRGB lower) {
		this.lower = lower;
	}

	public ColorRGB getUpper() {
		return upper;
	}

	public void setUpper(ColorRGB upper) {
		this.upper = upper;
	}

	public ColorRGB getSky() {
		return sky;
	}

	public void setSky(ColorRGB sky) {
		this.sky = sky;
	}

	public Integer getCloudHeight() {
		return cloudHeight;
	}

	public void setCloudHeight(Integer cloudHeight) {
		this.cloudHeight = cloudHeight;
	}

	public Integer getCloudSpeed() {
		return cloudSpeed;
	}

	public void setCloudSpeed(Integer cloudSpeed) {
		this.cloudSpeed = cloudSpeed;
	}

	public String getCloudMap() {
		return cloudMap;
	}

	public void setCloudMap(String cloudMap) {
		this.cloudMap = cloudMap;
	}

	@Override
	public String toString() {
		return "CelestAtmosphere [height=" + height + ", lower=" + lower + ", upper=" + upper + ", sky=" + sky
				+ ", cloudHeight=" + cloudHeight + ", cloudSpeed=" + cloudSpeed + ", cloudMap=" + cloudMap + "]";
	}
	
	
}
