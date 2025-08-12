package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_lINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
	goToWebsite(JsonUtility.readJson(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtility.readJson(QA).getUrl());
	}

	public LoginPage goToLoginPage() {// page functions..
		logger.info("trying to perform the click to goto SignIn Page");
		clickOn(SIGN_IN_lINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());//pass the session to other page..
		return loginPage;
	}
	

}
