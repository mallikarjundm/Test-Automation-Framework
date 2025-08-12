package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestold {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		
		BrowserUtility browserUtility= new BrowserUtility(browserName);
		browserUtility.goToWebsite("http://www.automationpractice.pl");
		browserUtility.maximizeWindow();
		
		
		browserUtility.clickOn(SignInLinkLocator);
		
		
		browserUtility.enterText(emailTextBoxLocator, "java@gmail.com");
		
		
		browserUtility.enterText(pwdTextBoxLocator, "shdsh152!");
		
		
		browserUtility.clickOn(submitLoginButtonLocator);
	}

}
