package libnoiseforjava.domain;

import libnoiseforjava.module.Exponent;
import libnoiseforjava.module.ModuleBase;

public class ExponentBuilder {
	
	Double exponentScalar;
	ModuleBase target;
	Exponent exponent;
	
	public Exponent build(Double exponentScalar, ModuleBase target){
		this.exponentScalar = exponentScalar;
		this.target = target;
		this.exponent = new Exponent(target);
		return this.exponent;
	}

	public Double getExponentScalar() {
		return exponentScalar;
	}

	@Override
	public String toString() {
		return "ExponentBuilder [exponentScalar=" + exponentScalar + "]";
	}

	
}
