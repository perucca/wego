package fr.istic.master.wego.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fr.istic.master.wego.model.EnumWeather;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.IdealWeather;

@DisplayName("Test class of RequiredWeather class")
@RunWith(JUnitPlatform.class)
public class IdealWeatherValidatorTest {

	@DisplayName("Test if the conditions are acceptable")
	@ParameterizedTest
	@CsvSource({
		"12.0, 23.0, Rain",
		"10.0, 23.0, Rain",
		"13.0, 23.0, Rain",
		"13.0, 14.0, Rain",
		"13.0, 25.0, Rain",
	})
	public void testacceptable(float forecastWind, float forecastTemperature, String weather) {
		Forecast forecast = new Forecast(forecastWind, forecastTemperature, EnumWeather.from(weather));
		IdealWeather requiredWeather = new IdealWeather(10.0f,13.0f,14.0f,25.0f,EnumSet.of(EnumWeather.RAIN));
		assertTrue(new IdealWeatherValidator(requiredWeather).validate(forecast), "La condition acceptable n'est pas vérifier");
	}
	
	@DisplayName("Test if the conditions are un-acceptable")
	@ParameterizedTest
	@CsvSource({
		"12.0, 23.0, Clear",
		"9.0, 23.0, Rain",
		"14.0, 23.0, Rain",
		"12.0, 26.0, Rain",
	})
	public void testnonacceptable(float forecastWind, float forecastTemperature, String weather) {
		Forecast forecast = new Forecast(forecastWind, forecastTemperature, EnumWeather.from(weather));
		IdealWeather requiredWeather = new IdealWeather(10.0f,13.0f,14.0f,25.0f,EnumSet.of(EnumWeather.RAIN));
		assertFalse(new IdealWeatherValidator(requiredWeather).validate(forecast), "La condition non-acceptable n'est pas vérifier");
	}
	
}
