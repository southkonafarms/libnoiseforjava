package libnoiseforjava.domain;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.module.RidgedMulti;

public class RidgedMultiBuilder {
	
	Double mountainBaseFrequency;
	Double mountainLacunairty;
	Integer mountainBaseOctaveCount;
	NoiseQuality noiseQuality;
	RidgedMulti ridgedMulti;
	
	
	public RidgedMulti build(Double mountainBaseFrequency, Double mountainLacunairty,
			Integer mountainBaseOctaveCount, NoiseQuality noiseQuality) {
		this.mountainBaseFrequency = mountainBaseFrequency;
		this.mountainLacunairty = mountainLacunairty;
		this.mountainBaseOctaveCount = mountainBaseOctaveCount;
		this.noiseQuality = noiseQuality;
		this.ridgedMulti = new RidgedMulti();
		Integer currSeed = GenRandomRolls.Instance().getD1000();
		this.ridgedMulti.setFrequency(mountainBaseFrequency);
		this.ridgedMulti.setLacunarity(mountainLacunairty);
		this.ridgedMulti.setNoiseQuality(noiseQuality);
		this.ridgedMulti.setOctaveCount(mountainBaseOctaveCount);
		this.ridgedMulti.setSeed(currSeed);
		return this.ridgedMulti;
	}


	public Double getMountainBaseFrequency() {
		return mountainBaseFrequency;
	}


	public Double getMountainLacunairty() {
		return mountainLacunairty;
	}


	public Integer getMountainBaseOctaveCount() {
		return mountainBaseOctaveCount;
	}


	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}


	@Override
	public String toString() {
		return "RidgedMultiBuilder [mountainBaseFrequency=" + mountainBaseFrequency + ", mountainLacunairty="
				+ mountainLacunairty + ", mountainBaseOctaveCount=" + mountainBaseOctaveCount + ", noiseQuality="
				+ noiseQuality + "]";
	}
	
}
