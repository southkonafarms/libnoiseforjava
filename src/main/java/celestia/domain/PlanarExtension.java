package celestia.domain;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.Star;

public class PlanarExtension {
	
	private static String GRAPHIC_SUFFIX = ".png";
	
	public enum PlanarClass {PLANET("planet"){}, MOON("moon"){};
		
		private String type;
		
		PlanarClass(String type){
			this.setType(type);
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	};
	
	/*
	 * Open GL colors ... take HTML colors and divide by 255
	 */
	public class OGL_Color{
		public Double rOfRGB;
		public Double gOfRGB;
		public Double bOfRGB;
		@Override
		public String toString() {
			return "OGL_Color [rOfRGB=" + rOfRGB + ", gOfRGB=" + gOfRGB + ", bOfRGB=" + bOfRGB + "]";
		}
		
		
	}
	
	private Integer planarExtensionId;
	private Integer planarId;
	private String planarName;
	private PlanarClass planarClass;
	private String texture;
	private String nightTexture;
	private OGL_Color color;
	private String specularTexture;
	private Double specularPower;
	private OGL_Color hazeColor;
	private Double hazeDensity;
	private Double radius;
	private Double oblateness;
	private Integer atmosphereHeight;
	private OGL_Color lower;
	private OGL_Color upper;
	private OGL_Color sky;
	private Integer cloudHeight;
	private String cloudMap;
	private Integer cloudSpeed;
	private Double period;
	private Double semiMajorAxis;
	private Double eccentricity;
	private Double inclination;
	private Double longOfPericenter;
	private Double meanLongitude;
	private Double rotationPeriod;
	private Double obliquity;
	private Double albedo;
	private Boolean emmisive;
	private String bumpMap;
	private Double bumpHeight;
	private OGL_Color specularColor;
	private String dateStamp;
	
	public PlanarExtension (){}
	
	

	public PlanarExtension(Integer planarExtensionId, Integer planarId, String planarName, PlanarClass planarClass,
			String texture, String nightTexture, OGL_Color color, String specularTexture, Double specularPower,
			OGL_Color hazeColor, Double hazeDensity, Double radius, Double oblateness, Integer atmosphereHeight,
			OGL_Color lower, OGL_Color upper, OGL_Color sky, Integer cloudHeight, String cloudMap, Integer cloudSpeed,
			Double period, Double semiMajorAxis, Double eccentricity, Double inclination, Double longOfPericenter,
			Double meanLongitude, Double rotationPeriod, Double obliquity, Double albedo, Boolean emmisive,
			String bumpMap, Double bumpHeight, OGL_Color specularColor, String dateStamp) {
		super();
		this.planarExtensionId = planarExtensionId;
		this.planarId = planarId;
		this.planarName = planarName;
		this.planarClass = planarClass;
		this.texture = texture;
		this.nightTexture = nightTexture;
		this.color = color;
		this.specularTexture = specularTexture;
		this.specularPower = specularPower;
		this.hazeColor = hazeColor;
		this.hazeDensity = hazeDensity;
		this.radius = radius;
		this.oblateness = oblateness;
		this.atmosphereHeight = atmosphereHeight;
		this.lower = lower;
		this.upper = upper;
		this.sky = sky;
		this.cloudHeight = cloudHeight;
		this.cloudMap = cloudMap;
		this.cloudSpeed = cloudSpeed;
		this.period = period;
		this.semiMajorAxis = semiMajorAxis;
		this.eccentricity = eccentricity;
		this.inclination = inclination;
		this.longOfPericenter = longOfPericenter;
		this.meanLongitude = meanLongitude;
		this.rotationPeriod = rotationPeriod;
		this.obliquity = obliquity;
		this.albedo = albedo;
		this.emmisive = emmisive;
		this.bumpMap = bumpMap;
		this.bumpHeight = bumpHeight;
		this.specularColor = specularColor;
		this.dateStamp = dateStamp;
	}

	public static PlanarExtension build(Star star, Planetoid planetoid, PlanarClass planarClass){
		PlanarExtension instance = new PlanarExtension();
		instance.planarClass = planarClass;
		instance.texture = planetoid.getPlanetoidName()+GRAPHIC_SUFFIX;
		return instance;
	}

	public Boolean getEmmisive() {
		return emmisive;
	}



	public void setEmmisive(Boolean emmisive) {
		this.emmisive = emmisive;
	}



	public String getBumpMap() {
		return bumpMap;
	}



	public void setBumpMap(String bumpMap) {
		this.bumpMap = bumpMap;
	}



	public Double getBumpHeight() {
		return bumpHeight;
	}



	public void setBumpHeight(Double bumpHeight) {
		this.bumpHeight = bumpHeight;
	}



	public OGL_Color getSpecularColor() {
		return specularColor;
	}



	public void setSpecularColor(OGL_Color specularColor) {
		this.specularColor = specularColor;
	}



	public PlanarClass getPlanarClass() {
		return planarClass;
	}



	public void setPlanarClass(PlanarClass planarClass) {
		this.planarClass = planarClass;
	}



	public Double getInclination() {
		return inclination;
	}



	public void setInclination(Double inclination) {
		this.inclination = inclination;
	}



	public String getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(String dateStamp) {
		this.dateStamp = dateStamp;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getNightTexture() {
		return nightTexture;
	}

	public void setNightTexture(String nightTexture) {
		this.nightTexture = nightTexture;
	}

	public OGL_Color getColor() {
		return color;
	}

	public void setColor(OGL_Color color) {
		this.color = color;
	}

	public String getSpecularTexture() {
		return specularTexture;
	}

	public void setSpecularTexture(String specularTexture) {
		this.specularTexture = specularTexture;
	}

	public Double getSpecularPower() {
		return specularPower;
	}

	public void setSpecularPower(Double specularPower) {
		this.specularPower = specularPower;
	}

	public OGL_Color getHazeColor() {
		return hazeColor;
	}

	public void setHazeColor(OGL_Color hazeColor) {
		this.hazeColor = hazeColor;
	}

	public Double getHazeDensity() {
		return hazeDensity;
	}

	public Integer getPlanarExtensionId() {
		return planarExtensionId;
	}

	public Integer getPlanarId() {
		return planarId;
	}

	public void setPlanarId(Integer planarId) {
		this.planarId = planarId;
	}

	public void setPlanarExtensionId(Integer planarExtensionId) {
		this.planarExtensionId = planarExtensionId;
	}

	public String getPlanarName() {
		return planarName;
	}

	public void setPlanarName(String planarName) {
		this.planarName = planarName;
	}

	public void setHazeDensity(Double hazeDensity) {
		this.hazeDensity = hazeDensity;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getOblateness() {
		return oblateness;
	}

	public void setOblateness(Double oblateness) {
		this.oblateness = oblateness;
	}

	public Integer getAtmosphereHeight() {
		return atmosphereHeight;
	}

	public void setAtmosphereHeight(Integer atmosphereHeight) {
		this.atmosphereHeight = atmosphereHeight;
	}

	public OGL_Color getLower() {
		return lower;
	}

	public void setLower(OGL_Color lower) {
		this.lower = lower;
	}

	public OGL_Color getUpper() {
		return upper;
	}

	public void setUpper(OGL_Color upper) {
		this.upper = upper;
	}

	public OGL_Color getSky() {
		return sky;
	}

	public void setSky(OGL_Color sky) {
		this.sky = sky;
	}

	public Integer getCloudHeight() {
		return cloudHeight;
	}

	public void setCloudHeight(Integer cloudHeight) {
		this.cloudHeight = cloudHeight;
	}

	public String getCloudMap() {
		return cloudMap;
	}

	public void setCloudMap(String cloudMap) {
		this.cloudMap = cloudMap;
	}

	public Integer getCloudSpeed() {
		return cloudSpeed;
	}

	public void setCloudSpeed(Integer cloudSpeed) {
		this.cloudSpeed = cloudSpeed;
	}

	public Double getPeriod() {
		return period;
	}

	public void setPeriod(Double period) {
		this.period = period;
	}

	public Double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(Double semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public void setEccentricity(Double eccentricity) {
		this.eccentricity = eccentricity;
	}

	public Double getLongOfPericenter() {
		return longOfPericenter;
	}

	public void setLongOfPericenter(Double longOfPericenter) {
		this.longOfPericenter = longOfPericenter;
	}

	public Double getMeanLongitude() {
		return meanLongitude;
	}

	public void setMeanLongitude(Double meanLongitude) {
		this.meanLongitude = meanLongitude;
	}

	public Double getRotationPeriod() {
		return rotationPeriod;
	}

	public void setRotationPeriod(Double rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}

	public Double getObliquity() {
		return obliquity;
	}

	public void setObliquity(Double obliquity) {
		this.obliquity = obliquity;
	}

	public Double getAlbedo() {
		return albedo;
	}

	public void setAlbedo(Double albedo) {
		this.albedo = albedo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albedo == null) ? 0 : albedo.hashCode());
		result = prime * result + ((atmosphereHeight == null) ? 0 : atmosphereHeight.hashCode());
		result = prime * result + ((bumpHeight == null) ? 0 : bumpHeight.hashCode());
		result = prime * result + ((bumpMap == null) ? 0 : bumpMap.hashCode());
		result = prime * result + ((cloudHeight == null) ? 0 : cloudHeight.hashCode());
		result = prime * result + ((cloudMap == null) ? 0 : cloudMap.hashCode());
		result = prime * result + ((cloudSpeed == null) ? 0 : cloudSpeed.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((dateStamp == null) ? 0 : dateStamp.hashCode());
		result = prime * result + ((eccentricity == null) ? 0 : eccentricity.hashCode());
		result = prime * result + ((emmisive == null) ? 0 : emmisive.hashCode());
		result = prime * result + ((hazeColor == null) ? 0 : hazeColor.hashCode());
		result = prime * result + ((hazeDensity == null) ? 0 : hazeDensity.hashCode());
		result = prime * result + ((inclination == null) ? 0 : inclination.hashCode());
		result = prime * result + ((longOfPericenter == null) ? 0 : longOfPericenter.hashCode());
		result = prime * result + ((lower == null) ? 0 : lower.hashCode());
		result = prime * result + ((meanLongitude == null) ? 0 : meanLongitude.hashCode());
		result = prime * result + ((nightTexture == null) ? 0 : nightTexture.hashCode());
		result = prime * result + ((oblateness == null) ? 0 : oblateness.hashCode());
		result = prime * result + ((obliquity == null) ? 0 : obliquity.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((planarClass == null) ? 0 : planarClass.hashCode());
		result = prime * result + ((planarExtensionId == null) ? 0 : planarExtensionId.hashCode());
		result = prime * result + ((planarId == null) ? 0 : planarId.hashCode());
		result = prime * result + ((planarName == null) ? 0 : planarName.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result + ((rotationPeriod == null) ? 0 : rotationPeriod.hashCode());
		result = prime * result + ((semiMajorAxis == null) ? 0 : semiMajorAxis.hashCode());
		result = prime * result + ((sky == null) ? 0 : sky.hashCode());
		result = prime * result + ((specularColor == null) ? 0 : specularColor.hashCode());
		result = prime * result + ((specularPower == null) ? 0 : specularPower.hashCode());
		result = prime * result + ((specularTexture == null) ? 0 : specularTexture.hashCode());
		result = prime * result + ((texture == null) ? 0 : texture.hashCode());
		result = prime * result + ((upper == null) ? 0 : upper.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanarExtension other = (PlanarExtension) obj;
		if (albedo == null) {
			if (other.albedo != null)
				return false;
		} else if (!albedo.equals(other.albedo))
			return false;
		if (atmosphereHeight == null) {
			if (other.atmosphereHeight != null)
				return false;
		} else if (!atmosphereHeight.equals(other.atmosphereHeight))
			return false;
		if (bumpHeight == null) {
			if (other.bumpHeight != null)
				return false;
		} else if (!bumpHeight.equals(other.bumpHeight))
			return false;
		if (bumpMap == null) {
			if (other.bumpMap != null)
				return false;
		} else if (!bumpMap.equals(other.bumpMap))
			return false;
		if (cloudHeight == null) {
			if (other.cloudHeight != null)
				return false;
		} else if (!cloudHeight.equals(other.cloudHeight))
			return false;
		if (cloudMap == null) {
			if (other.cloudMap != null)
				return false;
		} else if (!cloudMap.equals(other.cloudMap))
			return false;
		if (cloudSpeed == null) {
			if (other.cloudSpeed != null)
				return false;
		} else if (!cloudSpeed.equals(other.cloudSpeed))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dateStamp == null) {
			if (other.dateStamp != null)
				return false;
		} else if (!dateStamp.equals(other.dateStamp))
			return false;
		if (eccentricity == null) {
			if (other.eccentricity != null)
				return false;
		} else if (!eccentricity.equals(other.eccentricity))
			return false;
		if (emmisive == null) {
			if (other.emmisive != null)
				return false;
		} else if (!emmisive.equals(other.emmisive))
			return false;
		if (hazeColor == null) {
			if (other.hazeColor != null)
				return false;
		} else if (!hazeColor.equals(other.hazeColor))
			return false;
		if (hazeDensity == null) {
			if (other.hazeDensity != null)
				return false;
		} else if (!hazeDensity.equals(other.hazeDensity))
			return false;
		if (inclination == null) {
			if (other.inclination != null)
				return false;
		} else if (!inclination.equals(other.inclination))
			return false;
		if (longOfPericenter == null) {
			if (other.longOfPericenter != null)
				return false;
		} else if (!longOfPericenter.equals(other.longOfPericenter))
			return false;
		if (lower == null) {
			if (other.lower != null)
				return false;
		} else if (!lower.equals(other.lower))
			return false;
		if (meanLongitude == null) {
			if (other.meanLongitude != null)
				return false;
		} else if (!meanLongitude.equals(other.meanLongitude))
			return false;
		if (nightTexture == null) {
			if (other.nightTexture != null)
				return false;
		} else if (!nightTexture.equals(other.nightTexture))
			return false;
		if (oblateness == null) {
			if (other.oblateness != null)
				return false;
		} else if (!oblateness.equals(other.oblateness))
			return false;
		if (obliquity == null) {
			if (other.obliquity != null)
				return false;
		} else if (!obliquity.equals(other.obliquity))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (planarClass != other.planarClass)
			return false;
		if (planarExtensionId == null) {
			if (other.planarExtensionId != null)
				return false;
		} else if (!planarExtensionId.equals(other.planarExtensionId))
			return false;
		if (planarId == null) {
			if (other.planarId != null)
				return false;
		} else if (!planarId.equals(other.planarId))
			return false;
		if (planarName == null) {
			if (other.planarName != null)
				return false;
		} else if (!planarName.equals(other.planarName))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		if (rotationPeriod == null) {
			if (other.rotationPeriod != null)
				return false;
		} else if (!rotationPeriod.equals(other.rotationPeriod))
			return false;
		if (semiMajorAxis == null) {
			if (other.semiMajorAxis != null)
				return false;
		} else if (!semiMajorAxis.equals(other.semiMajorAxis))
			return false;
		if (sky == null) {
			if (other.sky != null)
				return false;
		} else if (!sky.equals(other.sky))
			return false;
		if (specularColor == null) {
			if (other.specularColor != null)
				return false;
		} else if (!specularColor.equals(other.specularColor))
			return false;
		if (specularPower == null) {
			if (other.specularPower != null)
				return false;
		} else if (!specularPower.equals(other.specularPower))
			return false;
		if (specularTexture == null) {
			if (other.specularTexture != null)
				return false;
		} else if (!specularTexture.equals(other.specularTexture))
			return false;
		if (texture == null) {
			if (other.texture != null)
				return false;
		} else if (!texture.equals(other.texture))
			return false;
		if (upper == null) {
			if (other.upper != null)
				return false;
		} else if (!upper.equals(other.upper))
			return false;
		return true;
	}
	
	public static Map<String, Object> getPlanarExtensionMap(PlanarExtension planarExtension){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(PlanarExtensionDao.ALBEDO, planarExtension.getAlbedo());
		map.put(PlanarExtensionDao.ATMOSPHEREHEIGHT, planarExtension.getAtmosphereHeight());
		map.put(PlanarExtensionDao.CLOUDHEIGHT, planarExtension.getCloudHeight());
		map.put(PlanarExtensionDao.CLOUDMAP, planarExtension.getCloudMap());
		map.put(PlanarExtensionDao.CLOUDSPEED, planarExtension.getCloudSpeed());
		map.put(PlanarExtensionDao.COLORR, planarExtension.getColor().rOfRGB);
		map.put(PlanarExtensionDao.COLORG, planarExtension.getColor().gOfRGB);
		map.put(PlanarExtensionDao.COLORB, planarExtension.getColor().bOfRGB);
		map.put(PlanarExtensionDao.ECCENTRICITY, planarExtension.getEccentricity());
		map.put(PlanarExtensionDao.HAZECOLORR, planarExtension.getHazeColor().rOfRGB);		
		map.put(PlanarExtensionDao.HAZECOLORG, planarExtension.getHazeColor().gOfRGB);		
		map.put(PlanarExtensionDao.HAZECOLORB, planarExtension.getHazeColor().bOfRGB);
		map.put(PlanarExtensionDao.HAZEDENSITY, planarExtension.getHazeDensity());
		map.put(PlanarExtensionDao.ORBITLONGOFPERICENTRE, planarExtension.getLongOfPericenter());
		map.put(PlanarExtensionDao.ATMOSPHERELOWERR, planarExtension.getLower().rOfRGB);		
		map.put(PlanarExtensionDao.ATMOSPHERELOWERG, planarExtension.getLower().gOfRGB);		
		map.put(PlanarExtensionDao.ATMOSPHERELOWERB, planarExtension.getLower().bOfRGB);		
		map.put(PlanarExtensionDao.ORBITMEANLONGITUDE, planarExtension.getMeanLongitude());
		map.put(PlanarExtensionDao.NIGHTTEXTURE, planarExtension.getNightTexture());
		map.put(PlanarExtensionDao.OBLATENESS, planarExtension.getOblateness());
		map.put(PlanarExtensionDao.OBLIQUITY, planarExtension.getObliquity());
		map.put(PlanarExtensionDao.ROTATIONPERIOD, planarExtension.getRotationPeriod());
		map.put(PlanarExtensionDao.SEMIMAJORAXIS, planarExtension.getSemiMajorAxis());
		map.put(PlanarExtensionDao.ATMOSPHERESKYR, planarExtension.getSky().rOfRGB);
		map.put(PlanarExtensionDao.ATMOSPHERESKYG, planarExtension.getSky().gOfRGB);
		map.put(PlanarExtensionDao.ATMOSPHERESKYB, planarExtension.getSky().bOfRGB);
		map.put(PlanarExtensionDao.SPECULARPOWER, planarExtension.getSpecularPower());
		map.put(PlanarExtensionDao.SPECULARTEXTURE, planarExtension.getSpecularTexture());
		map.put(PlanarExtensionDao.TEXTURE, planarExtension.getTexture());
		map.put(PlanarExtensionDao.ATMOSPHEREUPPERR, planarExtension.getUpper().rOfRGB);
		map.put(PlanarExtensionDao.ATMOSPHEREUPPERG, planarExtension.getUpper().gOfRGB);
		map.put(PlanarExtensionDao.ATMOSPHEREUPPERB, planarExtension.getUpper().bOfRGB);
		map.put(PlanarExtensionDao.PLANETOIDEXTENSIONID, planarExtension.getPlanarExtensionId());
		map.put(PlanarExtensionDao.PLANETOIDID, planarExtension.getPlanarId());
		map.put(PlanarExtensionDao.PLANETOIDNAME, planarExtension.getPlanarName());
		map.put(PlanarExtensionDao.ORBITPERIOD, planarExtension.getPeriod());
		map.put(PlanarExtensionDao.ORBITSEMIMAJORAXIS, planarExtension.getSemiMajorAxis());
		map.put(PlanarExtensionDao.ORBITECCENTRICITY, planarExtension.getEccentricity());
		map.put(PlanarExtensionDao.ORBITINCLINATION, planarExtension.getInclination());
		map.put(PlanarExtensionDao.PLANAR_CLASS, planarExtension.getPlanarClass().name());
		map.put(PlanarExtensionDao.EMMISIVE, planarExtension.getEmmisive());
		map.put(PlanarExtensionDao.BUMP_MAP, planarExtension.getBumpMap());
		map.put(PlanarExtensionDao.BUMP_HEIGHT, planarExtension.getBumpHeight());
		map.put(PlanarExtensionDao.SPECULAR_COLORR, planarExtension.getSpecularColor().rOfRGB);
		map.put(PlanarExtensionDao.SPECULAR_COLORG, planarExtension.getSpecularColor().gOfRGB);
		map.put(PlanarExtensionDao.SPECULAR_COLORB, planarExtension.getSpecularColor().bOfRGB);
		map.put(PlanarExtensionDao.DATESTAMP, planarExtension.getDateStamp());
		return map;
	}

	public static String[] csvPlanarExtension() {
		return new String[] { 
				PlanarExtensionDao.ALBEDO
				, PlanarExtensionDao.ATMOSPHEREHEIGHT
				, PlanarExtensionDao.CLOUDHEIGHT
				, PlanarExtensionDao.CLOUDMAP
				, PlanarExtensionDao.CLOUDSPEED
				, PlanarExtensionDao.COLORR
				, PlanarExtensionDao.COLORG
				, PlanarExtensionDao.COLORB
				, PlanarExtensionDao.ECCENTRICITY
				, PlanarExtensionDao.HAZECOLORR
				, PlanarExtensionDao.HAZECOLORG
				, PlanarExtensionDao.HAZECOLORB
				, PlanarExtensionDao.HAZEDENSITY
				, PlanarExtensionDao.ORBITLONGOFPERICENTRE
				, PlanarExtensionDao.ATMOSPHERELOWERR
				, PlanarExtensionDao.ATMOSPHERELOWERG
				, PlanarExtensionDao.ATMOSPHERELOWERB
				, PlanarExtensionDao.ORBITMEANLONGITUDE
				, PlanarExtensionDao.NIGHTTEXTURE
				, PlanarExtensionDao.OBLATENESS
				, PlanarExtensionDao.OBLIQUITY
				, PlanarExtensionDao.ROTATIONPERIOD
				, PlanarExtensionDao.SEMIMAJORAXIS
				, PlanarExtensionDao.ATMOSPHERESKYR
				, PlanarExtensionDao.ATMOSPHERESKYG
				, PlanarExtensionDao.ATMOSPHERESKYB
				, PlanarExtensionDao.SPECULARPOWER
				, PlanarExtensionDao.SPECULARTEXTURE
				, PlanarExtensionDao.TEXTURE
				, PlanarExtensionDao.ATMOSPHEREUPPERR
				, PlanarExtensionDao.ATMOSPHEREUPPERG
				, PlanarExtensionDao.ATMOSPHEREUPPERB
//				, PlanarExtensionDao.PLANETOIDEXTENSIONID
				, PlanarExtensionDao.PLANETOIDID
				, PlanarExtensionDao.PLANETOIDNAME
				, PlanarExtensionDao.ORBITPERIOD
				, PlanarExtensionDao.ORBITSEMIMAJORAXIS
				, PlanarExtensionDao.ORBITECCENTRICITY
				, PlanarExtensionDao.ORBITINCLINATION
				, PlanarExtensionDao.PLANAR_CLASS
				, PlanarExtensionDao.EMMISIVE
				, PlanarExtensionDao.BUMP_MAP
				, PlanarExtensionDao.BUMP_HEIGHT
				, PlanarExtensionDao.SPECULAR_COLORR
				, PlanarExtensionDao.SPECULAR_COLORG
				, PlanarExtensionDao.SPECULAR_COLORB
				, PlanarExtensionDao.DATESTAMP};
			};
	;

	@Override
	public String toString() {
		return "PlanarExtension [planarExtensionId=" + planarExtensionId + ", planarId=" + planarId + ", planarName="
				+ planarName + ", planarClass=" + planarClass + ", texture=" + texture + ", nightTexture="
				+ nightTexture + ", color=" + color + ", specularTexture=" + specularTexture + ", specularPower="
				+ specularPower + ", hazeColor=" + hazeColor + ", hazeDensity=" + hazeDensity + ", radius=" + radius
				+ ", oblateness=" + oblateness + ", atmosphereHeight=" + atmosphereHeight + ", lower=" + lower
				+ ", upper=" + upper + ", sky=" + sky + ", cloudHeight=" + cloudHeight + ", cloudMap=" + cloudMap
				+ ", cloudSpeed=" + cloudSpeed + ", period=" + period + ", semiMajorAxis=" + semiMajorAxis
				+ ", eccentricity=" + eccentricity + ", inclination=" + inclination + ", longOfPericenter="
				+ longOfPericenter + ", meanLongitude=" + meanLongitude + ", rotationPeriod=" + rotationPeriod
				+ ", obliquity=" + obliquity + ", albedo=" + albedo + ", emmisive=" + emmisive + ", bumpMap=" + bumpMap
				+ ", bumpHeight=" + bumpHeight + ", specularColor=" + specularColor + ", dateStamp=" + dateStamp + "]";
	}
	
	
}
