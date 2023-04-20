package steps;


import io.cucumber.java.en.Then;

import static driver.DriverManager.quitDriver;

public class CommonSteps {

    @Then("I close the browser")
    public void closeBrowser(){
        quitDriver();
    }
}
