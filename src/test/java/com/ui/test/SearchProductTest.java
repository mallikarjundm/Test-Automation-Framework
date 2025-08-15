package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })

public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "printed summer dress";
	
	@BeforeMethod(description=" valid user logs into the application")
	public void setup() {
		myAccountPage=homepage.goToLoginPage().doLoginWith("watori5783@mvpmedix.com", "akk123");
	}
	
	
	@Test(description= "Verify if the logged in user is able to search for a product and correct products search results are displayed", 
			groups= {"e2e", "smoke", "sanity"})
	public void verifyProductSearchTest() {
		boolean actuaResult=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actuaResult, true);
	}
	
	

}
