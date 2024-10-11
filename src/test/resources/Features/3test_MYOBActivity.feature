@order3

Feature: User is on reports page

  Scenario: User want to extract gstReturn
  
    Given User is on reports page
    When user click on  gst return button 
    Then User enter from and to date 
    And User extract A1 B1 and G1 
    Then User click on reporting and reports button