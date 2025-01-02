package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.NavigationPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NavigationSteps extends UIInteractionSteps {

    @Step("Navigate to the Home Page")
    public void openHomePageWithNavigation() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(visibilityOfElementLocated(NavigationPage.HOME_PAGE_LOGO));
    }

    @Step("Navigate to the Offers Page")
    public void navigateToOffersPage() {
        find(NavigationPage.OFFERS_PAGE_LINK).click();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    @Step("Verify the user is on the Offers Page")
    public boolean isOnOffersPage() {
        String currentUrl = getDriver().getCurrentUrl();
//        System.out.println("Current URL: " + currentUrl);
        return currentUrl.contains("/offers");
    }
}
