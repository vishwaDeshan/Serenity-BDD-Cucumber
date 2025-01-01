package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.response.Response;
import starter.apis.PostBookAPI;

public class PostBookSteps {

    private PostBookAPI postBookAPI = new PostBookAPI();
    private Response response;

    // Scenario 1: Add a book with valid details
    @When("I add a book with title {string} and author {string}")
    public void iPostABookWithTitleAndAuthor(String title, String author) {
        response = postBookAPI.addBook(title, author);
    }

    @Then("the response status code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("the response should contain the added book details with title {string} and author {string}")
    public void theResponseShouldContainTheAddedBookDetails(String title, String author) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains("\"title\":\"" + title + "\"");
        assertThat(responseBody).contains("\"author\":\"" + author + "\"");
    }

    // Scenario 2: Add a book with invalid credentials
    @Given("I have invalid username and password")
    public void i_have_invalid_username_and_password() {
    }

    @When("I add a book with id {int} title {string} and author {string} using invalid credentials")
    public void i_add_a_book_with_id_title_and_author_using_invalid_credentials(Integer id, String title, String author) {
        response = postBookAPI.addBookWithInvalidCredentials(id, title, author);
    }

    // Scenario 3: Add a book with missing author field
    @When("I add a book with title {string} and no author")
    public void iAddABookWithTitleAndNoAuthor(String title) {
        response = postBookAPI.addBookWithoutAuthor(title);
    }

    @Then("the response should contain error {string}")
    public void theResponseShouldContainError(String errorMessage) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains(errorMessage);
    }

    // Scenario 4: Add a book with existing data
    @Given("the library already contains a book with title {string} and author {string}")
    public void theLibraryAlreadyContainsABookWithTitleAndAuthor(String title, String author) {
        response = postBookAPI.addBook(title, author);
        assertThat(response.getStatusCode()).isEqualTo(201); // Ensure the book was added
    }
    // Scenario 5: Add a Book with a Negative ID
    @When("I add a book with a negative ID {int} with title {string} and author {string}")
    public void i_add_a_book_with_a_negative_ID_with_title_and_author(Integer id, String title, String author) {
        response = postBookAPI.addBookWithNegativeID(id, title, author);
    }

    @Then("the response should contain the added book details with id {int}, title {string} and author {string}")
    public void the_response_should_contain_the_added_book_details_with_id_title_and_author(Integer id, String title, String author) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains("\"id\":" + id);
        assertThat(responseBody).contains("\"title\":\"" + title + "\"");
        assertThat(responseBody).contains("\"author\":\"" + author + "\"");
    }

    // Scenario 6: Add a Book with an Existing ID but Different Title and Author
    @Given("the library already contains a book with id {int}, title {string}, and author {string}")
    public void the_library_already_contains_a_book_with_id_title_and_author(Integer id, String title, String author) {
        response = postBookAPI.addBookWithID(id, title, author);
        assertThat(response.getStatusCode()).isEqualTo(201); // Ensure the book was added
    }

    @When("I add a book with id {int}, title {string}, and author {string}")
    public void i_add_a_book_with_id_title_and_author(Integer id, String title, String author) {
        response = postBookAPI.addBookWithExistingIDDifferentData(id, title, author);
    }

    @Then("the response should contain the updated book details with id {int}, title {string} and author {string}")
    public void the_response_should_contain_the_updated_book_details_with_id_title_and_author(Integer id, String title, String author) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains("\"id\":" + id);
        assertThat(responseBody).contains("\"title\":\"" + title + "\"");
        assertThat(responseBody).contains("\"author\":\"" + author + "\"");
    }

    // Scenario 7: Add a Book with Special Characters in Title and Author
    @When("I add a book with title {string} and author {string}")
    public void i_add_a_book_with_title_and_author(String title, String author) {
        response = postBookAPI.addBook(title, author);
    }

    // Scenario 8
    // : Add a Book Without User
    @When("I add a book with title {string} and author {string} without providing user credentials")
    public void i_add_a_book_with_title_and_author_without_providing_user_credentials(String title, String author) {
        response = postBookAPI.addBookWithoutUser(title, author);
    }


}
