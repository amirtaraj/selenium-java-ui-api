Feature: ODNxt API Test

  @smoke
  Scenario: Example Get Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a GET request
    Then I should receive a response with status code 200

  @smoke
  Scenario: Example Post Scenario
    Given I have set the "base_url"
    And I have set the path "users"
    And I have set the content type to "application"
    When I perform a POST request to with payload "post_request"
    Then I should receive a response with status code 201

  @smoke
  Scenario: Example Put Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a PUT request to with payload "put_request"
    Then I should receive a response with status code 200

  @smoke
  Scenario: Example Delete Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a DELETE request
    Then I should receive a response with status code 204   
