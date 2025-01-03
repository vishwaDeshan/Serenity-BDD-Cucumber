package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import static org.assertj.core.api.Assertions.assertThat;

import starter.apis.PostBookAPI;

import java.io.IOException;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * PostBookSteps defines the step definitions for Cucumber scenarios
 * related to adding books via the PostBookAPI.
 */
public class PostBookSteps {

    private PostBookAPI postBookAPI = new PostBookAPI();
    private HttpResponse<String> response;
    private ObjectMapper objectMapper = new ObjectMapper(); // For JSON parsing

    // Scenario 1: Add a book with valid details
    @When("I add a book with title {string} and author {string}")
    public void iPostABookWithTitleAndAuthor(String title, String author) throws IOException, InterruptedException {
        response = postBookAPI.addBook(title, author);
    }

    @Then("the response status code should be {int}")
    public void theResponseCodeShouldBe(int expectedStatusCode) {
        assertThat(response.statusCode()).isEqualTo(expectedStatusCode);
    }

    @Then("the response should contain the added book details with title {string} and author {string}")
    public void theResponseShouldContainTheAddedBookDetails(String title, String author) throws IOException {
        String responseBody = response.body();
        JsonNode jsonNode = parseJson(responseBody);

        // Assert that the title and author match
        assertThat(jsonNode.has("title")).isTrue();
        assertThat(jsonNode.get("title").asText()).isEqualTo(title);

        assertThat(jsonNode.has("author")).isTrue();
        assertThat(jsonNode.get("author").asText()).isEqualTo(author);
    }

    // Scenario 2: Add a book with invalid credentials
    @Given("I have invalid username and password")
    public void i_have_invalid_username_and_password() {
        // Toggle the credentials in PostBookAPI to invalid
        postBookAPI.setInvalidCredentials(true);
    }

    @When("I add a book with id {int} title {string} and author {string} using invalid credentials")
    public void i_add_a_book_with_id_title_and_author_using_invalid_credentials(Integer id, String title, String author)
            throws IOException, InterruptedException {
        response = postBookAPI.addBookWithInvalidCredentials(id, title, author);
    }

    // Scenario 3: Add a book with missing author field
    @When("I add a book with title {string} and no author")
    public void iAddABookWithTitleAndNoAuthor(String title) throws IOException, InterruptedException {
        response = postBookAPI.addBookWithoutAuthor(title);
    }

    @Then("the response should contain error {string}")
    public void theResponseShouldContainError(String errorMessage) throws IOException {
        String responseBody = response.body();
        JsonNode jsonNode = parseJson(responseBody);

        // Assuming the error message is in a field named "error"
        assertThat(jsonNode.has("error")).isTrue();
        assertThat(jsonNode.get("error").asText()).contains(errorMessage);
    }

    // Scenario 4: Add a book with existing data
    @Given("the library already contains a book with title {string} and author {string}")
    public void theLibraryAlreadyContainsABookWithTitleAndAuthor(String title, String author) throws IOException, InterruptedException {
        response = postBookAPI.addBook(title, author);
        assertThat(response.statusCode()).isEqualTo(201); // Ensure the book was added
    }

    // Scenario 5: Add a book with null id and empty title and author
    @When("I add a book with id null, empty title {string}, and empty author {string}")
    public void iAddABookWithNullIdAndEmptyTitleAndAuthor(String title, String author) throws IOException, InterruptedException {
        response = postBookAPI.addBookWithNullIdAndEmptyFields(title, author);
    }

    // Scenario 6: Add a Book with a Negative ID
    @When("I add a book with a negative ID {int} with title {string} and author {string}")
    public void i_add_a_book_with_a_negative_ID_with_title_and_author(Integer id, String title, String author)
            throws IOException, InterruptedException {
        response = postBookAPI.addBookWithNegativeID(id, title, author);
    }

    @Then("the response should contain the added book details with a valid auto-generated id, title {string} and author {string}")
    public void the_response_should_contain_the_added_book_details_with_auto_generated_id_title_and_author(String title, String author)
            throws IOException {
        String responseBody = response.body();
        JsonNode jsonNode = parseJson(responseBody);

        // Extract fields
        int idResponse = jsonNode.has("id") ? jsonNode.get("id").asInt() : -1;
        String titleResponse = jsonNode.has("title") ? jsonNode.get("title").asText() : "";
        String authorResponse = jsonNode.has("author") ? jsonNode.get("author").asText() : "";

        // Assert that id is positive (auto-generated)
        assertThat(idResponse).isGreaterThan(0);

        // Assert title and author match
        assertThat(titleResponse).isEqualTo(title);
        assertThat(authorResponse).isEqualTo(author);
    }

    // Scenario 7: Add a Book with an Existing ID but Different Title and Author
    @Given("the library already contains a book with id {int}, title {string}, and author {string}")
    public void the_library_already_contains_a_book_with_id_title_and_author(Integer id, String title, String author)
            throws IOException, InterruptedException {
        response = postBookAPI.addBookWithID(id, title, author);
        assertThat(response.statusCode()).isEqualTo(201); // Ensure the book was added
    }

    @When("I add a book with id {int}, title {string}, and author {string}")
    public void i_add_a_book_with_id_title_and_author(Integer id, String title, String author)
            throws IOException, InterruptedException {
        response = postBookAPI.addBookWithExistingIDDifferentData(id, title, author);
    }

    @Then("the response should contain the updated book details with id {int}, title {string} and author {string}")
    public void the_response_should_contain_the_updated_book_details_with_id_title_and_author(Integer id, String title, String author)
            throws IOException {
        String responseBody = response.body();
        JsonNode jsonNode = parseJson(responseBody);

        // Extract fields
        int idResponse = jsonNode.has("id") ? jsonNode.get("id").asInt() : -1;
        String titleResponse = jsonNode.has("title") ? jsonNode.get("title").asText() : "";
        String authorResponse = jsonNode.has("author") ? jsonNode.get("author").asText() : "";

        // Assert that id matches
        assertThat(idResponse).isEqualTo(id);

        // Assert title and author match
        assertThat(titleResponse).isEqualTo(title);
        assertThat(authorResponse).isEqualTo(author);
    }

    // Scenario 9: Add a Book Without User
    @When("I add a book with title {string} and author {string} without providing user credentials")
    public void i_add_a_book_with_title_and_author_without_providing_user_credentials(String title, String author)
            throws IOException, InterruptedException {
        response = postBookAPI.addBookWithoutUser(title, author);
    }

    // Helper method to parse JSON responses
    private JsonNode parseJson(String jsonString) throws IOException {
        return objectMapper.readTree(jsonString);
    }

    // Scenario 10: Add a book with admin
    @Given("I have admin credentials")
    public void i_have_admin_credentials() {
        // No action needed as admin credentials are handled within PostBookAPI methods
        // This step is a placeholder for future configurations or setups if required
    }
}






