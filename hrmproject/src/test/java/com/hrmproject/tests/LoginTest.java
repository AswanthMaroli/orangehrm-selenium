package com.hrmproject.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrmproject.base.BaseClass;
import com.hrmproject.pageobjects.LoginPage;
import com.hrmproject.utilities.Log;


/*
 *  author : Aswanth Maroli
 *  date   : 01/03/2025
 * 
 */

public class LoginTest extends BaseClass { // Extend BaseClass

    private WebDriver driver;
    @Parameters("browser")
    @BeforeMethod(groups= {"smoke","sanity"})
    public void setUp(String browser) {
        loadConfig(); // Load configuration file
//        String browser = getProperties().getProperty("browser").trim(); // Trim extra spaces
        System.out.println("Browser from parameter: " + browser+" "); 
        driver =initializeBrowserAndOpenApplication(browser);

    }
    
    @Test(groups="sanity")
    public void successfulLoginTest() {
    	Log.startTestCase("successfulLoginTest");
        LoginPage loginPage = new LoginPage(driver);
        String userName = getProperties().getProperty("username");
        String password = getProperties().getProperty("password");
        loginPage.performLogin(userName, password);
        Log.endTestCase("successfulLoginTest");
    }
    
    @Test(groups="smoke")
    public void failedLoginTest() {
    	Log.startTestCase("failedLoginTest");
        LoginPage loginPage = new LoginPage(driver);
        String userName = "sdjsdf";
        String password = getProperties().getProperty("password");
        loginPage.performLogin(userName, password);
        Log.endTestCase("failedLoginTest");
    }
    
   
    @AfterMethod(groups= {"smoke","sanity"})
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }
}
