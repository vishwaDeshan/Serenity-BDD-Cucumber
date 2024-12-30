package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.SearchPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;

public class SearchSteps extends UIInteractionSteps {

    @Step("Navigate to the Search Page")
    public void openSearchPage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(presenceOfElementLocated(SearchPage.SEARCH_BAR));
    }

    @Step("Search for {0}")
    public void searchForItem(String itemName) {
        find(SearchPage.SEARCH_BAR).clear();
        find(SearchPage.SEARCH_BAR).sendKeys(itemName);
        find(SearchPage.SEARCH_BUTTON).click();
    }

    @Step("Verify search results contain {0}")
    public boolean verifySearchResults(String itemName) {
        String searchResultsText = find(SearchPage.SEARCH_RESULTS).getText();
        return searchResultsText.toLowerCase().contains(itemName.toLowerCase());
    }

    @Step("Verify no results message is displayed")
    public boolean verifyNoResultsMessage() {
        return find(SearchPage.NO_RESULTS_MESSAGE).isDisplayed();
    }
}

