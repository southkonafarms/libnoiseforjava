package celestia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zenred.util.GenRandomRolls;

/**
 * defines the stars period in the cluster around the barycentre in terran years
 * 
 * @author jredden
 *
 */

public class Period {
	/**
	 * instead of a continuous curve, use an integral of step increments
	 */
	private static List<Double> steps = new ArrayList<Double>();
	static{
		steps.add(0.0);
		steps.add(5000000.0);
		steps.add(7500000.0);
		steps.add(10000000.0);
		steps.add(50000000.0);
		steps.add(75000000.0);
		steps.add(100000000.0);
		steps.add(500000000.0);
		steps.add(1000000000.0);
		steps.add(5000000000.0);
		steps.add(10000000000.0);
		steps.add(Double.MAX_VALUE);
	}
	private static List<Double> periodSteps = new ArrayList<Double>();
	static{
		periodSteps.add(1000.0);
		periodSteps.add(2000.0);
		periodSteps.add(3000.0);
		periodSteps.add(5000.0);
		periodSteps.add(8000.0);
		periodSteps.add(13000.0);
		periodSteps.add(21000.0);
		periodSteps.add(34000.0);
		periodSteps.add(55000.0);
		periodSteps.add(89000.0);
		periodSteps.add(134000.0);
		periodSteps.add(Double.MAX_VALUE);
	}

	/**
	 * 
	 * @param smallStep
	 * @param largeStep
	 * @return period
	 */
	private static Double genPeriod(Double smallStep, Double largeStep){
		Double draw = GenRandomRolls.Instance().draw_rand();
		Double period = smallStep  + (draw*(largeStep-smallStep));
		return period;
	}
	
	/**
	 * 
	 * @param distanceToCentre
	 * @return stars period in years
	 */
	public static Double build(Double distanceToCentre){
		
		
		Double nStep = 0.0;
		Double nStepPlusOne = 0.0;
		Double period = 0.0;
		int idex = 0;
		Double stepN = steps.get(idex);
		while (idex < steps.size()){
			Double stepNplus1 = steps.get(idex+1);
			if(distanceToCentre >= stepN &&  distanceToCentre <= stepNplus1){
				period = genPeriod(periodSteps.get(idex), periodSteps.get(idex+1)) ;
				break;
			}
			stepN = stepNplus1;
			++idex;
		}

		if(0.0 == period){
			throw new RuntimeException("period cannot be generated:" + distanceToCentre);
		}
		return period;
	}
}
