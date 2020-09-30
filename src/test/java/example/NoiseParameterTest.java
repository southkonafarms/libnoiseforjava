package example;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import libnoiseforjava.domain.Builder;
import libnoiseforjava.domain.BuilderPlaneParameters;
import libnoiseforjava.domain.GradientPointParameter;
import libnoiseforjava.domain.RenderImageParameter;
import libnoiseforjava.module.Perlin;
import libnoiseforjava.persistence.Output;
import libnoiseforjava.util.ColorCafe;
import libnoiseforjava.util.ImageCafe;
import libnoiseforjava.util.NoiseMap;
import libnoiseforjava.util.NoiseMapBuilderPlane;

import org.junit.Test;

public class NoiseParameterTest {
	
	static Integer noiseMapWidth = new Integer(256);
	static Integer noiseMapHeight = new Integer(256);
	static Integer destinationWidth = new Integer(256);
	static Integer destinationHeight = new Integer(256);
	static Double lowerXBoundTile2 = new Double(2.0);
	static Double upperXBoundTile2 = new Double(6.0);
	static Double lowerZBoundTile2 = new Double(5.0);
	static Double upperZBoundTile2 = new Double(10.0);
	static Double lowerXBoundTile3 = new Double(6.0);
	static Double upperXBoundTile3 = new Double(10.0);
	static Double lowerZBoundTile3 = new Double(5.0);
	static Double upperZBoundTile3 = new Double(10.0);
	
	static List<GradientPointParameter> gradientPointList = new ArrayList<GradientPointParameter>();
	
	static{
		
		GradientPointParameter gradientPointParameter = new GradientPointParameter(-1.0000, new ColorCafe(0, 0, 128, 255));  //deeps
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(-0.2500, new ColorCafe(0, 0, 255, 255));  // shallow
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.0000, new ColorCafe(0, 128, 255, 255));  // shore
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.0625, new ColorCafe(240, 240, 64, 255));  // sand
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.1250, new ColorCafe(32, 160, 0, 255));  // grass
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.3750, new ColorCafe(224, 224, 0, 255));  // dirt
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(0.7500, new ColorCafe(128, 128, 128, 255));  // rock
		gradientPointList.add(gradientPointParameter);
		gradientPointParameter = new GradientPointParameter(1.0000, new ColorCafe(255, 255, 255, 255));  // snow
		gradientPointList.add(gradientPointParameter);
		
	}
	
	static Double lightContrast = new Double(3.0);
	static Double lightBrightness = new Double(2.0);
	


	@Test
	public void testTile2() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		perlin.setOctaveCount(6);
		perlin.setFrequency(1.0);
		perlin.setPersistence(0.5);
		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBoundTile2, upperXBoundTile2, lowerZBoundTile2, upperZBoundTile2);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"noiseParm0_test.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}

	@Test
	public void testTile3() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		perlin.setOctaveCount(6);
		perlin.setFrequency(1.0);
		perlin.setPersistence(0.75);

		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBoundTile3, upperXBoundTile3, lowerZBoundTile3, upperZBoundTile3);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"noiseParm1_test.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}
	
	@Test
	public void testTileFreq0() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		perlin.setOctaveCount(6);
		perlin.setFrequency(4.0);
		perlin.setPersistence(0.75);

		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBoundTile3, upperXBoundTile3, lowerZBoundTile3, upperZBoundTile3);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"noiseFreq0_test.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}
	
	@Test
	public void testTileFreq1() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		perlin.setOctaveCount(6);
		perlin.setFrequency(8.0);
		perlin.setPersistence(0.75);

		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBoundTile3, upperXBoundTile3, lowerZBoundTile3, upperZBoundTile3);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"noiseFreq1_test.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}
}
