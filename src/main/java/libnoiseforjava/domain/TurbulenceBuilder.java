package libnoiseforjava.domain;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.module.ModuleBase;
import libnoiseforjava.module.Turbulence;

public class TurbulenceBuilder {
	
	Integer seed;
	Double frequency;
	Double power;
	Integer roughness;
	Turbulence turbulence;
	
	public Turbulence build(Integer seed, Double frequency, Double power, Integer roughness, ModuleBase moduleBase) {
		this.seed = seed;
		this.frequency = frequency;
		this.power = power;
		this.roughness = roughness;
		this.turbulence = new Turbulence(moduleBase);
		this.turbulence.setSeed(seed);
		this.turbulence.setFrequency(frequency);
		this.turbulence.setPower(power);
		this.turbulence.setRoughness(roughness);
		return this.turbulence;
	}

	public Turbulence build(Double frequency, Double power, Integer roughness, ModuleBase moduleBase) {
		this.seed = GenRandomRolls.Instance().getD1000();
		this.frequency = frequency;
		this.power = power;
		this.roughness = roughness;
		this.turbulence = new Turbulence(moduleBase);
		this.turbulence.setSeed(seed);
		this.turbulence.setFrequency(frequency);
		this.turbulence.setPower(power);
		this.turbulence.setRoughness(roughness);
		return this.turbulence;
	}

	public Integer getSeed() {
		return seed;
	}

	public Double getFrequency() {
		return frequency;
	}

	public Double getPower() {
		return power;
	}

	public Integer getRoughness() {
		return roughness;
	}

	@Override
	public String toString() {
		return "TurbulenceBuilder [seed=" + seed + ", frequency=" + frequency + ", power=" + power + ", roughness="
				+ roughness + "]";
	}
	
}
