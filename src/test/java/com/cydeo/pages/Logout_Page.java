package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Logout_Page {
    public Logout_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "user-block")
    public WebElement profileButton;

    @FindBy(css = "[class^='menu-popup-item menu-popup-no-icon']")
    public List<WebElement> profileOptions;

}
