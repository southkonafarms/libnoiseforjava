package example;

/*
 * Copyright (C) 2004 Jason Bevins (original code)
 * Copyright © 2010 Thomas J. Hodge (java port of original code)
 * 
 * This program uses the libnoiseforjava to generate a texture map.
 * 
 * libnoiseforjava is a Java port of the C++ library libnoise, which may be found at 
 * http://libnoise.sourceforge.net/.  libnoise was developed by Jason Bevins, who may be 
 * contacted at jlbezigvins@gmzigail.com (for great email, take off every 'zig').
 * Porting to Java was done by Thomas Hodge, who may be contacted at
 * libnoisezagforjava@gzagmail.com (remove every 'zag').
 * 
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * This program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import libnoiseforjava.domain.ControlPoint;
import libnoiseforjava.domain.CurveBuilder;
import libnoiseforjava.exception.*;

import libnoiseforjava.module.*;
import libnoiseforjava.util.*;

import com.zenred.util.GenRandomRolls;


public class WeirdExample_4 {
	// generates an example Granite texture, as shown at
	// http://libnoise.sourceforge.net/examples/textures/index.html
	
	private static Logger logger = Logger.getLogger(WeirdExample_4.class);

	static final int TEXTURE_HEIGHT = 1024;
	static final int TEXTURE_WIDTH = 2048;
	
	static List<ControlPoint> controlPoints = new ArrayList<ControlPoint>();
	
	static {
		ControlPoint controlPoint = new ControlPoint();
		controlPoint.inputValue = -2.0000;
		controlPoint.outputValue = -1.625;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = -1.0000;
		controlPoint.outputValue = -1.375;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.0000;
		controlPoint.outputValue = -0.375;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.0625;
		controlPoint.outputValue = 0.125;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.1250;
		controlPoint.outputValue = 0.250;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.2500;
		controlPoint.outputValue = 1.000;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.5000;
		controlPoint.outputValue = 0.2500;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 0.7500;
		controlPoint.outputValue = 0.2500;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 1.0000;
		controlPoint.outputValue = 0.500;
		controlPoints.add(controlPoint);
		controlPoint = new ControlPoint();
		controlPoint.inputValue = 2.0000;
		controlPoint.outputValue = 0.500;
		controlPoints.add(controlPoint);

	}


	public static void main(String[] args) throws ExceptionInvalidParam {

		
		int primaryGraniteSeed = GenRandomRolls.Instance().get_D10();
		int baseGrainsSeed = GenRandomRolls.Instance().getD1000();
		int finalGraniteSeed = GenRandomRolls.Instance().getD3();
		int finalGraniteFrequency = GenRandomRolls.Instance().getD100000();
		int finalGranitePower = GenRandomRolls.Instance().get_D8();
		int finalGraniteRoughness = GenRandomRolls.Instance().get_D6();
		double displacement = GenRandomRolls.Instance().getD100000();
		
		final Double medianValue = 0.0;
		
		Spheres spheres = new Spheres();
		spheres.setFrequency(primaryGraniteSeed);
		
		Curve curve = new CurveBuilder().builder(spheres, medianValue, controlPoints );

		// Use Voronoi polygons to produce the small grains for the granite
		// texture.
		
/*
		Voronoi baseGrains = new Voronoi();
		baseGrains.setSeed(baseGrainsSeed);
		baseGrains.setFrequency(finalGraniteFrequency);
		baseGrains.enableDistance(true);
		baseGrains.setDisplacement(displacement);
*/
		// Scale the small grain values so that they may be added to the base
		// granite texture. Voronoi polygons normally generate pits, so apply a
		// negative scaling factor to produce bumps instead.
		
		/*
		ScaleBias scaledGrains = new ScaleBias(baseGrains);
		scaledGrains.setScale(20.0);
		scaledGrains.setBias(1.0);
		*/

		// Combine the primary granite texture with the small grain texture.
		Add combinedGranite = new Add(curve, spheres);
		// Finally, perturb the granite texture to add realism.
		Turbulence finalGranite = new Turbulence(combinedGranite);
		finalGranite.setSeed(finalGraniteSeed);
		finalGranite.setFrequency(finalGraniteFrequency);
		finalGranite.setPower(1.0 / finalGranitePower );
		finalGranite.setRoughness(finalGraniteRoughness);

		// Given the granite noise module, create a non-seamless texture map
		// create Noisemap object
		NoiseMap textureMap = new NoiseMap(TEXTURE_WIDTH, TEXTURE_HEIGHT);
		textureMap = CreatePlanarTexture(finalGranite, false, TEXTURE_WIDTH, TEXTURE_HEIGHT);
		textureMap.setSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);

		// create renderer object
		RendererImage renderer = new RendererImage();

		// shades of gray
		renderer.clearGradient();
		renderer.addGradientPoint(-1.0000, new ColorCafe(192, 192, 192, 255));
		renderer.addGradientPoint(-0.9375, new ColorCafe(180, 180, 180, 255));
		renderer.addGradientPoint(-0.8750, new ColorCafe(175, 175, 175, 255));
		renderer.addGradientPoint(0.0000, new ColorCafe(160, 160, 160, 255));
		renderer.addGradientPoint(0.5000, new ColorCafe(150, 150, 150, 255));
		renderer.addGradientPoint(0.7500, new ColorCafe(135, 135, 135, 255));
		renderer.addGradientPoint(1.0000, new ColorCafe(128, 128, 128, 255));
		renderer.addGradientPoint(0.7200, new ColorCafe(135, 135, 135, 255));
		renderer.addGradientPoint(0.4900, new ColorCafe(150, 150, 150, 255));
		renderer.addGradientPoint(0.0020, new ColorCafe(160, 160, 160, 255));
		renderer.addGradientPoint(-0.8650, new ColorCafe(175, 175, 175, 255));
		renderer.addGradientPoint(-0.9075, new ColorCafe(180, 180, 180, 255));
		renderer.addGradientPoint(-1.0001, new ColorCafe(192, 192, 192, 255));
		renderer.buildTerrainGradient();


		// Set up the texture renderer and pass the noise map to it.
		ImageCafe destTexture = new ImageCafe(textureMap.getWidth(),
				textureMap.getHeight());
		renderer.setSourceNoiseMap(textureMap);
		renderer.setDestImage(destTexture);
		renderer.enableLight(true);
		renderer.setLightAzimuth(135.0);
		renderer.setLightElev(60.0);
		renderer.setLightContrast(2.0);
		renderer.setLightColor(new ColorCafe(255, 255, 255, 0));

		// Render the texture.
		renderer.render();

		BufferedImage im = buffBuilder(destTexture.getHeight(),
				destTexture.getWidth(), destTexture);

		try {
			ImageIO.write(im, "png", new File("images/"+ Math.random() +"_weirdExample_4.png"));
		} catch (IOException e1) {
			System.out.println("Could not write the image file.");
		}
		
		logger.info("primaryGraniteSeed:"+primaryGraniteSeed);
		logger.info("baseGrainsSeed:"+baseGrainsSeed);
		logger.info("finalGraniteSeed:"+finalGraniteSeed);
		logger.info("finalGraniteFrequency:"+finalGraniteFrequency);
		logger.info("finalGranitePower:"+finalGranitePower);
		logger.info("finalGraniteRoughness:"+finalGraniteRoughness);
		logger.info("displacement:" +displacement);
	}// end of main

	static NoiseMap CreatePlanarTexture(ModuleBase noiseModule,
			boolean seamless, int width, int height) throws ExceptionInvalidParam {
		// Map the output values from the noise module onto a plane. This will
		// create a two-dimensional noise map which can be rendered as a flat
		// texture map.
		NoiseMapBuilderPlane plane = new NoiseMapBuilderPlane(width, height);
		NoiseMap noiseMap = new NoiseMap(width, height);
		plane.setBounds(-1.0, 7.0, 1.0, 1.1);
		plane.setDestSize(width, height);
		plane.setSourceModule(noiseModule);
		plane.setDestNoiseMap(noiseMap);
		// plane.enableSeamless(seamless);
		plane.build();

		return noiseMap;
	}

	static BufferedImage buffBuilder(int height, int width, ImageCafe imageCafe) {

		BufferedImage im = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int c = getRGBA(imageCafe.getValue(i, j));
				im.setRGB(i, j, c);
			}
		}
		return im;
	}

	public static final int getRGBA(ColorCafe colorCafe) {
		int red, blue, green, alpha;
		red = colorCafe.getRed();
		blue = colorCafe.getBlue();
		green = colorCafe.getGreen();
		alpha = colorCafe.getAlpha();
		Color color = new Color(red, green, blue, alpha);
		int rgbnumber = color.getRGB();
		return rgbnumber;
	}

}
