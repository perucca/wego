package fr.istic.master.wego.model;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

/**
 * Represents the rules for allowing a sport practice.<br>
 * Stored by Sport class.
 *
 * @author michel
 *
 */
@Embeddable
public class IdealWeather {

	private Float minWind; //
	private Float maxWind;
	private Float minTemperature;
	private Float maxTemperature;
	private Set<EnumWeather> allowedWeather = new HashSet<EnumWeather>();

	public IdealWeather() {
	}

	public IdealWeather(Float minWind, Float maxWind, Float minTemperature, Float maxTemperature,
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

	@ElementCollection(targetClass = EnumWeather.class, fetch=FetchType.EAGER)
	@CollectionTable(name = "weather", joinColumns = @JoinColumn(name = "weather_id"))
	@Column(name = "allowedWeather", nullable = false)
	@Enumerated(EnumType.STRING)
	public Set<EnumWeather> getAllowedWeather() {
		return allowedWeather;
	}

	public void setAllowedWeather(Set<EnumWeather> allowedWeather) {
		this.allowedWeather = allowedWeather;
	}
}