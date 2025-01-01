Feature: Add a Book in the Library

  Scenario: Add a book with valid details
    When I add a book with title "The Book New" and author "The Author New"
    Then the response status code should be 201
    And the response should contain the added book details with title "The Book New" and author "The Author New"

  Scenario: Add a book with invalid credentials
    Given I have invalid username and password
    When I add a book with id 5 title "The Book Anonymous" and author "The Author Anonymous" using invalid credentials
    Then the response status code should be 401

  Scenario: Add a book with missing author field
    When I add a book with title "The Book Without Author" and no author
    Then the response status code should be 400
    And the response should contain error "Author is required"

  Scenario: Add a book with existing data
    Given the library already contains a book with title "Existing Book" and author "Existing Author"
    When I add a book with title "Existing Book" and author "Existing Author"
    Then the response status code should be 409
    And the response should contain error "Book Already Exists"

  Scenario: Add a Book with a Negative ID
    When I add a book with a negative ID -10 with title "The Book Negative ID" and author "Author Negative ID"
    Then the response status code should be 201
    And the response should contain the added book details with id -10, title "The Book Negative ID" and author "Author Negative ID"

  Scenario: Add a Book with an Existing ID but Different Title and Author
    Given the library already contains a book with id 1, title "Original Book", and author "Original Author"
    When I add a book with id 1, title "Different Title", and author "Different Author"
    Then the response status code should be 201
    And the response should contain the updated book details with id 1, title "Different Title" and author "Different Author"

  Scenario: Add a Book with Special Characters in Title and Author
    When I add a book with title "$pecial@Title!" and author "Auth#or$pecial"
    Then the response status code should be 201
    And the response should contain the added book details with title "$pecial@Title!" and author "Auth#or$pecial"

  Scenario: Add a Book Without User
    When I add a book with title "Unauthorized Book" and author "No User" without providing user credentials
    Then the response status code should be 401
    And the response should contain error "Unauthorized"