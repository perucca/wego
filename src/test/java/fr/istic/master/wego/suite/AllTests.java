package fr.istic.master.wego.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.istic.master.wego.model.TestModel;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses(TestModel.class)
public class AllTests extends TestSuite {

}
