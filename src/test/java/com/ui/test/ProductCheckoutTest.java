package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "printed summer dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = " User logs into the application and searches for a product")
	public void setup() {
		searchResultPage = homepage.goToLoginPage().doLoginWith("watori5783@mvpmedix.com", "akak123")
				.searchForProduct(SEARCH_TERM);
	}

	@Test(description = "Verify if the logged in is able to buy the dress", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() {
		String result=searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).addProductToCart().proceedToCheckout()
				.goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePaymentByWire();
		Assert.assertTrue(result.contains("complete"));
	}

}
