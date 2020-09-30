package libnoiseforjava.domain;

import java.util.List;

import libnoiseforjava.module.Curve;
import libnoiseforjava.module.ModuleBase;

public class CurveBuilder {
	

	ModuleBase moduleBase;
	Double medianValue;
	List<ControlPoint> controlPoints;
	Curve curve;
	
	
	public Curve builder(ModuleBase moduleBase, Double medianValue, List<ControlPoint> controlPoints) {
		this.moduleBase = moduleBase;
		this.medianValue = medianValue;
		this.controlPoints = controlPoints;
		this.curve = new Curve(moduleBase);
		for(ControlPoint controlPoint : this.controlPoints){
			this.curve.addControlPoint(controlPoint.inputValue + this.medianValue, controlPoint.outputValue + this.medianValue);
		}
		return this.curve;
	}


	public ModuleBase getModuleBase() {
		return moduleBase;
	}


	public Double getMedianValue() {
		return medianValue;
	}


	public List<ControlPoint> getControlPoints() {
		return controlPoints;
	}


	public Curve getCurve() {
		return curve;
	}


	@Override
	public String toString() {
		return "CurveBuilder [moduleBase=" + moduleBase + ", medianValue=" + medianValue + ", controlPoints="
				+ controlPoints +"]";
	}

	
}
