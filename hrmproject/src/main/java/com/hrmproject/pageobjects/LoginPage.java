package com.hrmproject.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmproject.utilities.ActionClass;

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
		
        ActionClass.performEnterText(driver,txtUserName, username);
        ActionClass.performEnterText(driver,txtPassword, password);
        ActionClass.performClick(driver,btnLogin);
		return new AdminDashboard(driver);
        

	}
	

}
