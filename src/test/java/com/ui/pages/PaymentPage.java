package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
	private static final By WARNING_TXT_LOCATOR = By.xpath("//p[contains(@class, 'alert-warning')]");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public String captureWaringTextOfPaymentPage() {
		return getVisibleText(WARNING_TXT_LOCATOR);
	}

}
