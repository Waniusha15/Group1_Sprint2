package com.cydeo.utilities;

import com.cydeo.pages.Login_Page;
import com.cydeo.pages.Stream_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CRM_Utils {
    public static void login(String user) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        var pom = new Login_Page();

        String loginEmail;
        String password = ConfigurationReader.getProperty("helpdeskPassword");
        if (user.equalsIgnoreCase("helpdesk"))
            loginEmail = ConfigurationReader.getProperty("helpdeskLogin");
        else if (user.equalsIgnoreCase("hr"))
            loginEmail = ConfigurationReader.getProperty("hrLogin");
        else if (user.equalsIgnoreCase("marketing"))
            loginEmail = ConfigurationReader.getProperty("marketingLogin");
        else
            throw new IllegalArgumentException();

        pom.loginInput.sendKeys(loginEmail);
        pom.passwordInput.sendKeys(password);
        pom.loginButton.click();
    }
}
