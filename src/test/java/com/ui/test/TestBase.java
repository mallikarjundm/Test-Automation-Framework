package com.ui.test;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.testng.annotations.Optional;

public class TestBase {
	
	protected HomePage homepage;
	 Logger logger=LoggerUtility.getLogger(this.getClass());
	 private boolean isLambdaTest;
	
	 
	 @Parameters({"browser", "isLambdaTest", "isHeadless"})
	
	 @BeforeMethod(description= "This Loads the HomePage of Website")
		
	 public void setUp(
				@Optional("chrome") String browser, 
				@Optional("false") boolean isLambdaTest, 
				@Optional("true") boolean isHeadless) {
		  
		 ITestResult result = Reporter.getCurrentTestResult(); 
		 this.isLambdaTest=isLambdaTest;
		  
		 WebDriver lambdaDriver;
		 if (isLambdaTest) {
			 lambdaDriver= LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			 homepage= new HomePage(lambdaDriver);
		 }
		 else {
		 logger.info("Load the Homepage of the website");
			homepage=new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		 }
		}
	 
	 public BrowserUtility getInstance() {
		 return homepage;
	 }
	 
	 
	 @AfterMethod(description="Tear down the browser")
	 public void tearDown() {
		 if(isLambdaTest) {
			 LambdaTestUtility.quitSession();
		 }
		 else {
		        BrowserUtility.quitBrowser(); // or DriverFactory.quitDriver()
		    }
	 }

}
