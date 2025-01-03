package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.AddToCartPage;

import java.time.Duration;

public class AddToCart extends UIInteractionSteps {

    AddToCartPage addToCartPage;


    @Step("Navigate to the products page")
    public void openProductsPage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(addToCartPage.PRODUCTS_CONTAINER);
    }

    /**
     * Click the "Add to Cart" button for a specific product.
     * @param productName The exact name of the product.
     */
    @Step("Click the 'Add to cart' button for {0}")
    public void clickAddToCartButton(String productName) {
        // Wait for the "Add to Cart" button to be visible
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(addToCartPage.addToCartButton(productName));
        // Find the button element and click on it
        clickOn(find(addToCartPage.addToCartButton(productName)));
    }

    /**
     * Retrieve the text of the "Add to Cart" button for a specific product.
     * @param productName The exact name of the product.
     * @return The button text.
     */
    @Step("Get the button text for {0}")
    public String getButtonText(String productName) {
        return find(addToCartPage.addedButton(productName)).getText();
    }

    /**
     * Retrieve the background color of the "Added" button for a specific product.
     * @param productName The exact name of the product.
     * @return The background color in RGBA format.
     */
    @Step("Get the 'Added' button background color for {0}")
    public String getAddedButtonColor(String productName) {
        return find(addToCartPage.addedButton(productName)).getCssValue("background-color");
    }
}

