package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.JSONUtility.*;

public final class HomePage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);  //to call the parent class constructor from the child class constructor
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(readJson(QA).getUrl());
		
		maximizeWindow();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);  //to call the parent class constructor from the child class constructor
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(readJson(QA).getUrl());
		
		maximizeWindow();
	}
	
	




	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), \"Sign\")]");
	
	
	
	//page functionality - goto login page
	public LoginPage gotoLoginPage() {
		logger.info("Trying to performe click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
//		LoginPage loginPage= new LoginPage(getDriver());
//		return loginPage;
		
		return new LoginPage(getDriver());
		
	}
}
