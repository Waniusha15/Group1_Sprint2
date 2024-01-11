package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard_Page {



    public Dashboard_Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageButton;



    @FindBy(xpath ="//span[@class='feed-add-post-form-link feed-add-post-form-link-active']/following-sibling::span" )

    public List<WebElement> fallowingModules;



  @FindBy(id = "feed-add-post-form-link-text")
  public WebElement moreButton;




    @FindBy(css = ".menu-popup-item-text")

  public   List<WebElement>   moreModules;



}
