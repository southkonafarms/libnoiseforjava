package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

/**
 * 
 * generate the "flatness" of the planar
 * 
 * very close proximity to a star warp effect not accounted for
 * 
 * planars with a radius of less than 200 kloms are assigned a 
 * an oblateness of zero, given potential irregular shape
 * 
 * @author jredden
 *
 */
public class Oblateness {
	
	interface Range {
		Double gen(UnifiedPlanetoidI unifiedPlanetoidI);
	}

	private static SortedMap<Double,Range> rangeMap = new TreeMap<Double, Range>();
	static{
		rangeMap.put(Double.MIN_VALUE, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0;
			}
		});
		rangeMap.put(200.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.0001);
			}
		});
		rangeMap.put(500.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.0005);
			}
		});
		rangeMap.put(1000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.0007);
			}
		});
		rangeMap.put(2000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.001);
			}
		});
		rangeMap.put(3000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.002);
			}
		});
		rangeMap.put(5000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.003);
			}
		});
		rangeMap.put(7000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.005);
			}
		});
		rangeMap.put(10000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.01);
			}
		});
		rangeMap.put(30000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.03);
			}
		});
		rangeMap.put(50000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.05);
			}
		});
		rangeMap.put(100000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.1);
			}
		});
		rangeMap.put(200000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.5);
			}
		});
		rangeMap.put(500000.0, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 0.09);
			}
		});
		rangeMap.put(Double.MAX_VALUE, new Range(){
			@Override
			public Double gen(UnifiedPlanetoidI unifiedPlanetoidI) {
				return 0.0 + (GenRandomRolls.Instance().draw_rand() * 1.0);
			}
		});
	}
	
	public static Double build(UnifiedPlanetoidI unifiedPlanetoidI) {
		Set<Double> keySet = rangeMap.keySet();
		Double oblatenessScalar = null;
		Iterator<Double> rangeIterator = keySet.iterator();
		Double currentRangeKey = rangeIterator.next();
		while (rangeIterator.hasNext()) {
			Double nextRangeKey = rangeIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getRadius() > currentRangeKey
					&& unifiedPlanetoidI.getPlanetoid().getRadius() <= nextRangeKey) {
				oblatenessScalar = rangeMap.get(nextRangeKey).gen(unifiedPlanetoidI);
				break;
			}
		}
		return oblatenessScalar;
	}
}
