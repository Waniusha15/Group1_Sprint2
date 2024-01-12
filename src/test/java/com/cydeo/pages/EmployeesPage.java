package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeesPage {

    public EmployeesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[contains(@class,'webform-small-button-add')]")
    public WebElement addDepartmentButton;

    @FindBy(css = "input#NAME")
    public WebElement inputDepartmentName;

    @FindBy(xpath = "//select[@id='IBLOCK_SECTION_ID']")
    public WebElement parentDepartmentDropdown;

    @FindBy(xpath = "//span[.='Add']")
    public WebElement addButton;


}
