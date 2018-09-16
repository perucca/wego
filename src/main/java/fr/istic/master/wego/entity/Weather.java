package fr.istic.master.wego.entity;

import javax.persistence.Embeddable;

/**
 * Represents the rules for allowing a sport practice.<br>
 * Stored by Sport class.
 * 
 * @author michel
 *
 */
@Embeddable
public class Weather {

	private Float minWind;
	private Float maxWind;
	private Float minTemperature;
	private Float maxTemperature;
	private boolean sunny;
	private boolean rainy;
	
	
	public Float getMinWind() {
		return minWind;
	}
	public void setMinWind(Float minWind) {
		this.minWind = minWind;
	}
	public Float getMaxWind() {
		return maxWind;
	}
	public void setMaxWind(Float maxWind) {
		this.maxWind = maxWind;
	}
	public Float getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(Float minTemperature) {
		this.minTemperature = minTemperature;
	}
	public Float getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(Float maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public boolean isSunny() {
		return sunny;
	}
	public void setSunny(boolean sunny) {
		this.sunny = sunny;
	}
	public boolean isRainy() {
		return rainy;
	}
	public void setRainy(boolean rainy) {
		this.rainy = rainy;
	}
}