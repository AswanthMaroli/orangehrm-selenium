package com.hrmproject.pageobjects;

import org.openqa.selenium.WebDriver;

/*
 *  author : Aswanth Maroli
 *  date   : 01/03/2025
 * 
 */

public class BasePage {
	
	protected WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void navigateTo(String url) {
		  
		driver.get(url);
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
	}
	
	

}
