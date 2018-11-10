package fr.istic.master.wego.dto;

public class WeekendAdviceDto {

	private Long id;
	private String sport;
	private String place;
	private String weather;
	private float temperature;
	private float wind;
	

	public WeekendAdviceDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWind() {
		return wind;
	}

	public void setWind(float wind) {
		this.wind = wind;
	}

}