package com.cydeo.step_definitions;

import com.cydeo.pages.EmployeesPage;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddDepartment_StepDefinitions {

    Login_Page loginPage = new Login_Page();
    EmployeesPage employeePage = new EmployeesPage();
    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {

        if(userType.equals("hr")){
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("hrLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("hrPassword"));
            loginPage.loginButton.click();
        } else if (userType.equals("helpdesk")) {
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("helpdeskLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("helpdeskPassword"));
            loginPage.loginButton.click();
        }else{
            loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("marketingLogin"));
            loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("marketingPassword"));
            loginPage.loginButton.click();
        }

    }
    @When("clicks to Employees button")
    public void clicks_to_employees_button() {

        WebElement employeesButton = Driver.getDriver().findElement(By.xpath("//li[@data-id='menu_company']"));
        employeesButton.click();


    }
    @Then("user should see {string} page")
    public void user_should_see_page(String expectedTitle) {

        BrowserUtils.verifyTitleContains(expectedTitle);

    }


    @When("user logs in as hr")
    public void user_logs_in_as_hr() {

        loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("hrLogin"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("hrPassword"));
        loginPage.loginButton.click();

    }

    @And("user should see ADD DEPARTMENT button and clicks")
    public void userShouldSeeADDDEPARTMENTButtonAndClicks() {

        employeePage.addDepartmentButton.click();
    }

    @And("user should enter the department name")
    public void userShouldEnterTheDepartmentName() {

        employeePage.inputDepartmentName.sendKeys("123" + Keys.ENTER);
    }

    @And("user should select the parent department")
    public void userShouldSelectTheParentDepartment() {

        Select select = new Select(employeePage.parentDepartmentDropdown);

        select.selectByIndex(1);

    }

    @Then("user should click {string} button")
    public void userShouldClickButton(String arg0) {

        employeePage.addButton.click();
    }




    @When("user logs in as Helpdesk user")
    public void userLogsInAsHelpdeskUser() {

        loginPage.loginInput.sendKeys(ConfigurationReader.getProperty("helpdeskLogin"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("helpdeskPassword"));
        loginPage.loginButton.click();
    }

    @And("user should not see ADD DEPARTMENT button")
    public void userShouldNotSeeADDDEPARTMENTButton() {

        BrowserUtils.verifyElementNotDisplayed(By.xpath("//a[contains(@class,'webform-small-button-add')]"));


    }
}
//    List< WebElement > employeeButton = Driver.getDriver().findElements(By.xpath("//span[@class='menu-item-link-text']"));
//        for (WebElement webElement : employeeButton) {
//                if(webElement.getText().equals("Employees")){
//                webElement.click();
//                }
//                }
