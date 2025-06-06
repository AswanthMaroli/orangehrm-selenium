package com.hrmproject.utilities;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v132.network.model.WebTransportConnectionEstablished;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

/*
 *  author : Aswanth Maroli
 *  date   : 01/03/2025
 * 
 */

public class ActionClass {
	
	
	 public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	

	public static void performClick(WebDriver driver,By locator ) {
		
		driver.findElement(locator).click();
		
		
	}
	
	public static void performClick(WebDriver driver,WebElement element ) {
		
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		   wait.until(ExpectedConditions.visibilityOf(element));
		
	       waitForElementToBeVisible(driver, element, 10);
			
			element.click();
			
			
	}
	
	public static void performEnterText(WebDriver driver, By locator, String value) {
		
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);


	}
	
   public static void performEnterText(WebDriver driver,WebElement element, String value) {
	   
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(element));
	   
	   waitForElementToBeVisible(driver, element, 10);
		
		element.click();
		element.clear();
		element.sendKeys(value);


	}
   
   public void scrollByVisibilityOfElement(WebDriver driver,WebElement element) {
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView();", element);
   }
   
   public boolean isElementIsDisplayed(WebElement element) {
	   
	   boolean flag = false;
		try {
			element.isDisplayed();
			flag = true;
		} catch (Exception e) {
			 System.out.println("Element is not found: "+element);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element ");

			} else {
				System.out.println("Unable to locate element ");
			}
		}
		return flag;

	   
   }
   
   
   public boolean selectByIndex(WebElement element,int index) {
	   
	   try {
		   
		   Select s = new Select(element);
		   s.selectByIndex(index);
		   return true;
		   
	   }catch(Exception e) {
		   
		   return false;
	   }
   }
   
   
   public boolean selectByValue(WebElement element,String value) {
	   
	   try {
		   
		   Select s = new Select(element);
		   s.selectByValue(value);
		   return true;
		   
	   }catch(Exception e) {
		   
		   return false;
	   }
   }
   
  public boolean selectByVisibleText(WebElement element,String text) {
	   
	   try {
		   
		   Select s = new Select(element);
		   s.selectByVisibleText(text);
		   return true;
		   
	   }catch(Exception e) {
		   
		   return false;
	   }
   }
  
  public static void takeScreenShot(WebDriver driver,String filename,String path) {
	  
	  TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
	  
	  File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
	 
	  try {
		  
		  FileUtils.copyFile(source, new File(path + filename + ".png"));
	  }catch(Exception e){
		  
		  e.printStackTrace();
		  
	  }
	  
	  
  }
  
   
   
	
}
