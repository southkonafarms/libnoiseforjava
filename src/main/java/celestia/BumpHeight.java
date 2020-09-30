package celestia;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.service_rules_and_infrastructure.GenAtmosphere;
import com.zenred.cosmos.service_rules_and_infrastructure.RadiusRange;
import com.zenred.cosmos.service_rules_and_infrastructure.TemperatureRange;
import com.zenred.util.GenRandomRolls;

/**
 * gen bump height for celestia
 * 
 * @author jredden
 *
 */

public class BumpHeight {
	
	interface BumpHeightComponent{
		Double genHeight();
	}
	
	private static Map<String, BumpHeightComponent> buildMap = new HashMap<String, BumpHeight.BumpHeightComponent>();
	static {
		// Dwarf planetoids
		buildMap.put(RadiusRange.s_DWARF_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*0.1;
			}
		});
		buildMap.put(RadiusRange.s_DWARF_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*0.3;
			}
		});
		buildMap.put(RadiusRange.s_DWARF_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 2.0 + GenRandomRolls.Instance().draw_rand()*1.0;
			}
		});
		buildMap.put(RadiusRange.s_DWARF_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.1 + GenRandomRolls.Instance().draw_rand()*0.3;
			}
		});
		buildMap.put(RadiusRange.s_DWARF_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.001;
			}
		});
		
		// mini planetoids
		buildMap.put(RadiusRange.s_MINI_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*0.2;
			}
		});
		buildMap.put(RadiusRange.s_MINI_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*0.5;
			}
		});
		buildMap.put(RadiusRange.s_MINI_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 2.0 + GenRandomRolls.Instance().draw_rand()*1.5;
			}
		});
		buildMap.put(RadiusRange.s_MINI_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.1 + GenRandomRolls.Instance().draw_rand()*0.35;
			}
		});
		buildMap.put(RadiusRange.s_MINI_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.002;
			}
		});
		
		// Terran like planetoids
		buildMap.put(RadiusRange.s_EARTH_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*1.0;
			}
		});
		buildMap.put(RadiusRange.s_EARTH_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*1.5;
			}
		});
		buildMap.put(RadiusRange.s_EARTH_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 2.0 + GenRandomRolls.Instance().draw_rand()*2.0;
			}
		});
		buildMap.put(RadiusRange.s_EARTH_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.1 + GenRandomRolls.Instance().draw_rand()*0.9;
			}
		});
		buildMap.put(RadiusRange.s_EARTH_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.05;
			}
		});

		// super terran planetoids
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*3.0;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.5 + GenRandomRolls.Instance().draw_rand()*3.1;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 2.0 + GenRandomRolls.Instance().draw_rand()*5.0;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.1 + GenRandomRolls.Instance().draw_rand()*1.1;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.1;
			}
		});

		// mini gas giant planetoid
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.01;
			}
		});
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.01;
			}
		});
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.01;
			}
		});
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.02 + GenRandomRolls.Instance().draw_rand()*0.01;
			}
		});
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.02;
			}
		});

		// gas giant planetoids
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.02;
			}
		});
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.02;
			}
		});
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.02;
			}
		});
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.02 + GenRandomRolls.Instance().draw_rand()*0.02;
			}
		});
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.03;
			}
		});
		
		// super gas giant planetoids
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID+":"+TemperatureRange.CRYOGENIC, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.03;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID+":"+TemperatureRange.ICE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.03;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID+":"+TemperatureRange.TEMPERATE, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.01 + GenRandomRolls.Instance().draw_rand()*0.03;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID+":"+TemperatureRange.HOT, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.02 + GenRandomRolls.Instance().draw_rand()*0.03;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID+":"+TemperatureRange.MOLTEN, new BumpHeightComponent() {
			@Override
			public Double genHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*0.04;
			}
		});

	}
	
	/**
	 * 
	 * @param unifiedPlanetoidI
	 * @return generated bump height
	 */
	public static Double build(UnifiedPlanetoidI unifiedPlanetoidI){
		Double height = null;
		Double radius = unifiedPlanetoidI.getPlanetoid().getRadius();
		String planarSizeType = GenAtmosphere.sizeType(radius);
		String temperatureType = GenAtmosphere.temperatureType(unifiedPlanetoidI.getPlanetoid().getTemperature());
		String key = planarSizeType + ":" + temperatureType;
		height = buildMap.get(key).genHeight();
		if(null == height){
			throw new RuntimeException("failure for " + planarSizeType + " and " + temperatureType);
		}
		return height;
	}

}
