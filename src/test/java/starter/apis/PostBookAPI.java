package starter.apis;

import java.util.Base64;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookAPI {

    private static final String BASE_URL = "http://localhost:7081";

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    private RequestSpecification createRequestSpec(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic " + encodeCredentials(username, password));
    }

    // add a book with valid credentials
    public Response addBook(String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{\"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec("admin", "password")
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Method to add a book with invalid credentials
    public Response addBookWithInvalidCredentials(Integer id, String title, String author) {
        String endpoint = "/api/books";
        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return createRequestSpec("invalidUser", "wrongPassword")  // Invalid credentials
                .body(requestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
}
