package com.cydeo.utilities;

import com.cydeo.pages.Login_Page;
import org.openqa.selenium.By;

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

    public static boolean fileIsPicture(String fileExtension) {
        if (fileExtension.equals(".docx") ||
                fileExtension.equals(".pdf") ||
                fileExtension.equals(".txt")) {
            return false;
        }
        else if (fileExtension.equals(".jpeg") || fileExtension.equals(".png"))
            return true;
        else
            throw new IllegalArgumentException();
    }
}
