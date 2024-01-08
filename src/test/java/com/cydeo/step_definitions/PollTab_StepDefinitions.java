package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.pages.PollTab_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
}
