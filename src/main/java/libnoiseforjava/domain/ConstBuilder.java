package libnoiseforjava.domain;

import libnoiseforjava.module.Const;

public class ConstBuilder {
	
	Double constant;
	Const const1;

	public ConstBuilder(Double constant) {
		super();
		this.constant = constant;
	}
	
	public Const build(){
		this.const1 = new Const();
		this.const1.setConstValue(this.constant);
		return const1;
	}

	public Double getConstant() {
		return constant;
	}

	@Override
	public String toString() {
		return "ConstBuilder [constant=" + constant + "]";
	}

}
