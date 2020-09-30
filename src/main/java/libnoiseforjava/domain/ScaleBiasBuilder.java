package libnoiseforjava.domain;

import libnoiseforjava.module.ModuleBase;
import libnoiseforjava.module.ScaleBias;

public class ScaleBiasBuilder {
	
	Double scale;
	Double bias;
	ScaleBias scaleBias;
	
	public ScaleBias  build(Double scale, Double bias, ModuleBase moduleBase) {
		this.scale = scale;
		this.bias = bias;
		this.scaleBias = new ScaleBias(moduleBase);
		this.scaleBias.setBias(bias);
		this.scaleBias.setScale(scale);
		return this.scaleBias;
	}

	public Double getScale() {
		return scale;
	}

	public Double getBias() {
		return bias;
	}

	public ScaleBias getScaleBias() {
		return scaleBias;
	}

	@Override
	public String toString() {
		return "ScaleBiasBuilder [scale=" + scale + ", bias=" + bias + "]";
	}
	

}
