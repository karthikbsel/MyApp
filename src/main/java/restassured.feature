Feature: Incident Management
  Scenario: Create a new incident
    Given Set the endpoint
    And set the authorisation
    And set the contentType as json
    When you send the request as post
    Then verify the status code is 201
    



