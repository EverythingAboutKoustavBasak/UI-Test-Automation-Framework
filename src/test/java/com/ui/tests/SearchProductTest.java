package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "summer printed dress";
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("joxel24027@hebase.com", "Test@123");
		
	}
	
	
	@Test(description = "Verify if the logged in user is able to search for a product and the correct product/products are displayed",
			groups = {"e2e","smoke","sanity"})
			
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		assertEquals(actualResult, true);
	}
}
