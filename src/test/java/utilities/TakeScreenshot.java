package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenshot {

	public static boolean captureScreenshot(WebDriver driver, String filename) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desiredFile;

		// System.out.println(desiredFile);
		try {
			if (driver instanceof FirefoxDriver) {
				desiredFile = new File("./test-output/screenshots/Firefox/" + filename + ".jpg");
				Files.deleteIfExists(desiredFile.toPath());
				// System.out.println(Files.deleteIfExists(desiredFile.toPath()));
				FileUtils.copyFile(screenshot, new File("./test-output/screenshots/Firefox/" + filename + ".jpg"));
			} else if (driver instanceof ChromeDriver) {
				desiredFile = new File("./test-output/screenshots/Chrome/" + filename + ".jpg");
				Files.deleteIfExists(desiredFile.toPath());
				// System.out.println(Files.deleteIfExists(desiredFile.toPath()));
				FileUtils.copyFile(screenshot, new File("./test-output/screenshots/Chrome/" + filename + ".jpg"));
			}

			return true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
