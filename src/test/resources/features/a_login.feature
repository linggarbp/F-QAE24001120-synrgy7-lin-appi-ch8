Feature: Login

  Scenario: Login with valid username and password
    Given User is on login page
    And User input username with "standard_user"
    And User input password with "secret_sauce"
    When User click on login button
    Then User is on home page

  Scenario: Login with invalid password
    Given User is on login page
    And User input username with "standard_user"
    And User input password with "tomato_sauce"
    When User click on login button
    Then Error message is showing up