package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class PaginationPage extends PageObject {

    @FindBy(xpath = "//div[contains(@class, 'col-xs-8')]//ul[contains(@class, 'pagination pull-right')]//li[contains(@class, 'active')]/a")
    public static WebElementFacade currentPageButton;
    @FindBy(css = "a[role='button'] span:contains('2')")
    public static WebElementFacade secondPageButton;

    @FindBy(css = "a[aria-label='Previous']")
    public static WebElementFacade previousPageButton;

    @FindBy(css = "a[aria-label='Next']")
    public static WebElementFacade nextPageButton;

    @FindBy(css = "a[aria-label='Last']")
    public static WebElementFacade lastPageButton;

    @FindBy(css = "a[role='button'] span:contains('3')")
    public static WebElementFacade thirdPageButton;

    @FindBy(css = "a[role='button'] span:contains('4')")
    public static WebElementFacade pageFourButton;

}
