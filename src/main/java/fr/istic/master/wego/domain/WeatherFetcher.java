package fr.istic.master.wego.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.model.EnumWeather;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.service.openweather.OpenWeatherService;
import fr.istic.master.wego.service.openweather.data.OpenWeatherForecast;
import fr.istic.master.wego.service.openweather.data.OpenWeatherForecastItem;

@Service
public class WeatherFetcher {

	private final static int MAX_OPENWEATHER_FORECAST = 5*8; //5 days/3 hours of forecast
	
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
			
			Logger.getGlobal().log(Level.INFO, "Place: "+ place.getName() + " Forecast:" + forecast);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "Encountered an error for the place: " + place.getName() + " zipcode: "
					+ place.getPostCode(), e);
		}
	}

	private Forecast transformOWForecastToWegoForecast(OpenWeatherForecast owforecast) {
		Forecast forecast = new Forecast();
		
		int shift = computeForecastShift();
		
		if(shift > MAX_OPENWEATHER_FORECAST) {
			shift = MAX_OPENWEATHER_FORECAST-4; //Hack on prend la prévision de la dernière journée à 12h
		}
		
		OpenWeatherForecastItem owForecastItem = owforecast.getList().get(shift-1); 

		forecast.setTemperature(owForecastItem.getMain().getTemperature());
		forecast.setWeather(EnumWeather.from(owForecastItem.getWeather().get(0).getMain()));
		forecast.setWind(owForecastItem.getWind().getSpeed());
		return forecast;
	}

	private int computeForecastShift() {
		LocalDate today = LocalDate.now();
		LocalDate nextSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)); 
		
		int nbOfDays = 0;
		if(nextSaturday.getDayOfMonth() >= today.getDayOfMonth())
		{
			nbOfDays = nextSaturday.getDayOfMonth() - today.getDayOfMonth();
		} else {
			nbOfDays = today.getDayOfMonth()%today.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth() + nextSaturday.getDayOfMonth();
		}
		
		int decalage = (nbOfDays-1)*8+4;
		return decalage;
	}


}
