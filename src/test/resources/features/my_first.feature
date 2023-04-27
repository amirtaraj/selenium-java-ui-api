Feature: ODNxt
  As a user I should able to navigate to ODNXT app

  Scenario: Dashboard Page
    Given I navigate to "https://odnxt-web-automation-template.azurewebsites.net/"
    Then I wait for 2 sec
    Then I select "2023" option by value from dropdown having id "select_fiscalYear"
    Then option "2023" by value from dropdown having id "select_fiscalYear" should be selected
    Then I wait for 2 sec
    When I click on element having id "th_reviewId_1001"
    Then I take screenshot
    Then element having xpath "//div[contains(text(),'1001')]" should have partial text as "1001"
