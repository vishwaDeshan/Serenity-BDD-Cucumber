package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.QuantityPage;

public class QuantitySteps extends UIInteractionSteps {

    @Step("Navigate to the Home Page")
    public void openHomePage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Step("Click the increment button")
    public void clickIncrement() {
        find(QuantityPage.INCREMENT_BUTTON).click();
    }

    @Step("Click the decrement button")
    public void clickDecrement() {
        find(QuantityPage.DECREMENT_BUTTON).click();
    }

    @Step("Get the current quantity value")
    public int getCurrentQuantity() {
        String quantityValue = find(QuantityPage.QUANTITY_INPUT).getAttribute("value");
        return Integer.parseInt(quantityValue);
    }
}
