package fr.istic.master.wego.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.model.User;

@Component
public class WeatherService {
// Pour chaque place de chaque user

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserPlaceDao userPlaceDao;

	@Scheduled(cron = "10 * * * * SUN-SAT")
	public void launcheWeatherAnalysis() {
		userDao.findAll().forEach((user) -> {
			analyseUserPlaces(user);
		});

	}

	private void analyseUserPlaces(User user) {
		System.out.println("Analyse du user: " + user);
		userPlaceDao.findByUser(user).forEach((userPlace) -> {
			System.out.println("Analyse de la place: " + userPlace.getPlace());
		});
	}
}
