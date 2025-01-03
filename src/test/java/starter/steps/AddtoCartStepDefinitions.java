package starter.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import actions.AddToCart;

public class AddtoCartStepDefinitions {

    AddToCart addToCartSteps;
    private String currentProductName;

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        addToCartSteps.openProductsPage();
    }

    @When("I click the {string} button for {string}")
    public void iClickTheButtonForProduct(String buttonText, String productName) {
        if(buttonText.equalsIgnoreCase("Add to cart")) {
            addToCartSteps.clickAddToCartButton(productName);
            currentProductName = productName;
        }
    }

    @Then("the {string} button should change to {string}")
    public void theButtonShouldChangeTo(String initialButtonText, String expectedButtonText) {
        String actualButtonText = addToCartSteps.getButtonText(currentProductName);
        Assert.assertTrue("Button text should contain " + expectedButtonText,
                actualButtonText.contains(expectedButtonText.toUpperCase()));
    }

    @Then("the button color should change from {string} to {string}")
    public void theButtonColorShouldChangeFromTo(String initialColor, String expectedColor) {
        String actualColor = addToCartSteps.getAddedButtonColor(currentProductName);
        String expectedColorRGBA = getColorRGBA(expectedColor);
        Assert.assertEquals("Button color should change to " + expectedColor, expectedColorRGBA, actualColor);
    }

    private String getColorRGBA(String colorName) {
        switch(colorName.toLowerCase()) {
            case "green":
                return "rgba(7, 121, 21, 1)"; // green color
            case "orange":
                return "rgba(252, 119, 16, 1)"; // orange color
            default:
                return "";
        }
    }
}
