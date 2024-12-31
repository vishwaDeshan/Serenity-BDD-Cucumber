package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class QuantityPage extends PageObject {
    public static final By DECREMENT_BUTTON = By.cssSelector("a.decrement");
    public static final By QUANTITY_INPUT = By.cssSelector("input.quantity");
    public static final By INCREMENT_BUTTON = By.cssSelector("a.increment");
}
