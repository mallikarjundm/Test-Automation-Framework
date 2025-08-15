package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailedPage extends BrowserUtility{
	private static final By SIZE_DROP_DOWN_LOCATOR=By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR=By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR =By.xpath("//a[@title=\"Proceed to checkout\"]");

	public ProductDetailedPage(WebDriver driver) {
		super(driver);
		
	}
	
	public ProductDetailedPage changeSize(Size size) {
		selectFromDropDown(SIZE_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailedPage(getDriver());
	}
	
	public ProductDetailedPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailedPage(getDriver());
	}
	public ShoppingCartPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}

}
