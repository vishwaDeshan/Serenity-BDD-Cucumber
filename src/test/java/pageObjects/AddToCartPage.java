package pageObjects;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class AddToCartPage extends PageObject {
    // Locator for the products container
    public static final By PRODUCTS_CONTAINER = By.cssSelector("div.products-wrapper");

    /**
     * Locator for the "Add to Cart" button based on the product name.
     * @param productName The exact name of the product.
     * @return By locator for the "Add to Cart" button.
     */
    public By addToCartButton(String productName) {
        // Using relative XPath with exact product name and partial button text
        return By.xpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), 'ADD TO CART')]");
    }


    /**
     * Locator for the "Added" button based on the product name.
     * @param productName The exact name of the product.
     * @return By locator for the "Added" button.
     */
    public By addedButton(String productName) {
        // Using relative XPath with exact product name and partial button text
        return By.xpath("//h4[text()='" + productName + "']/../div[@class='product-action']/button[contains(text(), '✔ ADDED')]");
    }
}

