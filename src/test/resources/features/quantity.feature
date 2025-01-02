Feature: Quantity Management
  Test the quantity increase and decrease functionalities.

  @quantity
  Scenario: Verify quantity increment and decrement
    Given I am on the home page
    When I click the increment button
    Then the quantity value should increase by 1
    When I click the decrement button
    Then the quantity value should decrease by 1
