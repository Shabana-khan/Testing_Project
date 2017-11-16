package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExecuteTest {
	public static Properties CONFIG = new Properties();

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub

		//loading Config file
		FileInputStream fis = new FileInputStream("./src/test/java/config/config.properties");
		CONFIG.load(fis);
		fis.close();
		
		SearchKeyTest skt = new SearchKeyTest();
		skt.openBrowser("chromedriver", "chromedriverpath", "chrome");
		skt.openWebPage();
		skt.searchKey("sony tv");
	}

}
