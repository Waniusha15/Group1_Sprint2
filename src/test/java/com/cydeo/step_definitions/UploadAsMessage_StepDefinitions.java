package com.cydeo.step_definitions;

import com.cydeo.utilities.CRM_Utils;
import io.cucumber.java.en.Given;

public class UploadAsMessage_StepDefinitions {
    @Given("user logged in as {string} and launched to the main page")
    public void userLoggedInAsAndLaunchedToTheMainPage(String userType) {
        CRM_Utils.login(userType);
    }
}
