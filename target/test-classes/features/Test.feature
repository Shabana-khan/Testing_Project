Feature: Adding products to the shopping cart 

@chromeScenario
Scenario: Verify the selected products in shopping cart in chrome

Given Open the "chrome" and launch the application "ebay"			

Then Run the test cases from "Chrome_EbayTest" sheet in "ebayTestData"		

Then Close the browser		

@firefoxScenario
Scenario: Verify the selected products in shopping cart in firefox

Given Open the "firefox" and launch the application "ebay"		

Then Run the test cases from "Firefox_EbayTest" sheet in "ebayTestData"		

Then Close the browser	
