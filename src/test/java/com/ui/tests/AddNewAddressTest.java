package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;

public class AddNewAddressTest extends TestBase{

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("joxel24027@hebase.com", "Test@123");
		
	}
	
	@Test
	public void VerifyAddNewAddressTest() {
	
		myAccountPage.goToAddAddressPage().saveAddress();
	}
	
}
