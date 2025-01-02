package com.AssetManagement.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.pages.RegistrationPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Registration_01 extends BaseClass {

	@Test
	public void verifyRegisterNow() {

		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		// Step 4 Click on Register Now
		lp.clickRegisterNow();
		
		RegistrationPage rp =new RegistrationPage(driver);
		boolean registerpage = rp.verifyRegisterNow();
		Assert.assertTrue(registerpage);
		}
	}

