//package com.ui.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.utility.BrowserUtility;
//
//public class LoginTestOld {
//
//	public static void main(String[] args) {
//
//		WebDriver driver = new ChromeDriver();
//		
//		BrowserUtility browserUtility= new BrowserUtility(driver);
//		
//		
//		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
//		browserUtility.maximizeWindow();
//		
//		By signInLinkLocator= By.xpath("//a[contains(text(), \"Sign\")]");
//		browserUtility.clickOn(signInLinkLocator);
//		
//		By emailInputLocator= By.id("email");	
//		browserUtility.sendKeys(emailInputLocator, "joxel24027@hebase.com");
//		
//		By passwordInputLocator= By.id("passwd");
//		browserUtility.sendKeys(passwordInputLocator, "Test@123");
//		
//		By submitLoginLocator= By.id("SubmitLogin");
//		browserUtility.clickOn(submitLoginLocator);
//		
//		
//		
//		
//		
//	}
//
//}
