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
        // This step doesn't need to do anything specific because the credentials are handled in the API call itself.
        // We're simulating the invalid username and password scenario.
    }

    @When("I add a book with id {int} title {string} and author {string} using invalid credentials")
    public void i_add_a_book_with_id_title_and_author_using_invalid_credentials(Integer id, String title, String author) {
        // Send POST request with invalid credentials
        response = postBookAPI.addBookWithInvalidCredentials(id, title, author);
    }
}
