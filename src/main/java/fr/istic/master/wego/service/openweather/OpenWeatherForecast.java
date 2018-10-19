package fr.istic.master.wego.service.openweather;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherForecast {
	private List<OpenWeatherForecastItem> list;

	@JsonProperty(value = "list")
	public List<OpenWeatherForecastItem> getList() {
		return list;
	}

	public void setList(List<OpenWeatherForecastItem> list) {
		this.list = list;
	}

}
