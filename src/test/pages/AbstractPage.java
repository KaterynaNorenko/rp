package pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public abstract class AbstractPage {

    protected WebDriver driver = DriverManager.getDriver();

    protected AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilElementVisible(WebElement element, Duration timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementVisible(WebElement element) {
        waitUntilElementVisible(element, Duration.ofSeconds(20));
    }

    public void verifyPageTitle(String expectedText) {
        assertTrue(
                "Title does not contain expected text. Expected: " + expectedText +
                " but was: " + driver.getTitle(),
                driver.getTitle().contains(expectedText)
        );
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        new Select(element).selectByVisibleText(visibleText);
    }
}
