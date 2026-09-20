package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
	
	/*
	 * Best Test Methods Principal - 
	 * 1. Should be small is size only contains the test steps
	 * 2. should have atleast one assertion
	 * 3. Reduce the use of the local variables
	 * 4. Can't use any loops or conditional statements and try catch blocks inside the test methods
	 * 5. have @Test annotation with description attribute and groups attribute
	 */
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	@Test(description = "Verify user is able to login with valid credentials", groups = {"smoke", "sanity"},
			dataProvider = "LoginTestDataProvider", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class)
	public void LoginTest(User user) {
		
//		String userName = 	homePage.gotoLoginPage()
//									.doLoginWith("joxel24027@hebase.com", "Test@123")	
//									.getUserName();
		
		assertEquals(homePage.gotoLoginPage()
				.doLoginWith(user.getUsername(), user.getPassword())	
				.getUserName(), 
				"Som Basak", "User name does not match after login");
		
		
	}
	
	
	@Test(description = "Verify user is able to login with valid credentials", groups = {"smoke", "sanity"},
			dataProvider = "LoginTestCSVDataProvider", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class)
	public void LoginCSVTest(User user) {
		
//		String userName = 	homePage.gotoLoginPage()
//									.doLoginWith("joxel24027@hebase.com", "Test@123")	
//									.getUserName();
		
		assertEquals(homePage.gotoLoginPage()
				.doLoginWith(user.getUsername(), user.getPassword())	
				.getUserName(), 
				"Som Basak", "User name does not match after login");
		
		
	}
	
	@Test(description = "Verify user is able to login with valid credentials", groups = {"smoke", "sanity"},
			dataProvider = "LoginTestExcelDataProvider", dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
			
	public void LoginExcelTest(User user) {
		
		assertEquals(homePage.gotoLoginPage()
				.doLoginWith(user.getUsername(), user.getPassword())	
				.getUserName(), 
				"Som Basak", "User name does not match after login");		
	}
	
	
	
	
}
