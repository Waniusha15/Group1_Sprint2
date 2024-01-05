
    package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

    public class Driver {

        //Create a private constructor to reduce access to this object

        private Driver(){

        }

        //We make the WebDriver private to reduce access outside the class
        //We make the WebDriver static because we will use it in a static method.

        //private static WebDriver driver; // default value = null
        private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
        /*
        Create a re-usable utility method which will return the same driver instance once we call it.
        -   If an instance doesn't exist, it will create first, and it will always return the same instance.
         */
        public static WebDriver getDriver(){

            if(driverPool.get() == null){
                //we will read our browserType from the configuration.properties file.
                //this way we can control which browser is opened from outside our code.
                String browserType = ConfigurationReader.getProperty("browser");

        /*
        Depending on browserType returned from configuration.properties file
        switch statement will determine the "case" and open the matching browser.

         */
                switch (browserType){
                    case "chrome":
                        //WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "firefox":
                        //WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                }

            }

            return driverPool.get();

        }
        /*
        Create a new Driver.closeDriver();
        it will use .quit() method to quit browsers, and then set the driver value to null.
         */
        public static void closeDriver(){
            if(driverPool.get() != null){
                driverPool.get().quit();
                driverPool.remove();
            }
        }

    }


