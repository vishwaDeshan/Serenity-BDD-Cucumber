package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import starter.apis.UpdateBookAPI;

public class UpdateBookSteps {

    private UpdateBookAPI bookApi = new UpdateBookAPI();
    private Response response;

    //case 1 and 4
    @When("I update the book with id {int} to title {string} and author {string}")
    public void i_update_the_book(int id, String title, String author) {
        response = bookApi.updateBook(id, title, author);
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode); // Updated to handle any expected status code, including 208
    }

    @Then("the response should contain the updated book details with title {string} and author {string}")
    public void the_response_should_contain_updated_book_details(String title, String author) {
        assertThat(response.jsonPath().getString("title")).isEqualTo(title);
        assertThat(response.jsonPath().getString("author")).isEqualTo(author);
    }

    //case 2
    @When("I try to update a book with an invalid id {int}")
    public void i_try_to_update_a_book_with_an_invalid_id(int id) {
        response = bookApi.updateBook(id, "New Title", "New Author");
    }

    @Then("the response code should be {int} for invalid book id")
    public void the_response_code_should_be_404_for_invalid_book_id(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }


    //case 3
    @When("I try to update a book with invalid JSON format")
    public void i_try_to_update_a_book_with_invalid_json_format() {
        response = bookApi.updateBookInvalidJason();
    }

    @Then("the response code should be 400 for invalid JSON")
    public void the_response_code_should_be_400_for_invalid_json() {
        // Validate that the response code is 400 (Bad Request)
        assertThat(response.statusCode()).isEqualTo(400);
    }

    // case 4 'And"
    @Then("the response code should be {int} for Bad Request")
    public void the_response_code_should_be_400_for_Bad_Request(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

}
