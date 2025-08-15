package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class InvalidLoginCredentials extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "Arjun@gmail.com";
	private static final String INVALID_PASSWORD = "Arjun123";

	@Test(description = "Verify if the proper error message is shown for the invalid credentials for the users..", groups = {
			"e2e", "sanity", "smoke" })

	public void loginTest() {

		assertEquals(homepage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");
	}

}