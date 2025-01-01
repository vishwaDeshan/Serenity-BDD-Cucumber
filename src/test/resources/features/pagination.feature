Feature: Offer Page Pagination
  Scenario: Navigate to Google
    Given I open Google in a browser

  Scenario: Navigate to the Offer page and click the first page
    Given I am on the Offer page
    When I click on the first page button
    Then I should be on the first page

  Scenario: Navigate to the Offer page and click the second page
    Given I am on the Offer page
    When I click on the second page button
    Then I should be on the second page

  Scenario: Navigate to the Offer page and click the next button
    Given I am on the Offer page
    When I click on the next button
    Then I should be on the next page

  Scenario: Navigate to the Offer page and click the previous button
    Given I am on the Offer page
    When I click on the previous button
    Then I should be on the previous page

  Scenario: Navigate to the Offer page and click the last page
    Given I am on the Offer page
    When I click on the last page button
    Then I should be on the last page

  Scenario: Navigate to the Offer page and click on a specific page (e.g. page 3)
    Given I am on the Offer page
    When I click on the page "3" button
    Then I should be on the page "3"