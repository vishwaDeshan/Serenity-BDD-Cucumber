package actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.QuantityPage;

public class QuantitySteps extends UIInteractionSteps {

    @FindBy(css = "a.decrement")
    public static WebElementFacade DECREMENT_BUTTON;

    @FindBy(css = "input.quantity")
    public static WebElementFacade QUANTITY_INPUT;

    @FindBy(css = "a.increment")
    public static WebElementFacade INCREMENT_BUTTON;

    @Step("Navigate to the Home Page")
    public void openHomePageWithQuantity() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Step("Click the increment button")
    public void clickIncrement() {
        INCREMENT_BUTTON.click();
    }

    @Step("Click the decrement button")
    public void clickDecrement() {
        DECREMENT_BUTTON.click();
    }

    @Step("Get the current quantity value")
    public int getCurrentQuantity() {
        String quantityValue = QUANTITY_INPUT.getAttribute("value");
        return Integer.parseInt(quantityValue);
    }
}
