Feature: Offer Page Pagination Functionality
  Verify the pagination works as expected.

  Scenario: Verify the pagination buttons are working
    Given I am on the "offers" page with pagination
    When I click on the next page button
    Then the page number should update to 2

  Scenario: Verify the "Previous" button works correctly
    Given I am on the "offers" page with pagination
    When I click on the next page button
    When I click on the previous page button
    Then the page number should update to click previous 1
#