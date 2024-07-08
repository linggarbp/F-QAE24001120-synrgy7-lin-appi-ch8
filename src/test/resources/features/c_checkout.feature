Feature: Checkout

  Scenario: Checkout two items
    Given User login with valid username and password
    And User add to cart first item
    And User add to cart second item
    And User click on cart button
    And User click on checkout button
    And User input firstname lastname and postalcode
    And User click on continue button
    When User click on finish button
    Then User is on complete page