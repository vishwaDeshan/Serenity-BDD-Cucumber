Feature: Add to Cart Functionality
  Verify that the "Add to Cart" button works as expected.

  @addtocart
  Scenario: Add a product to the cart successfully
    Given I am on the products page
    When I click the "Add to cart" button for "Brocolli - 1 Kg"
    Then the "Add to cart" button should change to "✔ ADDED"
#    And the button color should change from "green" to "orange"
