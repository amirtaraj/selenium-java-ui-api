Feature: ODNxt API Test

  @smoke
  Scenario: Example Get Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a GET request
    Then I should receive a response with status code 200
