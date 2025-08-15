package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;//instance variable always marked with private
	private AddressPOJO address;
	
	@BeforeMethod(description= "Valid first time users logs into the application")
	public void setup() {
		myAccountPage=homepage.goToLoginPage().doLoginWith("watori5783@mvpmedix.com", "akak123");
		address= FakeAddressUtility.getFakeAddress();
		
	}
	
	@Test
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}

}
