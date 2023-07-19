Feature: API Test
As a API Tester I should able to get response from ReqRes app

  @api
  Scenario: Example Get Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a GET request
    Then I should receive a response with status code 200
    Then I should get "data.id" as "2"
    Then I should get "data.email" as "janet.weaver@reqres.in"


  @api
  Scenario: Example Post Scenario
    Given I have set the "base_url"
    And I have set the path "users"
    And I have set the content type to "application"
    When I perform a POST request to with payload "post_request"
    Then I should receive a response with status code 201

  @api
  Scenario: Example Put Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a PUT request to with payload "put_request"
    Then I should receive a response with status code 200

  @api
  Scenario: Example Delete Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a DELETE request
    Then I should receive a response with status code 204   
