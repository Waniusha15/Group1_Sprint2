package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1 - Create properties an object from Properties class (create an object)
    //make it private, so it's not accessed from outside the class
    //make it static to make sure it's created and loaded before everything else.
    private static Properties properties = new Properties();

    static {

        try{
            //2 - Open the file in Java Memory using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 - Load the properties with file (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();

        }catch (IOException e){
            System.out.println("FILE NOT FOUND WITH GIVEN PATH");
            e.printStackTrace();
        }

    }

    //create utility method to use object to read
    //4 - Use properties object to read from the file (read properties)

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
