package actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class NavigationSteps extends UIInteractionSteps {

    @FindBy(css = "div.brand.greenLogo")
    private WebElementFacade homePageLogo;

    @FindBy(css = "a.cart-header-navlink[href='#/offers']")
    private WebElementFacade offersPageLink;

    @Step("Open the Home Page")
    public void openHomePage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @Step("Navigate to the Offers Page")
    public void navigateToOffersPage() {
        // Click the offers page link
        offersPageLink.click();

        // Wait for the new tab to be opened and switch to it
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));  // Switch to the second tab (offers page)
    }

    @Step("Verify the user is on the Offers Page")
    public void verifyOffersPage() {
        // Get the current URL and verify if it contains '/offers'
        String currentUrl = getDriver().getCurrentUrl();
        assertTrue("Expected to be on the Offers page, but URL is " + currentUrl,
                currentUrl.contains("/offers"));
    }
}
