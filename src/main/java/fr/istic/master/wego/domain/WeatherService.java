package fr.istic.master.wego.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.service.openweather.OpenWeatherForecast;
import fr.istic.master.wego.service.openweather.OpenWeatherForecastItem;
import fr.istic.master.wego.service.openweather.OpenWeatherService;

@Service
public class WeatherService {

	@Autowired
	private PlaceDao placeDao;

	@Autowired
	private UserPlaceDao userPlaceDao;

	@Autowired
	private OpenWeatherService openWeatherService;

	/**
	 *
	 *
	 * "0 0 * * * *" = the top of every hour of every day. "* /10 * * * * *" = every
	 * ten seconds. "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day. "0 0 8,10 *
	 * * *" = 8 and 10 o'clock of every day. "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00,
	 * 9:30 and 10 o'clock every day. "0 0 9-17 * * MON-FRI" = on the hour
	 * nine-to-five weekdays "0 0 0 25 12 ?" = every Christmas Day at midnight
	 *
	 * Cron expression is represented by six fields:
	 *
	 * second, minute, hour, day of month, month, day(s) of week
	 *
	 * (*) means match any
	 *
	 * /X means "every X"
	 *
	 * ? means no specific value
	 **/
	@Scheduled(cron = "*/30 * * * * *")
	public void launcheWeatherAnalysis() {
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
			Logger.getGlobal().log(Level.SEVERE,
					"Error for the place: " + place.getName() + " zipcode: " + place.getPostCode() + "Error: " + e);
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
