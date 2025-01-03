package starter.steps;

import actions.NavigationSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class NavigationStepDefinitions {

    @Steps
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
        navigationSteps.verifyOffersPage();
    }
}
