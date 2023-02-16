package com.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.PageObjects.LoginPageObjects;
import com.Utilities.ReadConfig;
import com.Utilities.TakeScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig loginCredentials = new ReadConfig();
	String url = loginCredentials.getUrl();
	String username = loginCredentials.getUsername();
	String password = loginCredentials.getPassword();
	String appname = loginCredentials.getAppname();

	
	//Extent -------------------------Report//
	public static ExtentReports extent;
	public static ExtentTest test;
	public ExtentSparkReporter spark;
	
	@BeforeSuite
	public void startReport() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String curDate = dtf.format(now).toString();
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Reports/report "+ " "+ curDate+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Summary Report");
		extent.attachReporter(spark);
		
	}
	
	
	//LAUNCH ------------------------ BROWSER//
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);	
	}
	
	//ExplicitWait
	public static void dynamicWait(WebElement element) {
		int x=0;
		while(true){
			boolean flag = element.isDisplayed();
			x=x+1;
			if(flag==true) {
				break;
			}
			if(x==100) {
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//ImplicitWait
	public static void staticWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	//jsClick
		public static void jsClick(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}
		
		//jsType
				public static void jsType(WebElement element, String value) {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript(" arguments[0].value= '"+ value +"' ", element);
				}
		public static void hitEnter(WebElement element) {
			element.sendKeys(Keys.RETURN);
		}
		
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException
		{
			//driver.quit();
			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test Case is Passed  " + result.getName());
				test.pass("Test Case is passed");	        
			}
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL, "Test Case is Failed--" + result.getName());
				test.log(Status.FAIL, "Test Case is Failed --" + result.getThrowable().getMessage());
				TakeScreenshot TS = new TakeScreenshot();
				String path = TS.TakeSnapShot(driver, result.getName());
				test.addScreenCaptureFromPath(path);
	

			}
		}
		
		//AFTER ----------------------- SUITE  ///
		 @AfterSuite
			public void endReport() {
				extent.flush();
			}
}
