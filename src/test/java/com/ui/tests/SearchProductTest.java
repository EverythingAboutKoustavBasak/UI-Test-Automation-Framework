package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

	private MyAccountPage myAccountPage;
	
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("joxel24027@hebase.com", "Test@123");
		
	}
	
	
	@Test(description = "Verify if the logged in user is able to search for a product and the correct product/products are displayed",
			groups = {"e2e","smoke","sanity"})
			
	public void verifyProductSearchTest() {
		String data = myAccountPage.searchForAProduct("Printed Summer Dress").getSearchResultTitle();
		System.out.println(data);
	}
}
