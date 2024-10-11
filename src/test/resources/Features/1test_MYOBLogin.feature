@order1

Feature: Verify User is able to do login

  Scenario: Verify user is on Login Page
  
    Given User user is on MYOB Login Page
    When user enter email on MYOB
    Then click on next button
    And user enter password on MYOB
    Then click on signin button