package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class SearchPage extends PageObject {
    public static final By SEARCH_BAR = By.cssSelector("input.search-keyword");
    public static final By SEARCH_BUTTON = By.cssSelector("button.search-button");
    public static final By SEARCH_RESULTS = By.cssSelector("div.products-wrapper");
    public static final By NO_RESULTS_MESSAGE = By.cssSelector("p");
}

