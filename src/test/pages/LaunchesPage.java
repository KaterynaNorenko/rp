package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LaunchesPage extends AbstractPage {

    public LaunchesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'allLatestDropdown')]")
    private WebElement launchesPageName;

    @FindBy(xpath = "//a[contains(@href,'launches')][contains(@class,'sidebarButton')]")
    private WebElement launchesSideButton;

    @FindBy(xpath = "//div[contains(@class,'allLatestDropdown__arrow')]")
    private WebElement launchesDropdownArrow;

    @FindBy(xpath = "//div[(text()='Latest launches')][contains(@class,'option')]")
    private WebElement launchesDropdownLatestLaunches;

    @FindBy(xpath = "//div[(text()='All launches')][contains(@class,'option')]")
    private WebElement launchesDropdownAllLaunches;

    @FindBy(xpath = "//div[contains(@class,'itemCounter')]")
    private WebElement itemCounter;

    @FindBy(xpath = "//*[contains(@class,'breadcrumb__link-item')]")
    private WebElement actionPannelName;

    public void waitUntilLaunchesPageNameIsVisible() {
        waitUntilElementVisible(launchesPageName);
    }

    public void pressLaunchesSideButton() {
        launchesSideButton.click();
    }

    public void pressLaunchesDropdown() {
        launchesDropdownArrow.click();
    }

    public void chooseLaunches(String launches) {
        WebElement launchesType = "Latest".equals(launches)
                              ? launchesDropdownLatestLaunches
                              : launchesDropdownAllLaunches;
        launchesType.click();
    }

    public void verifyNumberOfItems(String expectedText){
        assertTrue(
                "Items do not equal expected number. Expected: " + expectedText +
                " but was: " + itemCounter.getText(),
                itemCounter.getText().contains(expectedText)
        );
    }

    public void verifyActionPannelText(String expectedText){
        assertTrue(
                "Action Pannel does not contain expected text. Expected: " + expectedText +
                " but was: " + actionPannelName.getText(),
                actionPannelName.getText().contains(expectedText)
        );
    }
}
