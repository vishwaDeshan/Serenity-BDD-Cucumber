package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

import starter.apis.DeleteBookAPI;

public class DeleteBookSteps {

    private DeleteBookAPI bookApi = new DeleteBookAPI();
    private Response response;

    @When("I delete the book with id {int}")
    public void i_delete_the_book_with_id(int id) {
        response = bookApi.deleteBook(id);
    }

    @Then("the response code should be {int} for successful deletion")
    public void the_response_code_should_be_for_successful_deletion(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @When("I try to delete a book with an invalid id {int}")
    public void i_try_to_delete_a_book_with_an_invalid_id(int id) {
        response = bookApi.deleteNonExistentBook(id);
    }

    @Then("the response code should be {int} for non-existent book")
    public void the_response_code_should_be_for_non_existent_book(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @When("an unauthorized user tries to delete the book with id {int}")
    public void an_unauthorized_user_tries_to_delete_the_book_with_id(int id) {
        response = bookApi.deleteBookAsUnauthorizedUser(id);
    }

    @Then("the response code should be {int} for unauthorized deletion")
    public void the_response_code_should_be_for_unauthorized_deletion(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @When("I try to delete the book with id {int} using case-sensitive admin credentials")
    public void i_try_to_delete_the_book_with_case_sensitive_admin_credentials(int id) {
        response = bookApi.deleteBookCaseSensitivityCheck(id);
    }

    @Then("the response code should be {int} for case-sensitive admin credentials")
    public void the_response_code_should_be_for_case_sensitive_admin_credentials(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @When("I try to delete the book with id {int} using case-sensitive user credentials")
    public void i_try_to_delete_the_book_with_case_sensitive_user_credentials(int id) {
        response = bookApi.deleteBookUnauthorizedUserCaseSensitivityCheck(id);
    }

    @Then("the response code should be {int} for case-sensitive user credentials")
    public void the_response_code_should_be_for_case_sensitive_user_credentials(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

}

