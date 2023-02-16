package com.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.TakeScreenshot1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123 {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		TakeScreenshot1 ts = new TakeScreenshot1();
		driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.manage().window().maximize();
		driver.get("https://sunera3-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
		driver.findElement(By.id("username")).sendKeys("sateeshjanapana123@suneratech.com");
		
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'App Launcher')]/../..")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Search apps and items...']")).sendKeys("Sales");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//*[@class='slds-dropdown__item']//p//b[text()='Sales'])[3]")).click();
		ts.TakeSnapShot(driver, "Lead object");
		WebElement element = driver.findElement(By.xpath("//span[@class='slds-truncate'][contains(text(),'Leads1')]"));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	    driver.findElement(By.xpath("//a[@title='New']//div[text()='New']")).click();
	    ts.TakeSnapShot(driver, "Lead Page");
	    driver.findElement(By.xpath("//button[@id=//label[text()='Salutation']/@for]")).click();
	    driver.findElement(By.xpath("//span[@class='slds-truncate'][text()='Mr.']")).click();

	}

}
