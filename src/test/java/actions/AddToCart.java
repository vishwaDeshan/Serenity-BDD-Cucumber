package actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import static org.awaitility.Awaitility.await;
import java.util.concurrent.TimeUnit;

public class AddToCart extends UIInteractionSteps {

    @FindBy(css = "div.products-wrapper")
    private WebElementFacade productsContainer;

    @FindBy(xpath = "//h4[text()='%s']/../div[@class='product-action']/button[contains(text(), 'ADD TO CART')]")
    private WebElementFacade addToCartButton;

    @FindBy(xpath = "//h4[text()='%s']/../div[@class='product-action']/button[contains(text(), '✔ ADDED')]")
    private WebElementFacade addedButton;

    @Step("Navigate to the products page")
    public void openProductsPage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Step("Click the 'Add to cart' button for {0}")
    public void clickAddToCartButton(String productName) {
        WebElementFacade button = findByXpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), 'ADD TO CART')]");
        button.click();
    }

    @Step("Get the button text for {0}")
    public String getButtonText(String productName) {
        WebElementFacade addedButtonElement = findByXpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), '✔ ADDED')]");
        await().atMost(10, TimeUnit.SECONDS).until(() -> addedButtonElement.getText().equals("✔ ADDED"));
        return addedButtonElement.getText();
    }

    @Step("Get the 'Added' button background color for {0}")
    public String getAddedButtonColor(String productName) {
        WebElementFacade addedButtonElement = findByXpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), '✔ ADDED')]");
        await().atMost(10, TimeUnit.SECONDS).until(() -> addedButtonElement.getCssValue("background-color").equals("rgba(7, 121, 21, 1)"));
        return addedButtonElement.getCssValue("background-color");
    }

    // Helper method for finding elements by XPath
    private WebElementFacade findByXpath(String xpath) {
        return find(xpath);
    }
}
