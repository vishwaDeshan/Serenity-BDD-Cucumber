package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class OffersPage extends PageObject {
    public static final By VEG_FRUIT_NAME_HEADER = By.cssSelector("tr th:nth-child(1)");
    public static final By VEG_FRUIT_NAME_COLUMN = By.cssSelector("tr td:nth-child(1)");
}
