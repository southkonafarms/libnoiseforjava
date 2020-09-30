package app;

import components.OddTerranPlanar;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class OddTerranPlanarApp {
	
	public void basicOddTerran() {
		OddTerranPlanar oddTerranPlanar = new OddTerranPlanar();

		ImageCafe imageCafe = oddTerranPlanar.build(Boolean.FALSE);
		String uri = "images/" + Math.random()
		+ "OddTerranPlanarApp0.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		OddTerranPlanarApp terranPlanarApp = new OddTerranPlanarApp();
		terranPlanarApp.basicOddTerran();

	}

}
