package com.hrmproject.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmproject.utilities.UIElementExtension;

public class LoginPage extends BasePage{
	
	
	@FindBy(xpath ="//input[@placeholder='Username']")
	private WebElement txtUserName;
	
	@FindBy(name ="password")
	private WebElement txtPassword;
	
	@FindBy(xpath ="//button[normalize-space()='Login']")
	private WebElement btnLogin;
		
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements( driver, this);
	}
	
	public AdminDashboard performLogin(String username,String password) {
		
        UIElementExtension.performEnterText(driver,txtUserName, username);
        UIElementExtension.performEnterText(driver,txtPassword, password);
        UIElementExtension.performClick(driver,btnLogin);
		return new AdminDashboard(driver);
        

	}
	

}
