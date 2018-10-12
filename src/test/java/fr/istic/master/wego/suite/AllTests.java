package fr.istic.master.wego.suite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import fr.istic.master.wego.domain.RequiredWeatherValidatorTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({
	//ModelTest.class, 
	RequiredWeatherValidatorTest.class
	})
public class AllTests {

}
