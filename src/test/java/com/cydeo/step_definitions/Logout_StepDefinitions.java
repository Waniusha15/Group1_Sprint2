package com.cydeo.step_definitions;

import com.cydeo.pages.Logout_Page;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Logout_StepDefinitions {
    Logout_Page logoutPage = new Logout_Page();
    @Then("user clicks on his profile")
    public void user_clicks_on_his_profile() {
       logoutPage.profileButton.click();
    }
    @Then("user clicks on Log out button")
    public void user_clicks_on_log_out_button() {
        for (WebElement each_profileOption : logoutPage.profileOptions) {
            if(each_profileOption.getText().equals("Log out")){
                each_profileOption.click();
            }
        }
    }
    @Then("user should land on the login page with title {string}")
    public void user_should_land_on_the_login_page_with_title(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @And("user sees following options")
    public void user_sees_following_options(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>();
        for (WebElement each_profileOption : logoutPage.profileOptions) {
            actualOptions.add(each_profileOption.getText());
        }
        Assert.assertEquals(actualOptions,expectedOptions);

    }
}
