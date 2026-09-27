package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class AddNewAddressAtFirstTimeTest extends TestBase{

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	AddressPOJO addressPojo;
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("joxel24027@hebase.com", "Test@123");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verify the first time valid logged in user can able to update the address through the 'ADD MY FIRST ADDRESS' btn",
			groups = {"e2e","smoke","sanity"})
			
	public void VerifyAddNewAddressAtFirstTimeTest() {
	
		String actualAddressHeading = myAccountPage.goToAddAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(actualAddressHeading, addressPojo.getAddressAlias().toUpperCase(), "The Address Heading is not matching");
	}
	
}
