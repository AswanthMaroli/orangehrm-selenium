package com.hrmproject.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import org.w3c.dom.DOMConfiguration;

import com.hrmproject.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *  author : Aswanth Maroli
 *  date   : 01/03/2025
 * 
 */

public class BaseClass {
	
	private WebDriver driver;
	private static Properties prop;
	
	
	@BeforeSuite // Load configuration file
	public void loadConfig() {
		try {
			DOMConfigurator.configure("log4j.xml");
//			ExtentManager.setExtent();
			prop = new Properties();
			File propFile = new File(System.getProperty("user.dir") + "/configuration/config.properties");

			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			fis.close();  

			System.out.println("Config file loaded successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}
	
	
	public static Properties getProperties() {   	// Getter method for prop 

		return prop;
	}

	// Initialize WebDriver and Open Application
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		
		browserName = browserName.trim().toLowerCase();
		
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			throw new IllegalArgumentException("❌ Invalid browser name: " + browserName);
	}


		// Browser Configurations
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		// Fetch URL from properties file
		String url = prop.getProperty("url", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login").trim();   // Use default if missing
		System.out.println("Launching URL: " + url);
		
		try {
			
			driver.get(url);
			
		}catch(Exception e) {
			System.err.println("Timeout occurred while loading the URL: " + url);
			driver.navigate().refresh(); 
		}
		

		return driver;	
	}
	
//	@AfterSuite
//	public  void closeConfig() {
//		
//		ExtentManager.endReport();
//	
//	}
}
