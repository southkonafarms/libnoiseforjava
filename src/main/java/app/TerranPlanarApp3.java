package app;

import components.TerranPlanar3;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class TerranPlanarApp3 {
	
	// width of elevation grid, in points
	protected static Integer width = 2048;
	// height of elevation grid, in points
	protected static Integer height = 1024;

	
	public void basicTerran() {
		TerranPlanar3 terranPlanar = new TerranPlanar3();

		ImageCafe imageCafe = terranPlanar.build(Boolean.FALSE);
		imageCafe.setSize(width, height);
		String uri = "images/" + Math.random()
		+ "TerranPlanarApp03.png";
		Output.writer(imageCafe, uri);

	}


	public static void main(String[] args) {
		TerranPlanarApp3 terranPlanarApp = new TerranPlanarApp3();
		terranPlanarApp.basicTerran();

	}

}
