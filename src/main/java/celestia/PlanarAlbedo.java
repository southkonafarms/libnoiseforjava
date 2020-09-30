package celestia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.ExistingSystemWithStars;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.util.GenRandomRolls;

public class PlanarAlbedo {
	
	private static Logger logger = Logger.getLogger(PlanarAlbedo.class);
	
	interface PlanarTemperature {
		public Double modAlbedo(Double albedo);
	}
	
	interface PlanarAtmosphere{
		public Double modAlbedo(Double albedo, Double percentage);
	}
	
	interface PlanarSize{
		public Double modAlbedo(Double albedo);
	}

	private static Map<Double, PlanarTemperature> temperatureMap = new HashMap<Double, PlanarTemperature>();
	static{
		temperatureMap.put(new Double(0.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.7;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(new Double(100.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.5;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(new Double(150.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.2;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(new Double(200.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				return albedo;	// no change
			}
		});
		temperatureMap.put(new Double(400.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.2;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(new Double(600.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.4;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(new Double(1000.0), new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.7;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		temperatureMap.put(Double.MAX_VALUE, new PlanarTemperature() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += GenRandomRolls.Instance().draw_rand()*0.8;
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
	}
	/**
	 * method does not account for absorption and reflection for individual chemical elements at light frequencies.
	 */
	private static Map<String, PlanarAtmosphere> atmosphereMap = new HashMap<String, PlanarAtmosphere>();
	static{
		atmosphereMap.put("Chlorine", new PlanarAtmosphere() {
			
			@Override
			public Double modAlbedo(Double albedo, Double percentage) {
				logger.info("start albedo:"+albedo);
				albedo -= (percentage * GenRandomRolls.Instance().draw_rand() * 0.2 );
				if(albedo < 0.0){
					albedo = 0.0 + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		atmosphereMap.put("Water", new PlanarAtmosphere() {
			
			@Override
			public Double modAlbedo(Double albedo, Double percentage) {
				logger.info("start albedo:"+albedo);
				albedo -= (percentage * GenRandomRolls.Instance().draw_rand() * 0.3 );
				if(albedo < 0.0){
					albedo = 0.0  + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		atmosphereMap.put("Ozone", new PlanarAtmosphere() {
			
			@Override
			public Double modAlbedo(Double albedo, Double percentage) {
				logger.info("start albedo:"+albedo);
				albedo -= (percentage * GenRandomRolls.Instance().draw_rand() * 0.1 );
				if(albedo < 0.0){
					albedo = 0.0 + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
	}
	private static Set<String> atmosphereKeys = atmosphereMap.keySet();
	
	private static Map<Double, PlanarSize> sizeMap = new HashMap<Double, PlanarSize>(); 
	static{
		sizeMap.put(new Double(0.0), new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo -= (GenRandomRolls.Instance().draw_rand() * 0.9);
				if(albedo < 0.0){
					albedo = 0.0 + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		sizeMap.put(new Double(1000.0), new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo -= (GenRandomRolls.Instance().draw_rand() * 0.7);
				if(albedo < 0.0){
					albedo = 0.0 + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
			return albedo;
			}
		});
		sizeMap.put(new Double(1500.0), new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo -= (GenRandomRolls.Instance().draw_rand() * 0.3);
				if(albedo < 0.0){
					albedo = 0.0 + GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		sizeMap.put(new Double(2000.0), new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
					return albedo; // do nothing
			}
		});
		sizeMap.put(new Double(10000.0), new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += (GenRandomRolls.Instance().draw_rand() * 0.2);
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.01;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
		sizeMap.put(Double.MAX_VALUE, new PlanarSize() {
			@Override
			public Double modAlbedo(Double albedo) {
				logger.info("start albedo:"+albedo);
				albedo += (GenRandomRolls.Instance().draw_rand() * 0.2);
				if(albedo > 1.0){
					albedo = 1.0 - GenRandomRolls.Instance().draw_rand() * 0.04;
				}
				logger.info("end albedo:"+albedo);
				return albedo;
			}
		});
	}
	
	public static Double typicalAlbedo = 0.30;
	
	
	
	/**
	 * -Assume full planar phase, geometric albedo, 100% potential flux
	 * -The closer to the star, the greater albedo
	 * -Hotter the star, the greater the albedo
	 * -Atmospheres, with water, will reduce albedo
	 * -dwarf planar size, will reduce albedo
	 * -ice planars will increase albedo
	 * 
	 * @param unifiedPlanetoidI
	 * @return generated albedo
	 */
	public static Double genAlbedoPlanar(UnifiedPlanetoidI unifiedPlanetoidI) {
		Double startAlbedo = typicalAlbedo;
		Set<Double> temperatureMapKeys = temperatureMap.keySet();
		Iterator<Double> temperatureIterator = temperatureMapKeys.iterator();
		Double currentTemperatureKey = temperatureIterator.next();
		while (temperatureIterator.hasNext()) {
			Double nextTemperatureKey = temperatureIterator.next();
			if (unifiedPlanetoidI.getPlanetoid().getTemperature() > currentTemperatureKey
					&& unifiedPlanetoidI.getPlanetoid().getTemperature() <= nextTemperatureKey) {
				startAlbedo = temperatureMap.get(nextTemperatureKey).modAlbedo(startAlbedo);
				break;
			}
			currentTemperatureKey = nextTemperatureKey;
		}
		List<Atmosphere> atmospheres = null;
		atmospheres = ExistingSystemWithStars.readPlanarsAtmosphere(unifiedPlanetoidI.getPlanetoid());
		for (Atmosphere atmosphere : atmospheres) {
			if (atmosphereKeys.contains(atmosphere.getChem_name())) {
				startAlbedo = atmosphereMap.get(atmosphere.getChem_name()).modAlbedo(startAlbedo,
						atmosphere.getPercentage());
			}
		}
		Set<Double> sizeMapKeys = sizeMap.keySet();
		Iterator<Double> sizeIterator = sizeMapKeys.iterator();
		Double currentSizeKey = sizeIterator.next();
		while(sizeIterator.hasNext()){
			Double nextSizeKey = sizeIterator.next();
			if(unifiedPlanetoidI.getPlanetoid().getRadius() > currentSizeKey &&
					unifiedPlanetoidI.getPlanetoid().getRepId() <= nextSizeKey){
				startAlbedo = sizeMap.get(nextSizeKey).modAlbedo(startAlbedo);
				break;
			}
			currentSizeKey = nextSizeKey;
		}
		return startAlbedo;
	}
	
}
