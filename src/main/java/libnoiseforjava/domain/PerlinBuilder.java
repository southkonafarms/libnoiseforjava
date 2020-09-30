package libnoiseforjava.domain;

import com.zenred.util.GenRandomRolls;

import libnoiseforjava.NoiseGen.NoiseQuality;
import libnoiseforjava.module.Perlin;

public class PerlinBuilder {
	
	Integer seed;
	Double frequency;
	Double persistence;
	Integer octaveCount;
	NoiseQuality noiseQuality;
	Perlin perlin;
	
	public Perlin biuld(Integer seed, Double frequency, Double persistence, Double lacunarity, Integer octaveCount, NoiseQuality noiseQuality ){
		this.seed = seed;
		this.frequency = frequency;
		this.persistence = persistence;
		this.octaveCount = octaveCount;
		this.noiseQuality = noiseQuality;
		this.perlin = new Perlin();
		this.perlin.setSeed(seed);
		this.perlin.setFrequency(frequency);
		this.perlin.setPersistence(persistence);
		this.perlin.setLacunarity(lacunarity);
		this.perlin.setOctaveCount(octaveCount);
		this.perlin.setNoiseQuality(noiseQuality);
		return this.perlin;
	}

	public Perlin biuld(Double frequency, Double persistence, Double lacunarity, Integer octaveCount, NoiseQuality noiseQuality ){
		this.seed = GenRandomRolls.Instance().getD1000();
		this.frequency = frequency;
		this.persistence = persistence;
		this.octaveCount = octaveCount;
		this.noiseQuality = noiseQuality;
		this.perlin = new Perlin();
		this.perlin.setSeed(seed);
		this.perlin.setFrequency(frequency);
		this.perlin.setPersistence(persistence);
		this.perlin.setLacunarity(lacunarity);
		this.perlin.setOctaveCount(octaveCount);
		this.perlin.setNoiseQuality(noiseQuality);
		return this.perlin;
	}

	public Integer getSeed() {
		return seed;
	}

	public Double getFrequency() {
		return frequency;
	}

	public Double getPersistence() {
		return persistence;
	}

	public Integer getOctaveCount() {
		return octaveCount;
	}

	public NoiseQuality getNoiseQuality() {
		return noiseQuality;
	}
	
	public Perlin getPerlin(){
		return perlin;
	}

	@Override
	public String toString() {
		return "PerlinBuilder [seed=" + seed + ", frequency=" + frequency + ", persistence=" + persistence
				+ ", octaveCount=" + octaveCount + ", noiseQuality=" + noiseQuality + "]";
	}

}
