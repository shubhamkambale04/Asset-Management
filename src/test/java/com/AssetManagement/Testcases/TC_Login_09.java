package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Login_09 extends BaseClass {

	@DataProvider(name = "loginDataProvider")
	public Object[][] loginDataProvider() {
		return new Object[][] { { "ADMIN", "Admin@123", "Super Admin" } };
	}

	@Test(dataProvider = "loginDataProvider")
	public void verifySuccessfulLoginRole(String username, String password, String role) throws InterruptedException {
		
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Step 5 & 6
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);
		// Step 7 Select role
		lp.selectRole(role);

		// Step 8 Click loginButton
		lp.clickLoginButton();

		// Wait for the dashboard page to be loaded
		WebElement dashboardElement = driver.findElement(By.id("asub0"));

		// Step 9 Assert successful login by checking if the dashboard element is displayed
		Assert.assertTrue(dashboardElement.isDisplayed(), "Login is successful. Dashboard page is displayed.");
	}
}
