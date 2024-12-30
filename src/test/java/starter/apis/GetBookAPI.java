package starter.apis;

import java.util.Base64;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookAPI {

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

    // Method to get all books
    public Response getAllBooks() {
        String endpoint = "/api/books";
        return createRequestSpec("admin", "password")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Method to get a book by valid ID
    public Response getBookById(int id) {
        String endpoint = "/api/books/" + id;
        return createRequestSpec("admin", "password")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Method to get a book by invalid ID
    public Response getBookByInvalidId(int id) {
        String endpoint = "/api/books/" + id;
        return createRequestSpec("admin", "password")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Method to get a book with invalid credentials
    public Response getBookWithInvalidCredentials(int id) {
        String endpoint = "/api/books/" + id;
        return createRequestSpec("invalidUser", "wrongPassword")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
    // Method to get all books without authorization
    public Response getAllBooksWithoutAuthorization() {
        String endpoint = "/api/books";
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }


    // Method to get books with forbidden access
    public Response getBooksWithUserRole() {
        String endpoint = "/api/books";
        return createRequestSpec("user", "password")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    // Method to get a book by invalid string ID
    public Response getBookByInvalidStringId(String id) {
        String endpoint = "/api/books/" + id;
        return createRequestSpec("admin", "password")
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
}




