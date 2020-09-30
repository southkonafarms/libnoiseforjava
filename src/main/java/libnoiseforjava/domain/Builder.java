package libnoiseforjava.domain;

import org.apache.log4j.Logger;

import libnoiseforjava.exception.ExceptionInvalidParam;
import libnoiseforjava.util.ImageCafe;
import libnoiseforjava.util.NoiseMap;
import libnoiseforjava.util.NoiseMapBuilderPlane;
import libnoiseforjava.util.RendererImage;


public class Builder {
	
	private static Logger logger = Logger.getLogger(Builder.class);

	/**
	 * 
	 * @param width
	 * @param height
	 * @return NoiseMap
	 * @throws ExceptionInvalidParam
	 */
	public static NoiseMap createNoiseMap(Integer width, Integer height) throws ExceptionInvalidParam{
		logger.info("Builder CTOR width:" + width + " height:" + height);
		return new NoiseMap(width, height);
	}
	
	/**
	 * 
	 * @param builderPlaneParameters
	 * @return NoiseMapBuilderPlane
	 * @throws ExceptionInvalidParam
	 */
	public static NoiseMapBuilderPlane builderPlane(
			BuilderPlaneParameters builderPlaneParameters)
			throws ExceptionInvalidParam {
		logger.info("NoiseMapBuilderPlane height:" + builderPlaneParameters.getDestHeight() + " width:" + builderPlaneParameters.getDestWidth());
		// create Builder object
		NoiseMapBuilderPlane noiseMapBuilderPlane = new NoiseMapBuilderPlane(builderPlaneParameters.getDestWidth(), builderPlaneParameters.getDestHeight());
		noiseMapBuilderPlane
				.setSourceModule(builderPlaneParameters.getPerlin());
		noiseMapBuilderPlane.setDestNoiseMap(builderPlaneParameters
				.getNoiseMap());
		noiseMapBuilderPlane.setDestSize(
				builderPlaneParameters.getDestWidth(),
				builderPlaneParameters.getDestHeight());
		noiseMapBuilderPlane.setBounds(builderPlaneParameters.getLowerXBound(),
				builderPlaneParameters.getUpperXBound(),
				builderPlaneParameters.getLowerZBound(),
				builderPlaneParameters.getUpperZBound());
		noiseMapBuilderPlane.build();
		return noiseMapBuilderPlane;
	}
	
	/**
	 * 
	 * @param renderImageParameter
	 * @return RenderImage
	 * @throws ExceptionInvalidParam
	 */
	public static ImageCafe buildRendererImage(
			RenderImageParameter renderImageParameter)
			throws ExceptionInvalidParam {
		RendererImage renderer = new RendererImage();
		renderer.clearGradient();
		for (GradientPointParameter gradientPointParameter : renderImageParameter
				.getGradientPointList()) {
			renderer.addGradientPoint(
					gradientPointParameter.getGradientPosition(),
					gradientPointParameter.getColorCafe());
		}
		ImageCafe imageCafe = new ImageCafe(renderImageParameter.getNoiseMap()
				.getWidth(), renderImageParameter.getNoiseMap().getHeight());
		logger.info("image height and width:" + renderImageParameter.getNoiseMap().getHeight() + "::"
				+ renderImageParameter.getNoiseMap().getWidth());
		renderer.setSourceNoiseMap(renderImageParameter.getNoiseMap());

		renderer.setDestImage(imageCafe);
		renderer.enableLight(renderImageParameter.getLightEnable());
		renderer.setLightContrast(renderImageParameter.getLightContrast());
		renderer.setLightBrightness(renderImageParameter.getLightBrightness());
		renderer.render();

		return imageCafe;
	}
	
	/**
	 * 
	 * @param renderImageParameter
	 * @return RenderImage
	 * @throws ExceptionInvalidParam
	 */
	public static ImageCafe buildRendererImage(
			RenderImageSphereParameter renderImageParameter)
			throws ExceptionInvalidParam {
		RendererImage renderer = new RendererImage();
		renderer.clearGradient();
		for (GradientPointParameter gradientPointParameter : renderImageParameter
				.getGradientPointList()) {
			renderer.addGradientPoint(
					gradientPointParameter.getGradientPosition(),
					gradientPointParameter.getColorCafe());
		}
		ImageCafe imageCafe = new ImageCafe(renderImageParameter.getNoiseMap()
				.getWidth(), renderImageParameter.getNoiseMap().getHeight());
		renderer.setSourceNoiseMap(renderImageParameter.getNoiseMap());

		renderer.setDestImage(imageCafe);
		renderer.enableLight(renderImageParameter.getLightEnable());
		renderer.setLightContrast(renderImageParameter.getLightContrast());
		renderer.setLightBrightness(renderImageParameter.getLightBrightness());
		renderer.render();

		return imageCafe;
	}

}
