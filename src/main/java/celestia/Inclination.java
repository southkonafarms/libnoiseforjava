package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.zenred.util.GenRandomRolls;

/**
 * generates an inclination.  0 to 180 degrees, 90 is a polar orbit
 * 
 * @author jredden
 *
 */
public class Inclination {
		
	interface Operation{
		Double gen();
	}
	
	private static SortedMap<Integer,Operation> steps = new TreeMap<Integer, Operation>();
	static{
		steps.put(new Integer(0), new Operation(){
			@Override
			public Double gen() {
				return 0.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(10), new Operation(){
			@Override
			public Double gen() {
				return 10.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(20), new Operation(){
			@Override
			public Double gen() {
				return 20.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(30), new Operation(){
			@Override
			public Double gen() {
				return 30.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(40), new Operation(){
			@Override
			public Double gen() {
				return 40.0+(GenRandomRolls.Instance().draw_rand()*30.0);
			}
		});
		steps.put(new Integer(45), new Operation(){
			@Override
			public Double gen() {
				return 70.0+(GenRandomRolls.Instance().draw_rand()*30.0);
			}
		});
		steps.put(new Integer(50), new Operation(){
			@Override
			public Double gen() {
				return 100.0+(GenRandomRolls.Instance().draw_rand()*30.0);
			}
		});
		steps.put(new Integer(55), new Operation(){
			@Override
			public Double gen() {
				return 130.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(60), new Operation(){
			@Override
			public Double gen() {
				return 140.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(70), new Operation(){
			@Override
			public Double gen() {
				return 150.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(80), new Operation(){
			@Override
			public Double gen() {
				return 160.0+(GenRandomRolls.Instance().draw_rand()*10.0);
			}
		});
		steps.put(new Integer(90), new Operation(){
			@Override
			public Double gen() {
				return 170.0+(GenRandomRolls.Instance().draw_rand()*20.0);
			}
		});
		steps.put(new Integer(100), new Operation(){
			@Override
			public Double gen() {
				return 180.0;
			}
		});
	}
	/**
	 * generates inclination between 0 and 180 degrees.  Tends towards 180 or 0, 
	 * not so much as a "polar" oribit
	 * 
	 * @return inclination
	 */
	public static Double build(){
		Double inclination = 0.0;
		Integer draw = GenRandomRolls.Instance().getD100();
		Set<Integer> stepsKeys = steps.keySet();
		Iterator<Integer> step = stepsKeys.iterator();
		Integer stepN = step.next();
		Integer stepNplusOne = step.next();
		while(step.hasNext()){
			if(draw >= stepN && draw <= stepNplusOne){
				inclination = steps.get(stepN).gen();
			}
			stepN = stepNplusOne;
			stepNplusOne = step.next();
		}
		return inclination;
	}
}
