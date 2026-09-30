package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility{

	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage changeSize(Size size) {
		selectFromDropdown(SIZE_DROP_DOWN_LOCATOR, size.getValue());
		return (new ProductDetailsPage(getDriver()));
	}

}
