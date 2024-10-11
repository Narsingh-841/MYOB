@order5

Feature: Extract the Aged Receivable values from MYOB software 

	Scenario:  User want to extract Receivables reconciliation with tax report
	
		Given user is on the report page 
		When user click on Receivables reconciliation with tax report
		Then user enter the to date
		Then user extract aged receivable value
		When user click on the reporting