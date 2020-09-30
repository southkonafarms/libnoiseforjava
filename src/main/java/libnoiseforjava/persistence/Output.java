package libnoiseforjava.persistence;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import libnoiseforjava.util.ColorCafe;
import libnoiseforjava.util.ImageCafe;

public class Output {

	/**
	 * 
	 * @param height
	 * @param width
	 * @param imageCafe
	 * @return buffered Image
	 */
	static BufferedImage buffBuilder(Integer height, Integer width,
			ImageCafe imageCafe) {

		BufferedImage bufferedImage = new BufferedImage(height, width,
				BufferedImage.TYPE_INT_ARGB);

		for (int idex = 0; idex < height; idex++) {
			for (int idex2 = 0; idex2 < width; idex2++) {
				int rgbNumber = getRGBA(imageCafe.getValue(idex, idex2));
				bufferedImage.setRGB(idex, idex2, rgbNumber);
			}
		}
		return bufferedImage;
	}

	/**
	 * 
	 * @param colorCafe
	 * @return rgb color
	 */
	public static final Integer getRGBA(ColorCafe colorCafe) {
		Integer red, blue, green, alpha;
		red = colorCafe.getRed();
		blue = colorCafe.getBlue();
		green = colorCafe.getGreen();
		alpha = colorCafe.getAlpha();
		Color color = new Color(red, green, blue, alpha);
		Integer rgbNumber = color.getRGB();
		return rgbNumber;
	}

	/**
	 * 
	 * @param imageCafe
	 * @param uri
	 */
	public static void writer(ImageCafe imageCafe, String uri) {
		BufferedImage bufferedImage = buffBuilder(imageCafe.getWidth(),
				imageCafe.getHeight(), imageCafe);
		try {
			ImageIO.write(bufferedImage, "png", new File(uri));
		} catch (IOException eio) {
			System.out.println("Could not write the image file:" + uri);
		}

	}
}
