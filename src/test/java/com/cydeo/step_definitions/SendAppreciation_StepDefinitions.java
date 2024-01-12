package com.cydeo.step_definitions;


import com.cydeo.pages.Home_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendAppreciation_StepDefinitions {

    Home_Page homePage = new Home_Page();
    Login_Page loginPage = new Login_Page();

    @Given("user logs in and already on the home page")
    public void userLogsInAndAlreadyOnTheHomePage() {
         Driver.getDriver().get(ConfigurationReader.getProperty("url"));
         loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("hrLogin"));
         loginPage.passwordInput.sendKeys((ConfigurationReader.getProperty("hrPassword")));
         loginPage.loginButton.click();
    }
    @Then("user launched to home page")
    public void userLaunchedToHomePage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleContains("Portal"));
    }

    @When("User on stream page click More button")
    public void user_on_stream_page_click_button() {
           homePage.MoreOptionButton.click();
    }
    @Then("User should click Appreciation on the option")
    public void user_should_click_on_the_option() {
          homePage.AppreciationOptionButton.click();
    }
    @When("User types {string} in the message field")
    public void user_types_in_the_message_field(String string) {
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.sendKeysBox.sendKeys(string);
        Driver.getDriver().switchTo().parentFrame();
    }
    @Then("User should send the message to All employee")
    public void user_should_send_the_message_to() {
        BrowserUtils.verifyElementDisplayed(homePage.allEmployee);
    }
    @When("User should click SEND button")
    public void user_should_click_button() {
        homePage.sendButton.click();
    }

    @Then("User should verify Activity Stream is displayed")
    public void userShouldVerifyIsDisplayed() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
         BrowserUtils.verifyElementDisplayed(homePage.activityStream);

    }


    @Then("User should see {string} as an Error message")
    public void userShouldSeeAsAnErrorMessage(String expectedTitle) {
           String actualTitle = homePage.titleNotSpecified.getText();
           Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("User not specify anyone to sending appreciation")
    public void userNotSpecifyAnyoneToSendingAppreciation() {
             homePage.allEmployeeButton.click();
    }

    @Then("User see {string}")
    public void userSee(String expectedMessage) {
        String actualMessage = homePage.SpecifyAPerson.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Then("User should see the delivery button {string} displayed by default.")
    public void userShouldSeeTheDeliveryIsAllEmployeesByDefault(String expectedDeliveryButton) {
        String actualAllEmployeeButton = homePage.allEmployeesButton.getText();
        Assert.assertEquals(actualAllEmployeeButton,expectedDeliveryButton);
    }

    @Then("User can click Cancel button to cancel sending appreciation any time")
    public void userCanClickCancelButtonToCancelSendingAppreciationAnyTime() {
        homePage.cancelButton.click();
    }
}