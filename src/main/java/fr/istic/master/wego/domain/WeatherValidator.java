package fr.istic.master.wego.domain;

import com.google.common.collect.Range;

import fr.istic.master.wego.model.ForeCast;
import fr.istic.master.wego.model.Weather;

/**
 * @author michel
 *
 */
public class WeatherValidator {

	private Weather weather;

	public WeatherValidator(Weather weather) {
		this.weather = weather;
	}

	public boolean validate(ForeCast forecast) {
		return validateTemperature(forecast) && validateWind(forecast) && validateWeather(forecast);
	}

	private boolean validateWeather(ForeCast forecast) {

		switch (forecast.getWeather()) {
		case "rain":
			return weather.isRainy();
		case "sunny":
			return weather.isSunny();
		default:
			return false;
		}
	}

	private boolean validateWind(ForeCast forecast) {
		Range<Float> range = Range.closed(weather.getMinWind(), weather.getMaxWind());
		return range.contains(forecast.getWind());
	}

	private boolean validateTemperature(ForeCast forecast) {
		Range<Float> range = Range.closed(weather.getMinTemperature(), weather.getMaxTemperature());
		return range.contains(forecast.getTemperature());
	}

}
