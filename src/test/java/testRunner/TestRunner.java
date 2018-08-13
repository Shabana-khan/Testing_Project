package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions" }, plugin = {
		"json:target/cucumber-json/ebay-reports" }, dryRun = false, monochrome = true, tags = {
				"@chromeScenario,@firefoxScenario" })
public class TestRunner {

}