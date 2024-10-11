@order8
Feature: Extract the Balance Sheet Values from xero software 

	Scenario:  User want to extract Balance Sheet Values 
	
		Given User is on client Aged Recievable summary page
		When User click on the accounting button
		And user click on Balance Sheet button
		Then user extract the GST value from balance sheet page