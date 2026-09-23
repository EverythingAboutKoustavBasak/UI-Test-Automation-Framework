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

@Listeners({ com.ui.listeners.TestListener.class })
public class InvalidCredentialLoginTest extends TestBase {

	/*
	 * Best Test Methods Principal - 1. Should be small is size only contains the
	 * test steps 2. should have atleast one assertion 3. Reduce the use of the
	 * local variables 4. Can't use any loops or conditional statements and try
	 * catch blocks inside the test methods 5. have @Test annotation with
	 * description attribute and groups attribute
	 */

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final String INVALID_EMAIL_ADDRESS = "abc@gamil.com";
	private static final String INVALID_PASSWORD = "abc@123";

	@Test(description = "Verify if the error msg is shown for the invalid credential", groups = { "smoke",
			"sanity" }, retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)

	public void invalidCredLoginTest() {

		assertEquals(homePage.gotoLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.", "Error message does not match/appear");
	}

}
