package operations;

import java.util.Properties;

import org.openqa.selenium.By;

public class ElementGenerator {
	// Find element by using object value
	public By getObject(String objectName, Properties OR) throws Exception {
		String objectType = "";
		String objName = "";
		if (objectName.contains("_")) {
			objectType = objectName.split("_")[1];
			objName = OR.getProperty(objectName.split("_")[0]);
		} else {
			objectType = OR.getProperty(objectName).split("#")[0];
			objName = OR.getProperty(objectName).split("#")[1];
		}

		// Find by id
		if (objectType.equalsIgnoreCase("ID")) {

			return By.id(objName);
		}
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(objName);
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(OR.getProperty(objName));

		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {

			return By.name(OR.getProperty(objName));

		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(OR.getProperty(objName));

		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {
			return By.linkText(objName);

		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(OR.getProperty(objName));

		}
		// Find by tagname
		else if (objectType.equalsIgnoreCase("TAGNAME")) {

			return By.tagName(OR.getProperty(objName));
		}
		// Find by text
		else if (objectType.equalsIgnoreCase("TEXT")) {

			return By.tagName(objName);
		} else {
			System.out.println(objectName);
			throw new Exception("Wrong object type");
		}
	}
}
