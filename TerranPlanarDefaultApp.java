package app;

import components.TerranPlanarDefault;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class TerranPlanarDefaultApp {
	
	public void basicTerran() {
		TerranPlanarDefault terranPlanar = new TerranPlanarDefault();

		ImageCafe imageCafe = terranPlanar.build(Boolean.FALSE);
		String uri = "images/" + Math.random()
		+ "TerranPlanarDefaultApp.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		TerranPlanarDefaultApp terranPlanarApp = new TerranPlanarDefaultApp();
		terranPlanarApp.basicTerran();

	}

}
