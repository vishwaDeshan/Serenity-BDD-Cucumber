Feature: Delete a Book from the Library

  Scenario: Successfully delete a book
    Given I delete the book with id 1
    Then the response code should be 200 for successful deletion

  Scenario: Attempt to delete a non-existent book
    Given I try to delete a book with an invalid id 99999
    Then the response code should be 404 for non-existent book

  Scenario: Unauthorized user attempts to delete a book
    Given an unauthorized user tries to delete the book with id 1
    Then the response code should be 403 for unauthorized deletion


