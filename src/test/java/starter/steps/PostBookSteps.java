package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.response.Response;
import starter.apis.PostBookAPI;

public class PostBookSteps {

    private PostBookAPI postBookAPI = new PostBookAPI();
    private Response response;

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
}
