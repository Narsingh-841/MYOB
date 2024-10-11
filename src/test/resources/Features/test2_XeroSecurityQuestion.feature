@order2
Feature: Verify User is able to do login by passing security questions

  Scenario: Verify user able to pass security Answer
    Given User wants to enter security ans
    When user enter security question ans
    Then user subit the Answer