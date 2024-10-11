@order4
Feature: Searching for specific Quarter

	Scenario:  User serach for specific Quarter
	
		Given user is on client home page
		When user click on Accounting button
		And User click on activity statement
	 Then user is on client Activity statement page
		And User enter the From date on Xero software
		And User enter the To date on Xero software
		And User click the update button again