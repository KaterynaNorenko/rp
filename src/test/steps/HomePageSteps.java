package steps;

import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @Then("^I verify page title contains text '(.*)'$")
    public void verifyPageTitle(String expectedText) {
        homePage.waitUntilHomePageNameIsVisible();
        homePage.verifyPageTitle(expectedText);
    }
}
