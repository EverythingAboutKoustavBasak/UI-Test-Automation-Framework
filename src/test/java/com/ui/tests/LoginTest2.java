package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		HomePage homePage= new HomePage(driver);
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.doLoginWith("joxel24027@hebase.com", "Test@123");
		
		
		
		
		
		
	}

}
