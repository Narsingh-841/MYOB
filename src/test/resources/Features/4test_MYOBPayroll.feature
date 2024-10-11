@order4

Feature: Extract the Payroll Activity values from MYOB software 

	Scenario:  User want to extract Payroll Activity Report
	
		Given user is on report page
		When user click on payroll activity
		Then user enetr from date
		Then user enter to date
		Then user extract W1 and W2 value
		When user click on reporting