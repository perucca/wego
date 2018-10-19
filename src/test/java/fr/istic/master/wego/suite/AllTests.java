package fr.istic.master.wego.suite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import fr.istic.master.wego.domain.RequiredWeatherValidatorTest;
import fr.istic.master.wego.service.openweather.OpenWeatherServiceTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({
	//ModelTest.class,
	OpenWeatherServiceTest.class,
	RequiredWeatherValidatorTest.class
	})
public class AllTests {

}
