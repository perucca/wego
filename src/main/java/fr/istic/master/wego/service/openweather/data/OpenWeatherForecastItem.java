package fr.istic.master.wego.service.openweather.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherForecastItem {
	private OWMainForecast main;
	private List<OWWeatherForecast> weather;
	private OWWindForecast wind;
	private long dt;

	@JsonProperty(value = "weather")
	public List<OWWeatherForecast> getWeather() {
		return weather;
	}

	public void setWeather(List<OWWeatherForecast> weather) {
		this.weather = weather;
	}

	@JsonProperty(value = "wind")
	public OWWindForecast getWind() {
		return wind;
	}

	public void setWind(OWWindForecast wind) {
		this.wind = wind;
	}

	@JsonProperty(value = "main")
	public OWMainForecast getMain() {
		return main;
	}

	public void setMain(OWMainForecast main) {
		this.main = main;
	}

	@JsonProperty(value = "dt")
	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}
}
