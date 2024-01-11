package com.cydeo.step_definitions;

import com.cydeo.pages.Login_Page;
import com.cydeo.pages.MyProfile_Page;
import com.cydeo.pages.ProfileIcon_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyPage_StepDefinitions {

    ProfileIcon_Page profilePage = new ProfileIcon_Page();
    MyProfile_Page myProfilePage = new MyProfile_Page();

    Login_Page loginPage = new Login_Page();


    @When("user is logs in as {string} and password {string}")
    public void user_is_logs_in_as(String user, String password) {
        loginPage.loginInput.sendKeys(user);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("user clicks profile dropdown")
    public void user_clicks_profile_dropdown() {
        profilePage.profileIconLink.click();
        BrowserUtils.sleep(1);

    }

    @Then("user clicks My Profile option from profile options")
    public void user_clicks_option_from_profile_options() {
        myProfilePage.myProfileIconLink.click();
        BrowserUtils.sleep(1);
    }

    @Then("user should be able to see the following options on my Profile page like {string}")
    public void user_should_be_able_to_see_the_following_options_on_my_profile_page_like(String expectedOptions) {
        List<WebElement> actualElements = Driver.getDriver().findElements(By.className("profile-menu-item"));
        Set<String> actualOptions = new HashSet<>(); // Set does not keep duplicates elements.
        for (WebElement actualElement : actualElements) {
            actualOptions.add(actualElement.getText());
        }
        for (String expectedOption : expectedOptions.split(",")) {
            Assert.assertTrue(actualOptions.contains(expectedOption));
        }
    }

}
