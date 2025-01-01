package starter.steps;

import actions.PaginationSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class PaginationStepDefinitions {

    PaginationSteps paginationSteps;


    @Given("I open Google in a browser")
    public void iOpenGoogleInABrowser() {
        paginationSteps.openGooglePage();
    }

    @Given("I am on the Offer page")
    public void I_am_on_offer_page() {
        paginationSteps.openOfferPage();
    }

    @Then("I click on the first page button")
    public void click_first_page_button(){
        paginationSteps.openOfferPage();
    }

    @Then("I should be on the first page")
    public void should_be_on_first_page() {
        paginationSteps.verifyCurrentPage("1"); // Pass the expected page number as "1"
    }

    @Then("I click on the second page button")
    public void click_second_page_button() {
        paginationSteps.clickSecondPage();
    }

    @Then("I should be on the second page")
    public void should_be_on_second_page() {
        paginationSteps.verifyCurrentPage("2"); // Pass the expected page number as "1"
    }

    // Step to click the next page button
    @Then("I click on the next button")
    public void click_next_page_button() {
        paginationSteps.clickNextPage();
    }

    @Then("I should be on the next page")
    public void should_be_on_next_page() {
        paginationSteps.verifyNextPage(); // Validate the page has changed to the next one
    }

    // Step to click the previous page button
    @Then("I click on the previous button")
    public void click_previous_page_button() {
        paginationSteps.clickPreviousPage();
    }

    @Then("I should be on the previous page")
    public void should_be_on_prev_page() {
        paginationSteps.verifyNextPage(); // Validate the page has changed to the next one
    }
    // Step to click the last page button
    @Then("I click on the last page button")
    public void click_last_page_button() {
        paginationSteps.clickLastPage();
    }
    @Then("I should be on the last page")
    public void should_be_on_last_page() {
        paginationSteps.verifyNextPage(); // Validate the page has changed to the next one
    }
    // Step to click on a specific page button (for example, page 3)
    @Then("I click on the page {string} button")
    public void click_on_specific_page_button(String pageNumber) {
        if(pageNumber.equals("1")) {
            paginationSteps.clickFirstPage();
        } else if(pageNumber.equals("2")) {
            paginationSteps.clickSecondPage();
        } else if(pageNumber.equals("3")) {
            paginationSteps.clickThirdPage();
        }
        // You can add more pages here if necessary
    }

    // Step to verify the current page
    @Then("I should be on the page {string}")
    public void verify_current_page(String expectedPage) {
        paginationSteps.verifyCurrentPage(expectedPage);  // Implement the verification logic inside PaginationSteps
    }
}
