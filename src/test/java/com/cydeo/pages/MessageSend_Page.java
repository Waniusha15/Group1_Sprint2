package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageSend_Page {
    public MessageSend_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath ="//a[@title='Activity Stream']")
    public WebElement activityStreamTab;

    @FindBy (id = "feed-add-post-form-tab-message")
    public WebElement messageTab;

    @FindBy (xpath = "//body[@contenteditable='true']")
    public WebElement messageText;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "(//div[@class='feed-post-text-block'])[1]")
    public WebElement lastMessageText;

   // @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    //public WebElement sendButton;

    @FindBy (xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy (xpath = "//span[@class='feed-add-info-text']")
    public WebElement messageErrorText;

    @FindBy (xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement closeAllEmployeesButton;

    @FindBy(xpath = "//span[@data-id='UA']")
    public WebElement allEmployeesButton;

    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;

    @FindBy(xpath ="//span[@class='feed-add-post-micro-title']")
    public WebElement sendMessageText;







}
