package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class AddToCartPage extends PageObject {
    public static final By PRODUCTS_CONTAINER = By.cssSelector("div.products-wrapper");

    public By addToCartButton(String productName) {
        return By.xpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), 'ADD TO CART')]");
    }

    public By addedButton(String productName) {
        return By.xpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), '✔ ADDED')]");
    }
}

