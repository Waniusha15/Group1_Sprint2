package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PollTab_Page {

    public PollTab_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//span[.='Poll'])[2]")
    public WebElement pollTabButton;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement toAllEmployees;

    @FindBy(xpath = "//body[@style='min-height: 184px;']")
    public WebElement messageBox;

    @FindBy(id = "question_0")
    public WebElement questionBox;

    @FindBy(id = "answer_0__0_")
    public WebElement answer1Box;

    @FindBy(id = "answer_0__1_")
    public WebElement answer2Box;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    public WebElement sendButton;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement pollOnActivityPage;

    @FindBy(id = "multi_0")
    public WebElement multipleChoiceBox;



}
