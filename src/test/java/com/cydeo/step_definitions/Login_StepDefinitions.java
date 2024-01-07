package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {
    Login_Page loginPage = new Login_Page();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user is logs in as {string}")
    public void user_is_logs_in_as(String userType) {
        if(userType.equals("hr")){
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("hrLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("hrPassword"));
            loginPage.loginButton.click();
        } else if (userType.equals("helpdesk")) {
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("helpdeskLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("helpdeskPassword"));
            loginPage.loginButton.click();
        }else{
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("marketingLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("marketingPassword"));
            loginPage.loginButton.click();
        }
    }
    @Then("user should land on Home page with {string} in title")
    public void user_should_land_on_home_page_with_in_title(String keyWordInTitle) {
        BrowserUtils.verifyTitleContains(keyWordInTitle);
    }
}
