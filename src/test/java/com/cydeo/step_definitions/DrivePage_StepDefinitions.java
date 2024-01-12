package com.cydeo.step_definitions;

import com.cydeo.pages.Drive_Page;
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

public class DrivePage_StepDefinitions {

    Drive_Page drivePage = new Drive_Page();

    @When("user clicks Drive page")
    public void user_clicks_drive_page() {
    drivePage.drivePageLocation.click();
        BrowserUtils.sleep(1);


    }
    @Then("user should be able to see the following options on Drive page like {string}")
    public void user_should_be_able_to_see_the_following_options_on_drive_page_like(String expectedOptions) {
        List<WebElement> actualElements = Driver.getDriver().findElements(By.className("main-buttons-item-text-title"));

        Set<String> actualOptions = new HashSet<>(); // Set does not keep duplicates elements.
        for (WebElement actualElement : actualElements) {
            actualOptions.add(actualElement.getText());
        }
        for (String expectedOption : expectedOptions.split(",")) {
            Assert.assertTrue(actualOptions.contains(expectedOption));
        }



    }
}
