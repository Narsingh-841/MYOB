@order2 
Feature: Search for specific client name

	Scenario: I am on homepage and I search for specific name
	
		Given I am on home page
		When I enter client name in search box
		And I press enter keyword
		Then I should land on client home screen
		When I go to Lodgments 
		And Select Activity statements 
		