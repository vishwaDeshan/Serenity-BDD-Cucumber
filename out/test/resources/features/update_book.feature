Feature: Update a Book in the Library

  Scenario: Update a book details
    Given I update the book with id 2 to title "The_book_new" and author "Author_new"
    Then the response code should be 200
    And the response should contain the updated book details with title "The_book_new" and author "Author_new"


  Scenario: Update a book with an invalid ID
    Given I try to update a book with an invalid id 99999
    Then the response code should be 404 for invalid book id

  Scenario: Update a book with invalid JSON format
    Given I try to update a book with invalid JSON format
    Then the response code should be 400 for invalid JSON

