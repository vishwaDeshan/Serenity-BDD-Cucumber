package starter.apis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class PostBookAPI {

    private static final String BASE_URL = "http://localhost:7081";
    private static final String ENDPOINT = "/api/books";
    private final HttpClient httpClient;
    private boolean invalidCredentials = false; // Flag to toggle credentials

    public PostBookAPI() {
        this.httpClient = HttpClient.newHttpClient();
    }


    public void setInvalidCredentials(boolean isInvalid) {
        this.invalidCredentials = isInvalid;
    }


    // Encode credentials using Base64 for Basic Authentication.
    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return Base64.getEncoder().encodeToString(auth.getBytes());
    }

    // Create an HttpRequest.Builder with necessary headers.
    private HttpRequest.Builder createRequestBuilder(String username, String password) {
        String encodedCredentials = encodeCredentials(username, password);
        return HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + ENDPOINT))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodedCredentials);
    }

    // Add a book with valid credentials.
    public HttpResponse<String> addBook(String title, String author) throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\", \"author\": \"%s\"}", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with invalid credentials.
    public HttpResponse<String> addBookWithInvalidCredentials(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("UserUnknown", "Pa$$word")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book without the author field.
    public HttpResponse<String> addBookWithoutAuthor(String title) throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\" }", title);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with a negative ID.
    public HttpResponse<String> addBookWithNegativeID(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with an existing ID but different title and author.
    public HttpResponse<String> addBookWithExistingIDDifferentData(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with a specific ID.
    public HttpResponse<String> addBookWithID(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book without user credentials (No Authorization).
    public HttpResponse<String> addBookWithoutUser(String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\", \"author\": \"%s\" }", title, author);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + ENDPOINT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with null ID and empty fields.
    public HttpResponse<String> addBookWithNullIdAndEmptyFields(String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": null, \"title\": \"%s\", \"author\": \"%s\" }", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // Add a book with admin credentials (specific method for admin).
    public HttpResponse<String> addBookWithAdmin(String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\", \"author\": \"%s\" }", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
