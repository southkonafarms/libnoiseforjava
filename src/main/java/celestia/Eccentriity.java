package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.zenred.util.GenRandomRolls;

public class Eccentriity {
	
	interface Operation{
		Double gen();
	}
	
	private static SortedMap<Integer,Operation> steps = new TreeMap<Integer, Operation>();
	static{
		steps.put(new Integer(0), new Operation(){
			@Override
			public Double gen() {
				return 0.0+(GenRandomRolls.Instance().draw_rand()*30.0);
			}
		});
		steps.put(new Integer(50), new Operation(){
			@Override
			public Double gen() {
				return 30.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(60), new Operation(){
			@Override
			public Double gen() {
				return 40.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(70), new Operation(){
			@Override
			public Double gen() {
				return 50.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(80), new Operation(){
			@Override
			public Double gen() {
				return 60.0+(GenRandomRolls.Instance().draw_rand()*40.0);
			}
		});
		steps.put(new Integer(100), new Operation(){
			@Override
			public Double gen() {
				return 99.9999;
			}
		});
	}

	/**
	 * generates an eccentricity between 0.0 and 1.0
	 * 
	 * usually closer to 0.0
	 * 
	 * @return eccentricity
	 */
	public static Double build(){
		Double eccentricity = 0.0;
		Integer draw = GenRandomRolls.Instance().getD100();
		Set<Integer> stepsKeys = steps.keySet();
		Iterator<Integer> step = stepsKeys.iterator();
		Integer stepN = step.next();
		Integer stepNplusOne = step.next();
		while(step.hasNext()){
			if(draw >= stepN && draw <= stepNplusOne){
				eccentricity = steps.get(stepN).gen();
			}
			stepN = stepNplusOne;
			stepNplusOne = step.next();
		}
		return eccentricity/100.0;
	}
}
