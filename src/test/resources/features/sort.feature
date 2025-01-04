Feature: Sorting Functionality
  Verify the sorting of vegetable/fruit names.


  @sort
  Scenario: Sort vegetable/fruit names in ascending order
    Given I am on the offers page
    When I click on the "Veg/fruit name" column header
    Then the names should be sorted in ascending order

  @sort
  Scenario: Sort vegetable/fruit names in descending order
    Given I am on the offers page
    When I click on the "Veg/fruit name" column header twice
    Then the names should be sorted in descending order

