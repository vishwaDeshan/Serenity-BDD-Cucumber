package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import actions.SearchSteps;

public class SearchStepDefinitions {

    SearchSteps searchSteps;

    @Given("I am on the search page")
    public void iAmOnTheSearchPage() {
        searchSteps.openSearchPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String itemName) {
        searchSteps.searchForItem(itemName);
    }

    @Then("I should see results containing {string}")
    public void iShouldSeeResultsContaining(String itemName) {
        Assert.assertTrue("The search results should contain the item.", searchSteps.verifySearchResults(itemName));
    }

    @Then("I should see a message indicating no results")
    public void iShouldSeeAMessageIndicatingNoResults() {
        Assert.assertTrue("A 'no results' message should be displayed.", searchSteps.verifyNoResultsMessage());
    }
}

