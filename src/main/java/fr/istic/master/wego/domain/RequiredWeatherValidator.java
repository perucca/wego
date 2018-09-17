package fr.istic.master.wego.domain;

import com.google.common.collect.Range;

import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.RequiredWeather;

/**
 * @author michel
 *
 */
public class RequiredWeatherValidator {

	private RequiredWeather weather;

	public RequiredWeatherValidator(RequiredWeather weather) {
		this.weather = weather;
	}

	public boolean validate(Forecast forecast) {
		return validateTemperature(forecast) && validateWind(forecast) && validateWeather(forecast);
	}

	private boolean validateWeather(Forecast forecast) {

		switch (forecast.getWeather()) {
		case "rain":
			return weather.isRainy();
		case "sunny":
			return weather.isSunny();
		default:
			return false;
		}
	}

	private boolean validateWind(Forecast forecast) {
		Range<Float> range = Range.closed(weather.getMinWind(), weather.getMaxWind());
		return range.contains(forecast.getWind());
	}

	private boolean validateTemperature(Forecast forecast) {
		Range<Float> range = Range.closed(weather.getMinTemperature(), weather.getMaxTemperature());
		return range.contains(forecast.getTemperature());
	}

}
