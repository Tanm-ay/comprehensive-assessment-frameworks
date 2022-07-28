package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber/features", glue = "cucumber/stepdefinitions", stepNotifications = true)
public class CucumberRunner
{
	/*
	 * The tests sometimes run extremely slowly, might be due to webdriver problems
	 * that have been around lately. But apart from that everything works as
	 * expected.
	 */
}
