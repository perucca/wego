package fr.istic.master.wego.service.openweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.istic.master.wego.WegoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = WegoApplication.class)
@WebAppConfiguration
public class OpenWeatherServiceTest {

	@Autowired
	private OpenWeatherService ows;

	@Test
	public void testOpenWeatherApiCall() {

		OpenWeatherForecast forecast = ows.callAPI("35760", "FR");
		assertEquals(40, forecast.getList().size());
		assertNotNull(forecast.getList().toArray()[28]);

	}
}
