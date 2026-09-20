package com.ui.tests;

import com.constants.Browser;
import com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private boolean isLamda;
	
	@Parameters({"browser", "isLamda", "isHeadless"})
	@BeforeMethod(description = "Setup the browser and navigate to the home page")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLamda, @Optional("true") boolean isHeadless, ITestResult result) {
		
		logger.info("Browser = " + browser);
		logger.info("isLamda = " + isLamda);
		logger.info("isHeadless = " + isHeadless);
		
		this.isLamda = isLamda;
		WebDriver lamdaDriver;
		
		if(isLamda) {
			lamdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);
		}else {
			logger.info("Load the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
		
	}
	
	
	public BrowserUtility getInstence() {
		return homePage;
	}
	
	@AfterMethod(description="Tear Down the browser")
	public void tearDown() {
		if(isLamda) {
			LamdaTestUtility.quitSession(); //quit the browser session on lamda test
		}else {
			homePage.quit(); //quit the local session
		}
		
	}

}
