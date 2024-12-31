package starter.apis;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookAPI {

    private static final String BASE_URL = "http://localhost:7081";

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(java.util.Base64.getEncoder().encode(auth.getBytes()));
    }

    public Response deleteBook(int id) {
        String endpoint = "/api/books/" + id;

        return given()
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))
                .when()
                .delete(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    public Response deleteBookAsUnauthorizedUser(int id) {
        String endpoint = "/api/books/" + id;

        return given()
                .header("Authorization", "Basic " + encodeCredentials("user", "password"))
                .when()
                .delete(BASE_URL + endpoint)
                .then()
                .extract().response();
    }

    public Response deleteNonExistentBook(int id) {
        String endpoint = "/api/books/" + id;

        return given()
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))
                .when()
                .delete(BASE_URL + endpoint)
                .then()
                .extract().response();
    }
}

