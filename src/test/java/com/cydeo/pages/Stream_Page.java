package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stream_Page {

    public Stream_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement messageWindowButton;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    private WebElement uploadFileButton;

    @FindBy(xpath = "(//div[@class='diskuf-extended']//td//input)[1]")
    private WebElement uploadOrDragFileInput;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendMessageButton;


}
