package celestia.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jredden
 *
 */

public class StarExtension {

	private Integer starExtensionId;
	private Integer starId;
	private String starName;
	private Double period;
	private Double semiMajorAxis;
	private Double eccentricity;
	private Double ascendingNode;
	private Double inclination;
	private Double apparantMagnitude;
	private String datestamp;

	public StarExtension() {
	}

	public StarExtension(Integer starExtensionId, Integer starId, String starName, Double period, Double semiMajorAxis,
			Double eccentricity, Double ascendingNode, Double inclination, Double apparantMagnitude) {
		super();
		this.starExtensionId = starExtensionId;
		this.starId = starId;
		this.starName = starName;
		this.period = period;
		this.semiMajorAxis = semiMajorAxis;
		this.eccentricity = eccentricity;
		this.ascendingNode = ascendingNode;
		this.inclination = inclination;
		this.apparantMagnitude = apparantMagnitude;
	}

	public Integer getStarExtensionId() {
		return starExtensionId;
	}

	public void setStarExtensionId(Integer starExtensionId) {
		this.starExtensionId = starExtensionId;
	}

	public Integer getStarId() {
		return starId;
	}

	public void setStarId(Integer starId) {
		this.starId = starId;
	}

	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
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

	public Double getAscendingNode() {
		return ascendingNode;
	}

	public void setAscendingNode(Double ascendingNode) {
		this.ascendingNode = ascendingNode;
	}

	public Double getInclination() {
		return inclination;
	}

	public void setInclination(Double inclination) {
		this.inclination = inclination;
	}

	public Double getApparantMagnitude() {
		return apparantMagnitude;
	}

	public void setApparantMagnitude(Double apparantMagnitude) {
		this.apparantMagnitude = apparantMagnitude;
	}
	
	public String getDatestamp() {
		return datestamp;
	}

	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}

	public static Map<String, Object> getStarExtensionMap(StarExtension starExtension) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(StarExtensionDao.APPARANTMAGNITUDE, starExtension.getApparantMagnitude());
		map.put(StarExtensionDao.ASCENDINGNODE, starExtension.getAscendingNode());
		map.put(StarExtensionDao.STAR_ECCENTRICITY, starExtension.getEccentricity());
		map.put(StarExtensionDao.INCLINATION, starExtension.getInclination());
		map.put(StarExtensionDao.PERIOD, starExtension.getPeriod());
		map.put(StarExtensionDao.STAR_SEMIMAJORAXIS, starExtension.getSemiMajorAxis());
		map.put(StarExtensionDao.STAREXTENSIONID, starExtension.getStarExtensionId());
		map.put(StarExtensionDao.STARNAME, starExtension.getStarName());
		map.put(StarExtensionDao.STARID, starExtension.getStarId());
		return map;
	}

	public static String[] csvStarExtension() {
		return new String[] { StarExtensionDao.APPARANTMAGNITUDE, StarExtensionDao.ASCENDINGNODE,
				StarExtensionDao.STAR_ECCENTRICITY, StarExtensionDao.INCLINATION, StarExtensionDao.PERIOD,
				StarExtensionDao.STAR_SEMIMAJORAXIS, StarExtensionDao.STAREXTENSIONID, StarExtensionDao.STARNAME,
				StarExtensionDao.STARID };
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apparantMagnitude == null) ? 0 : apparantMagnitude.hashCode());
		result = prime * result + ((ascendingNode == null) ? 0 : ascendingNode.hashCode());
		result = prime * result + ((eccentricity == null) ? 0 : eccentricity.hashCode());
		result = prime * result + ((inclination == null) ? 0 : inclination.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((semiMajorAxis == null) ? 0 : semiMajorAxis.hashCode());
		result = prime * result + ((starExtensionId == null) ? 0 : starExtensionId.hashCode());
		result = prime * result + ((starId == null) ? 0 : starId.hashCode());
		result = prime * result + ((starName == null) ? 0 : starName.hashCode());
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
		StarExtension other = (StarExtension) obj;
		if (apparantMagnitude == null) {
			if (other.apparantMagnitude != null)
				return false;
		} else if (!apparantMagnitude.equals(other.apparantMagnitude))
			return false;
		if (ascendingNode == null) {
			if (other.ascendingNode != null)
				return false;
		} else if (!ascendingNode.equals(other.ascendingNode))
			return false;
		if (eccentricity == null) {
			if (other.eccentricity != null)
				return false;
		} else if (!eccentricity.equals(other.eccentricity))
			return false;
		if (inclination == null) {
			if (other.inclination != null)
				return false;
		} else if (!inclination.equals(other.inclination))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (semiMajorAxis == null) {
			if (other.semiMajorAxis != null)
				return false;
		} else if (!semiMajorAxis.equals(other.semiMajorAxis))
			return false;
		if (starExtensionId == null) {
			if (other.starExtensionId != null)
				return false;
		} else if (!starExtensionId.equals(other.starExtensionId))
			return false;
		if (starId == null) {
			if (other.starId != null)
				return false;
		} else if (!starId.equals(other.starId))
			return false;
		if (starName == null) {
			if (other.starName != null)
				return false;
		} else if (!starName.equals(other.starName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StarExtension [starExtensionId=" + starExtensionId + ", starId=" + starId + ", starName=" + starName
				+ ", period=" + period + ", semiMajorAxis=" + semiMajorAxis + ", eccentricity=" + eccentricity
				+ ", ascendingNode=" + ascendingNode + ", inclination=" + inclination + ", apparantMagnitude="
				+ apparantMagnitude + ", datestamp=" + datestamp + "]";
	}

}
