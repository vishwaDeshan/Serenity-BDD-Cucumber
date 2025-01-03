package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import actions.AddToCart;

public class AddtoCartStepDefinitions {

    AddToCart addToCartSteps;
    private String currentProductName;

    /**
     * Given step to navigate to the products page.
     */
    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        addToCartSteps.openProductsPage();
    }

    /**
     * When step to click the "Add to cart" button for a specific product.
     * @param buttonText The text of the button (e.g., "Add to cart").
     * @param productName The exact name of the product.
     */
    @When("I click the {string} button for {string}")
    public void iClickTheButtonForProduct(String buttonText, String productName) {
        if(buttonText.equalsIgnoreCase("Add to cart")) {
            addToCartSteps.clickAddToCartButton(productName);
            currentProductName = productName;
        }
        // Extendable for other buttons if needed
    }

    /**
     * Then step to verify that the button text changes to "Added".
     * @param initialButtonText The initial text of the button (e.g., "Add to cart").
     * @param expectedButtonText The expected text after clicking (e.g., "Added").
     */
    @Then("the {string} button should change to {string}")
    public void theButtonShouldChangeTo(String initialButtonText, String expectedButtonText) {
        String actualButtonText = addToCartSteps.getButtonText(currentProductName);
        // Assert that the actual button text contains the expected text
        Assert.assertTrue("Button text should contain " + expectedButtonText,
                actualButtonText.contains(expectedButtonText.toUpperCase()));
    }

    /**
     * Then step to verify that the button color changes from green to orange.
     * @param initialColor The initial color name (e.g., "green").
     * @param expectedColor The expected color name after clicking (e.g., "orange").
     */
    @Then("the button color should change from {string} to {string}")
    public void theButtonColorShouldChangeFromTo(String initialColor, String expectedColor) {
        String actualColor = addToCartSteps.getAddedButtonColor(currentProductName);
        // Convert color names to expected RGBA values
        String expectedColorRGBA = getColorRGBA(expectedColor);
        Assert.assertEquals("Button color should change to " + expectedColor, expectedColorRGBA, actualColor);
    }

    /**
     * Helper method to convert color names to their corresponding RGBA values.
     * Adjust these values based on the actual colors used in your application.
     * @param colorName The name of the color (e.g., "green", "orange").
     * @return The RGBA value as a string.
     */
    private String getColorRGBA(String colorName) {
        switch(colorName.toLowerCase()) {
            case "green":
                return "rgba(7, 121, 21, 1)"; // Example green color
            case "orange":
                return "rgba(252, 119, 16, 1)"; // Example orange color
            default:
                return "";
        }
    }
}

