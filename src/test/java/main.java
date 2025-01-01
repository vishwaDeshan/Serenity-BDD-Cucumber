import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.apis.GetBookAPI;
import java.time.Duration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class main {
    private static GetBookAPI bookApi = new GetBookAPI();
    private static Response response;

    public static void main(String[] args) {

        response = bookApi.getBookById(1);
        Map<Integer, String> statusMessages = getIntegerStringMap();

        int statusCode = response.statusCode();
        String statusMessage = statusMessages.getOrDefault(statusCode, "Unknown Status");
        System.out.println("Manually Decoded Status Message: " + statusMessage);
        // Check the status code
//        if (response.statusCode() == 401) { // Specifically handle 401 Unauthorized
//            System.out.println("Unauthorized access!");
//
//            try {
//                // Attempt to extract the error message from the response JSON
//                String errorMessage = response.jsonPath().getString("message"); // Adjust key as per API response
//                System.out.println("Error Message: " + errorMessage);
//            } catch (Exception e) {
//                System.out.println("Error parsing unauthorized response: " + e.getMessage());
//                System.out.println("Raw Response Body: " + response.getBody().asString());
//            }
//        } else if (response.statusCode() >= 400) { // Handle other errors
//            System.out.println("Error occurred!");
//
//            try {
//                String errorMessage = response.jsonPath().getString("message"); // Adjust key as needed
//                System.out.println("Error Message: " + errorMessage);
//            } catch (Exception e) {
//                System.out.println("Error parsing response: " + e.getMessage());
//                System.out.println("Raw Response Body: " + response.getBody().asString());
//            }
//        } else {
//            // If successful
//            System.out.println("Request was successful!");
//            System.out.println("Response Body: " + response.getBody().asString());
//        }
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
