@order9
Feature: Extracting GST Reconicliatio values

	Scenario:  User want to extract the GST Reconciliation statement of client
	
		Given User is on Balance Sheet page of client
		When user click on the Accounting Button
		And User click the GST Reconciliation Button
		Then User click on export Drop down Button
		And User click on excel option