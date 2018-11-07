package fr.istic.master.wego.service.openweather;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.istic.master.wego.service.openweather.data.OpenWeatherForecast;

@Service
public class OpenWeatherService {

	private final RestTemplate restTemplate;
	private static final String API_KEY = "d57ff8c8ad6d033dbf8cf1b6f278dd1e";

	public OpenWeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public OpenWeatherForecast callAPI(String zip_code, String country_code) {

		return this.restTemplate.getForObject(
				"http://api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}&units=metric&appid={API_KEY}",
				OpenWeatherForecast.class, zip_code, country_code, API_KEY);
	}

}