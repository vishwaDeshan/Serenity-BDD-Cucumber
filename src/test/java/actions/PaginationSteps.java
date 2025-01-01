package actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.NavigationPage;
import pageObjects.PaginationPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PaginationSteps extends UIInteractionSteps {

    public void openGooglePage() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Close WebDriver
        driver.quit();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div/div/div/div[2]/ul/li[3]/a")
    public static WebElementFacade currentPageButton;


    @Step("Navigate to the offers page")
    public void openOfferPage(String page) {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/"+page);
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(ExpectedConditions.visibilityOf(currentPageButton));
    }

    @Step("Navigate to second page")
    public void iClickOnTheNextPageButton() {
        find(PaginationPage.NEXT_PAGE).click();
    }

    @Step("Verify the user is on the next Page")
    public void PageNumberShouldUpdateTo(int number) {
        String pageNumberText = find(PaginationPage.SECOND_PAGE).getText();
        assertTrue("Page number is not correct", pageNumberText.contains(String.valueOf(number)));
    }

    @Step("Verify the user is on the prev Page")
    public void PageNumberShouldUpdate(int number) {
        String pageNumberText = find(PaginationPage.FIRST_PAGE).getText();
        assertTrue("Page number is not correct", pageNumberText.contains(String.valueOf(number)));
    }

    @Step("Navigate to first page")
    public void iClickOnThePrevPageButton() {
        find(PaginationPage.PREV_PAGE).click();
    }



}
