package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	public static void setupSparkReporter(String reportName) {
		
		//trying to distinguish the report name by using date time 
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timeStamp = format.format(date);
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//test-reports//"+reportName+"_"+timeStamp+".html");
	    extentReports = new ExtentReports();
	    extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createExterntTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
}
