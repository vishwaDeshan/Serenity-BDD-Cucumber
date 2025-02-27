Feature: Get Book Details from the Library

  Scenario: Get all books
    When I request all books
    Then the response code should be number 200
    And the response should contain a list of books

  Scenario: Get a book with user credentials
    Given I have user credentials
    When I request a book with id 3
    Then the response code should be number 200

  Scenario: Get a book by valid ID
    When I request a book with id 3
    Then the response code should be number 200
    And the response should contain the book details with id 3

  Scenario: Get a book with invalid ID
    When I request a book with an invalid id 99999
    Then the response code should be 404 for invalidate book id
    And the response should contain an error message "Not Found"

  Scenario: Get a book with invalid credentials
    Given I have invalid credentials
    When I request a book with id 3 using invalid credentials
    Then the response code should be number 401 invalidate credential
    And the response should contain an error message for invalid credential "Unauthorized"


#    ------------------------------------------------


  Scenario: Get all books without providing authorization
    Given I have invalid credentials
    Then request all books providing authorization
    Then the response code should be 401 for invalid string book id
    And the response should contain an error message "Unauthorized"


  Scenario: Get a book with invalid book id and user credentials (user role)
    Given I have user credentials
    When I request a book with id 123
    Then the response code should be for forbidden access 404
    And the response should contain an error message "Not Found"


  Scenario: Validate response structure of book details
    When I request a book with id 3
    Then the response code should be number 200
    And the response should contain the book details with fields "id", "title" and "author"

  Scenario: Fetch a book with an invalid string ID
    When I request a book with an invalid string id "abc"
    Then the response code should be 400 for invalid string book id
    And the response should contain an error message "Bad Request"
