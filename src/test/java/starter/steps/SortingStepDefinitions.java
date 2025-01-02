package starter.steps;

import actions.SortingSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SortingStepDefinitions {

    SortingSteps sortingSteps;

    @Given("I am on the offers page")
    public void iAmOnTheOffersPage() {
        sortingSteps.openOffersPage();
    }

    @When("I click on the {string} column header")
    public void iClickOnTheColumnHeader(String columnHeader) {
        if (columnHeader.equalsIgnoreCase("Veg/fruit name")) {
            sortingSteps.clickVegFruitNameHeader();
        } else {
            throw new IllegalArgumentException("Unsupported column header: " + columnHeader);
        }
    }

    @When("I click on the {string} column header twice")
    public void iClickOnTheColumnHeaderTwice(String columnHeader) {
        if (columnHeader.equalsIgnoreCase("Veg/fruit name")) {
            sortingSteps.clickVegFruitNameHeader();
            sortingSteps.clickVegFruitNameHeader();
        } else {
            throw new IllegalArgumentException("Unsupported column header: " + columnHeader);
        }
    }

    @Then("the names should be sorted in ascending order")
    public void theNamesShouldBeSortedInAscendingOrder() {
        Assert.assertTrue("The names should be sorted in ascending order.", sortingSteps.verifyAscendingOrder());
    }

    @Then("the names should be sorted in descending order")
    public void theNamesShouldBeSortedInDescendingOrder() {
        Assert.assertTrue("The names should be sorted in descending order.", sortingSteps.verifyDescendingOrder());
    }
}
