@order5
Feature: Extracting ICA Statement

	Scenario:  User is on client Home page
	
		Given user is on client home page and want to extract ICA statement
		When User click on Accounts and payments
		Then User get menu bar 
		When User click on Activity Statement
		Then User click on filter
		And User clear from  date box and enter the From date as provided in excel
		Then User clear the To box and enter the To date as provided in excel
		When User click the Submit button 
		Then User click on PrintFriendlyVersion
		And User direct to new tab
		And User Extract activity statement
		And user close the tab
