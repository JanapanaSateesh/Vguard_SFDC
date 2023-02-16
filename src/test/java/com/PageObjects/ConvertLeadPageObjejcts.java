package com.PageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestCases.Lead_TestCases;

public class ConvertLeadPageObjejcts extends Lead_TestCases{
	
	WebDriver driver;
	
	public ConvertLeadPageObjejcts (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath="//span[@class='slds-truncate'][text()='Convert']")
	@CacheLookup
	public WebElement convertbutton;
	
	@FindBy(xpath="(//span[@data-aura-class='runtime_sales_leadConvertModalFooter']//button[text()='Convert'])")
	@CacheLookup
	public WebElement convertleadbutton;
	
	@FindBy(xpath="(//span[@data-aura-class='runtime_sales_leadConvertModalFooter']//button[text()='Convert'])[2]")
	@CacheLookup
	public WebElement convertleadbutton2;
	
	@FindBy(xpath="//*[text()='Your lead has been converted']")
	@CacheLookup
	public WebElement convertleadvalidation;
	
	@FindBy(xpath="//button[@data-aura-class='runtime_sales_leadConvertModalFooter'][text()='Cancel']")
	@CacheLookup
	public WebElement cancelleadconvertbutton;
	
	@FindBy(xpath="//li[@data-name='converted']")
	@CacheLookup
	public WebElement convertusingsalespath;
	
	
	@FindBy(xpath="//span[text()='Select Converted Status']/..")
	@CacheLookup
	public WebElement selectconvertstatususingsalespath;
	
	@FindBy(xpath="//label[@for='opptyCheckBox']/..//input/..//label")
	@CacheLookup
	public WebElement dontcreateOppuponconversion;
	
	@FindBy(xpath="(//span[text()='Choose Existing'])[1]/parent::label//span[2]")
	@CacheLookup
	public WebElement chooseexistingaccount;
	
	@FindBy(xpath="//input[@id=//label//span[text()='Account Search']/../@for]")
	@CacheLookup
	public WebElement existingaccountinput;
	
	public String[][] TC_7_converLeadTestDataAccountAndContactWithExistAccount() throws IOException{
		return super.TC_7_converLeadTestDataAccountAndContactWithExistAccount();
	}
	
	String existingaccountname;
	public String dataForTC_7() throws IOException {
		String[][] data = TC_7_converLeadTestDataAccountAndContactWithExistAccount();
		existingaccountname= data[0][5];
		 return existingaccountname;
	}
	
	@FindBy(xpath="(//span[text()='Choose Existing'])[2]/parent::label//span[2]")
	@CacheLookup
	public WebElement chooseexistingcontact;
	
	@FindBy(xpath="//input[@id=//label//span[text()='Contact Search']/../@for]")
	@CacheLookup
	public WebElement existingcontactinput;
	
	public String[][] TC_8_converLeadTestDataAccountAndOppWithExistContact() throws IOException{
		return super.TC_8_converLeadTestDataAccountAndOppWithExistContact();
	}
	
	String existingcontactname;
	public String dataForTC_8() throws IOException {
		String[][] data = TC_8_converLeadTestDataAccountAndOppWithExistContact();
		existingcontactname= data[0][5];
		 return existingcontactname;
	}

	
	public void clickOnConvertButton() {
		convertbutton.click();
	}
	
	public void clickOnConvertLeadButton() {
		convertleadbutton.click();
	}
	
	public void clickOnConvertLeadButton2() {
		convertleadbutton2.click();
	}
	
	public String convertLeadValidation() {
		String ConvertLeadValidation = convertleadvalidation.getText();
		return ConvertLeadValidation;
	}
	
	public void clickOnCancelLeadConvertButton() {
		cancelleadconvertbutton.click();
	}
	
	public void clickOnConvertButtonUsingSalespath(){
		
		Actions act = new Actions(this.driver);
		act.doubleClick(convertusingsalespath).perform();
		//convertusingsalespath.click();
	}
	
	public void clickOnSelectConvertStatusUsingSalesPath() {
		Actions act = new Actions(this.driver);
		act.doubleClick(selectconvertstatususingsalespath).perform();
		//selectconvertstatususingsalespath.click();
	}
	
	public void clickOnDontCreateOppUponCon() {
		dontcreateOppuponconversion.click();
	}
	
	public void clickOnChooseExistingAccount() {
		chooseexistingaccount.click();
	}
	
	public void setExistingAccount(String accountname) {
		existingaccountinput.sendKeys(accountname);
	}
	
	public void clickOnExistingAccountNameTC_7(WebDriver driver) throws IOException {
		this.driver = driver;
		String Name1 =dataForTC_7();
		this.driver.findElement(By.xpath("//mark[text()='"+Name1+"']")).click();
	}
	
	public void clickOnChooseExistingContact() {
		chooseexistingcontact.click();
	}
	
	public void setExistingContact(String contactname) {
		existingcontactinput.sendKeys(contactname);
	}
	
	public void clickOnExistingContactNameTC_8(WebDriver driver) throws IOException {
		this.driver = driver;
		String Name1 =dataForTC_8();
		this.driver.findElement(By.xpath("//mark[text()='"+Name1+"'][last()]")).click();
	}
	
}
