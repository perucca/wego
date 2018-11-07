package fr.istic.master.wego.domain;

import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringRunner.class)
//@SpringJUnitConfig(classes = WegoApplication.class)
//@Import(TestConfigForMail.class)
//@WebAppConfiguration
public class WeatherJobTest {

	@Autowired
	WeatherJobScheduler job;

//	@Test
	public void weatherNotifier() {
		job.launcheWeatherAnalysis();
	}

}
