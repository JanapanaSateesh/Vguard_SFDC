package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	public WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	@CacheLookup
	public WebElement login;
	
	@FindBy(xpath="(//img[@title='User']/..)[last()]")
	@CacheLookup
	public WebElement userfordynamicwait;
	
	@FindBy(xpath="//span[text()='App Launcher']/../..")
	@CacheLookup
	public WebElement applauncher;
	
	@FindBy(xpath="//input[@id=//label[text()='Search apps and items...']/@for]")
	@CacheLookup
	public WebElement searchapp;
	
	@FindBy(xpath="//a[@href='/lightning/app/06m5g000003srGnAAI']//p//b")
	@CacheLookup
	public WebElement app;
	
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		login.click();
	}
	
	public void clickAppLauncher() {
		applauncher.click();
	}
	
	public void setAppName(String appname) {
		searchapp.sendKeys(appname);
	}
	
	public void clickOnApp() {
		app.click();
	}
	
	public void userLogin(String uname, String pwd, String appname) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login.click();
		applauncher.click();
		searchapp.sendKeys(appname);
		app.click();
	}
	
}
