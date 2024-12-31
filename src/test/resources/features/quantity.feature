Feature: Quantity Increment and Decrement
  Verify that clicking the plus and minus icons adjusts the quantity value correctly.

  @quantity
  Scenario: Increase quantity
    Given I am on the home page
    When I click the increment button
    Then the quantity value should increase by 1

  @quantity
  Scenario: Decrease quantity
    Given I am on the home page
    When I click the decrement button
    Then the quantity value should decrease by 1
