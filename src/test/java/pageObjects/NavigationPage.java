package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class NavigationPage extends PageObject {

    public static final By HOME_PAGE_LOGO = By.cssSelector("div.brand.greenLogo");
    public static final By OFFERS_PAGE_LINK = By.cssSelector("a.cart-header-navlink[href='#/offers']");
}
