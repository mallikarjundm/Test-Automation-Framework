package com.ui.test;
import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
  
  Logger logger=LoggerUtility.getLogger(this.getClass());
    @BeforeMethod(description= "This Loads the HomePage of Website")
	
    public void setUp() {
		homepage=new HomePage(CHROME,true);
	}
	
@Test(description= "This verifies if the valid user is able to login..", groups= {"e2e","sanity"}, dataProviderClass= com.ui.dataprovider.LoginDataProvider.class, dataProvider="LoginTestDataProvider")  
	
public void loginTest(User user) {
	
      assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "A ab");
}


//@Test(description= "This verifies if the valid user is able to login..", groups= {"e2e","sanity"}, dataProviderClass= com.ui.dataprovider.LoginDataProvider.class, dataProvider="LoginTestCSVDataProvider")  
//
//public void loginCSVTest(User user) {
//	
//    
//   assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "A ab");
// }
//
//
//@Test(description= "This verifies if the valid user is able to login..", groups= {"e2e","sanity"}, 
//dataProviderClass= com.ui.dataprovider.LoginDataProvider.class, dataProvider="LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)  
//
//public void loginEXCELTest(User user) {
//	
//	
//   assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "aab");
// 
//   }
}