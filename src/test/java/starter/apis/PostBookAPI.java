package starter.apis;

import java.util.Base64;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookAPI {

    private static final String BASE_URL = "http://localhost:7081";
    private boolean invalidCredentials = false; // Flag to toggle credentials

    // Set invalid credentials flag
    public void setInvalidCredentials(boolean isInvalid) {
        this.invalidCredentials = isInvalid;
    }

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    private RequestSpecification createRequestSpec() {
        if (invalidCredentials) {
            return given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Basic " + encodeCredentials("UserUnknown", "Pa$$word"));
        } else {
            return given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Basic " + encodeCredentials("admin", "password"));
        }
    }

    // Add a book with valid credentials
    public Response addBook(String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{\"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Add a book with invalid credentials
    public Response addBookWithInvalidCredentials(Integer id, String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Add a book without the author field
    public Response addBookWithoutAuthor(String title) {
        String endpoint = "/api/books";
        String requestBody = "{\"title\": \"" + title + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // New Method for Scenario 6: Add a Book with a Negative ID
    public Response addBookWithNegativeID(Integer id, String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // New Method for Scenario 7: Add a Book with Existing ID but Different Title and Author
    public Response addBookWithExistingIDDifferentData(Integer id, String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // New Method for Scenario 7: Add a Book with Specific ID
    public Response addBookWithID(Integer id, String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec()
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // New Method for Scenario 8: Add a Book with Special Characters in Title and Author
    // Reuses the existing addBook method since it handles any title and author strings
    // No additional method needed

    // New Method for Scenario 9: Add a Book Without User (No Credentials)
    public Response addBookWithoutUser(String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{\"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return given() // No Authorization header
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
}

