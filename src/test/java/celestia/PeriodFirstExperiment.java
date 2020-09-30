package celestia;

public class PeriodFirstExperiment {
	
	/**
	 * tests the implementation of orbital period (see https://en.wikipedia.org/wiki/Orbital_period) 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Double number = 2.0 * Math.PI *(Math.sqrt((624736.09*624736.09*624736.09)/(6.67408e-11*1.9885e30)));
		System.out.println("The number:"+number/1000.0);
		number = 2.0 * Math.PI *(Math.sqrt((1624736.09*1624736.09*1624736.09)/(6.67408e-11*1.9885e30)));
		System.out.println("The number:"+number/1000.0);
		number = 2.0 * Math.PI *(Math.sqrt((10624736.09*10624736.09*10624736.09)/(6.67408e-11*1.9885e30)));
		System.out.println("The number:"+number/1000.0);
		number = 2.0 * Math.PI *(Math.sqrt((50624736.09*50624736.09*50624736.09)/(6.67408e-11*1.9885e30)));
		System.out.println("The number:"+number/1000.0);
		number = 2.0 * Math.PI *(Math.sqrt((1050624736.09*1050624736.09*1050624736.09)/(6.67408e-11*1.9885e30)));
		System.out.println("The number:"+number/1000.0);

	}

}
