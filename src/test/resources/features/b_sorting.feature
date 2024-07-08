Feature: Sorting

  Scenario: Sorting item low to high price
    Given User login with valid username and password
    And User click on sorting button
    When User click on low to high button
    Then Items are lined up in order of low to high price