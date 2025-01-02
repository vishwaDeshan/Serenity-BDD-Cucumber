package actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import pageObjects.OffersPage;
import java.util.List;
import java.util.stream.Collectors;

public class SortingSteps extends UIInteractionSteps {

    @Step("Navigate to the Offers Page")
    public void openOffersPage() {
        openUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    @Step("Click on the 'Veg/fruit name' column header")
    public void clickVegFruitNameHeader() {
        find(OffersPage.VEG_FRUIT_NAME_HEADER).click();
    }

    @Step("Verify names are sorted in ascending order")
    public boolean verifyAscendingOrder() {
        List<String> names = findAll(OffersPage.VEG_FRUIT_NAME_COLUMN)
                .stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());

        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        return names.equals(sortedNames);
    }

    @Step("Verify names are sorted in descending order")
    public boolean verifyDescendingOrder() {
        List<String> names = findAll(OffersPage.VEG_FRUIT_NAME_COLUMN)
                .stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());

        List<String> sortedNames = names.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        return names.equals(sortedNames);
    }
}
