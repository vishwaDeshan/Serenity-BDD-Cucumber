Feature: Search Functionality
  Verify the search bar works as expected.

  @search
  Scenario: Search for an existing product
    Given I am on the search page
    When I search for "Tomato"
    Then I should see results containing "Tomato"

  @search
  Scenario: Search for a non-existing product
    Given I am on the search page
    When I search for "InvalidProductName"
    Then I should see a message indicating no results
