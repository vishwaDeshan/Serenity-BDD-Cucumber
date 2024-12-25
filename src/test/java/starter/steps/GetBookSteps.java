package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.apis.GetBookAPI;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookSteps {

    private GetBookAPI bookApi = new GetBookAPI();
    private Response response;

    @When("I request all books")
    public void i_request_all_books() {
        response = bookApi.getAllBooks();
    }

    @Then("the response code should be number {int}")
    public void the_response_code_should_be(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain a list of books")
    public void the_response_should_contain_a_list_of_books() {
        assertThat(response.jsonPath().getList("books")).isNotEmpty();
    }

    @Then("the response should contain an empty list of books")
    public void the_response_should_contain_an_empty_list_of_books() {
        assertThat(response.jsonPath().getList("books")).isEmpty();
    }

    @When("I request a book with id {int}")
    public void i_request_a_book_with_id(int id) {
        response = bookApi.getBookById(id);
    }

    @Then("the response should contain the book details with id {int}")
    public void the_response_should_contain_the_book_details_with_id(int id) {
        assertThat(response.jsonPath().getInt("id")).isEqualTo(id);
    }

    @When("I request a book with an invalid id {int}")
    public void i_request_a_book_with_an_invalid_id(int id) {
        response = bookApi.getBookByInvalidId(id);
    }

    @Then("the response code should be {int} for invalidate book id")
    public void the_response_code_should_be_for_invalid_book_id(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain an error message {string}")
    public void the_response_should_contain_an_error_message(String expectedMessage) {
        assertThat(response.jsonPath().getString("errorMessage")).isEqualTo(expectedMessage);
    }

    @Given("I have invalid credentials")
    public void i_have_invalid_credentials() {
        // No additional setup required here as invalid credentials are handled in the API call
    }

    @When("I request a book with id {int} using invalid credentials")
    public void i_request_a_book_with_id_using_invalid_credentials(int id) {
        response = bookApi.getBookWithInvalidCredentials(id);
    }
}
