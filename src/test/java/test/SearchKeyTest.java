package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchKeyTest{
	public static WebDriver driver;
	ExecuteTest et = new ExecuteTest();
	
		public void openBrowser(String object, String value, String browser){
			//setting system properties
			System.setProperty(et.CONFIG.getProperty(object), et.CONFIG.getProperty(value)+".exe");
			
			//instantiate driver
			switch(browser){
			case "chrome":
				driver = new ChromeDriver();
			}
		}
		
		
		//open web page
		public void openWebPage(){
			driver.get(et.CONFIG.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		//search in webpage
		public void searchKey(String key){
			driver.findElement(By.id("gh-ac")).sendKeys("sony tv");
			driver.findElement(By.id("gh-btn")).click();			
		}
		
	
}