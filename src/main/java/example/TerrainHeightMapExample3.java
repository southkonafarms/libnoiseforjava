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

import javax.imageio.ImageIO;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.domain.PerlinBuilder;
import libnoiseforjava.exception.*;
import libnoiseforjava.module.*;
import libnoiseforjava.util.*;

public class TerrainHeightMapExample3 {
	// generates an example Terrain Height Map, as shown at
	// http://libnoise.sourceforge.net/tutorials/tutorial3.html
	
	static Double frequency = 1.5;
	//  static Double persistence = 0.2;
	static Double persistence = 0.99;
	static Double lacunarity = 0.1;
	static Integer octive_count = 3;

	public static void main(String[] args) throws ExceptionInvalidParam {
		// create Perlin noise module object
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		Perlin perlin = new PerlinBuilder().biuld(currSeed, frequency,
				persistence, lacunarity, octive_count, NoiseQuality.QUALITY_STD);

		// create Noisemap object
		NoiseMap heightMap = new NoiseMap(2048, 1024);

		// create Builder object
		NoiseMapBuilderPlane heightMapBuilder = new NoiseMapBuilderPlane();
		heightMapBuilder.setSourceModule(perlin);
		heightMapBuilder.setDestNoiseMap(heightMap);
		heightMapBuilder.setDestSize(2048, 1024);
		heightMapBuilder.setBounds(0.0, 511.0, 0.0, 511.0);
		heightMapBuilder.build();

		// create renderer object
		RendererImage renderer = new RendererImage();

		// terrain gradient
		renderer.clearGradient();
		renderer.addGradientPoint(-1.0000, new ColorCafe(0, 0, 128, 255)); // deeps
		renderer.addGradientPoint(-0.2500, new ColorCafe(0, 0, 255, 255)); // shallow
		renderer.addGradientPoint(0.0000, new ColorCafe(0, 128, 255, 255)); // shore
		renderer.addGradientPoint(0.0625, new ColorCafe(240, 240, 64, 255)); // sand
		renderer.addGradientPoint(0.1250, new ColorCafe(32, 160, 0, 255)); // grass
		renderer.addGradientPoint(0.3750, new ColorCafe(224, 224, 0, 255)); // dirt
		renderer.addGradientPoint(0.7500, new ColorCafe(128, 128, 128, 255)); // rock
		renderer.addGradientPoint(1.0000, new ColorCafe(255, 255, 255, 255)); // snow

		// Set up the texture renderer and pass the noise map to it.
		ImageCafe destTexture = new ImageCafe(heightMap.getWidth(),
				heightMap.getHeight());
		renderer.setSourceNoiseMap(heightMap);
		renderer.setDestImage(destTexture);
		renderer.enableLight(true);
		renderer.setLightContrast(3.0); // Triple the contrast
		renderer.setLightBrightness(2.0); // Double the brightness

		// Render the texture.
		renderer.render();

		BufferedImage im = buffBuilder(destTexture.getWidth(),
				destTexture.getHeight(), destTexture);
		try {
			ImageIO.write(im, "png", new File("images/terrain_test3.png"));
		} catch (IOException e1) {
			System.out.println("Could not write the image file.");
		}

	}// end of main

	static BufferedImage buffBuilder(int height, int width, ImageCafe imageCafe) {

		BufferedImage im = new BufferedImage(height, width,
				BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
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
