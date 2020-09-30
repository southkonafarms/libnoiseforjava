package celestia;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

public class StarMassApproximator {
	
	private static Logger logger = Logger.getLogger(StarMassApproximator.class);
	
	interface StarMass{
		Double genStarMass();
	}

	private static Map<String, StarMass> starMassMap = new HashMap<String, StarMass>();
	static{
		starMassMap.put("sg2o",new StarMass() {
			@Override
			public Double genStarMass() {
				return 80.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("sg2b",new StarMass() {
			@Override
			public Double genStarMass() {
				return 60.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("sg2a",new StarMass() {
			@Override
			public Double genStarMass() {
				return 40.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("sg2f",new StarMass() {
			@Override
			public Double genStarMass() {
				return 20.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("sg2g",new StarMass() {
			@Override
			public Double genStarMass() {
				return 5.0 + GenRandomRolls.Instance().draw_rand() * 20.0;
			}
		});
		starMassMap.put("sg2k",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.9 + GenRandomRolls.Instance().draw_rand() * 11.0;
			}
		});
		starMassMap.put("sg2m",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.8 + GenRandomRolls.Instance().draw_rand() * 10.0;
			}
		});
		starMassMap.put("sg1o",new StarMass() {
			@Override
			public Double genStarMass() {
				return 70.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("sg1b",new StarMass() {
			@Override
			public Double genStarMass() {
				return 50.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("sg1a",new StarMass() {
			@Override
			public Double genStarMass() {
				return 30.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("sg1f",new StarMass() {
			@Override
			public Double genStarMass() {
				return 10.0 + GenRandomRolls.Instance().draw_rand() * 20.0;
			}
		});
		starMassMap.put("sg1g",new StarMass() {
			@Override
			public Double genStarMass() {
				return 2.5 + GenRandomRolls.Instance().draw_rand() * 10.0;
			}
		});
		starMassMap.put("sg1k",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.8 + GenRandomRolls.Instance().draw_rand() * 9.0;
			}
		});
		starMassMap.put("sg1m",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.6 + GenRandomRolls.Instance().draw_rand() * 9.0;
			}
		});
		starMassMap.put("g2o",new StarMass() {
			@Override
			public Double genStarMass() {
				return 60.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("g2b",new StarMass() {
			@Override
			public Double genStarMass() {
				return 40.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("g2a",new StarMass() {
			@Override
			public Double genStarMass() {
				return 20.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("g2f",new StarMass() {
			@Override
			public Double genStarMass() {
				return 5.0 + GenRandomRolls.Instance().draw_rand() * 20.0;
			}
		});
		starMassMap.put("g2g",new StarMass() {
			@Override
			public Double genStarMass() {
				return 2.0 + GenRandomRolls.Instance().draw_rand() * 10.0;
			}
		});
		starMassMap.put("g2k",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.7 + GenRandomRolls.Instance().draw_rand() * 8.0;
			}
		});
		starMassMap.put("g2m",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.5 + GenRandomRolls.Instance().draw_rand() * 9.0;
			}
		});
		starMassMap.put("g1o",new StarMass() {
			@Override
			public Double genStarMass() {
				return 50.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("g1b",new StarMass() {
			@Override
			public Double genStarMass() {
				return 30.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("g1a",new StarMass() {
			@Override
			public Double genStarMass() {
				return 15.0 + GenRandomRolls.Instance().draw_rand() * 35.0;
			}
		});
		starMassMap.put("g1f",new StarMass() {
			@Override
			public Double genStarMass() {
				return 3.0 + GenRandomRolls.Instance().draw_rand() * 20.0;
			}
		});
		starMassMap.put("g1g",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.0 + GenRandomRolls.Instance().draw_rand() * 8.0;
			}
		});
		starMassMap.put("g1k",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.5 + GenRandomRolls.Instance().draw_rand() * 6.0;
			}
		});
		starMassMap.put("g1m",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.4 + GenRandomRolls.Instance().draw_rand() * 5.0;
			}
		});
		starMassMap.put("sbgo",new StarMass() {
			@Override
			public Double genStarMass() {
				return 20.0 + GenRandomRolls.Instance().draw_rand() * 50.0;
			}
		});
		starMassMap.put("sbgb",new StarMass() {
			@Override
			public Double genStarMass() {
				return 10.0 + GenRandomRolls.Instance().draw_rand() * 30.0;
			}
		});
		starMassMap.put("sbga",new StarMass() {
			@Override
			public Double genStarMass() {
				return 5.0 + GenRandomRolls.Instance().draw_rand() * 25.0;
			}
		});
		starMassMap.put("sbgf",new StarMass() {
			@Override
			public Double genStarMass() {
				return 3.0 + GenRandomRolls.Instance().draw_rand() * 10.0;
			}
		});
		starMassMap.put("sbgg",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.0 + GenRandomRolls.Instance().draw_rand() * 6.0;
			}
		});
		starMassMap.put("sbgk",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.5 + GenRandomRolls.Instance().draw_rand() * 5.0;
			}
		});
		starMassMap.put("sbgm",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.4 + GenRandomRolls.Instance().draw_rand() * 4.0;
			}
		});
		starMassMap.put("o",new StarMass() {
			@Override
			public Double genStarMass() {
				return 10.0 + GenRandomRolls.Instance().draw_rand() * 40.0;
			}
		});
		starMassMap.put("b",new StarMass() {
			@Override
			public Double genStarMass() {
				return 2.0 + GenRandomRolls.Instance().draw_rand() * 8.0;
			}
		});
		starMassMap.put("a",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.5 + GenRandomRolls.Instance().draw_rand() * 0.5;
			}
		});
		starMassMap.put("f",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.0 + GenRandomRolls.Instance().draw_rand() * 0.5;
			}
		});
		starMassMap.put("g",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.7 + GenRandomRolls.Instance().draw_rand() * 0.3;
			}
		});
		starMassMap.put("k",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.2 + GenRandomRolls.Instance().draw_rand() * 0.5;
			}
		});
		starMassMap.put("m",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.01 + GenRandomRolls.Instance().draw_rand() * 0.19;
			}
		});
		starMassMap.put("sdo",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.125 + GenRandomRolls.Instance().draw_rand() * 0.001;
			}
		});
		starMassMap.put("sdb",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.124 + GenRandomRolls.Instance().draw_rand() * 0.001;
			}
		});
		starMassMap.put("sda",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.123 + GenRandomRolls.Instance().draw_rand() * 0.001;
			}
		});
		starMassMap.put("sdf",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.122 + GenRandomRolls.Instance().draw_rand() * 0.001;
			}
		});
		starMassMap.put("sdg",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.120 + GenRandomRolls.Instance().draw_rand() * 0.002;
			}
		});
		starMassMap.put("sdk",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.119 + GenRandomRolls.Instance().draw_rand() * 0.001;
			}
		});
		starMassMap.put("sdm",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.119 + GenRandomRolls.Instance().draw_rand() * 0.179;
			}
		});
		starMassMap.put("do",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.9 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("dwo",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.8 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("db",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.7 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("da",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.6 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("df",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.5 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("dg",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.4 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("dk",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.3 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("dm",new StarMass() {
			@Override
			public Double genStarMass() {
				return 1.2 + GenRandomRolls.Instance().draw_rand() * 0.1;
			}
		});
		starMassMap.put("pmd",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.009 + GenRandomRolls.Instance().draw_rand() * 0.0091;
			}
		});
		starMassMap.put("bs",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.005 + GenRandomRolls.Instance().draw_rand() * 0.0091;
			}
		});
		starMassMap.put("dbs",new StarMass() {
			@Override
			public Double genStarMass() {
				return 0.003 + GenRandomRolls.Instance().draw_rand() * 0.0091;
			}
		});
	}
	/**
	 * Generates approximate star mass use by Celestia
	 * 
	 * @param cosmosType
	 * @return
	 */
	public static Double genStarMass(String cosmosType){
		Double result;
		// str.substring(0, str.length()-1)
		result = starMassMap.get(cosmosType.substring(0, cosmosType.length()-1)).genStarMass();  // drop number
		if(null == result){
			logger.error("CosmosType:"+cosmosType+" did not map");
		}
		return result;

	}
}
