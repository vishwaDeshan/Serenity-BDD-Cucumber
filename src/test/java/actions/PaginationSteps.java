package actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.PaginationPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PaginationSteps extends UIInteractionSteps {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div/div/div/div[2]/ul/li[3]/a")
    public static WebElementFacade currentPageButton;

    @FindBy(css = "#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(7)>a")
    public static WebElementFacade NEXT_PAGE_BUTTON;

    @FindBy(css = "#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(2)>a")
    public static WebElementFacade PREV_PAGE_BUTTON;

    @FindBy(css = "#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li.active>a")
    public static WebElementFacade FIRST_PAGE_BUTTON;

    @FindBy(css = "#root>div>div.products-wrapper>div>div>div>div>div>div.col-xs-8>ul>li:nth-child(4)>a")
    public static WebElementFacade SECOND_PAGE_BUTTON;


    @Step("Navigate to the offers page")
    public void openOfferPage(String page) {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/"+page);
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(ExpectedConditions.visibilityOf(currentPageButton));
    }

    @Step("Navigate to second page")
    public void iClickOnTheNextPageButton() {
        NEXT_PAGE_BUTTON.click();
    }

    @Step("Verify the user is on the next Page")
    public void PageNumberShouldUpdateTo(int number) {
        String pageNumberText = SECOND_PAGE_BUTTON.getText();
        assertTrue("Page number is not correct", pageNumberText.contains(String.valueOf(number)));
    }

    @Step("Verify the user is on the prev Page")
    public void PageNumberShouldUpdate(int number) {
        String pageNumberText = FIRST_PAGE_BUTTON.getText();
        assertTrue("Page number is not correct", pageNumberText.contains(String.valueOf(number)));
    }

    @Step("Navigate to first page")
    public void iClickOnThePrevPageButton() {
        PREV_PAGE_BUTTON.click();
    }



}
