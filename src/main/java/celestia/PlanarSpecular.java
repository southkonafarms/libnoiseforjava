package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

/**
 * 
 * generates specular scalar for celestia. The complexity of clouds and
 * atmosphere are not accounted for
 * 
 * @author jredden
 *
 */

public class PlanarSpecular {

	interface Luminosity {
		Integer genSpecularLumenosityScalar();
	}

	interface Distance {
		Integer genSPecualrDistanceScalar();
	}

	interface Temperature {
		Integer genSpecularTemperatureScalar();
	}

	private static SortedMap<Double, Luminosity> luminosityMap = new TreeMap<Double, PlanarSpecular.Luminosity>();
	static {
		luminosityMap.put(new Double(0.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 1 + GenRandomRolls.Instance().get_D2();
			}
		});
		luminosityMap.put(new Double(0.00005), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 1 + GenRandomRolls.Instance().get_D4();
			}
		});
		luminosityMap.put(new Double(0.005), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 5 + GenRandomRolls.Instance().get_D6();
			}
		});
		luminosityMap.put(new Double(0.05), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 10 + GenRandomRolls.Instance().get_D8();
			}
		});
		luminosityMap.put(new Double(0.5), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 10 + GenRandomRolls.Instance().get_D10();
			}
		});
		luminosityMap.put(new Double(1.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 15 + GenRandomRolls.Instance().get_D18();
			}
		});
		luminosityMap.put(new Double(5.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 20 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(10.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 25 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(25.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 30 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(100.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 40 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(500.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 50 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(1000.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 60 + GenRandomRolls.Instance().getDX(20);
			}
		});
		luminosityMap.put(new Double(10000.0), new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 70 + GenRandomRolls.Instance().getDX(30);
			}
		});
		luminosityMap.put(Double.MAX_VALUE, new Luminosity() {
			@Override
			public Integer genSpecularLumenosityScalar() {
				return 100;
			}
		});
	}

	private static SortedMap<Double, Distance> distanceMap = new TreeMap<Double, Distance>();
	static {
		distanceMap.put(new Double(0.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 100;
			}
		});
		distanceMap.put(new Double(0.03), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 96;
			}
		});
		distanceMap.put(new Double(0.09), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 94;
			}
		});
		distanceMap.put(new Double(0.12), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 92;
			}
		});
		distanceMap.put(new Double(0.25), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 88;
			}
		});
		distanceMap.put(new Double(0.50), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 86;
			}
		});
		distanceMap.put(new Double(1.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 80;
			}
		});
		distanceMap.put(new Double(3.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 75;
			}
		});
		distanceMap.put(new Double(10.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 70;
			}
		});
		distanceMap.put(new Double(20.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 65;
			}
		});
		distanceMap.put(new Double(50.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 60;
			}
		});
		distanceMap.put(new Double(100.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 55;
			}
		});
		distanceMap.put(new Double(500.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 50;
			}
		});
		distanceMap.put(new Double(1000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 45;
			}
		});
		distanceMap.put(new Double(5000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 40;
			}
		});
		distanceMap.put(new Double(10000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 35;
			}
		});
		distanceMap.put(new Double(20000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 30;
			}
		});
		distanceMap.put(new Double(50000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 25;
			}
		});
		distanceMap.put(new Double(100000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 20;
			}
		});
		distanceMap.put(new Double(200000.0), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 15;
			}
		});
		distanceMap.put(new Double(5.0E5), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 10;
			}
		});
		distanceMap.put(new Double(5.0E6), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 5;
			}
		});
		distanceMap.put(new Double(5.0E7), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 3;
			}
		});
		distanceMap.put(new Double(5.0E10), new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 2;
			}
		});
		distanceMap.put(Double.POSITIVE_INFINITY, new Distance() {
			@Override
			public Integer genSPecualrDistanceScalar() {
				return 1;
			}
		});
	}

	private static SortedMap<Double, Temperature> temperatureMap = new TreeMap<Double, Temperature>();
	static {
		temperatureMap.put(new Double(0.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 100;
			}
		});
		temperatureMap.put(new Double(5.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 98;
			}
		});
		temperatureMap.put(new Double(10.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 95;
			}
		});
		temperatureMap.put(new Double(20.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 92;
			}
		});
		temperatureMap.put(new Double(50.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 88;
			}
		});
		temperatureMap.put(new Double(100.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 80;
			}
		});
		temperatureMap.put(new Double(150.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 75;
			}
		});
		temperatureMap.put(new Double(200.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 70;
			}
		});
		temperatureMap.put(new Double(300.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 50;
			}
		});
		temperatureMap.put(new Double(500.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 30;
			}
		});
		temperatureMap.put(new Double(800.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 15;
			}
		});
		temperatureMap.put(new Double(1600.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 10;
			}
		});
		temperatureMap.put(new Double(3200.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 5;
			}
		});
		temperatureMap.put(new Double(6400.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 3;
			}
		});
		temperatureMap.put(new Double(12800.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 2;
			}
		});
		temperatureMap.put(new Double(25600.0), new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 1;
			}
		});
		temperatureMap.put(Double.MAX_VALUE, new Temperature() {
			@Override
			public Integer genSpecularTemperatureScalar() {
				return 0;
			}
		});
	}

	/**
	 * 
	 * @param star
	 * @param unifiedPlanetoidI
	 * @return adjusted specular power of the planet
	 */
	public static Double build(Star star, UnifiedPlanetoidI unifiedPlanetoidI) {

		Set<Double> luminosityKeys = luminosityMap.keySet();
		Integer luminosityScalar = null;
		Iterator<Double> luminosityIterator = luminosityKeys.iterator();
		Double currentLuminosityKey = luminosityIterator.next();
		while (luminosityIterator.hasNext()) {
			Double nextLuminosityKey = luminosityIterator.next();
			if (star.getLuminosity() > currentLuminosityKey && star.getLuminosity() <= nextLuminosityKey) {
				luminosityScalar = luminosityMap.get(nextLuminosityKey).genSpecularLumenosityScalar();
				break;
			}
			currentLuminosityKey = nextLuminosityKey;
		}
		Integer distanceScalar = null;
		Set<Double> distanceKeys = distanceMap.keySet();
		Iterator<Double> distanceIterator = distanceKeys.iterator();
		Double currentDistanceKey = distanceIterator.next();
		while (distanceIterator.hasNext()) {
			Double nextDistanceKey = distanceIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary() > currentDistanceKey
					&& unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary() <= nextDistanceKey) {
				distanceScalar = distanceMap.get(nextDistanceKey).genSPecualrDistanceScalar();
				break;
			}
		}
		Integer temperatureScalar = null;
		Set<Double> temperatureKeys = temperatureMap.keySet();
		Iterator<Double> temperatureIterator = temperatureKeys.iterator();
		Double currentTemperatureKey = temperatureIterator.next();
		while (temperatureIterator.hasNext()) {
			Double nextTemperatureKey = temperatureIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getTemperature() > currentTemperatureKey
					&& unifiedPlanetoidI.getPlanetoid().getTemperature() <= nextTemperatureKey) {
				temperatureScalar = temperatureMap.get(nextTemperatureKey).genSpecularTemperatureScalar();
				break;
			}
		}
		Double planarScalar = new Double((luminosityScalar + distanceScalar + temperatureScalar) / 3);
		
		return planarScalar;
	}
}
