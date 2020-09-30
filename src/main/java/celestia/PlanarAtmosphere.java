package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

import celestia.domain.CelestAtmosphere;
import celestia.domain.ColorRGB;

public class PlanarAtmosphere {
	
	interface AtmosphereHeight {
		Double genAtmosphereHeight();
	}
	
	interface CloudHeight{
		Double genCloudHeight();
	}
	
	interface CloudSpeed{
		Double genCloudSpeed();
	}
	
	// changes the colors of the atmosphere as a iteration
	public static Double skyScalar = 1.0;
	public static Double highScalar = 2.0;
	public static Double lowScalar = 5.0;

	private static SortedMap<Double, AtmosphereHeight> heightMap = new TreeMap<Double, AtmosphereHeight>();
	static{
		heightMap.put(0.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 0.0;
			}
		});
		heightMap.put(2000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 0.0 + GenRandomRolls.Instance().draw_rand()*15.0;
			}
		});
		heightMap.put(4000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 5.0 + GenRandomRolls.Instance().draw_rand()*25.0;
			}
		});
		heightMap.put(6000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 10.0 + GenRandomRolls.Instance().draw_rand()*40.0;
			}
		});
		heightMap.put(8000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 30.0 + GenRandomRolls.Instance().draw_rand()*50.0;
			}
		});
		heightMap.put(11000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 40.0 + GenRandomRolls.Instance().draw_rand()*50.0;
			}
		});
		heightMap.put(14000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 50.0 + GenRandomRolls.Instance().draw_rand()*50.0;
			}
		});
		heightMap.put(20000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 60.0 + GenRandomRolls.Instance().draw_rand()*60.0;
			}
		});
		heightMap.put(50000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 80.0 + GenRandomRolls.Instance().draw_rand()*70.0;
			}
		});
		heightMap.put(80000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 100.0 + GenRandomRolls.Instance().draw_rand()*100.0;
			}
		});
		heightMap.put(160000.0, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 150.0 + GenRandomRolls.Instance().draw_rand()*150.0;
			}
		});
		heightMap.put(Double.MAX_VALUE, new AtmosphereHeight() {
			@Override
			public Double genAtmosphereHeight() {
				return 200.0 + GenRandomRolls.Instance().draw_rand()*200.0;
			}
		});
	}
	
	private static SortedMap<Double,CloudHeight> cloudHeightMap = new TreeMap<Double,CloudHeight>();
	static{
		cloudHeightMap.put(0.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 0.0;
			}
		});
		cloudHeightMap.put(1000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 1.0 + GenRandomRolls.Instance().draw_rand()*3.0;
			}
		});
		cloudHeightMap.put(2000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 1.0 + GenRandomRolls.Instance().draw_rand()*4.0;
			}
		});
		cloudHeightMap.put(4000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 5.0 + GenRandomRolls.Instance().draw_rand()*5.0;
			}
		});
		cloudHeightMap.put(6000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 3.0 + GenRandomRolls.Instance().draw_rand()*35.0;
			}
		});
		cloudHeightMap.put(8000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 5.0 + GenRandomRolls.Instance().draw_rand()*40.0;
			}
		});
		cloudHeightMap.put(11000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 5.0 + GenRandomRolls.Instance().draw_rand()*45.0;
			}
		});
		cloudHeightMap.put(14000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 10.0 + GenRandomRolls.Instance().draw_rand()*65.0;
			}
		});
		cloudHeightMap.put(20000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 10.0 + GenRandomRolls.Instance().draw_rand()*100.0;
			}
		});
		cloudHeightMap.put(50000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 20.0 + GenRandomRolls.Instance().draw_rand()*160.0;
			}
		});
		cloudHeightMap.put(80000.0, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 30.0 + GenRandomRolls.Instance().draw_rand()*350.0;
			}
		});
		cloudHeightMap.put(Double.MAX_VALUE, new CloudHeight(){
			@Override
			public Double genCloudHeight() {
				return 50.0 + GenRandomRolls.Instance().draw_rand()*1000.0;
			}
		});
	}
	
	private static SortedMap<Double,CloudSpeed> cloudSpeedMap = new TreeMap<Double,CloudSpeed>();
	static{
		cloudSpeedMap.put(0.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 0.0;
			}
		});
		cloudSpeedMap.put(4000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 4000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(8000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 8000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(12000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 12000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(16000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 16000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(22000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 22000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(40000.0, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return 40000.0/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
		cloudSpeedMap.put(Double.MAX_VALUE, new CloudSpeed() {
			@Override
			public Double genCloudSpeed() {
				return Double.MAX_VALUE/3000.0 * GenRandomRolls.Instance().draw_rand()*10.0;
			}
		});
	}
	
	private static ColorRGB genColorAtmosphere(Star star, UnifiedPlanetoidI unifiedPlanetoidI, Double scalar){
		Double distanceToPrimary = unifiedPlanetoidI.getPlanetoid().getDistanceToPrimary();  // only for planets
		ColorRGB colorRGB = PlanarSpecularColor.build(star, unifiedPlanetoidI);
		
		Double red = colorRGB.getColorR();
		Double green = colorRGB.getColorG();
		Double blue = colorRGB.getColorB();

		if(star.getLuminosity() > 1.0){
			Integer numberIterations = star.getLuminosity().intValue();
			for(int count = 0; count < numberIterations; count++){
				Double nextPercen = (1.0 - red)*0.01;
				red += (nextPercen/scalar);
				nextPercen = (1.0 - green)*0.01;
				green += (nextPercen/scalar);
				nextPercen = (1.0 - blue)*0.01;
				blue += (nextPercen/scalar);
			}
		}
		else{
			Double inverseLuminosity = 1.0/star.getLuminosity();
			Integer numberIterations = inverseLuminosity.intValue();
			for(int count = 0; count < numberIterations; count++){
				Double nextPercen = red * 0.01;
				red -= (nextPercen/scalar);
				nextPercen = green *.01;
				green -= (nextPercen/scalar);
				nextPercen = blue *.01;
				blue-= (nextPercen/scalar);
			}
		}
		colorRGB.setColorR(red);
		colorRGB.setColorG(green);
		colorRGB.setColorB(blue);
		return colorRGB;
	}
	
	private static Double cloudHeight(UnifiedPlanetoidI unifiedPlanetoidI){
		Set<Double> cloudHeightKeys = cloudHeightMap.keySet();
		Double cloudHeight = null;
		Iterator<Double> cloudHeightIterator = cloudHeightKeys.iterator();
		Double currentCloudHeightKey = cloudHeightIterator.next();
		while (cloudHeightIterator.hasNext()){
			Double nextCloudHeightKey = cloudHeightIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getRadius() > currentCloudHeightKey
					&& unifiedPlanetoidI.getPlanetoid().getRadius() <= nextCloudHeightKey){
				cloudHeight = cloudHeightMap.get(nextCloudHeightKey).genCloudHeight();
				break;
			}
			currentCloudHeightKey = nextCloudHeightKey;
		}
		return cloudHeight;
	}
	
	private static Double cloudSpeed(UnifiedPlanetoidI unifiedPlanetoidI){
		Set<Double> cloudSpeedKeys = cloudSpeedMap.keySet();
		Double cloudSpeed = null;
		Iterator<Double> cloudSpeedIterator = cloudSpeedKeys.iterator();
		Double currentCloudSpeedKey = cloudSpeedIterator.next();
		while(cloudSpeedIterator.hasNext()){
			Double nextCloudSpeedKey = cloudSpeedIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getRadius() > currentCloudSpeedKey
					&& unifiedPlanetoidI.getPlanetoid().getRadius() <= nextCloudSpeedKey){
				cloudSpeed = cloudSpeedMap.get(nextCloudSpeedKey).genCloudSpeed();
				break;
			}
			currentCloudSpeedKey = nextCloudSpeedKey;
		}
		return cloudSpeed;
	}

	/**
	 * 
	 * @param star
	 * @param unifiedPlanetoidI
	 * @return built celestia atmosphere scalars
	 */
	public static CelestAtmosphere build(Star star, UnifiedPlanetoidI unifiedPlanetoidI) {
		Set<Double> heightKeys = heightMap.keySet();
		Double height = null;
		Iterator<Double> heightKeysInterator = heightKeys.iterator();
		Double currrentHeightKey = heightKeysInterator.next();
		while (heightKeysInterator.hasNext()) {
			Double nextHeightKey = heightKeysInterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getRadius() > currrentHeightKey
					&& unifiedPlanetoidI.getPlanetoid().getRadius() <= nextHeightKey) {
				height = heightMap.get(nextHeightKey).genAtmosphereHeight();
				break;
			}
			currrentHeightKey = nextHeightKey;
		}
		ColorRGB skyColor = genColorAtmosphere(star, unifiedPlanetoidI, skyScalar);
		ColorRGB highColor = genColorAtmosphere(star, unifiedPlanetoidI, highScalar);
		ColorRGB lowColor = genColorAtmosphere(star, unifiedPlanetoidI, lowScalar);
		Integer celestCloudHeight = cloudHeight(unifiedPlanetoidI).intValue();
		Integer cloudSpeed = cloudSpeed(unifiedPlanetoidI).intValue();
		String cloudMap = unifiedPlanetoidI.getPlanetoid().getPlanetoidName() + GenSSC.cloudMapType;

		CelestAtmosphere celestAtmosphere = new CelestAtmosphere(height.intValue(), lowColor, highColor, skyColor,
				celestCloudHeight, cloudSpeed, cloudMap);
		return celestAtmosphere;
	}
}
