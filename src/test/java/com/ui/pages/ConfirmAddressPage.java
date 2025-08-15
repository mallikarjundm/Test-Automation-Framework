package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility{
	private static final By AGAIN_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.name("processAddress");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	public ShipmentPage goToShipmentPage() {
		clickOn(AGAIN_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShipmentPage(getDriver());
		
	}
	

}
