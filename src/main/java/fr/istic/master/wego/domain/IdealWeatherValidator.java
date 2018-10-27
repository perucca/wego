package fr.istic.master.wego.domain;

import com.google.common.collect.Range;

import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.IdealWeather;

/**
 * @author michel
 *
 */
public class IdealWeatherValidator {

	private IdealWeather idealWeatherCondition;

	public IdealWeatherValidator(IdealWeather idealWeatherCondition) {
		this.idealWeatherCondition = idealWeatherCondition;
	}

	public boolean validate(Forecast forecast) {
		return validateTemperature(forecast) && validateWind(forecast) && validateWeather(forecast);
	}

	private boolean validateWeather(Forecast forecast) {
		return idealWeatherCondition.getAllowedWeather().contains(forecast.getWeather());
	}

	private boolean validateWind(Forecast forecast) {
		Range<Float> range = Range.closed(idealWeatherCondition.getMinWind(), idealWeatherCondition.getMaxWind());
		return range.contains(forecast.getWind());
	}

	private boolean validateTemperature(Forecast forecast) {
		Range<Float> range = Range.closed(idealWeatherCondition.getMinTemperature(), idealWeatherCondition.getMaxTemperature());
		return range.contains(forecast.getTemperature());
	}

}
