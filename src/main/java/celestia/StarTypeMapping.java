package celestia;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * maps stqr type and radius from Cosmos to Celestia
 * 
 * @author jredden
 *
 */
public class StarTypeMapping {
	
	private static Logger logger = Logger.getLogger(StarTypeMapping.class);
	
	private static Map<String,String> cosmosToCelestiaMap = new HashMap<String, String>();
	static{
		cosmosToCelestiaMap.put("sg2o","OIa");
		cosmosToCelestiaMap.put("sg2b","BIa");
		cosmosToCelestiaMap.put("sg2a","AIa");
		cosmosToCelestiaMap.put("sg2f","FIa");
		cosmosToCelestiaMap.put("sg2g","GIa");
		cosmosToCelestiaMap.put("sg2k","KIa");
		cosmosToCelestiaMap.put("sg2m","MIa");
		cosmosToCelestiaMap.put("sg1o","OIb");
		cosmosToCelestiaMap.put("sg1b","BIb");
		cosmosToCelestiaMap.put("sg1a","AIb");
		cosmosToCelestiaMap.put("sg1f","FIb");
		cosmosToCelestiaMap.put("sg1g","GIb");
		cosmosToCelestiaMap.put("sg1k","KIb");
		cosmosToCelestiaMap.put("sg1m","MIb");
		cosmosToCelestiaMap.put("g2o","OII");
		cosmosToCelestiaMap.put("g2b","BII");
		cosmosToCelestiaMap.put("g2a","AII");
		cosmosToCelestiaMap.put("g2f","FII");
		cosmosToCelestiaMap.put("g2g","GII");
		cosmosToCelestiaMap.put("g2k","KII");
		cosmosToCelestiaMap.put("g2m","MII");
		cosmosToCelestiaMap.put("g1o","OIII");
		cosmosToCelestiaMap.put("g1b","BIII");
		cosmosToCelestiaMap.put("g1a","AIII");
		cosmosToCelestiaMap.put("g1f","FIII");
		cosmosToCelestiaMap.put("g1g","GIII");
		cosmosToCelestiaMap.put("g1k","KIII");
		cosmosToCelestiaMap.put("g1m","MIII");
		cosmosToCelestiaMap.put("sbgo","OIV");
		cosmosToCelestiaMap.put("sbgb","BIV");
		cosmosToCelestiaMap.put("sbga","AIV");
		cosmosToCelestiaMap.put("sbgf","FIV");
		cosmosToCelestiaMap.put("sbgg","GIV");
		cosmosToCelestiaMap.put("sbgk","KIV");
		cosmosToCelestiaMap.put("sbgm","MIV");
		cosmosToCelestiaMap.put("o","OV");
		cosmosToCelestiaMap.put("b","BV");
		cosmosToCelestiaMap.put("a","AV");
		cosmosToCelestiaMap.put("f","FV");
		cosmosToCelestiaMap.put("g","GV");
		cosmosToCelestiaMap.put("k","KV");
		cosmosToCelestiaMap.put("m","MV");
		cosmosToCelestiaMap.put("sdo","OVI");
		cosmosToCelestiaMap.put("sdb","BVI");
		cosmosToCelestiaMap.put("sda","AVI");
		cosmosToCelestiaMap.put("sdf","FVI");
		cosmosToCelestiaMap.put("sdg","GVI");
		cosmosToCelestiaMap.put("sdk","KVI");
		cosmosToCelestiaMap.put("sdm","MVI");
		cosmosToCelestiaMap.put("do","D");
		cosmosToCelestiaMap.put("dwo","D");
		cosmosToCelestiaMap.put("db","DA1");
		cosmosToCelestiaMap.put("da","DA2");
		cosmosToCelestiaMap.put("df","DA3");
		cosmosToCelestiaMap.put("dg","DA4");
		cosmosToCelestiaMap.put("dk","DA5");
		cosmosToCelestiaMap.put("dm","DA6");
		cosmosToCelestiaMap.put("pmd","L");
		cosmosToCelestiaMap.put("bs","L");
		cosmosToCelestiaMap.put("dbs","L");
	}

	/**
	 * 
	 * @param cosmosType
	 * @return celestial type
	 */
	public static String doTheMapping(String cosmosType){
		String result;
		// str.substring(0, str.length()-1)
		result = cosmosToCelestiaMap.get(cosmosType.substring(0, cosmosType.length()-1));  // drop number
		if(null == result){
			logger.error("CosmosType:"+cosmosType+" did not map");
		}
		return result;
	}
	
	/**
	 * 
	 * @param solarRadius
	 * @return star radius in meters
	 */
	public static Double solarRadiusToMeters(Double solarRadius){
		return solarRadius * (6.957*(Math.pow(10, 8)));  
	}
}
