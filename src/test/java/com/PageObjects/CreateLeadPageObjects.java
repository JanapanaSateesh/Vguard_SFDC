package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestCases.Lead_TestCases;

public class CreateLeadPageObjects extends Lead_TestCases {
	
	WebDriver driver;
	
	public CreateLeadPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public String[][] TC_1_createLeadTestData() throws IOException {
		// TODO Auto-generated method stub
		return super.TC_1_createLeadTestData();
	}
	
	public String Name;
	
	public String dataForTC_4() throws IOException {
		String[][] data = TC_1_createLeadTestData();
		 Name= data[0][0]+" "+data[0][1];
		 return Name;
	}
	
	@Override
	public String[][] TC_3_validateLeadPageCompanyError() throws IOException {
		// TODO Auto-generated method stub
		return super.TC_3_validateLeadPageCompanyError();
	}
	
	public String dataForTC_5() throws IOException {
		String[][] data = TC_3_validateLeadPageCompanyError();
		 Name= data[0][0]+" "+data[0][1];
		 return Name;
	}
	
	
	
	@FindBy(xpath="//span[@class='slds-truncate'][text()='Leads']")
	@CacheLookup
	public WebElement leadobject;
	
	@FindBy(xpath="//li[@data-target-selection-name='sfdc:StandardButton.Lead.New']//a//div")
	@CacheLookup
	public WebElement newbutton;
	
	@FindBy(xpath="//button[@id=//label[text()='Salutation']/@for]")
	@CacheLookup
	public WebElement salutation;

	@FindBy(xpath="//span[@class='slds-truncate'][text()='Mr.']")
	@CacheLookup
	public WebElement selectsalutation;
	
	@FindBy(xpath="//input[@id=//label[text()='First Name']/@for]")
	@CacheLookup
	public WebElement firstname;
	
	@FindBy(xpath="//input[@id=//label[text()='Last Name']/@for]")
	@CacheLookup
	public WebElement lastname;
	
	@FindBy(xpath="//input[@id=//label[text()='Phone']/@for]")
	@CacheLookup
	public WebElement phone;
	
	@FindBy(xpath="//input[@id=//label[text()='Company']/@for]")
	@CacheLookup
	public WebElement company;
	
	@FindBy(xpath="//input[@id=//label[text()='Email']/@for]")
	@CacheLookup
	public WebElement email;
	
	@FindBy(xpath="//li[@data-target-selection-name='sfdc:StandardButton.Lead.SaveEdit']//button")
	@CacheLookup
	public WebElement save;
	
	@FindBy(xpath="//slot[@name='primaryField']//lightning-formatted-name")
	@CacheLookup
	public WebElement leadnamevalidate;
	
	@FindBy(xpath="//div[@data-aura-class='forceSearchAssistant']//button")
	@CacheLookup
	public WebElement globalsearch;
	
	@FindBy(xpath="//input[@id=//label[text()='Search...']/@for]")
	@CacheLookup
	public WebElement globalSearchInputText;
	
	@FindBy(xpath="(//span[text()='Leads'])[2]")
	@CacheLookup
	public WebElement leadObjectFilter;
	
	@FindBy(xpath="//span[text()='Show more actions']/parent::button")
	@CacheLookup
	public WebElement showmoreactions;
	
	@FindBy(xpath="//*[@data-target-selection-name='sfdc:StandardButton.Lead.Edit']//span[text()='Edit']")
	@CacheLookup
	public WebElement edit;
	
	@FindBy(xpath="//button[@name='SaveEdit']")
	@CacheLookup
	public WebElement updatesave;
	
	
	
	
//	@FindBy(xpath="(//a[text()=' sate '])[last()]")
//	@CacheLookup
//	public WebElement createdLead;	
	
	
	
	public void clickOnLeadObject() {
		leadobject.click();
	}
	
	public void clickOnNewButton() {
		newbutton.click();
	}
	
	public void clickOnSalutation() {
		salutation.click();
	}
	
	public void selectSalutation() {
		selectsalutation.click();
	}
	
	public void setFirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setPhone(String phn) {
		phone.sendKeys(phn);
	}
	
	public void setCompany(String company) {
		this.company.sendKeys(company);
	}
	
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public String validateLeadFirstName() {
		String leadNameAfterSave = leadnamevalidate.getText();
		return leadNameAfterSave;
	}
	
	public void clickOnGlobalSearch() {
		
		globalsearch.click();
	}
	
	public void setGlobalSearch(String globalSearch) {
		globalSearchInputText.sendKeys(globalSearch);
	}
	
	public void clickOnLeadObjectAfterFilter() {
		leadObjectFilter.click();
	}
	
	public void clickOnCreatedLeadTC_4(WebDriver driver) throws IOException {
		this.driver = driver;
		String Name1 =dataForTC_4();
		this.driver.findElement(By.xpath("(//a[text()='"+Name1+"'])[last()]")).click();
	}
	
	public void clickOnCreatedLeadTC_5(WebDriver driver) throws IOException {
		this.driver = driver;
		
		String Name1 =dataForTC_5();
		this.driver.findElement(By.xpath("(//a[text()='"+Name1+"'])[last()]")).click();
	}
	
	public void clickOnShowMoreActions() {
		showmoreactions.click();
	}
	
	public void clickOnEdit() {
		edit.click();
	}
	
	public void clickOnUpdateSave() {
		updatesave.click();
	}
	
	
	//TC_3_validate Company
	
	@FindBy(xpath="//*[text()='We hit a snag.']")
	@CacheLookup
	public WebElement leadPageError;
	
	public String validateError() {
		String LeadPageError =leadPageError.getText();
		return LeadPageError;
	}
	
	@FindBy(xpath="//div[@class='fieldLevelErrors']//a[text()='Company']")
	@CacheLookup
	public WebElement companyError;
	
	public String validateCompanyError() {
		String CompanyError =companyError.getText();
		return CompanyError;
	}
}
