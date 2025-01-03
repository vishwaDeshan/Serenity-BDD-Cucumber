package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import starter.apis.UpdateBookAPI;

public class UpdateBookSteps {

    private UpdateBookAPI bookApi = new UpdateBookAPI();
    private HttpResponse<String> response;

    @When("I update the book with id {int} to title {string} and author {string}")
    public void i_update_the_book(int id, String title, String author) throws Exception {
        response = bookApi.updateBook(id, title, author);
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response code should be {int} for Bad Request")
    public void the_response_code_should_be_for_bad_request(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the response should contain the updated book details with title {string} and author {string}")
    public void the_response_should_contain_updated_book_details(String title, String author) {
        assertThat(response.body()).contains("\"title\":\"" + title + "\"");
        assertThat(response.body()).contains("\"author\":\"" + author + "\"");
    }

    @When("I try to update a book with an invalid id {int}")
    public void i_try_to_update_a_book_with_an_invalid_id(int id) throws Exception {
        response = bookApi.updateBook(id, "New Title", "New Author");
    }

    @Then("the response code should be {int} for invalid book id")
    public void the_response_code_should_be_for_invalid_book_id(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @When("I try to update a book with invalid JSON format")
    public void i_try_to_update_a_book_with_invalid_json_format() throws Exception {
        response = bookApi.updateBookInvalidJson();
    }

    @Then("the response code should be 400 for invalid JSON")
    public void the_response_code_should_be_for_invalid_json() {
        assertThat(response.statusCode()).isEqualTo(400);
    }
}
