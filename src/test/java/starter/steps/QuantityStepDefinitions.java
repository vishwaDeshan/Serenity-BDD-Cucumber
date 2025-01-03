package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import actions.QuantitySteps;

public class QuantityStepDefinitions {

    QuantitySteps quantitySteps;

    @Given("I am on the home page to check quantity")
    public void iAmOnTheHomePageQuantity() {
        quantitySteps.openHomePageWithQuantity();
    }

    @When("I click the increment button")
    public void iClickTheIncrementButton() {
        quantitySteps.clickIncrement();
    }

    @Then("the quantity value should increase by 1")
    public void theQuantityValueShouldIncreaseBy1() {
        int currentQuantity = quantitySteps.getCurrentQuantity();
        Assert.assertEquals("The quantity value should increase by 1.", 2, currentQuantity);
    }

    @When("I click the decrement button")
    public void iClickTheDecrementButton() {
        quantitySteps.clickDecrement();
    }

    @Then("the quantity value should decrease by 1")
    public void theQuantityValueShouldDecreaseBy1() {
        int currentQuantity = quantitySteps.getCurrentQuantity();
        Assert.assertEquals("The quantity value should decrease by 1.", 1, currentQuantity);
    }
}
