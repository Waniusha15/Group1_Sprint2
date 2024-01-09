package com.cydeo.utilities;

import com.cydeo.pages.Login_Page;

public class CRM_Utils {
    public static void login(String user) {
        var pom = new Login_Page();
        String loginEmail;
        String password = ConfigurationReader.getProperty("helpdeskPassword");
        if (user.equalsIgnoreCase("helpdesk"))
            loginEmail = ConfigurationReader.getProperty("helpdesk99@cybertekschool.com");
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
