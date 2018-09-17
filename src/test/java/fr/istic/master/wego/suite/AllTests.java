package fr.istic.master.wego.suite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import fr.istic.master.wego.domain.RequiredWeatherValidatorTest;
import fr.istic.master.wego.model.ModelTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ModelTest.class, RequiredWeatherValidatorTest.class})
public class AllTests {

}
