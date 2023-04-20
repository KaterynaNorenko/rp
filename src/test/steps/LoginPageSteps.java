package steps;

import io.cucumber.java.en.Given;
import pages.LoginPage;

import java.io.IOException;
import java.io.UncheckedIOException;

import static driver.DriverManager.getDriver;
import static steps.LocalConfigReader.getReportPortalLogin;
import static steps.LocalConfigReader.getReportPortalPassword;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();
    LocalConfigReader localConfig = new LocalConfigReader();

    public LoginPageSteps() throws IOException {}

    @Given("^I open Report Portal for '(.*)'$")
    public void openReportPortal(String urlName){
        try {PropertiesReader config = new PropertiesReader("configuration.properties");
            getDriver().manage().deleteAllCookies();
            getDriver().get(config.getUrl(urlName));
        } catch (IOException e) {
            throw new UncheckedIOException("Unable to reach url " + urlName, e);
        }

    }

    @Given("^I am logged into account$")
    public void loginIntoAccount(){
        loginPage.waitUntilLoginIsEnabled();
        loginPage.loginApplication(getReportPortalLogin(), getReportPortalPassword());
    }
}
