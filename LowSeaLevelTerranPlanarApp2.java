package app;

import components.LowSeaLevelTerranPlanar2;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class LowSeaLevelTerranPlanarApp2 {
	
	public void basicTerran() {
		LowSeaLevelTerranPlanar2 terranPlanar = new LowSeaLevelTerranPlanar2();

		ImageCafe imageCafe = terranPlanar.build(Boolean.FALSE);
		String uri = "images/" + Math.random()
		+ "LowSeaLevelTerranPlanarApp00.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		LowSeaLevelTerranPlanarApp2 terranPlanarApp = new LowSeaLevelTerranPlanarApp2();
		terranPlanarApp.basicTerran();

	}

}
