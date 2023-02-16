package com.Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestCases.BaseClass;

public class TestListneres extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + "is failed");
		 
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + "is skipped");
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		
	}

}
