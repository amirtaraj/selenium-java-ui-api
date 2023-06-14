Feature: ODNxt API Test

  @api
  Scenario: Agreement GET Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "agreement"
    When I perform a GET request
    Then I should receive a response with status code 200
    Then I should get "agreementKey[0]" as "1001"
    Then I should get "agreementNumber[1]" as "10235"
    Then I should get "salesLocation[4]" as "Vietnam"


  @api
  Scenario: Review GET Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "review"
    When I perform a GET request
    Then I should receive a response with status code 200
    Then I should get "reviewKey[0]" as "1001"
    Then I should get "agreementNumber[2]" as "10236"
    Then I should get "assignedTo[3]" as "John, Snow"

  @notinclude
  Scenario: Example Get Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a GET request
    Then I should receive a response with status code 200
    Then I should get "data.id" as "2"
    Then I should get "data.email" as "janet.weaver@reqres.in"


  @notinclude
  Scenario: Example Post Scenario
    Given I have set the "base_url"
    And I have set the path "users"
    And I have set the content type to "application"
    When I perform a POST request to with payload "post_request"
    Then I should receive a response with status code 201

  @notinclude
  Scenario: Example Put Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a PUT request to with payload "put_request"
    Then I should receive a response with status code 200

  @notinclude
  Scenario: Example Delete Scenario
    Given I have set the "base_url"
    And I have set the content type to "application"
    And I have set the path "users" with param "2"
    When I perform a DELETE request
    Then I should receive a response with status code 204   
