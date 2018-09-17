package fr.istic.master.wego.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.RequiredWeather;

@DisplayName("Test class of RequiredWeather class")
@RunWith(JUnitPlatform.class)
public class RequiredWeatherValidatorTest {

	@DisplayName("Test if the conditions are acceptable")
	@ParameterizedTest
	@CsvSource({
		"12.0, 23.0, rain",
		"10.0, 23.0, rain",
		"13.0, 23.0, rain",
		"13.0, 14.0, rain",
		"13.0, 25.0, rain",
	})
	public void testacceptable(float forecastWind, float forecastTemperature, String weather) {
		Forecast forecast = new Forecast(forecastWind, forecastTemperature, weather);
		RequiredWeather requiredWeather = new RequiredWeather(10.0f,13.0f,14.0f,25.0f,false,true);
		assertTrue(new RequiredWeatherValidator(requiredWeather).validate(forecast), "La condition acceptable n'est pas vérifier");
	}
	
	@DisplayName("Test if the conditions are un-acceptable")
	@ParameterizedTest
	@CsvSource({
		"12.0, 23.0, sunny",
		"9.0, 23.0, rain",
		"14.0, 23.0, rain",
		"12.0, 26.0, rain",
	})
	public void testnonacceptable(float forecastWind, float forecastTemperature, String weather) {
		Forecast forecast = new Forecast(forecastWind, forecastTemperature, weather);
		RequiredWeather requiredWeather = new RequiredWeather(10.0f,13.0f,14.0f,25.0f,false,true);
		assertFalse(new RequiredWeatherValidator(requiredWeather).validate(forecast), "La condition non-acceptable n'est pas vérifier");
	}
	
}
