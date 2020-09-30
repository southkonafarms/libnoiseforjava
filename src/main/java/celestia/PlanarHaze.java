package celestia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.ExistingSystemWithStars;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;
import com.zenred.cosmos.service_rules_and_infrastructure.GenAtmosphere;
import com.zenred.cosmos.service_rules_and_infrastructure.RadiusRange;
import com.zenred.util.GenRandomRolls;

import celestia.domain.ColorRGB;
import celestia.domain.Haze;

/**
 * 
 * approximates haze color and density.
 * 
 * modifiers like greenhouse effect, vulcanism, internal water fissures
 * need to be added later
 * 
 * @author jredden
 *
 */

public class PlanarHaze {

	public static ColorRGB noHaze = new ColorRGB(0.0, 0.0, 0.0); // black
	public static ColorRGB defaultHaze = new ColorRGB(1.0, 1.0, 1.0); // white
	public static ColorRGB defaultBigPlanarHaze = new ColorRGB(0.746, 0.746, 0.746); // gray

	interface HazeElement {
		Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI);
	}

	interface ColorMod {
		ColorRGB modDefault(ColorRGB colorRGB, Double percentage);
	}

	/*
	 * colorsThatModify.add("Sodium");
	 * 
	 */
	private static Map<String, ColorMod> modMap = new HashMap<String, ColorMod>();
	static {
		modMap.put("Water", new ColorMod() {
			@Override
			public ColorRGB modDefault(ColorRGB colorRGB, Double percentage) {
				Double blue = colorRGB.getColorB();
				blue -= (blue * percentage);
				if (blue < 0.0) {
					blue = 0.0;
				}
				colorRGB.setColorB(blue);
				return colorRGB;
			}
		});
		modMap.put("Carbon", new ColorMod() {
			@Override
			public ColorRGB modDefault(ColorRGB colorRGB, Double percentage) {
				Double red = colorRGB.getColorR();
				red += (red * percentage);
				if (red > 1.0) {
					red = 1.0;
				}
				colorRGB.setColorR(red);

				Double green = colorRGB.getColorG();
				green += (green * percentage);
				if (green > 1.0) {
					green = 1.0;
				}
				colorRGB.setColorG(green);

				Double blue = colorRGB.getColorB();
				blue += (blue * percentage);
				if (blue > 1.0) {
					blue = 1.0;
				}
				colorRGB.setColorB(blue);
				return colorRGB;
			}
		});
		modMap.put("Methane", new ColorMod(){
			@Override
			public ColorRGB modDefault(ColorRGB colorRGB, Double percentage) {
				Double green = colorRGB.getColorG();
				green -= (green * percentage);
				if(green < 0.0){
					green = 0.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
		modMap.put("Potassium", new ColorMod(){
			@Override
			public ColorRGB modDefault(ColorRGB colorRGB, Double percentage) {
				Double red = colorRGB.getColorR();
				red -= (red * percentage);
				if(red < 0.0){
					red = 0.0;
				}
				colorRGB.setColorR(red);

				Double green = colorRGB.getColorG();
				green -= (green * percentage);
				if(green < 0.0){
					green = 0.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
		modMap.put("Sodium", new ColorMod() {
			@Override
			public ColorRGB modDefault(ColorRGB colorRGB, Double percentage) {
				Double red = colorRGB.getColorR();
				red -= (red * percentage);
				if(red < 0.0){
					red = 0.0;
				}
				colorRGB.setColorR(red);
				
				Double green = colorRGB.getColorG();
				green -= (green * percentage);
				if(green < 0.0){
					green = 0.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
	}

	private static ColorRGB modifyDefault(ColorRGB colorRGB, UnifiedPlanetoidI unifiedPlanetoidI) {
		List<Atmosphere> atmospheres = ExistingSystemWithStars.readPlanarsAtmosphere(unifiedPlanetoidI.getPlanetoid());
		ColorRGB modColorRGB = colorRGB;
		for (Atmosphere atmosphere : atmospheres) {
			if (PlanarSpecularColor.colorsThatModify.contains(atmosphere.getChem_name())) {
				modColorRGB = modMap.get(atmosphere.getChem_name()).modDefault(colorRGB, atmosphere.getPercentage());
			}
		}
		return modColorRGB;
	}

	private static Map<String, HazeElement> buildMap = new HashMap<String, HazeElement>();
	static {
		buildMap.put(RadiusRange.s_MINI_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				Haze haze = new Haze(noHaze, 0.0);
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_DWARF_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				Haze haze = new Haze(noHaze, 0.1+ (GenRandomRolls.Instance().draw_rand()*0.1));
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_EARTH_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				ColorRGB colorRGB = modifyDefault(defaultHaze, unifiedPlanetoidI);
				Haze haze = new Haze(colorRGB, 0.2 + (GenRandomRolls.Instance().draw_rand()*0.1));
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_EARTH_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				ColorRGB colorRGB = modifyDefault(defaultHaze, unifiedPlanetoidI);
				Haze haze = new Haze(colorRGB, 0.3+ (GenRandomRolls.Instance().draw_rand()*0.2));
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_MINI_GAS_GIANT_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				ColorRGB colorRGB = modifyDefault(defaultBigPlanarHaze, unifiedPlanetoidI);
				Haze haze = new Haze(colorRGB, 0.5+ (GenRandomRolls.Instance().draw_rand()*0.2));
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_GAS_GIANT_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				ColorRGB colorRGB = modifyDefault(defaultBigPlanarHaze, unifiedPlanetoidI);
				Haze haze = new Haze(colorRGB, 0.7+ (GenRandomRolls.Instance().draw_rand()*0.1));
				return haze;
			}
		});
		buildMap.put(RadiusRange.s_SUPER_GAS_GIANT_PLANETOID, new HazeElement() {
			@Override
			public Haze genHaze(UnifiedPlanetoidI unifiedPlanetoidI) {
				ColorRGB colorRGB = modifyDefault(defaultBigPlanarHaze, unifiedPlanetoidI);
				Haze haze = new Haze(colorRGB, 0.8+ (GenRandomRolls.Instance().draw_rand()*0.2));
				return haze;
			}
		});
	}

	/**
	 * 
	 * @param unifiedPlanetoidI
	 * @return Haze objects
	 */
	public static Haze build(UnifiedPlanetoidI unifiedPlanetoidI){
		String sizeType = GenAtmosphere.sizeType(unifiedPlanetoidI.getPlanetoid().getRadius());
		return buildMap.get(sizeType).genHaze(unifiedPlanetoidI);
	}
}
