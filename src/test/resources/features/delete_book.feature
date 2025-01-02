Feature: Delete a Book from the Library

  Scenario: Successfully delete a book
    Given I delete the book with id 1
    Then the response code should be 200 for successful deletion

  Scenario: Attempt to delete a non-existent book
    Given I try to delete a book with an invalid id 99
    Then the response code should be 404 for non-existent book

  Scenario: Unauthorized user attempts to delete a book
    Given an unauthorized user tries to delete the book with id 1
    Then the response code should be 403 for unauthorized deletion

  Scenario: Delete a book using case-sensitive admin credentials
    Given I try to delete the book with id 2 using case-sensitive admin credentials
    Then the response code should be 401 for case-sensitive admin credentials

  Scenario: Delete a book using case-sensitive user credentials
    Given I try to delete the book with id 2 using case-sensitive user credentials
    Then the response code should be 401 for case-sensitive user credentials

