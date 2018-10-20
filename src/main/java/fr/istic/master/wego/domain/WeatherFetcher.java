package fr.istic.master.wego.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.service.openweather.OpenWeatherForecast;
import fr.istic.master.wego.service.openweather.OpenWeatherForecastItem;
import fr.istic.master.wego.service.openweather.OpenWeatherService;

@Service
public class WeatherFetcher {

	@Autowired
	private PlaceDao placeDao;

	@Autowired
	private UserPlaceDao userPlaceDao;

	@Autowired
	private OpenWeatherService openWeatherService;

	public void launchWeatherAnalysis() {
		userPlaceDao.findAll().stream().map((userPlace) -> userPlace.getPlace().getId())
				.forEach((idPlace) -> analysePlace(idPlace));

	}

	private void analysePlace(Long idPlace) {
		Place place = placeDao.findById(idPlace).orElseThrow(() -> new RuntimeException("Place Not Found."));

		try {
			OpenWeatherForecast owforecast = openWeatherService.callAPI(place.getPostCode(), "fr");

			Forecast forecast = transformOWForecastToWegoForecast(owforecast);
			place.setForecast(forecast);
			placeDao.save(place);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "Encountered an error for the place: " + place.getName() + " zipcode: "
					+ place.getPostCode() + "Error: " + e);
		}
	}

	private Forecast transformOWForecastToWegoForecast(OpenWeatherForecast owforecast) {
		Forecast forecast = new Forecast();
		OpenWeatherForecastItem owForecastItem = owforecast.getList().get(28); // Samedi
																				// 12h
		forecast.setTemperature(owForecastItem.getMain().getTemperature());
		forecast.setWeather(owForecastItem.getWeather().get(0).getMain());
		forecast.setWind(owForecastItem.getWind().getSpeed());
		return forecast;
	}

}
