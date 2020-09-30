package example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.TerranPlanar;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ImageCafe;

public class TerranPlanetTest {

	@Test
	public void basicTerranTest() {
		TerranPlanar terranPlanar = new TerranPlanar();
		ImageCafe  imageCafe = terranPlanar.build(Boolean.TRUE);
		String uri = "images/" + Math.random()
		+ "TerranPlanarTest0.png";
		Output.writer(imageCafe, uri);

		imageCafe = terranPlanar.build(Boolean.FALSE);
		uri = "images/" + Math.random()
		+ "TerranPlanarTest00.png";
		Output.writer(imageCafe, uri);

	}

}
