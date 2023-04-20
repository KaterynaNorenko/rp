package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class LoginPage extends AbstractPage{

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    private WebElement loginPageLoginInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement loginPagePasswordInput;

    public void loginApplication(String login, String password){
        loginPageLoginInput.sendKeys(login);
        loginPagePasswordInput.sendKeys(password);
        loginPageLoginInput.sendKeys(ENTER);
    }

    public void waitUntilLoginIsEnabled(){
        waitUntilElementVisible(loginPageLoginInput);
    }
}
