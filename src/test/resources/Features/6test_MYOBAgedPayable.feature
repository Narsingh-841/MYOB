@order6

Feature: Extract the Aged Payable values from MYOB software 

	Scenario:  User want to extract Payable reconciliation with tax report
	
		Given User is on report page 
		When user click on Payable reconciliation with tax report
		Then User enter the to date
		Then user extract aged Payable value
		When user click on the reporting button