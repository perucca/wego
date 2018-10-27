package fr.istic.master.wego.model;

import javax.persistence.Embeddable;

@Embeddable
public class Forecast {
	private Float wind;
	private Float temperature;
	private EnumWeather weather;

	public Forecast() {
	}

	public Forecast(Float wind, Float temperature, EnumWeather weather) {
		super();
		this.wind = wind;
		this.temperature = temperature;
		this.weather = weather;
	}

	public Float getWind() {
		return wind;
	}

	public void setWind(Float wind) {
		this.wind = wind;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public EnumWeather getWeather() {
		return weather;
	}

	public void setWeather(EnumWeather weather) {
		this.weather = weather;
	}
}
