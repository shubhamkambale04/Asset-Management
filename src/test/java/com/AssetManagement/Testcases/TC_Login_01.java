package com.AssetManagement.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AssetManagement.pages.DashboardPage;
import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Login_01 extends BaseClass {

	@Test()
	public void verifySuccessfulLogin() {
		try {
			
			// Step 3 Click on Login
			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			// Step 5 & 6
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(pro.getProperty("uname"));
			lp.setPassword(pro.getProperty("password"));
			lp.selectRole(pro.getProperty("role2"));

			// Step 8 Click loginButton
			lp.clickLoginButton();

			// MyAccount
			DashboardPage dp = new DashboardPage(driver);
			boolean targetPage = dp.DashboardExists();

			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_Login_Test");
	}
}
