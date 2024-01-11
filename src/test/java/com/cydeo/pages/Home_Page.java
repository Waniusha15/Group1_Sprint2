package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

    public Home_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (id = "feed-add-post-form-link-text")
    public WebElement MoreOptionButton;

    @FindBy (xpath = "(//span[.='Appreciation'])[2]")
    public WebElement AppreciationOptionButton;

    @FindBy (xpath = "//body[@contenteditable='true']")
    public WebElement sendKeysBox;

    @FindBy (xpath = "//span[@data-id='UA']")
    public WebElement allEmployee;

    @FindBy (css = "button[id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy (css = "div[id='pagetitle']")
    public WebElement activityStream;

    @FindBy (xpath = "//iframe[@class=\"bx-editor-iframe\"]")
    public WebElement iframe;

    @FindBy (xpath = "//div[@class='feed-add-error']")
    public WebElement titleNotSpecified;

    @FindBy (xpath = "//span[.='Please specify at least one person.']")
    public WebElement SpecifyAPerson;

    @FindBy (xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement allEmployeeButton;


    @FindBy (xpath = "(//span[.='All employees'])[3]")
    public WebElement allEmployeesButton;

    @FindBy (css = "button[id='blog-submit-button-cancel']")
    public WebElement cancelButton;

}
