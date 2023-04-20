package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@title='All Dashboards']")
    private WebElement homePageName;

    public void waitUntilHomePageNameIsVisible(){
        waitUntilElementVisible(homePageName);
    }
}
