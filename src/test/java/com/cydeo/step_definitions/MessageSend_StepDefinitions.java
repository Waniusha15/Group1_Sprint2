package com.cydeo.step_definitions;

import com.cydeo.pages.MessageSend_Page;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class MessageSend_StepDefinitions {

    MessageSend_Page messageSendPage=new MessageSend_Page();


    @When("User click the message tab")
    public void user_click_the_message_tab() {
        messageSendPage.messageTab.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    Random randomNumber=new Random();
    int showMe=randomNumber.nextInt(100);
    @When("User filled the message on the message content and recipients")
    public void user_filled_the_message_on_the_message_content_and_recipients() {
       Driver.getDriver().switchTo().frame(messageSendPage.iframe);
       messageSendPage.messageText.sendKeys("Sample Message "+showMe );
       Driver.getDriver().switchTo().parentFrame();

    }
    @When("User click the send button")
    public void user_click_the_send_button(){
        messageSendPage.sendButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));



    }
    @Then("User see message on the board")
    public void userSeeMessageOnTheBoard(){
      String textMessage=messageSendPage.lastMessageText.getText();
      Assert.assertEquals(textMessage,"Sample Message "+showMe);

    }

    @When("User click send button without message content")
    public void user_click_send_button_without_message_content() {
        messageSendPage.sendButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }
    @Then("User see error message for message content")
    public void user_see_error_message_for_message_content() {
        String expectedMessageErrorText="The message title is not specified";
        Assert.assertEquals(messageSendPage.messageErrorText.getText(),expectedMessageErrorText);

    }
    @Then("User click send button without recipients")
    public void user_click_send_button_without_recipients() {
        messageSendPage.closeAllEmployeesButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        messageSendPage.sendButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


    }
    @Then("User see error message for recipients")
    public void user_see_error_message_for_recipients() {
        String expectedRecipientErrorText="Please specify at least one person.";
        Assert.assertEquals(messageSendPage.messageErrorText.getText(),expectedRecipientErrorText);

    }

    @When("User see all employees button as recipient by default")
    public void user_see_all_employees_button_as_recipient_by_default() {
        Assert.assertTrue(messageSendPage.allEmployeesButton.isDisplayed());
        Assert.assertTrue(messageSendPage.allEmployeesButton.isEnabled());
    }

    @When("User click the cancel button")
    public void user_click_the_cancel_button() {
        messageSendPage.cancelButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Then("User see send message... message")
    public void user_see_send_message_message() {
       Assert.assertEquals(messageSendPage.sendMessageText.getText(),"Send message …");
    }








}
