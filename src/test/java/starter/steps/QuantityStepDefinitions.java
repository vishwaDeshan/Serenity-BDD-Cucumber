package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import actions.QuantitySteps;

public class QuantityStepDefinitions {

    QuantitySteps quantitySteps;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        quantitySteps.openHomePage();
    }

    @When("I click the increment button")
    public void iClickTheIncrementButton() {
        quantitySteps.clickIncrement();
    }

    @When("I click the decrement button")
    public void iClickTheDecrementButton() {
        quantitySteps.clickDecrement();
    }

    @Then("the quantity value should increase by 1")
    public void theQuantityValueShouldIncreaseBy1() {
        Assert.assertEquals("The quantity value should increase by 1.",
                quantitySteps.getCurrentQuantity(), 2);
    }

    @Then("the quantity value should decrease by 1")
    public void theQuantityValueShouldDecreaseBy1() {
        Assert.assertEquals("The quantity value should decrease by 1.",
                quantitySteps.getCurrentQuantity(), 0);
    }
}
