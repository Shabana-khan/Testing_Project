# Test and verify addition of any two products to the EBAY shopping cart in Chrome and Firefox

## Test Aim - 

1. To search for a any two products and adding to the cart.
2. To verify if the selected products are present in the cart

## Test Frameworks - 

Selenium with Cucumber(BDD)framework

1. Selenium Hybrid Framework:
	- Using excel data sheet to define test steps and pass test data
	- Maintaining page elements in separate files
	- Defining common functionalities in separate files
	
2. Cucumber reporting Framework:
	- Using Gherkin to define test behaviour
	- Step definitions to call basic test functions
	- Test runner to invoke multiple test scenarios

## Test Scenarios - 

1. Two separate scenarios to open the URL in Chrome and Firefox respectively
2. Run the test steps from the excel data sheet
3. Close the browser

## Test Data - 

The user can input data in the excel sheet in below format:

**Columns**
1.TestName - Any text to define the test step		Object	Value
2.PageName - Name of the web page to which the element belongs. 
			 Allowed values are:
			 - homepage-EBay home page
			 - productpage-Corresponding product page
			 - shoppingcartpage-Shopping cart page
			 - savedObjectpage-Mock page for saving a value for later use in the script	
3.API - The action to be performed. The allowed actions are:
		- setText - To enter any text
		- saveValue - To save the object value set in a previous step
		- saveScreenshot - To save the screenshots for a previous step
		- clickBtn - To click a button
		- waitForElement - To explicitly wait for an element
		- clickLink - To click a link
		- checkForElement - To check if an element is present or not
4.Object - The element name as stored in the project's Object Repository for the respective page. **Note : In order to save an element, append the element name with the type od element it needs to be saved as. Ex: To save loginBtn element as a link enter the object as loginBtn_link**
5.Value - The value that needs to be entered for the corresponding object.

The browser name, URL, excel sheet name and file name are passed in cucumber feature files.

## Test Output
The test result is saved inside directory mentioned in the Cucumber runner file.

## Project Structure
1. **src/test/java** - Contains common functionalities like Driver initialisation, Actual implementation of actions specified in the excel sheet, Generating elements based on different locators,  Excel file reader, snapshot functions, other utilities, cucumber step definitions and test runners.  
2. **src/test/resources** - Contains browser drivers,, Object repository, Cucumber feature files
3. **test-output** - Stores test snapshots
