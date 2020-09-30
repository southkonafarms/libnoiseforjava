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

public class TerrainMapTest2 {

	static Integer noiseMapWidth = new Integer(2048);
	static Integer noiseMapHeight = new Integer(1024);
	static Integer destinationWidth = new Integer(2048);
	static Integer destinationHeight = new Integer(1024);
	static Double lowerXBound = new Double(2.0);
	static Double upperXBound = new Double(6.0);
	static Double lowerZBound = new Double(1.0);
	static Double upperZBound = new Double(5.0);
	static Double lowerXBoundTile = new Double(6.0);
	static Double upperXBoundTile = new Double(10.0);
	static Double lowerZBoundTile = new Double(1.0);
	static Double upperZBoundTile = new Double(5.0);
	
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
	
	
	/*
	 * 
	 */

	@Test
	public void test() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBound, upperXBound, lowerZBound, upperZBound);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"_terrain_test2.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}

	@Test
	public void testTile() {
		NoiseMap noiseMap = Builder.createNoiseMap(noiseMapWidth,
				noiseMapHeight);
		Perlin perlin = new Perlin();
		BuilderPlaneParameters builderPlaneParameters = new BuilderPlaneParameters(
				perlin, noiseMap, destinationWidth, destinationHeight,
				lowerXBoundTile, upperXBoundTile, lowerZBoundTile, upperZBoundTile);
		@SuppressWarnings("unused")
		NoiseMapBuilderPlane noiseMapBuilderPlane = Builder
				.builderPlane(builderPlaneParameters);
		RenderImageParameter renderImageParameter = new RenderImageParameter(
				gradientPointList, noiseMap, Boolean.TRUE, lightContrast,
				lightBrightness);
		ImageCafe imageCafe = Builder.buildRendererImage(renderImageParameter);
		String uri = "images/"+Math.random()+"_terrain_test3.png";
		Output.writer(imageCafe, uri);
		assertTrue(imageCafe != null);
	}

}
