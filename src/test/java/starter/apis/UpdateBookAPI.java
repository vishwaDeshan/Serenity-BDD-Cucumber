package starter.apis;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class UpdateBookAPI {
    private static final String BASE_URL = "http://localhost:7081";
    private static final HttpClient client = HttpClient.newHttpClient();

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    public HttpResponse<String> updateBook(int id, String title, String author) throws Exception {
        String endpoint = BASE_URL + "/api/books/" + id;

        String requestBody = "{ \"id\": " + id + ", \"title\": \"" + title + "\", \"author\": \"" + author + "\" }";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> updateBookInvalidJson() throws Exception {
        String endpoint = BASE_URL + "/api/books/1";

        String invalidJson = "{ \"id\": 1, \"title\": \"Invalid Book Title\", \"author\": \"Author\" ";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + encodeCredentials("admin", "password"))
                .PUT(HttpRequest.BodyPublishers.ofString(invalidJson))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
