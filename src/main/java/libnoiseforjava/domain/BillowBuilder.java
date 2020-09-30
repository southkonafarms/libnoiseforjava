package libnoiseforjava.domain;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.module.Billow;

public class BillowBuilder {
	
	Double frequency;
	Double persistence;
	Double lacunarity;
	Integer octaveCount;
	NoiseQuality noiseQuality;
	
	Billow billow;
	
	public BillowBuilder(){}
	
	public Billow build(Double frequency, Double persistence, Double lacunarity, Integer octaveCount, NoiseQuality noiseQuality) {
		this.frequency = frequency;
		this.persistence = persistence;
		this.octaveCount = octaveCount;
		this.noiseQuality = noiseQuality;
		this.lacunarity = lacunarity;
		this.billow = new Billow();
		this.billow.setFrequency(frequency);
		this.billow.setLacunarity(lacunarity);
		this.billow.setPersistence(persistence);
		this.billow.setOctaveCount(octaveCount);
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		this.billow.setSeed(currSeed);
		this.billow.setNoiseQuality(noiseQuality);
		return this.billow;
	}

	public Double getFrequency() {
		return frequency;
	}

	public Double getPersistence() {
		return persistence;
	}

	public Double getLacunarity() {
		return lacunarity;
	}

	public Integer getOctaveCount() {
		return octaveCount;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}

	@Override
	public String toString() {
		return "BillowBuilder [frequency=" + frequency + ", persistence=" + persistence + ", lacunarity=" + lacunarity
				+ ", octaveCount=" + octaveCount + ", noiseQuality=" + noiseQuality + "]";
	}
	
	

}
