Feature: Add a Book in the Library

  Scenario: Add a book with valid details
    When I add a book with title "The Book New" and author "The Author New"
    Then the response status code should be 201
    And the response should contain the added book details with title "The Book New" and author "The Author New"