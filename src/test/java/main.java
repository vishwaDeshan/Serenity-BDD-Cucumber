
import com.jayway.jsonpath.JsonPath;
import org.jetbrains.annotations.NotNull;
import starter.apis.GetBookAPI;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class main {
    private static GetBookAPI bookApi = new GetBookAPI();
    private static HttpResponse<String> response;

    public static void main(String[] args) {
        // Make API call
            response = bookApi.getBookById(3);
        String responseBody = response.body();
        Object books = JsonPath.read(responseBody, "$.id");
        String idField = "id";
        System.out.println(assertThat(Optional.ofNullable(JsonPath.read(responseBody, "$." + idField))).isNotEmpty());
//        response = bookApi.getBookById(1);
//        Map<Integer, String> statusMessages = getIntegerStringMap();
//
//        int statusCode = response.statusCode();
//        String statusMessage = statusMessages.getOrDefault(statusCode, "Unknown Status");
//        System.out.println("Manually Decoded Status Message: " + statusMessage);
    }

    @NotNull
    private static Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> statusMessages = new HashMap<>();
        statusMessages.put(200, "OK");
        statusMessages.put(201, "Created");
        statusMessages.put(208, "Already Reported");
        statusMessages.put(400, "Bad Request");
        statusMessages.put(401, "Unauthorized");
        statusMessages.put(402, "Payment Required");
        statusMessages.put(403, "Forbidden");
        statusMessages.put(404, "Not Found");
        statusMessages.put(405, "Method Not Allowed");
        statusMessages.put(500, "Internal Server Error");
        return statusMessages;
    }
}
