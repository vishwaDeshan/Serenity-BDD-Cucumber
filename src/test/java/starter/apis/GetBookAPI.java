package starter.apis;

import java.net.http.HttpClient;
import java.util.Base64;
import io.restassured.http.ContentType;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookAPI {

    private static final String BASE_URL = "http://localhost:7081";

    private static final HttpClient client = HttpClient.newHttpClient();

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    public HttpRequest createRequestSpec(String uri, String username, String password) {
        String credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + credentials)
                .build();
    }



    // Method to get all books
    public HttpResponse<String> getAllBooks() {
        String endpoint = "/api/books";
        String username = "admin";
        String password = "password";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = createRequest(BASE_URL + endpoint, username, password);

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch books", e);
        }
    }

    private HttpRequest createRequest(String uri, String username, String password) {
        String credentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + credentials)
                .build();
    }



    // Method to get a book by valid ID
    public HttpResponse<String> getBookById(int id) {
        String endpoint = "/api/books/" + id;
        String username = "admin";
        String password = "password";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = createRequest(BASE_URL + endpoint, username, password);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch the book with ID: " + id, e);
        }
    }

    public HttpResponse<String> getAllBooksByInvalidCredential() {
        String endpoint = "/api/books";
        String invalidUsername = "invalidUser";
        String wrongPassword = "wrongPassword";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = createRequest(BASE_URL + endpoint, invalidUsername, wrongPassword);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch books with invalid credentials", e);
        }
    }

    // Method to get a book by invalid ID
    public HttpResponse<String> getBookByInvalidId(int id) {
        String endpoint = "/api/books/" + id;
        String username = "admin";
        String password = "password";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = createRequest(BASE_URL + endpoint, username, password);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch the book with invalid ID: " + id, e);
        }
    }

    // Method to get a book with invalid credentials
    public HttpResponse<String> getBookWithInvalidCredentials(int id) {
        String endpoint = "/api/books/" + id;
        String invalidUsername = "invalidUser";
        String wrongPassword = "wrongPassword";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest with invalid credentials
        HttpRequest request = createRequest(BASE_URL + endpoint, invalidUsername, wrongPassword);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch the book with invalid credentials for ID: " + id, e);
        }
    }

    // Method to get all books without authorization
    public HttpResponse<String> getAllBooksWithoutAuthorization() {
        String endpoint = "/api/books";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest without Authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .header("Content-Type", "application/json")
                .build();

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch books without authorization", e);
        }
    }


    // Method to get books with forbidden access
    public HttpResponse<String> getBooksWithUserRole() {
        String endpoint = "/api/books";
        String username = "user";
        String password = "password";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest with user role credentials
        HttpRequest request = createRequest(BASE_URL + endpoint, username, password);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch books with user role credentials", e);
        }
    }

    // Method to get a book by invalid string ID
    public HttpResponse<String> getBookByInvalidStringId(String id) {
        String endpoint = "/api/books/" + id;
        String username = "admin";
        String password = "password";

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest with valid admin credentials and invalid string ID
        HttpRequest request = createRequest(BASE_URL + endpoint, username, password);

        // Send the request and get the response
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch the book with invalid string ID: " + id, e);
        }
    }

}




