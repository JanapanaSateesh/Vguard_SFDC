package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TakeScreenshot {
	
	public String TakeSnapShot(WebDriver driver) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
//		String path="C:\\Users\\102789\\eclipse-workspace\\Vguard_SFDC\\Screenshots\\FailedScreenshots//"+dateName+screenshotName+".png";
//		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File destFile = new File(path);
//		FileUtils.copyFile(srcFile, destFile);
//		return path;
		
		byte[] screenshotBytes=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		String base64screenshot=Base64.getEncoder().encodeToString(screenshotBytes);
		return base64screenshot;
	}
}
