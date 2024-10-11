@order3
Feature: Searching for specific Quarter

	Scenario:  User serach for specific Quarter
	
		Given Client Activity statements
		When user click on History Button
		And User click the Filter button
		And User enter the From date as provided in excel
		And User enter the To date as provided in excel
		And User click the Filter button again
