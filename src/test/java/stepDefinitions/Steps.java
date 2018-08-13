package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import operations.EnvironmentSetup;
import testRunner.PerformTests;
import utilities.PathUtility;

public class Steps extends EnvironmentSetup {
	@Given("Open the {string} and launch the application {string}")
	public void open_the_and_launch_the_application(String string, String string2) {
		// setting driver
		if (string2.equalsIgnoreCase("EBAY")) {
			setDriver(string, PathUtility.EBAYURL);
		}
	}

	@Then("Run the test cases from {string} sheet in {string}")
	public void run_the_test_cases_from_sheet_in(String string, String string2) throws FileNotFoundException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		new PerformTests(string, string2);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		// closing driver
		DRIVER.close();
	}
}
