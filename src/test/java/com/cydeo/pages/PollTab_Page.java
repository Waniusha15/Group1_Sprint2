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

}
