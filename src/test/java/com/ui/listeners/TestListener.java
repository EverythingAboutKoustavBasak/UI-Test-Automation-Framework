package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
	    logger.info(result.getMethod().getMethodName());
	    logger.info(result.getMethod().getDescription());
	    logger.info(Arrays.toString(result.getMethod().getGroups()));
	
	   ExtentReporterUtility.createExterntTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+"	"+"PASSED");
		
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" " +"PASSED");
	}
	
	public void onTestFailure(ITestResult result) {
	    logger.error(result.getMethod().getMethodName()+"	"+"FAILED");
	    logger.error(result.getThrowable().getMessage());
	    
	    ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() +" " +"FAILED");
	    ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
	    
	    //try to capture the screenshot
	    Object testClass = result.getInstance();
	    TestBase tb = (TestBase)testClass;
	    BrowserUtility browserUtility = tb.getInstence();
	    logger.info("Trying to Capturing the Screenshot path for the failed tests");
	    String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
	    logger.info("Captured the Screenshot path for the failed tests");
	    
	    logger.info("Trying to attaching the Screenshot to the test report");
	    ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	    logger.info("The screenshot is attached successfully in the test report");
	    
	    
	}
	
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+"	"+"SKIPPED");
	
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" " +"SKIPPED");
	}
	
	public void onStart(ITestContext context) {
	    logger.info("Test Suite Started");
	    ExtentReporterUtility.setupSparkReporter("report.html");
	}
	
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		
		ExtentReporterUtility.flushReport();;
	}

}
