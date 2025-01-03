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

    @Step("Click the 'Add to cart' button for {0}")
    public void clickAddToCartButton(String productName) {
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(addToCartPage.addToCartButton(productName));
        clickOn(find(addToCartPage.addToCartButton(productName)));
    }

    @Step("Get the button text for {0}")
    public String getButtonText(String productName) {
        return find(addToCartPage.addedButton(productName)).getText();
    }

    @Step("Get the 'Added' button background color for {0}")
    public String getAddedButtonColor(String productName) {
        return find(addToCartPage.addedButton(productName)).getCssValue("background-color");
    }
}

