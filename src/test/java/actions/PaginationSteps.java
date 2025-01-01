package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.PaginationPage;

import java.time.Duration;

public class PaginationSteps extends UIInteractionSteps {
    public void openGooglePage() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Use WebDriver to navigate
        driver.get("https://www.google.com");

        // Close WebDriver
        driver.quit();
    }
    // Example of using a PageObject for Navigation Page
    @Step("Navigate to the Offer page")
    public void openOfferPage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOf(PaginationPage.currentPageButton));
    }

    // Step to click on the first page button
    @Step("Click on the first page button")
    public void clickFirstPage() {
        PaginationPage.currentPageButton.click();
    }

    // Step to click on the second page button
    @Step("Click on the second page button")
    public void clickSecondPage() {
        PaginationPage.secondPageButton.click();
    }

    // Step to click on the third page button
    @Step("Click on the third page button")
    public void clickThirdPage() {
        PaginationPage.thirdPageButton.click();
    }

    // Step to click on the fourth page button
    @Step("Click on the fourth page button")
    public void clickFourthPage() {
        PaginationPage.pageFourButton.click();
    }

    // Step to click on the next page button
    @Step("Click on the next page button")
    public void clickNextPage() {
        PaginationPage.nextPageButton.click();
    }

    // Step to click on the previous page button
    @Step("Click on the previous page button")
    public void clickPreviousPage() {
        PaginationPage.previousPageButton.click();
    }

    // Step to click on the last page button
    @Step("Click on the last page button")
    public void clickLastPage() {
        PaginationPage.lastPageButton.click();
    }

    // Verify that we are on the expected page (you can customize this step if needed)
    @Step("Verify that the current page is {0}")
    public void verifyCurrentPage(String expectedPageNumber) {
        String actualPageNumber = PaginationPage.currentPageButton.getText();
        if (!actualPageNumber.equals(expectedPageNumber)) {
            throw new AssertionError(
                    "Expected to be on page " + expectedPageNumber + " but was on page " + actualPageNumber
            );
        }
    }
    public String getCurrentPageNumber() {
        withTimeoutOf(Duration.ofSeconds(5))
                .waitFor(PaginationPage.currentPageButton);
        return PaginationPage.currentPageButton.getText().trim(); // Ensure whitespace is removed
    }

    public void verifyNextPage() {
        // Wait for the next page to load and become visible
        withTimeoutOf(Duration.ofSeconds(5))
                .waitFor(ExpectedConditions.visibilityOf(PaginationPage.currentPageButton));
        String currentPageButtonText = PaginationPage.currentPageButton.getText();

        // Validate that the page number has incremented
        int expectedNextPage = Integer.parseInt(currentPageButtonText)+1;
        if (!currentPageButtonText.equals(String.valueOf(expectedNextPage))) {
            throw new AssertionError(
                    "Expected to be on page " + expectedNextPage + " but was on page " + currentPageButtonText
            );
        }
    }

    public void verifyPrevPage() {
        // Wait for the next page to load and become visible
        withTimeoutOf(Duration.ofSeconds(5))
                .waitFor(ExpectedConditions.visibilityOf(PaginationPage.currentPageButton));
        String currentPageButtonText = PaginationPage.currentPageButton.getText();

        // Validate that the page number has incremented
        int expectedNextPage = Integer.parseInt(currentPageButtonText)-1;
        if (!currentPageButtonText.equals(String.valueOf(expectedNextPage))) {
            throw new AssertionError(
                    "Expected to be on page " + expectedNextPage + " but was on page " + currentPageButtonText
            );
        }
    }
}
