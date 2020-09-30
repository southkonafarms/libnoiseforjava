package celestia;

import celestia.domain.UV_2DVector;

/**
 * simulates a right ascension angle using the center of the space domain
 * 
 * @author jredden
 *
 */
public class RightAscension {

	public static final Double virtualEarth_U_Dimension = new Double(5000); // u
	public static final Double virtualEarth_V_Dimension = new Double(5000); // v

	/**
	 * 
	 * @param u_dimension
	 * @param v_dimension
	 * @return  simulated right ascension in degrees
	 */
	public static Double buildRightAcension(Double u_dimension, Double v_dimension) {
		UV_2DVector uv_2dVector = new UV_2DVector(u_dimension - virtualEarth_U_Dimension,
				v_dimension - virtualEarth_V_Dimension);
		return uv_2dVector.angleInDegrees();
	}

}
