Feature: MYOB Balance Sheet Operations

  Background:
    Given User is on the report page

  @order7
Scenario: User wants to extract GST values of balance sheet
  Given User is on the report page
  When user clicks on Balance Sheet report
  Then User enters the to date at balance sheet page
  Then user extracts GSTCollected, GSTPaid, GSTActual, GSTLastYear
  When user clicks on the reporting and reports button