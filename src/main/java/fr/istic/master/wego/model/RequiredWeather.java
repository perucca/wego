package fr.istic.master.wego.model;

import java.util.EnumSet;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Represents the rules for allowing a sport practice.<br>
 * Stored by Sport class.
 *
 * @author michel
 *
 */
@Embeddable
public class RequiredWeather {

	private Float minWind; //
	private Float maxWind;
	private Float minTemperature;
	private Float maxTemperature;
	private EnumSet<EnumWeather> allowedWeather;

	public RequiredWeather() {
	}

	public RequiredWeather(Float minWind, Float maxWind, Float minTemperature, Float maxTemperature,
			EnumSet<EnumWeather> allowedWeather) {
		this.minWind = minWind;
		this.maxWind = maxWind;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.allowedWeather = allowedWeather;
	}

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

	// TODO Collection of elements
	@Enumerated(EnumType.STRING)
	public EnumSet<EnumWeather> getAllowedWeather() {
		return allowedWeather;
	}

	public void setAllowedWeather(EnumSet<EnumWeather> allowedWeather) {
		this.allowedWeather = allowedWeather;
	}
}