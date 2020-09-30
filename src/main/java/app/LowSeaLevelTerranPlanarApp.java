package app;

import components.LowSeaLevelTerranPlanar;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class LowSeaLevelTerranPlanarApp {
	
	public void basicTerran() {
		LowSeaLevelTerranPlanar terranPlanar = new LowSeaLevelTerranPlanar();

		ImageCafe imageCafe = terranPlanar.build(Boolean.FALSE);
		String uri = "images/" + Math.random()
		+ "LowSeaLevelTerranPlanarApp00.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		LowSeaLevelTerranPlanarApp terranPlanarApp = new LowSeaLevelTerranPlanarApp();
		terranPlanarApp.basicTerran();

	}

}
