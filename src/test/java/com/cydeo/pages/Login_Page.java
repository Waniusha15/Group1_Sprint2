package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (name = "USER_LOGIN")
    public WebElement loginInput;
    @FindBy (name = "USER_PASSWORD")
    public WebElement passwordInput;
    @FindBy (className = "login-btn")
    public WebElement loginButton;
    @FindBy(xpath = "//div[.='Incorrect login or password']")
    public WebElement errorMessage;

    @FindBy(className = "login-item-checkbox-label")
    public WebElement rememberMe_text;
    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMe_checkbox;
}
