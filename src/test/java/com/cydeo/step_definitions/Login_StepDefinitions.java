package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_StepDefinitions {
    Login_Page loginPage = new Login_Page();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user is logs in as {string}")
    public void user_is_logs_in_as(String userType) {
       loginPage.login(userType);
    }
    @Then("user should land on Home page with {string} in title")
    public void user_should_land_on_home_page_with_in_title(String keyWordInTitle) {
        BrowserUtils.verifyTitleContains(keyWordInTitle);
    }
    @When("user logs in with invalid {string} and {string}")
    public void user_logs_in_with_invalid_and(String username, String password) {
        loginPage.loginInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expected_error_message) {
        Assert.assertEquals(loginPage.errorMessage.getText(),expected_error_message);
    }
    @Then("user see on the page {string} box")
    public void user_see_on_the_page_box(String rememberMe_text) {
       Assert.assertEquals(loginPage.rememberMe_text.getText(),rememberMe_text);
    }
    @Then("user is able to click on Remember me on this computer checkbox")
    public void user_is_able_to_click_on_remember_me_on_this_computer_checkbox() {
        loginPage.rememberMe_checkbox.click();
        Assert.assertTrue(loginPage.rememberMe_checkbox.isSelected());
    }
    @Then("user type his password in password input line")
    public void user_type_his_in_password_input_line() {
       loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("hrPassword"));
    }
    @Then("password should be masked by default")
    public void password_should_be_masked_by_default() {
        String attributeValue = loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals("password", attributeValue);
    }
}
