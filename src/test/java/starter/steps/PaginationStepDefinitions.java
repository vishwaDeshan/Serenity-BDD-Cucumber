package starter.steps;

import actions.PaginationSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import pageObjects.NavigationPage;

import static org.junit.Assert.assertTrue;

public class PaginationStepDefinitions {

    PaginationSteps paginationSteps;
    @Given("I am on the {string} page with pagination")
    public void iAmOnThePageWithPagination(String page) {
        paginationSteps.openOfferPage(page);
    }

    @When("I click on the next page button")
    public void iClickOnTheNextPageButton() {
        paginationSteps.iClickOnTheNextPageButton();
    }

    @Then("the page number should update to {int}")
    public void thePageNumberShouldUpdateTo(int pageNumber) {
        paginationSteps.PageNumberShouldUpdateTo(pageNumber);
    }

    @Then("the page number should update to click previous {int}")
    public void thePageNumberShouldUpdate(int pageNumber) {
        paginationSteps.PageNumberShouldUpdate(pageNumber);
    }
    @When("I click on the previous page button")
    public void iClickOnThePrevPageButton() {
        paginationSteps.iClickOnThePrevPageButton();
    }



}