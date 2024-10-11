@order3 
Feature: Search for specific client name

	Scenario: I am on homepage of XERO and I search for specific name
	
		Given I am on home page of XERO
		When I enter client name in search box of XERO
		And I press enter keyword of XERO
		Then I should land on client home screen of XERO
