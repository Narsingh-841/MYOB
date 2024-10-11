@order1
Feature: Verify User is able to do login

  Scenario: Verify user is on Login Page
  
    Given User user is on Login Page
    When user enter email 
    And user enter password 
    Then click on xero login button
    When user click on another authentication method
    And click on security Questions