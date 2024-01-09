package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.pages.PollTab_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class PollTab_StepDefinitions {
    Login_Page loginPage = new Login_Page();
    PollTab_Page pollTabPage = new PollTab_Page();

    Wait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @When("user clicks on the Poll tab")
    public void user_clicks_on_the_poll_tab() {
        pollTabPage.pollTabButton.click();

    }
    @Then("user sees default To: All Employees")
    public void user_sees_default(){
        BrowserUtils.waitForTitleContains("Portal");
        String actualResult = pollTabPage.toAllEmployees.getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.equals("All employees"));
    }

    @When("{string} user logs in successfully")
    public void userLogsInSuccessfully(String userType) {
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

    @Then("user is on home page")
    public void userIsOnHomePage() {
        BrowserUtils.verifyURLContains("login=yes");
    }


    @Given("user types in a title message: {string}")
    public void userTypesInATitleMessage(String message) throws InterruptedException {
        WebElement iframe  = Driver.getDriver().findElement(By.className("bx-editor-iframe"));
        Driver.getDriver().switchTo().frame(iframe);
        pollTabPage.messageBox.sendKeys(message);
        Driver.getDriver().switchTo().parentFrame();
    }

    @And("user provides a question: {string}")
    public void userProvidesAQuestion(String question) {
        pollTabPage.questionBox.sendKeys(question);
    }

    @And("user adds at least one answer")
    public void userAddsAtLeastOneAnswer() {
        pollTabPage.answer1Box.sendKeys("school");
        pollTabPage.answer2Box.sendKeys("bootcamp");
    }

    @Then("user clicks send")
    public void userClicksSend() {
        pollTabPage.sendButton.click();
    }


    @And("user can see the title message: {string} at the top of activity stream")
    public void userCanSeeTheTitleMessageAtTheTopOfActivityStream(String messageOnActivityPage) {
        BrowserUtils.sleep(2);
        Assert.assertTrue(pollTabPage.pollOnActivityPage.getText().equals(messageOnActivityPage));

    }


    @When("user clicks on the multiple choice box")
    public void userClicksOnTheMultipleChoiceBox() {
        pollTabPage.multipleChoiceBox.click();
    }

    @Then("multiple choice box remains selected")
    public void multipleChoiceBoxRemainsSelected() {
        Assert.assertTrue(pollTabPage.multipleChoiceBox.isSelected());
    }
}
