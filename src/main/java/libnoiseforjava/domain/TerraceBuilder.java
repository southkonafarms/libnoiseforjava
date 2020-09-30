package libnoiseforjava.domain;

import java.util.ArrayList;
import java.util.List;

import libnoiseforjava.module.Cached;
import libnoiseforjava.module.ModuleBase;
import libnoiseforjava.module.Terrace;

public class TerraceBuilder {
	
	Double low_control_point_scalar;
	Double mid_control_point_scalar;
	Double high_control_point_scalar;
	Double p_level;
	Double shelf_level;
	
	List<Double> controlPoints;
	Cached sourceModule;
	Terrace terrace;
	
	public Terrace build(Double low_control_point_scalar, Double mid_control_point_scalar,
			Double high_control_point_scalar, Double p_level, Double shelf_level, Cached moduleBase) {
		this.low_control_point_scalar = low_control_point_scalar;
		this.mid_control_point_scalar = mid_control_point_scalar;
		this.high_control_point_scalar = high_control_point_scalar;
		this.p_level = p_level;
		this.shelf_level = shelf_level;
		this.sourceModule = moduleBase;
		this.terrace = new Terrace(this.sourceModule);
		this.controlPoints = new ArrayList<Double>();
		this.terrace.addControlPoint(low_control_point_scalar);
		this.controlPoints.add(low_control_point_scalar);
		this.terrace.addControlPoint(shelf_level + p_level/mid_control_point_scalar);
		this.controlPoints.add(shelf_level + p_level/mid_control_point_scalar);
		this.terrace.addControlPoint(high_control_point_scalar);
		this.controlPoints.add(high_control_point_scalar);
		return this.terrace;
	}
	
	public Terrace build(List<Double> controlPoints, ModuleBase moduleBase){
		this.terrace = new Terrace(this.sourceModule);
		this.controlPoints = controlPoints;
		for (Double controlPoint : controlPoints){
			this.terrace.addControlPoint(controlPoint);
		}
		return this.terrace;
	}

	public Double getLow_control_point_scalar() {
		return low_control_point_scalar;
	}

	public void setLow_control_point_scalar(Double low_control_point_scalar) {
		this.low_control_point_scalar = low_control_point_scalar;
	}

	public Double getMid_control_point_scalar() {
		return mid_control_point_scalar;
	}

	public void setMid_control_point_scalar(Double mid_control_point_scalar) {
		this.mid_control_point_scalar = mid_control_point_scalar;
	}

	public Double getHigh_control_point_scalar() {
		return high_control_point_scalar;
	}

	public void setHigh_control_point_scalar(Double high_control_point_scalar) {
		this.high_control_point_scalar = high_control_point_scalar;
	}

	public Double getP_level() {
		return p_level;
	}

	public void setP_level(Double p_level) {
		this.p_level = p_level;
	}

	public Double getShelf_level() {
		return shelf_level;
	}

	public void setShelf_level(Double shelf_level) {
		this.shelf_level = shelf_level;
	}
	
	public List<Double> getControlPoints() {
		return controlPoints;
	}

	public void setControlPoints(List<Double> controlPoints) {
		this.controlPoints = controlPoints;
	}

	@Override
	public String toString() {
		return "TerraceBuilder [low_control_point_scalar=" + low_control_point_scalar + ", mid_control_point_scalar="
				+ mid_control_point_scalar + ", high_control_point_scalar=" + high_control_point_scalar + ", p_level="
				+ p_level + ", shelf_level=" + shelf_level + ", controlPoints=" + controlPoints + "]";
	}
	
	
}
