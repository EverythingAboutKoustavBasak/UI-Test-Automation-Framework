package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	
	private static final String SEARCH_TERM = "Prined Summer Dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "User logs into the application and search for a product")
	public void setup() {
		searchResultPage = homePage.gotoLoginPage().doLoginWith("joxel24027@hebase.com", "Test@123").searchForAProduct(SEARCH_TERM);
	}
	
	
	@Test(description = "Verify if the logged in user is able to buy a dress", groups = {"smoke", "sanity", "e2e"})
	public void checkoutTest() {
		searchResultPage.clickOntheProductAt(0).changeSize(Size.L);
		
		
	}

}
