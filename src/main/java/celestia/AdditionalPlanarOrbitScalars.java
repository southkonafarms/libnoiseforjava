package celestia;

import com.zenred.util.GenRandomRolls;

/**
 * could be fun making these more meaningful later ...
 * 
 * @author jredden
 *
 */

public class AdditionalPlanarOrbitScalars {
	
	private static Double aNumberOutOfTheEther = 0.2;
	private static Double anotherNumberOutOfTheEther = 40.0;
	private static Double yetAnotherNumberOutOfTheEther = 360.0;
	private static Double commonObliquity = 20.0;
	private static Double uncommonObliquity = 80.0;
	private static Double rotationalPeriod = 40.0;
	
	public static Double genEccentricity(){
		Double eccentricity = GenRandomRolls.Instance().draw_rand() * aNumberOutOfTheEther;
		return eccentricity;
	}

	public static Double genInclination(){
		Double inclination = GenRandomRolls.Instance().draw_rand() * anotherNumberOutOfTheEther;
		return inclination;
	}
	
	public static Double genLongOfPericentre(){
		Double longOfPericentre = GenRandomRolls.Instance().draw_rand() * yetAnotherNumberOutOfTheEther;
		return longOfPericentre;
	}
	
	public static Double genMeanLongitude(){
		Double meanLongitude = GenRandomRolls.Instance().draw_rand() * yetAnotherNumberOutOfTheEther;
		return meanLongitude;
	}
	
	public static Double genObliquity(){
		Double firstScalar = GenRandomRolls.Instance().draw_rand() * commonObliquity;
		if(GenRandomRolls.Instance().getD100() > 90){
			firstScalar += GenRandomRolls.Instance().draw_rand() * uncommonObliquity;
		}
		if(GenRandomRolls.Instance().get_D2() > 1) {
			firstScalar *= -1.0;
		}
		return firstScalar;
	}
	
	public static Double genRotationalPeriod(){
		Double d_rotationalPeriod = GenRandomRolls.Instance().draw_rand() * rotationalPeriod;
		return d_rotationalPeriod;
	}
	
	public static Double genAscendngNode(){
		Double d_ascendingNode = GenRandomRolls.Instance().draw_rand() * yetAnotherNumberOutOfTheEther;
		return d_ascendingNode;
	}
}
