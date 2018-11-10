package fr.istic.master.wego.service.openweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import fr.istic.master.wego.service.openweather.data.OpenWeatherForecast;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = WegoApplication.class)
//@WebAppConfiguration
public class OpenWeatherServiceTest {

	@Autowired
	private OpenWeatherService ows;

//	@Test
	public void testOpenWeatherApiCall() {

		OpenWeatherForecast forecast = ows.callAPI("35760", "FR");
		assertEquals(40, forecast.getList().size());
		assertNotNull(forecast.getList().toArray()[28]);

	}
}
