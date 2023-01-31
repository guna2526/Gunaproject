package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.ReusableMethods;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags=("@Login"),features ="src\\test\\resources", dryRun = false,stepNotifications=true, plugin = {
		"pretty", "json:target/output.json" },glue="com.stepdefinition", monochrome = true)
public class TestRunnerClass extends ReusableMethods {
@AfterClass
public static void generteJVM() {
	Reporting.generateJVMReport(getProjectLoc()+"\\target\\output.json");
}
}
