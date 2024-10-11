@order6
Feature: Extract the Aged Recievable summary values from xero software 

	Scenario:  User want to extract Aged Recievable summary values
	
		Given user is on client Aged Recievable summary page
		When User click on accounting button
		When User click on aged Recievable summary button
		When User click on column to select the outstanding gst button
		When User click on outstanding gst button
		When User click on end of month button
		When User click on last financial year button
		When User click on update button
		Then User check if the Aged Recievable summary exist then the Recievable value is mentioned on web else Zero