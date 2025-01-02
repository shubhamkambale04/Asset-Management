package com.AssetManagement.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AssetManagement.pages.DashboardPage;
import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Logout_02 extends BaseClass {

	@Test()
	public void verifySuccessfulLogout() {
		try {
			
			// Step 3 Click on Login
			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			// Step 5 & 6
			LoginPage lp=new LoginPage(driver);
			lp.setUsername(pro.getProperty("uname"));
			lp.setPassword(pro.getProperty("password"));
			lp.selectRole(pro.getProperty("role2"));

			// Step 8 Click loginButton
			lp.clickLoginButton();

			// MyAccount
			DashboardPage dp = new DashboardPage(driver);
			dp.DashboardExists();
			// Step 10 successful logout
			dp.clickLogout();

			boolean targetPage = hp.HomePageExists();

			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_Logout_Test");
	}
}
