Feature: Navigation Functionality
  Verify that the navigation features of the application work as expected.

  @navigation
  Scenario: Navigate to the Offers Page
    Given I am on the home page
    When I navigate to the Offers Page
    Then I should be redirected to the Offers Page
