package com.cydeo.step_definitions;

import com.cydeo.pages.Activity_St_Page;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Activity_St_Page_Definitions {


    Activity_St_Page dashboard_page = new Activity_St_Page();

    /*
    @Then("user should able to see Message option")
    public void user_should_able_to_see_message_option()   {

        String actualText = Driver.getDriver().getTitle();
        String expectedTitle = "MESSAGE";

        Assert.assertEquals(actualText,expectedTitle);


     */




    /*

    @Then("User should able to see fallowing modules")
    public void user_should_able_to_see_fallowing_modules(List<String> expectedText) {

        List<String> actualModule = new ArrayList<>();

        for (WebElement eacModule : dashboard_page.allModules) {

            actualModule.add(eacModule.getText());
        }

        Assert.assertEquals(expectedText,actualModule);
    }


 */


    @Then("User should able to see fallowing {string}")
    public void userShouldAbleToSeeFallowing(String expectedText) {

        String actualText = dashboard_page.messageButton.getText();

        Assert.assertEquals(expectedText,actualText);

        if (actualText.equals(expectedText)){
            System.out.println(actualText+ " --> Passed");
        }else {
            System.out.println(actualText+" --> fail");

        }

    }


    @Then("User should able to see fallowing modules")
    public void userShouldAbleToSeeFallowingModules(List<String> expectedText) {

        List<String> actualMod = new ArrayList<>();


        for (WebElement eacModule : dashboard_page.fallowingModules) {

            actualMod.add(eacModule.getText());
        }

        Assert.assertEquals(expectedText,actualMod);

        if (actualMod.equals(expectedText)){
            System.out.println(actualMod+" --> passed");
        }else {

            System.out.println(actualMod+" --> fail");
        }


    }




   @When("user is enters the  more information")
    public void userIsEntersTheMoreInformation()  {

        dashboard_page.moreButton.click();
        BrowserUtils.waitFor(2);
    }


    @Then("User should able to see fallowing more modules")
    public void userShouldAbleToSeeFallowingMoreModules(List<String> expectedText) {
        List<String> actualModule = new ArrayList<>();


        for (WebElement eacModule : dashboard_page.moreModules) {

            actualModule.add(eacModule.getText());
        }

        Assert.assertEquals(expectedText,actualModule);


        if (actualModule.equals(expectedText)){
            System.out.println(actualModule+" -->passed");
        }else {
            System.out.println(actualModule+" --> fail");
        }


    }





}
