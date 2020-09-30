package celestia.domain;

public class UV_2DVector {
	
	private Double u_dimension;
	private Double v_dimension;
	
	public UV_2DVector(Double u_dimension, Double v_dimension) {
		super();
		this.u_dimension = u_dimension;
		this.v_dimension = v_dimension;
	}

	public Double getU_dimension() {
		return u_dimension;
	}

	public Double getV_dimension() {
		return v_dimension;
	}

	private static Double checkForNegativeDegree(Double degree){
		if(degree < 0.0){
			degree += 360.0;
		}
		return degree;
	}

	public Double angleInDegrees(){
		Double angleRadians = Math.atan2(this.v_dimension, this.u_dimension);  // start with polar coordinates
		Double angleDegrees = checkForNegativeDegree(Math.toDegrees(angleRadians));
		return angleDegrees;
	}
	
	@Override
	public String toString() {
		return "UV_2DVector [u_dimension=" + u_dimension + ", v_dimension=" + v_dimension + "]";
	}
	
	
	
}
