package operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class test {
	public static Properties OR;
	public static FileInputStream fis;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OR = new Properties();
		fis = new FileInputStream("./src/test/java/objectRepository/homepage.properties");
		OR.load(fis);
		fis.close();
		String objectType = OR.getProperty("homesearchtextbox").split("\\(")[0];
		System.out.println(objectType);
	}

}
