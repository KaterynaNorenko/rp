package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LaunchesPage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LaunchesPageSteps {

    private final LaunchesPage launchesPage = new LaunchesPage();
    final static Logger logger = Logger.getLogger(LaunchesPageSteps.class.getName());

    @Given("I go to the Launches Page")
    public void verifyPageTitle() {
        launchesPage.pressLaunchesSideButton();
        launchesPage.waitUntilLaunchesPageNameIsVisible();
    }

    @When("I press the launches drop-down")
    public void pressLaunchesDropdown() {
        launchesPage.pressLaunchesDropdown();
        logger.setLevel(Level.INFO);
        logger.info("User is opening the launches drop-down");
    }

    @When("^I choose the '(Latest|All)' launches$")
    public void chooseLaunches(String launches) {
        launchesPage.chooseLaunches(launches);
        logger.setLevel(Level.WARNING);
        logger.warning("User might be unable to choose launches type");
    }

    @Then("^I verify that there are (\\d+) launches in the results$")
    public void verifyResultLaunches(int resultNumber) {
        launchesPage.verifyNumberOfItems(String.valueOf(resultNumber));
    }

    @Then("^I verify the '(Latest|All)' launches are chosen$")
    public void verifyLaunchesAreChosen(String launches) {
        launchesPage.verifyActionPannelText(launches);
    }
}
