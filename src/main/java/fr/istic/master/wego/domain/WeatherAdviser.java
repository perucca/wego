package fr.istic.master.wego.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.SportPlaceAssociationDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.RequiredWeather;
import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;

@Service
public class WeatherAdviser {

	@Autowired
	private SportPlaceAssociationDao spaDao;

	@Autowired
	private UserDao userDao;

	public void analyse() {

		userDao.findAll().stream().forEach((user) -> analyseWeather(user));
	}

	private void analyseWeather(User user) {
		Optional<SportPlaceAssociation> advice = spaDao.findByUserOrderedByPlacePreferenceAndSportPreference(user)
				.stream().filter((spa) -> {
					RequiredWeather requiredWeather = spa.getUsersport().getSport().getIdealWeather();
					Forecast forecast = spa.getUserplace().getPlace().getForecast();
					return new RequiredWeatherValidator(requiredWeather).validate(forecast);
				}).findFirst();

		// Pas de conseil si advice est null.
		user.setWeekendAdvice(advice.orElse(null));
		userDao.save(user);
	}

}
