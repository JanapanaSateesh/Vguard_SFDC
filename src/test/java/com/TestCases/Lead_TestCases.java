package com.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjects.ConvertLeadPageObjejcts;
import com.PageObjects.CreateLeadPageObjects;
import com.PageObjects.LoginPageObjects;
import com.Utilities.ExcelTestData;
import com.Utilities.TestListneres;


@Listeners(TestListneres.class)
public class Lead_TestCases extends BaseClass{
	
	@Test(enabled = true ,priority=1, groups={"Smoke","Regression"}, dataProvider = "TC_1_createLeadTestData")
	public void TC_1_CreateLead(String firstname, String lastname, String phone, String company, String email) throws InterruptedException {
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		
		test=extent.createTest("Create Lead")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		LP.userLogin(username, password, appname);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		jsType(CL.company, company);
		CL.setEmail(email);
		CL.clickOnSave();
		dynamicWait(CL.leadnamevalidate);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		
	}
	
	@Test(enabled = true ,priority=2, groups={"Smoke","Regression"}, dataProvider = "TC_2_updateLeadTestData", dependsOnMethods = {"TC_1_CreateLead"})
	public void TC_2_UpdateLead(String Email) throws InterruptedException, IOException {
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		
		test=extent.createTest("Update Lead")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		//Pre-Requisite
		Lead_TestCases LT = new Lead_TestCases();
		String[][] data =LT.TC_1_createLeadTestData();
		String firstname = data[0][0];
		String lastname = data[0][1];
		
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		CL.clickOnGlobalSearch();
		Thread.sleep(500);
		CL.setGlobalSearch(firstname +" "+ lastname);
		staticWait(4);
		hitEnter(CL.globalSearchInputText);
		staticWait(7);
		CL.clickOnLeadObjectAfterFilter();
		staticWait(10);	
		Thread.sleep(10000);
		CL.clickOnCreatedLeadTC_4(driver);
		Thread.sleep(5000);
		dynamicWait(CL.showmoreactions);
		staticWait(5);
		CL.clickOnShowMoreActions();
		Thread.sleep(5000);
		CL.clickOnEdit();
		dynamicWait(CL.phone);
		staticWait(5);
		jsType(CL.email, Email);
		staticWait(4);
		CL.clickOnUpdateSave();
		staticWait(10);
	}
	
	
	@Test(enabled = true,priority=3, groups={"Smoke","Regression"}, dataProvider="TC_3_validateLeadPageCompanyError")
	public void TC_3_ValidateCompany(String firstname, String lastname, String phone, String company, String email, String leaderror) throws InterruptedException {
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		test=extent.createTest("ValidateCompany")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		staticWait(9);
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		staticWait(5);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		
		jsType(CL.email, email);
		CL.clickOnSave();
		dynamicWait(CL.companyError);
		staticWait(5);
		String LeadPageError = CL.validateError();
		assertEquals(LeadPageError, leaderror);
		staticWait(3);
		String CompanyError = CL.validateCompanyError();
		assertEquals(CompanyError, "Company");
		staticWait(3);
		jsType(CL.company, company);
		CL.clickOnSave();
		staticWait(7);
		dynamicWait(CL.leadnamevalidate);
		staticWait(4);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		
	}
	
	@Test(enabled = true ,priority=4, groups= {"Smoke", "Regression"}, dependsOnMethods = "TC_1_CreateLead")
	public void TC_4_ConvertLead() throws InterruptedException, IOException {
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Convert Lead")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		//Pre-Requisite
		Lead_TestCases LT = new Lead_TestCases();
		String[][] data =LT.TC_1_createLeadTestData();
		String firstname = data[0][0];
		String lastname = data[0][1];
		
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		CL.clickOnGlobalSearch();
		Thread.sleep(500);
		CL.setGlobalSearch(firstname +" "+ lastname);
		staticWait(4);
		hitEnter(CL.globalSearchInputText);
		staticWait(7);
		CL.clickOnLeadObjectAfterFilter();
		staticWait(10);	
		Thread.sleep(10000);
		CL.clickOnCreatedLeadTC_4(driver);
		Thread.sleep(5000);
		dynamicWait(CL.showmoreactions);
		staticWait(5);
		CL.clickOnShowMoreActions();
		Thread.sleep(5000);
		ConL.clickOnConvertButton();
		Thread.sleep(10000);
	    staticWait(7);
	    ConL.clickOnConvertLeadButton();
	    Thread.sleep(4000);
	    dynamicWait(ConL.convertleadvalidation);
	    staticWait(4);
	    String LeadConvertedValidation = ConL.convertLeadValidation();
	    assertEquals(LeadConvertedValidation, "Your lead has been converted");
	    
	}
	
	@Test(enabled = true,priority = 5, groups = {"Smoke", "Regression"}, dependsOnMethods="TC_3_ValidateCompany" )
	public void TC_5_Conver_Lead_With_AccConOpp() throws InterruptedException, IOException {
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Conver_Lead_With_AccConOpp")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		//Pre-Requisite
		Lead_TestCases LT = new Lead_TestCases();
		String[][] data =LT.TC_3_validateLeadPageCompanyError();
		String firstname = data[0][0];
		String lastname = data[0][1];
		
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		CL.clickOnGlobalSearch();
		Thread.sleep(500);
		CL.setGlobalSearch(firstname +" "+ lastname);
		staticWait(4);
		hitEnter(CL.globalSearchInputText);
		staticWait(7);
		CL.clickOnLeadObjectAfterFilter();
		staticWait(10);	
		Thread.sleep(10000);
		CL.clickOnCreatedLeadTC_5(driver);
		Thread.sleep(5000);
		dynamicWait(ConL.convertusingsalespath);
		staticWait(4000);
		ConL.clickOnConvertButtonUsingSalespath();
		staticWait(5000);
		ConL.clickOnSelectConvertStatusUsingSalesPath();
		staticWait(5000);
		Thread.sleep(10000);
		ConL.clickOnConvertLeadButton2();
		Thread.sleep(4000);
		dynamicWait(ConL.convertleadvalidation);
		staticWait(7000);
		String leadValidation = ConL.convertLeadValidation();
		assertEquals(leadValidation, "Your lead has been converted");
	}

	
	@Test(enabled = true, groups= {"Smoke","Regression"}, dataProvider = "TC_6_converLeadTestDataAccountAndContact")
	public void TC_6_Conver_Lead_With_AccountAndContact(String firstname, String lastname, String phone, String company, String email) throws InterruptedException{
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Conver_Lead_With_AccountAndContact")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		staticWait(9);
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		staticWait(5);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		staticWait(3);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		jsType(CL.company, company);
		CL.setEmail(email);
		CL.clickOnSave();
		staticWait(7);
		dynamicWait(CL.leadnamevalidate);
		staticWait(4);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		staticWait(5);
		CL.clickOnShowMoreActions();
		staticWait(4);
		ConL.clickOnConvertButton();
		Thread.sleep(10000);
		jsClick(ConL.dontcreateOppuponconversion);
		//ConL.clickOnDontCreateOppUponCon();
		staticWait(3);
		ConL.clickOnConvertLeadButton();
		dynamicWait(ConL.convertleadvalidation);
		staticWait(3);
		String leadValidation = ConL.convertLeadValidation();
		assertEquals(leadValidation, "Your lead has been converted");
		
	}
	
	@Test(enabled = true, groups= {"Smoke","Regression"}, dataProvider = "TC_7_converLeadTestDataAccountAndContactWithExistAccount")
	public void TC_7_Convert_Lead_to_an_exist_Account_and_new_Contact_new_Opportunity(String firstname, String lastname, String phone, String company, String email, String existaccountname) throws InterruptedException, IOException {
		
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Convert_Lead_to_an_exist_Account_and_new_Contact_new_Opportunity")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		staticWait(9);
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		staticWait(5);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		staticWait(3);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		jsType(CL.company, company);
		CL.setEmail(email);
		CL.clickOnSave();
		staticWait(7);
		dynamicWait(CL.leadnamevalidate);
		staticWait(4);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		staticWait(5);
		CL.clickOnShowMoreActions();
		staticWait(4);
		ConL.clickOnConvertButton();
		Thread.sleep(10000);
		ConL.clickOnChooseExistingAccount();
		staticWait(3);
		ConL.setExistingAccount(existaccountname);
		staticWait(5);
		ConL.clickOnExistingAccountNameTC_7(driver);
		Thread.sleep(3000);
		ConL.clickOnConvertLeadButton();
		dynamicWait(ConL.convertleadvalidation);
		staticWait(3);
		String leadValidation = ConL.convertLeadValidation();
		assertEquals(leadValidation, "Your lead has been converted");
		
	}
	
	@Test(enabled = true, groups= {"Smoke","Regression"}, dataProvider = "TC_8_converLeadTestDataAccountAndOppWithExistContact")
	public void TC_8_Convert_Lead_to_new_Account_and_exist_Contact_new_Opportunity(String firstname, String lastname, String phone, String company, String email, String existcontactname) throws InterruptedException, IOException {
		
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Convert_Lead_to_new_Account_and_exist_Contact_new_Opportunity")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		staticWait(9);
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		staticWait(5);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		staticWait(3);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		jsType(CL.company, company);
		CL.setEmail(email);
		CL.clickOnSave();
		staticWait(7);
		dynamicWait(CL.leadnamevalidate);
		staticWait(4);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		staticWait(5);
		CL.clickOnShowMoreActions();
		staticWait(4);
		ConL.clickOnConvertButton();
		Thread.sleep(10000);
		ConL.clickOnChooseExistingContact();
		staticWait(3);
		ConL.setExistingContact(existcontactname);
		staticWait(5);
		ConL.clickOnExistingContactNameTC_8(driver);
		Thread.sleep(3000);
		ConL.clickOnConvertLeadButton();
		dynamicWait(ConL.convertleadvalidation);
		staticWait(3);
		String leadValidation = ConL.convertLeadValidation();
		assertEquals(leadValidation, "Your lead has been converted");
		
	}
	
	@Test(enabled = true, groups= {"Smoke","Regression"}, dataProvider = "TC_9_converLeadTestDataExistAccountExistContact")
	public void TC_9_Convert_a_Lead_to_an_exist_Account_and_exist_Contact_without_Opportunity(String firstname, String lastname, String phone, String company, String email,String existaccountname ,String existcontactname) throws InterruptedException, IOException {
		
		LoginPageObjects LP = new LoginPageObjects(driver);
		CreateLeadPageObjects CL = new CreateLeadPageObjects(driver);
		ConvertLeadPageObjejcts ConL = new ConvertLeadPageObjejcts(driver);
		
		test=extent.createTest("Convert_a_Lead_to_an_exist_Account_and_exist_Contact_without_Opportunity")
				.assignAuthor("Sateesh")
				.assignCategory("Functional Testing");
		
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickLoginButton();
		dynamicWait(LP.applauncher);
		staticWait(10);
		LP.clickAppLauncher();
		staticWait(10);
		jsType(LP.searchapp, appname);
		staticWait(5);
		LP.clickOnApp();
		Thread.sleep(10000);
		// ----------CREATE  A LEAD ------
		
		
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
		staticWait(9);
		CL.clickOnNewButton();
		dynamicWait(CL.phone);
		staticWait(5);
		CL.clickOnSalutation();
		CL.selectSalutation();
		CL.setFirstname(firstname);
		staticWait(3);
		CL.setLastName(lastname);
		CL.setPhone(phone);
		jsType(CL.company, company);
		CL.setEmail(email);
		CL.clickOnSave();
		staticWait(7);
		dynamicWait(CL.leadnamevalidate);
		staticWait(4);
		String leadNameAfterSave = CL.validateLeadFirstName();
		assertTrue(leadNameAfterSave.contains(firstname));
		staticWait(5);
		CL.clickOnShowMoreActions();
		staticWait(4);
		ConL.clickOnConvertButton();
		Thread.sleep(10000);
		ConL.clickOnChooseExistingAccount();
		staticWait(3);
		ConL.setExistingAccount(existaccountname);
		staticWait(5);
		ConL.clickOnExistingAccountNameTC_7(driver);
		
		staticWait(3);
		ConL.clickOnChooseExistingContact();
		ConL.setExistingContact(existcontactname);
		staticWait(5);
		ConL.clickOnExistingContactNameTC_8(driver);
		staticWait(3);
		ConL.clickOnConvertLeadButton();
		dynamicWait(ConL.convertleadvalidation);
		staticWait(3);
		String leadValidation = ConL.convertLeadValidation();
		assertEquals(leadValidation, "Your lead has been converted");
		
		
	}
	
	@DataProvider
	public String[][] TC_1_createLeadTestData() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_1_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_2_updateLeadTestData() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_2_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_3_validateLeadPageCompanyError() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_3_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_6_converLeadTestDataAccountAndContact() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_6_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_7_converLeadTestDataAccountAndContactWithExistAccount() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_7_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_8_converLeadTestDataAccountAndOppWithExistContact() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_8_Data");
		return data;
	}
	
	@DataProvider
	public String[][] TC_9_converLeadTestDataExistAccountExistContact() throws IOException {
		ExcelTestData testData = new ExcelTestData();
		String[][] data = testData.getTestData("TC_9_Data");
		return data;
	}
	
	
	
//	@DataProvider
//	public Object[][] TC_1_createLeadTestData() {
//		Object[][] data = new Object[1][5];
//		
//		data[0][0] = "Arun";
//		data[0][1] = "Kumar";
//		data[0][2] = "7788654382";
//		data[0][3] = "CapGemini Ltd";
//		data[0][4] = "arunjammu@gmail.com";
//		return data;	
//	}
//	
//	@DataProvider
//	public Object[][] TC_2_updateLeadTestData() {
//		Object[][] data = new Object[1][1];
//		data[0][0] = "bhanu123@gmail.com";
//		
//		return data;
//		
//	}

}
