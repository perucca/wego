package fr.istic.master.wego.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.User;

@Service
public class WeatherAdviceNotifier {

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendMail(User user) {
		Sport sport = user.getWeekendAdvice().getUsersport().getSport();
		Place place = user.getWeekendAdvice().getUserplace().getPlace();
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getMail()); 
        message.setSubject("Wego Advice"); 
        message.setText("Greetings "+user.getFirstName()+" "+user.getLastName()+",\n"
        		+ "My activity advice for the next week end is: "+ sport.getSportName() + " at "+ place.getName()+ ".\n"
        		+ "The weather at this place will be: \n" 
        		+ "Weather:" +place.getForecast().getWeather()+ "\n" 
        		+ "Temperature: " +place.getForecast().getTemperature()+ "\n"
        		+ "Wind: "+ place.getForecast().getWind()+ "\n"
        		);
        emailSender.send(message);
	}
	
}
