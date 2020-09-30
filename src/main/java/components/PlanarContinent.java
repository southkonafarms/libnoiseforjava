package components;

import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.domain.SelectBuilder;
import libnoiseforjava.domain.SpheresBuilder;
import libnoiseforjava.domain.TurbulenceBuilder;
import libnoiseforjava.module.Add;
import libnoiseforjava.module.Cached;
import libnoiseforjava.module.Select;
import libnoiseforjava.module.Spheres;
import libnoiseforjava.module.Turbulence;

public class PlanarContinent implements  CachedIF {
	
	private static Logger logger = Logger.getLogger(PlanarContinent.class);
	
	private Cached baseContinentDef;
	private Double spheres_scalar;
	private Boolean genSpheres = Boolean.FALSE;
	private Double turbulenceFrequency_0;
	private Double turbulenceFrequency_1;
	private Double turbulenceFrequency_2;
	private Double turbulencePowerScalar_0;
	private Double turbulencePowerScalar_1;
	private Double turbulencePowerScalar_2;
	private Integer turbulenceRoughness_0;
	private Integer turbulenceRoughness_1;
	private Integer turbulenceRoughness_2;
	private Double continent_def_lower_bounds;
	private Double continent_def_upper_bounds;
	private Double continent_def_edge_falloff;
	private Cached continentDef;
	
	
	public PlanarContinent(Double spheres_scalar, Boolean genSpheres, Double turbulenceFrequency_0,
			Double turbulenceFrequency_1, Double turbulenceFrequency_2, Double turbulencePowerScalar_0,
			Double turbulencePowerScalar_1, Double turbulencePowerScalar_2, Integer turbulenceRoughness_0,
			Integer turbulenceRoughness_1, Integer turbulenceRoughness_2, Double continent_def_lower_bounds,
			Double continent_def_upper_bounds, Double continent_def_edge_falloff, Cached baseContinentDef) {
		super();
		this.spheres_scalar = spheres_scalar;
		this.genSpheres = genSpheres;
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
		this.turbulenceFrequency_1 = turbulenceFrequency_1;
		this.turbulenceFrequency_2 = turbulenceFrequency_2;
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
		this.turbulencePowerScalar_2 = turbulencePowerScalar_2;
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
		this.turbulenceRoughness_1 = turbulenceRoughness_1;
		this.turbulenceRoughness_2 = turbulenceRoughness_2;
		this.continent_def_lower_bounds = continent_def_lower_bounds;
		this.continent_def_upper_bounds = continent_def_upper_bounds;
		this.continent_def_edge_falloff = continent_def_edge_falloff;
		this.baseContinentDef = baseContinentDef;
	}


	@Override
	public Cached build() {
		Integer nextSeed = GenRandomRolls.Instance().getD1000();
		TurbulenceBuilder turbulenceBuilder = new TurbulenceBuilder();
		Turbulence continentDef_tu0 = turbulenceBuilder.build(nextSeed, turbulenceFrequency_0, turbulencePowerScalar_0, turbulenceRoughness_0,
				baseContinentDef);
		Turbulence continentDef_tu1 = turbulenceBuilder.build(nextSeed, turbulenceFrequency_1, turbulencePowerScalar_1, turbulenceRoughness_1,
				continentDef_tu0);
		Turbulence continentDef_tu2 = null;
		if(genSpheres){
		Spheres morePools = new SpheresBuilder().build(20.0);
		Add continentDef_tu1_add = new Add(morePools, continentDef_tu1);
		continentDef_tu2 = turbulenceBuilder.build(nextSeed, turbulenceFrequency_2, turbulencePowerScalar_2, turbulenceRoughness_2,
				continentDef_tu1_add);

		}
		else{
		continentDef_tu2 = turbulenceBuilder.build(nextSeed, turbulenceFrequency_2, turbulencePowerScalar_2, turbulenceRoughness_2,
				continentDef_tu1);
		}

		Select continentDef_se = new SelectBuilder().build(baseContinentDef, continentDef_tu2, baseContinentDef,
				continent_def_lower_bounds, continent_def_upper_bounds, continent_def_edge_falloff);
		continentDef = new Cached(continentDef_se);
		logger.info(this.toString());
		return continentDef;
	}


	public Double getSpheres_scalar() {
		return spheres_scalar;
	}


	public void setSpheres_scalar(Double spheres_scalar) {
		this.spheres_scalar = spheres_scalar;
	}


	public Boolean getGenSpheres() {
		return genSpheres;
	}


	public void setGenSpheres(Boolean genSpheres) {
		this.genSpheres = genSpheres;
	}


	public Double getTurbulenceFrequency_0() {
		return turbulenceFrequency_0;
	}


	public void setTurbulenceFrequency_0(Double turbulenceFrequency_0) {
		this.turbulenceFrequency_0 = turbulenceFrequency_0;
	}


	public Double getTurbulenceFrequency_1() {
		return turbulenceFrequency_1;
	}


	public void setTurbulenceFrequency_1(Double turbulenceFrequency_1) {
		this.turbulenceFrequency_1 = turbulenceFrequency_1;
	}


	public Double getTurbulenceFrequency_2() {
		return turbulenceFrequency_2;
	}


	public void setTurbulenceFrequency_2(Double turbulenceFrequency_2) {
		this.turbulenceFrequency_2 = turbulenceFrequency_2;
	}


	public Double getTurbulencePowerScalar_0() {
		return turbulencePowerScalar_0;
	}


	public void setTurbulencePowerScalar_0(Double turbulencePowerScalar_0) {
		this.turbulencePowerScalar_0 = turbulencePowerScalar_0;
	}


	public Double getTurbulencePowerScalar_1() {
		return turbulencePowerScalar_1;
	}


	public void setTurbulencePowerScalar_1(Double turbulencePowerScalar_1) {
		this.turbulencePowerScalar_1 = turbulencePowerScalar_1;
	}


	public Double getTurbulencePowerScalar_2() {
		return turbulencePowerScalar_2;
	}


	public void setTurbulencePowerScalar_2(Double turbulencePowerScalar_2) {
		this.turbulencePowerScalar_2 = turbulencePowerScalar_2;
	}


	public Integer getTurbulenceRoughness_0() {
		return turbulenceRoughness_0;
	}


	public void setTurbulenceRoughness_0(Integer turbulenceRoughness_0) {
		this.turbulenceRoughness_0 = turbulenceRoughness_0;
	}


	public Integer getTurbulenceRoughness_1() {
		return turbulenceRoughness_1;
	}


	public void setTurbulenceRoughness_1(Integer turbulenceRoughness_1) {
		this.turbulenceRoughness_1 = turbulenceRoughness_1;
	}


	public Integer getTurbulenceRoughness_2() {
		return turbulenceRoughness_2;
	}


	public void setTurbulenceRoughness_2(Integer turbulenceRoughness_2) {
		this.turbulenceRoughness_2 = turbulenceRoughness_2;
	}


	public Double getContinent_def_lower_bounds() {
		return continent_def_lower_bounds;
	}


	public void setContinent_def_lower_bounds(Double continent_def_lower_bounds) {
		this.continent_def_lower_bounds = continent_def_lower_bounds;
	}


	public Double getContinent_def_upper_bounds() {
		return continent_def_upper_bounds;
	}


	public void setContinent_def_upper_bounds(Double continent_def_upper_bounds) {
		this.continent_def_upper_bounds = continent_def_upper_bounds;
	}


	public Double getContinent_def_edge_falloff() {
		return continent_def_edge_falloff;
	}


	public void setContinent_def_edge_falloff(Double continent_def_edge_falloff) {
		this.continent_def_edge_falloff = continent_def_edge_falloff;
	}


	@Override
	public String toString() {
		return "PlanarContinent [spheres_scalar=" + spheres_scalar + ", genSpheres=" + genSpheres
				+ ", turbulenceFrequency_0=" + turbulenceFrequency_0 + ", turbulenceFrequency_1="
				+ turbulenceFrequency_1 + ", turbulenceFrequency_2=" + turbulenceFrequency_2
				+ ", turbulencePowerScalar_0=" + turbulencePowerScalar_0 + ", turbulencePowerScalar_1="
				+ turbulencePowerScalar_1 + ", turbulencePowerScalar_2=" + turbulencePowerScalar_2
				+ ", turbulenceRoughness_0=" + turbulenceRoughness_0 + ", turbulenceRoughness_1="
				+ turbulenceRoughness_1 + ", turbulenceRoughness_2=" + turbulenceRoughness_2
				+ ", continent_def_lower_bounds=" + continent_def_lower_bounds + ", continent_def_upper_bounds="
				+ continent_def_upper_bounds + ", continent_def_edge_falloff=" + continent_def_edge_falloff + "]";
	}

	
}
