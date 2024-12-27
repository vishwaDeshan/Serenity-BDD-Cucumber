import io.restassured.response.Response;
import starter.apis.GetBookAPI;

import static org.assertj.core.api.Assertions.assertThat;

public class main {
    private static GetBookAPI bookApi = new GetBookAPI();
    private static Response response;

    public static void main(String[] args) {
        // Make API call
        response = bookApi.getAllBooks();

        // Check the status code
        if (response.statusCode() == 401) { // Specifically handle 401 Unauthorized
            System.out.println("Unauthorized access!");

            try {
                // Attempt to extract the error message from the response JSON
                String errorMessage = response.jsonPath().getString("message"); // Adjust key as per API response
                System.out.println("Error Message: " + errorMessage);
            } catch (Exception e) {
                System.out.println("Error parsing unauthorized response: " + e.getMessage());
                System.out.println("Raw Response Body: " + response.getBody().asString());
            }
        } else if (response.statusCode() >= 400) { // Handle other errors
            System.out.println("Error occurred!");

            try {
                String errorMessage = response.jsonPath().getString("message"); // Adjust key as needed
                System.out.println("Error Message: " + errorMessage);
            } catch (Exception e) {
                System.out.println("Error parsing response: " + e.getMessage());
                System.out.println("Raw Response Body: " + response.getBody().asString());
            }
        } else {
            // If successful
            System.out.println("Request was successful!");
            System.out.println("Response Body: " + response.getBody().asString());
        }
    }
}
