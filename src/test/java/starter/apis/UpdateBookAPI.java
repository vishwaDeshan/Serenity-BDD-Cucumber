package starter.apis;
import java.util.Base64;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UpdateBookAPI {

    private static final String BASE_URL = "http://localhost:7081";

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }
    public Response updateBook(int id, String title, String author) {
        String endpoint = "/api/books/" + id;

        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))  // Add authorization header
                .body(requestBody)
                .when()
                .put(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    public Response updateBookInvalidJason() {
        String endpoint = "/api/books/1" ;

        String invalidJson = "{ \"id\": 1, \"title\": \"Invalid Book Title\", \"author\": \"Author\" "; // Invalid JSON

        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))  // Add authorization header
                .body(invalidJson)
                .when()
                .put(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
}
