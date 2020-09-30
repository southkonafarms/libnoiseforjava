package app;

import components.TerranPlanar2;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class TerranPlanarApp2 {
	
	public void basicTerran() {
		TerranPlanar2 terranPlanar = new TerranPlanar2();

		ImageCafe imageCafe = terranPlanar.build(Boolean.FALSE);
		String uri = "images/" + Math.random()
		+ "TerranPlanarApp02.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		TerranPlanarApp2 terranPlanarApp = new TerranPlanarApp2();
		terranPlanarApp.basicTerran();

	}

}
