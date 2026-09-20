package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");	
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	public MyAccountPage doLoginWith(String emailAdress, String password) {
		sendKeys(EMAIL_TEXT_BOX_LOCATOR, emailAdress);
		sendKeys(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		
//		MyAccountPage myAccountPage= new MyAccountPage(getDriver());
//		return myAccountPage;
		return new MyAccountPage(getDriver());
	}
}

