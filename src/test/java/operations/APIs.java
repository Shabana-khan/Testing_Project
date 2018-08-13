package operations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;
import utilities.TakeScreenshot;

public class APIs {
	private WebDriver driver;

	ElementGenerator elementGenerator = new ElementGenerator();

	public APIs(WebDriver driver) {
		this.driver = driver;
	}

	// save screenshot

	public String saveScreenshot(String testcase, String object, String value, Properties or) {
		if (TakeScreenshot.captureScreenshot(driver, testcase)) {
			System.out.println("Inside " + testcase);
			return Constants.PASS;
		} else {
			return Constants.FAIL;
		}
	}

	// save data

	public String saveValue(String filename, String object, String value, Properties or) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			fileIn = new FileInputStream("./src/test/resources/objectRepository/" + filename + ".properties");
			configProperty.load(fileIn);
			configProperty.setProperty(object, value);
			fileOut = new FileOutputStream("./src/test/resources/objectRepository/" + filename + ".properties");
			configProperty.store(fileOut, "");
			return Constants.PASS;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Constants.FAIL;
		}
	}

	// Wait for the element to load
	public String waitForElement(String testcase, String object, String value, Properties or) {
		try {
			int timeInSeconds = Integer.parseInt(value);
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementGenerator.getObject(object, or)));

			System.out.println("Inside " + testcase);
			return Constants.PASS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.FAIL;
		}

	}

	// Checks if an element is present or not
	public String checkForElement(String testcase, String object, String value, Properties or) {
		try {
			System.out.println("Inside " + testcase);
			if (driver.findElement(elementGenerator.getObject(object, or)).isDisplayed()) {
				return Constants.PASS;
			} else {
				return Constants.PASS;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.FAIL;
		}

	}

	// enter text into the text box
	public String setText(String testcase, String object, String value, Properties or) {
		try {
			driver.findElement(elementGenerator.getObject(object, or)).sendKeys(value);
			System.out.println("Inside " + testcase);
			return Constants.PASS;
		} catch (Exception e) {
			saveScreenshot(testcase, object, value, or);
			System.out.println(e.getMessage());
			return Constants.FAIL;
		}

	}

	// click button
	public String clickBtn(String testcase, String object, String value, Properties or) {
		try {
			WebElement btn = driver.findElement(elementGenerator.getObject(object, or));
			new Actions(driver).moveToElement(btn).perform();
			btn.click();
			System.out.println("Inside " + testcase);
			return Constants.PASS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.FAIL;
		}

	}

	// click link
	public String clickLink(String testcase, String object, String value, Properties or) {

		try {
			WebElement link = driver.findElement(elementGenerator.getObject(object, or));
			new Actions(driver).moveToElement(link).perform();
			link.click();
			return Constants.PASS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.FAIL;
		}

	}

}
