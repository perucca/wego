package fr.istic.master.wego.domain;

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
public class WeatherJobTest {

	@Autowired
	WeatherJobScheduler job;

	@Test
	public void weatherNotifier() {
		job.launcheWeatherAnalysis();
	}

}
