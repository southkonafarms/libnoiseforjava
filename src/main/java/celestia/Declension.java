package celestia;

import java.util.HashMap;
import java.util.Map;

/**
 * converts and angle to a declension 0 to 90 or 0 to -90
 * 
 * @author jredden
 *
 */

public enum Declension {
	FIRST_QUADRANT, SECOND_QUADRANT, THIRD_QUADRANT, FOURTH_QUADRANT;
	
	private static Declension declension;
	
	interface Worker{
		public Double genDeclension(Double angle);
	}
	
	private static Map<Declension, Worker> workMap = new HashMap<Declension, Worker>(); 
	static{
		workMap.put(FIRST_QUADRANT, new Worker(){

			@Override
			public Double genDeclension(Double angle) {
				return 90.0 - angle;
			}
			
		});
		workMap.put(SECOND_QUADRANT, new Worker(){

			@Override
			public Double genDeclension(Double angle) {
				return 90.0 - angle;
			}
			
		});
		workMap.put(THIRD_QUADRANT, new Worker(){

			@Override
			public Double genDeclension(Double angle) {
				return -(270.0 - angle);
			}
			
		});
		workMap.put(FOURTH_QUADRANT, new Worker(){

			@Override
			public Double genDeclension(Double angle) {
				return 90.0 - (360.0 - angle);
			}
			
		});
	}
	
	public static Double determineQuadrant(Double angle){
		if(angle >= 0.0 && angle <= 90.0){
			declension = FIRST_QUADRANT;
		}
		else if(angle >= 90.0 && angle <= 180.0){
			declension = SECOND_QUADRANT;
		}
		else if(angle >= 180.0 && angle <= 270.0){
			declension = THIRD_QUADRANT;
		}
		else if(angle >= 270.0 && angle <= 360.0){
			declension = FOURTH_QUADRANT;
		}
		else{
			RuntimeException runtimeException = new RuntimeException("Illegal Angle:"+angle);
			throw runtimeException;
		}
		return getDeclension(angle);
	}
	
	private static Double getDeclension(Double angle){
		return workMap.get(declension).genDeclension(angle);
	}
	
	public static Declension getQuadrant(){
		return declension;
	}
}
