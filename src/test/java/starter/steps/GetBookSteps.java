package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import starter.apis.GetBookAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @Then("the response code should be for forbidden access {int}")
    public void the_response_code_should_be_for_forbidden_access(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain an error message {string}")
    public void the_response_should_contain_an_error_message(String expectedMessage) {
        int statusCode = response.statusCode();
        Map<Integer, String> statusMessages = getIntegerStringMap();
        String statusMessage = statusMessages.getOrDefault(statusCode, "Unknown Status");
        assertThat(statusMessage).isEqualTo(expectedMessage);

    }

    @Given("I have invalid credentials")
    public void i_have_invalid_credentials() {
        response = bookApi.getAllBooksByInvalidCredential();
    }

    @When("I request a book with id {int} using invalid credentials")
    public void i_request_a_book_with_id_using_invalid_credentials(int id) {
        response = bookApi.getBookWithInvalidCredentials(id);
    }
  
    @When("I request all books without authorization")
    public void i_request_all_books_without_authorization() {
        response = bookApi.getAllBooksWithoutAuthorization();
    }
    @Then("request all books providing authorization")
    public void i_request_all_books_invalid_credentials() {
        response = bookApi.getAllBooks();
    }

    @Given("I have user credentials")
    public void i_have_user_credentials() {
        response = bookApi.getBooksWithUserRole();
    }

    @When("I request all books using user credentials")
    public void i_request_all_books_using_user_credentials() {
        response = bookApi.getBooksWithUserRole();
    }



    @Then("the response should contain the book details with fields {string}, {string}, {string}, and {string}")
    public void the_response_should_contain_the_book_details_with_fields(String idField, String titleField, String authorField, String priceField) {
        assertThat(Optional.ofNullable(response.jsonPath().get(idField))).isNotNull();
        assertThat(Optional.ofNullable(response.jsonPath().get(titleField))).isNotNull();
        assertThat(Optional.ofNullable(response.jsonPath().get(authorField))).isNotNull();
        assertThat(Optional.ofNullable(response.jsonPath().get(priceField))).isNotNull();
    }


    @When("I request a book with an invalid string id {string}")
    public void i_request_a_book_with_an_invalid_string_id(String id) {
        response = bookApi.getBookByInvalidStringId(id);
    }

    @Then("the response code should be {int} for invalid string book id")
    public void the_response_code_should_be_for_invalid_string_book_id(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain an error message for invalid string id {string}")
    public void the_response_should_contain_an_error_message_for_invalid_string_id(String expectedMessage) {
        assertThat(response.jsonPath().getString("errorMessage")).isEqualTo(expectedMessage);
    }


    @Then("the response code should be number {int} invalidate credential")
    public void the_response_should_contain_an_error_code_invalid_credit(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain an error message for invalid credential {string}")
    public void the_response_should_contain_an_error_message_invalid_credit(String expectedMessage) {
        int statusCode = response.statusCode();
        Map<Integer, String> statusMessages = getIntegerStringMap();
        String statusMessage = statusMessages.getOrDefault(statusCode, "Unknown Status");
        assertThat(statusMessage).isEqualTo(expectedMessage);
    }

    @NotNull
    private static Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> statusMessages = new HashMap<>();
        statusMessages.put(200, "OK");
        statusMessages.put(201, "Created");
        statusMessages.put(208, "Already Reported");
        statusMessages.put(400, "Bad Request");
        statusMessages.put(401, "Unauthorized");
        statusMessages.put(402, "Payment Required");
        statusMessages.put(403, "Forbidden");
        statusMessages.put(404, "Not Found");
        statusMessages.put(405, "Method Not Allowed");
        statusMessages.put(500, "Internal Server Error");
        return statusMessages;
    }
}



