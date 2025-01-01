package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import actions.NavigationSteps;

public class NavigationStepDefinitions {

    NavigationSteps navigationSteps;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        navigationSteps.openHomePage();
    }

    @When("I navigate to the Offers Page")
    public void iNavigateToTheOffersPage() {
        navigationSteps.navigateToOffersPage();
    }

    @Then("I should be redirected to the Offers Page")
    public void iShouldBeRedirectedToTheOffersPage() {
        Assert.assertTrue("The user should be on the Offers page.", navigationSteps.isOnOffersPage());
    }
}
