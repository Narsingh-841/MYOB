@order7
Feature: Extract the Aged payable summary values from xero software 

	Scenario:  User want to extract Aged payable summary values
	
		Given user is on client Aged payable summary page
		When user click on accounting button
		When user click on aged payable summary button
		When user click on column to select the outstanding gst button
		When user click on outstanding gst button
		When user click on end of month button
		When user click on last financial year button
		When user click on update button
		Then user check if the Aged payable summary exist then the payable value is mentioned on web else Zero