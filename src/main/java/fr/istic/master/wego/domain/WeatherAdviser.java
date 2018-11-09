package fr.istic.master.wego.domain;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.SportPlaceAssociationDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.IdealWeather;
import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.service.WeekEndAdviceService;

@Service
public class WeatherAdviser {

	@Autowired
	private SportPlaceAssociationDao spaDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private WeekEndAdviceService weekendAdviceService;

	public void analyse() {

		userDao.findAll().stream().forEach((user) -> {
			Logger.getGlobal().log(Level.INFO, "Analysing User:" + user);
			analyseWeather(user);
		});
	}

	private void analyseWeather(User user) {
		Optional<SportPlaceAssociation> advice = spaDao.findByUserOrderedByPlacePreferenceAndSportPreference(user)
				.stream().filter((spa) -> {
					IdealWeather idealWeatherCondition = spa.getUsersport().getSport().getIdealWeather();
					Forecast forecast = spa.getUserplace().getPlace().getForecast();
					return new IdealWeatherValidator(idealWeatherCondition).validate(forecast);
				}).findFirst();

		weekendAdviceService.deleteByUser(user);
		if (advice.isPresent()) {
			SportPlaceAssociation spa = advice.get();
			weekendAdviceService.create(user, spa.getUserplace().getPlace(), spa.getUsersport().getSport());
		} 

	}

}
