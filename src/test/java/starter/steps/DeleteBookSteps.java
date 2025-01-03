package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;
import starter.apis.DeleteBookAPI;

public class DeleteBookSteps {

    private DeleteBookAPI bookApi = new DeleteBookAPI();
    private int responseCode;

    @When("I delete the book with id {int}")
    public void i_delete_the_book_with_id(int id) throws Exception {
        responseCode = bookApi.deleteBook(id);
    }

    @When("I try to delete a book with an invalid id {int}")
    public void i_try_to_delete_a_book_with_invalid_id(int id) throws Exception {
        responseCode = bookApi.deleteBookInvalidId(id);
    }

    @When("an unauthorized user tries to delete the book with id {int}")
    public void an_unauthorized_user_tries_to_delete_the_book_with_id(int id) throws Exception {
        responseCode = bookApi.deleteBookUnauthorized(id);
    }

    @When("I try to delete the book with id {int} using case-sensitive admin credentials")
    public void i_try_to_delete_the_book_with_case_sensitive_admin_credentials(int id) throws Exception {
        responseCode = bookApi.deleteBookCaseSensitiveAdmin(id);
    }

    @When("I try to delete the book with id {int} using case-sensitive user credentials")
    public void i_try_to_delete_the_book_with_case_sensitive_user_credentials(int id) throws Exception {
        responseCode = bookApi.deleteBookCaseSensitiveUser(id);
    }

    @Then("the response code should be {int} for successful deletion")
    public void the_response_code_should_be_200_for_successful_deletion(int statusCode) {
        assertThat(responseCode).isEqualTo(statusCode);
    }

    @Then("the response code should be {int} for non-existent book")
    public void the_response_code_should_be_404_for_non_existent_book(int statusCode) {
        assertThat(responseCode).isEqualTo(statusCode);
    }

    @Then("the response code should be {int} for unauthorized deletion")
    public void the_response_code_should_be_403_for_unauthorized_deletion(int statusCode) {
        assertThat(responseCode).isEqualTo(statusCode);
    }

    @Then("the response code should be {int} for case-sensitive admin credentials")
    public void the_response_code_should_be_401_for_case_sensitive_admin_credentials(int statusCode) {
        assertThat(responseCode).isEqualTo(statusCode);
    }

    @Then("the response code should be {int} for case-sensitive user credentials")
    public void the_response_code_should_be_401_for_case_sensitive_user_credentials(int statusCode) {
        assertThat(responseCode).isEqualTo(statusCode);
    }
}
