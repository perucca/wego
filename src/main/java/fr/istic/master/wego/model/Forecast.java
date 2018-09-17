package fr.istic.master.wego.model;

import javax.persistence.Embeddable;

@Embeddable
public class ForeCast {
	private Float wind;
	private Float temperature;
	private String weather;
	
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
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
}
