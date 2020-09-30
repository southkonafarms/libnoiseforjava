package celestia.domain;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zenred.cosmos.domain.System;
import com.zenred.johntredden.domain.AbstractJDBCDao;

public class StarExtensionDao extends AbstractJDBCDao {
	
	public static final String STAR_EXTENSION = "StarExtension";
	
	public static final String STAREXTENSIONID = "starExtensionId";
	public static final String STARID = "starId";
	public static final String STARNAME = "starName";
	public static final String PERIOD = "period";
	public static final String STAR_SEMIMAJORAXIS = "semiMajorAxis";
	public static final String STAR_ECCENTRICITY = "eccentricity";
	public static final String ASCENDINGNODE = "ascendingNode";
	public static final String INCLINATION = "inclination";
	public static final String APPARANTMAGNITUDE = "apparantMagnitude";
	public static final String DATESTAMP = "datestamp";
	
	private static String lastStarExtensionInsertSql = "SELECT MAX("+STAREXTENSIONID+") FROM " + STAR_EXTENSION;
	
	private static String readStarExtensionByIdSql = "SELECT "
			+ " stex." + STAREXTENSIONID + " "
			+ ", stex." + STARID + " "
			+ ", stex." + STARNAME + " "
			+ ", stex." + PERIOD + " "
			+ ", stex." + STAR_SEMIMAJORAXIS + " "
			+ ", stex." + STAR_ECCENTRICITY + " "
			+ ", stex." + ASCENDINGNODE + " "
			+ ", stex." + INCLINATION + " "
			+ ", stex." + APPARANTMAGNITUDE + " "
			+ ", stex." + DATESTAMP + " "
			+ " FROM " + STAR_EXTENSION + " stex "
			+ " WHERE stex." + STAREXTENSIONID + " = ? "
			;
	private static String readStarExtensionByStarNameSql = "SELECT "
			+ " stex." + STAREXTENSIONID + " "
			+ ", stex." + STARID + " "
			+ ", stex." + STARNAME + " "
			+ ", stex." + PERIOD + " "
			+ ", stex." + STAR_SEMIMAJORAXIS + " "
			+ ", stex." + STAR_ECCENTRICITY + " "
			+ ", stex." + ASCENDINGNODE + " "
			+ ", stex." + INCLINATION + " "
			+ ", stex." + APPARANTMAGNITUDE + " "
			+ ", stex." + DATESTAMP + " "
			+ " FROM " + STAR_EXTENSION + " stex "
			+ " WHERE stex." + STARNAME + " = ? "
			;
	private static String readSystemByNameCountSql = "SELECT COUNT(*) " 
			+ " FROM " + STAR_EXTENSION + " stex " + " WHERE stex." + STARNAME
			+ " = ? "
			;

	
	private static String deleteStarExtensionSql = "DELETE FROM " + STAR_EXTENSION + " WHERE " + STAREXTENSIONID
			+ " = ? ";
	
	private static String updateStarExtensionByStarNameSql = "UPDATE " + STAR_EXTENSION + " stex SET " 
			+ " stex."+STARID+" = ?  "
			+ ", stex."+PERIOD+" = ?  "
			+ ", stex."+STAR_SEMIMAJORAXIS+" = ?  "
			+ ", stex."+STAR_ECCENTRICITY+" = ?  "
			+ ", stex."+ASCENDINGNODE+" = ?  "
			+ ", stex."+INCLINATION+" = ?  "
			+ ", stex."+APPARANTMAGNITUDE+" = ?  "
			+ " WHERE stex."+STARNAME+ " = ?"; 
			;

	/**
	 * 
	 * @param starExtension
	 * @return new StarExtension object
	 */
	@Transactional
	public StarExtension addStarExtension(StarExtension starExtension) {
		Map<String, Object> starExtensionMap = StarExtension.getStarExtensionMap(starExtension);
		super.jdbcInsertSetup().withTableName(STAR_EXTENSION).usingColumns(StarExtension.csvStarExtension())
				.execute(starExtensionMap);
		Integer starExtensionId = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(lastStarExtensionInsertSql);
		starExtension.setStarExtensionId(starExtensionId);
		return readStarExtensionById(starExtensionId);
	}

	/**
	 * 
	 * @param starExtensionId
	 * @return found StarExtension
	 */
	public StarExtension readStarExtensionById(Integer starExtensionId) {
		Object[] param = { starExtensionId };
		Map<String, Object> starExtensionMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readStarExtensionByIdSql, param);
		return buildStarExtension(starExtensionMap);
	}
	
	public StarExtension readStarExtensionByStarName(String starName){
		Object[] param = { starName };
		Map<String, Object> starExtensionMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(readStarExtensionByStarNameSql, param);
		return buildStarExtension(starExtensionMap);
	}
	
	/**
	 * 
	 * @param starExtension
	 */
	public void deleteStarExtension(StarExtension starExtension){
		super.jdbcSetUp()
		.getSimpleJdbcTemplate()
		.update(deleteStarExtensionSql,
				new Object[] {starExtension.getStarExtensionId()});
	}
	/**
	 * 
	 * @param starExtension
	 * @return true if already built
	 */
	public Boolean doesStarExtensionExist(StarExtension starExtension){
		Boolean answer = true;
		int count  = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForInt(readSystemByNameCountSql, starExtension.getStarName());
		if(0 == count ){
			answer = false;
		}
		return answer;
	}
	
	/**
	 * 
	 * @param starExtension
	 * @return updated StarExtension domain object
	 */
	public StarExtension updateStarExtensionByStarName(StarExtension starExtension) {
		super.jdbcSetUp().getSimpleJdbcTemplate().update(updateStarExtensionByStarNameSql,
				new Object[] { starExtension.getStarId(), starExtension.getPeriod(), starExtension.getSemiMajorAxis(),
						starExtension.getEccentricity(), starExtension.getAscendingNode(),
						starExtension.getInclination(), starExtension.getApparantMagnitude(),
						starExtension.getStarName() });
		return readStarExtensionByStarName(starExtension.getStarName());
	}
	
	private StarExtension buildStarExtension(Map<String, Object> starExtensionMap){
		StarExtension starExtension = new StarExtension();
		String s_starExtensionId = starExtensionMap.get(STAREXTENSIONID).toString();
		starExtension.setStarExtensionId(new Integer(s_starExtensionId));
		String s_starId = starExtensionMap.get(STARID).toString();
		starExtension.setStarId(new Integer(s_starId));
		starExtension.setStarName(starExtensionMap.get(STARNAME).toString());
		String s_period = starExtensionMap.get(PERIOD).toString();
		starExtension.setPeriod(new Double(s_period));
		String s_starSemiMajorAxis = starExtensionMap.get(STAR_SEMIMAJORAXIS).toString();
		starExtension.setSemiMajorAxis(new Double(s_starSemiMajorAxis));
		String s_starEccentricity = starExtensionMap.get(STAR_ECCENTRICITY).toString();
		starExtension.setEccentricity(new Double(s_starEccentricity));
		String s_ascendingNode = starExtensionMap.get(ASCENDINGNODE).toString();
		starExtension.setAscendingNode(new Double(s_ascendingNode));
		String s_inclinaton = starExtensionMap.get(INCLINATION).toString();
		starExtension.setInclination(new Double(s_inclinaton));
		String s_apparentMagnitude = starExtensionMap.get(APPARANTMAGNITUDE).toString();
		starExtension.setApparantMagnitude(new Double(s_apparentMagnitude));
		starExtension.setDatestamp(starExtensionMap.get(DATESTAMP).toString());
		return starExtension;
	}
	
}
