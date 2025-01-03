package starter.apis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

/**
 * PostBookAPI interacts with the Book API to perform various POST operations
 * such as adding books with different scenarios.
 */
public class PostBookAPI {

    private static final String BASE_URL = "http://localhost:7081";
    private static final String ENDPOINT = "/api/books";
    private final HttpClient httpClient;
    private boolean invalidCredentials = false; // Flag to toggle credentials

    /**
     * Constructor initializes the HttpClient.
     */
    public PostBookAPI() {
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * Set invalid credentials flag.
     *
     * @param isInvalid true to use invalid credentials, false otherwise.
     */
    public void setInvalidCredentials(boolean isInvalid) {
        this.invalidCredentials = isInvalid;
    }

    /**
     * Encode credentials using Base64 for Basic Authentication.
     *
     * @param username The username.
     * @param password The password.
     * @return The encoded credentials.
     */
    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return Base64.getEncoder().encodeToString(auth.getBytes());
    }

    /**
     * Create an HttpRequest.Builder with necessary headers.
     *
     * @param username The username for Basic Auth.
     * @param password The password for Basic Auth.
     * @return Configured HttpRequest.Builder.
     */
    private HttpRequest.Builder createRequestBuilder(String username, String password) {
        String encodedCredentials = encodeCredentials(username, password);
        return HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + ENDPOINT))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodedCredentials);
    }

    /**
     * Add a book with valid credentials.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBook(String title, String author) throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\", \"author\": \"%s\"}", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book with invalid credentials.
     *
     * @param id     The ID of the book.
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithInvalidCredentials(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("UserUnknown", "Pa$$word")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book without the author field.
     *
     * @param title The title of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithoutAuthor(String title) throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\" }", title);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book with a negative ID.
     * The server should ignore the ID and auto-increment.
     *
     * @param id     The negative ID of the book.
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithNegativeID(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book with an existing ID but different title and author.
     *
     * @param id     The existing ID of the book.
     * @param title  The new title of the book.
     * @param author The new author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithExistingIDDifferentData(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book with a specific ID.
     *
     * @param id     The ID of the book.
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithID(Integer id, String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": %d, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book without user credentials (No Authorization).
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
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

    /**
     * Add a book with null ID and empty fields.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithNullIdAndEmptyFields(String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{ \"id\": null, \"title\": \"%s\", \"author\": \"%s\" }", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Add a book with admin credentials (specific method for admin).
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @return HttpResponse containing the server's response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public HttpResponse<String> addBookWithAdmin(String title, String author)
            throws IOException, InterruptedException {
        String requestBody = String.format("{\"title\": \"%s\", \"author\": \"%s\" }", title, author);

        HttpRequest request = createRequestBuilder("admin", "password")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
