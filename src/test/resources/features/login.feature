Feature: check login functionality

  Scenario: check login is successful with valid credentials
    Given user on login page
    When user enters valid username and password
    And clicks on login button
    Then user is navigated to the homepage