package celestia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.ExistingSystemWithStars;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.UnifiedPlanetoidI;

import celestia.domain.ColorRGB;

/**
 * 
 * usually the specular color is the same as the star, but
 * some atmosphere components will change the color
 * 
 * @author jredden
 *
 */

public class PlanarSpecularColor {
	
	interface Color{
		ColorRGB modify(ColorRGB colorRGB, Double percentage);
	}
	
	static private Logger logger = Logger.getLogger(PlanarSpecularColor.class);
	static public List<String> colorsThatModify = new ArrayList<String>();
	static{
		colorsThatModify.add("Water");
		colorsThatModify.add("Carbon");
		colorsThatModify.add("Methane");
		colorsThatModify.add("Potassium");
		colorsThatModify.add("Sodium");
	}
	static private Map<String, Color> colorsMap = new HashMap<String, Color>();
	static{
		colorsMap.put("Water", new Color(){
			@Override
			public ColorRGB modify(ColorRGB colorRGB, Double percentage) {
				Double blue = colorRGB.getColorB();
				blue += (blue * percentage);
				if(blue > 1.0){
					blue = 1.0;
				}
				colorRGB.setColorB(blue);
				return colorRGB;
			}
		});
		colorsMap.put("Carbon", new Color(){
			@Override
			public ColorRGB modify(ColorRGB colorRGB, Double percentage) {
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
				colorRGB.setColorG(green);
					
				Double blue = colorRGB.getColorB();
				blue -= (blue * percentage);
				if(blue< 0.0){
					blue = 0.0;
				}
				colorRGB.setColorB(blue);
				return colorRGB;
			}
		});
		colorsMap.put("Methane", new Color(){
			@Override
			public ColorRGB modify(ColorRGB colorRGB, Double percentage) {
				Double green = colorRGB.getColorG();
				green += (green * percentage);
				if(green > 1.0){
					green = 1.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
		colorsMap.put("Potassium", new Color(){
			@Override
			public ColorRGB modify(ColorRGB colorRGB, Double percentage) {
				Double red = colorRGB.getColorR();
				red += (red * percentage);
				if(red > 1.0){
					red = 1.0;
				}
				colorRGB.setColorR(red);

				Double green = colorRGB.getColorG();
				green += (green * percentage);
				if(green > 1.0){
					green = 1.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
		colorsMap.put("Sodium", new Color(){
			@Override
			public ColorRGB modify(ColorRGB colorRGB, Double percentage) {
				Double red = colorRGB.getColorR();
				red += (red * percentage);
				if(red > 1.0){
					red = 1.0;
				}
				colorRGB.setColorR(red);
				
				Double green = colorRGB.getColorG();
				green += (green * percentage);
				if(green > 1.0){
					green = 1.0;
				}
				colorRGB.setColorB(green);
				return colorRGB;
			}
		});
	}
	
	public static ColorRGB build(Star star, UnifiedPlanetoidI unifiedPlanetoidI) {
		ColorRGB colorRGB = StarColorMapping.mapStarColor(star.getStar_color());
		List<Atmosphere> atmospheres = ExistingSystemWithStars
				.readPlanarsAtmosphere(unifiedPlanetoidI.getPlanetoid());
		for(Atmosphere atmosphere : atmospheres){
			if(colorsThatModify.contains(atmosphere.getChem_name())){
				logger.info("modifying " + colorRGB + " for " + atmosphere.getChem_name());
				colorRGB = colorsMap.get(atmosphere.getChem_name()).modify(colorRGB, atmosphere.getPercentage());
			}
		}
		return colorRGB;
	}

}
