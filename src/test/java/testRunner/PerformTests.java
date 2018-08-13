package testRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import operations.APIs;
import operations.EnvironmentSetup;
import utilities.Constants;
import utilities.ExcelReader;
import utilities.PathUtility;

public class PerformTests extends EnvironmentSetup {

	public Properties OR;
	public FileInputStream fis;
	public APIs apis;
	public Method[] method;
	public int totalAPIs;
	public ExcelReader excelFile;

	public PerformTests(String sheetName, String fileName) throws IOException, FileNotFoundException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		OR = new Properties();

		// load all APIs
		apis = new APIs(DRIVER);
		method = apis.getClass().getMethods();
		totalAPIs = method.length;

		// load excel sheet
		excelFile = new ExcelReader(PathUtility.EXCEL_FILE_PATH + fileName + ".xlsx");

		// Fetch total rows in the specified sheet
		int totalRows = excelFile.getTotalRows(sheetName);

		// check if sheet is not empty
		if (totalRows != 0) {
			ArrayList<String> pagenames = new ArrayList<String>();
			String previousValue = "";
			// iterate through each row in the sheet
			for (int rowindex = 1; rowindex < totalRows; rowindex++) {
				// Fetch the Test Case, Page Name, API, Object
				// Value
				String currentTestCase = excelFile.getCellValue(sheetName, Constants.TESTCASE, rowindex);
				// System.out.println(currentTestCase);
				String currentPageName = excelFile.getCellValue(sheetName, Constants.PAGENAME, rowindex);
				// System.out.println(currentPageName);
				String currentAPI = excelFile.getCellValue(sheetName, Constants.API, rowindex);
				// System.out.println(currentAPI);
				String currentObject = "";
				if (excelFile.getCellValue(sheetName, Constants.OBJECT, rowindex) != "") {
					currentObject = excelFile.getCellValue(sheetName, Constants.OBJECT, rowindex);
				}
				// System.out.println(currentObject);
				String currentValue = "";
				// System.out.println(currentValue);
				if (excelFile.getCellValue(sheetName, Constants.VALUE, rowindex) != "") {
					currentValue = excelFile.getCellValue(sheetName, Constants.VALUE, rowindex);
					previousValue = currentValue;
				} else {
					currentValue = previousValue;
				}

				if (!pagenames.contains(currentPageName)) {
					pagenames.add(currentPageName);
					fis = new FileInputStream(
							"./src/test/resources/objectRepository/" + currentPageName.toLowerCase() + ".properties");
					OR.load(fis);
					fis.close();
				}

				if (currentAPI != null) {
					for (int apiIndex = 0; apiIndex < totalAPIs; apiIndex++) {
						boolean invokeMethodSuccess = false;
						if (method[apiIndex].getName().equals(currentAPI)) {

							if (method[apiIndex].getName() == "saveValue") {
								invokeMethodSuccess = method[apiIndex]
										.invoke(apis, currentPageName, currentObject, currentValue, OR)
										.equals(Constants.FAIL);
							} else {
								invokeMethodSuccess = method[apiIndex]
										.invoke(apis, currentTestCase, currentObject, currentValue, OR)
										.equals(Constants.FAIL);
							}
							if (invokeMethodSuccess) {
								System.out.println("Failed");
							} else {
								System.out.println("Passed");
							}
						}
					}
				}
			}
		}

	}
}
