package fr.istic.master.wego.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
//@SpringJUnitConfig(classes = WegoApplication.class)
@Import(TestConfigForMail.class)
@WebAppConfiguration
public class WeatherJobTest {

	@Autowired
	WeatherJobScheduler job;

	@Test
	public void weatherNotifier() {
		job.launcheWeatherAnalysis();
	}

}
