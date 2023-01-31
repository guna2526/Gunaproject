package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.ReusableMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookClass extends ReusableMethods{
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
		maximizeWindow();
	}
@After
public void afterScenario(Scenario scenario) {
	scenario.attach(screenshot(),"images/png", "EveryScenario");
	closeAllWindows();

}
}
