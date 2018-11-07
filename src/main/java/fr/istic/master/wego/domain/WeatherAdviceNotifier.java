package fr.istic.master.wego.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.WeekendAdviceDao;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.WeekendAdvice;

@Service
public class WeatherAdviceNotifier {

	@Autowired
	private WeekendAdviceDao weaDao;

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(WeekendAdvice wea) {
		Sport sport = wea.getSport();
		Place place = wea.getPlace();
		User user = wea.getUser();

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getMail());
		message.setSubject("Wego Advice");
		message.setText("Greetings " + user.getFirstName() + " " + user.getLastName() + ",\n"
				+ "My activity advice for the next week end is: " + sport.getSportName() + " at " + place.getName()
				+ ".\n" + "The weather at this place will be: \n" + "Weather:" + place.getForecast().getWeather() + "\n"
				+ "Temperature: " + place.getForecast().getTemperature() + "\n" + "Wind: "
				+ place.getForecast().getWind() + "\n");
		emailSender.send(message);
	}

	public void sendMails() {
		weaDao.findAll().forEach(wea -> sendMail(wea));
	}

}
