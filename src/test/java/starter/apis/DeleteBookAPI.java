package starter.apis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class DeleteBookAPI {

    private static final String BASE_URL = "http://localhost:7081";

    private String encodeCredentials(String username, String password) {
        String auth = username + ":" + password;
        return new String(Base64.getEncoder().encode(auth.getBytes()));
    }

    public int deleteBook(int id) throws IOException {
        String endpoint = "/api/books/" + id;
        URL url = new URL(BASE_URL + endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Authorization", "Basic " + encodeCredentials("admin", "password"));

        return connection.getResponseCode();
    }

    public int deleteBookInvalidId(int id) throws IOException {
        String endpoint = "/api/books/" + id;
        URL url = new URL(BASE_URL + endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Authorization", "Basic " + encodeCredentials("admin", "password"));

        return connection.getResponseCode();
    }

    public int deleteBookUnauthorized(int id) throws IOException {
        String endpoint = "/api/books/" + id;
        URL url = new URL(BASE_URL + endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Authorization", "Basic " + encodeCredentials("user", "password"));

        return connection.getResponseCode();
    }

    public int deleteBookCaseSensitiveAdmin(int id) throws IOException {
        String endpoint = "/api/books/" + id;
        URL url = new URL(BASE_URL + endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Authorization", "Basic " + encodeCredentials("Admin", "password"));

        return connection.getResponseCode();
    }

    public int deleteBookCaseSensitiveUser(int id) throws IOException {
        String endpoint = "/api/books/" + id;
        URL url = new URL(BASE_URL + endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Authorization", "Basic " + encodeCredentials("User", "password"));

        return connection.getResponseCode();
    }
}
