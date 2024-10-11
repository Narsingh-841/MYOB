@order4
Feature: Extracting data values from a Quarter

	Scenario: User want to extract the values for JULY Quarter 
	
	Given All the filtered Quarter are visible to user
		When user click on July Quarter
		Then July Quarter will get open
	
		Given All the filtered Quarters are visible to user
		When user click on October Quarter
		Then October Quarter will get open
	
		Given All the filtered Quarter are visible to the user
		When user click on January Quarter
		Then January Quarter will get open
	
		Given All the filtered Quarters are visible to the user
		When user click on April Quarter
		Then April Quarter will get open
		
		
		