package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Login_03 extends BaseClass {

	@DataProvider(name = "invalidLoginDataProvider")
	public Object[][] invalidLoginDataProvider() {
		return new Object[][] { { "ADMIN1", "Invalid@123", "Super Admin" } };
	}

	@Test(dataProvider = "invalidLoginDataProvider")
	public void verifyInvalidLogin(String username, String password, String role) {

		try {
				
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Step 5 & 6
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);
		// Step 7: Attempt to select a role(Select role only if the credentials are valid)
		if (!username.equals("ADMIN1") && !password.equals("Invalid@123")) {
			lp.selectRole(role);
		} else {
			System.out.println("Incorrect username & password provided.");
		}

		//Step 8 Click on login Button
		lp.clickLoginButton();

		// Wait for the error message to be displayed
		WebElement loginLink = driver.findElement(By.xpath("//a[normalize-space()='Login']"));

		//Step 9 Assert unsuccessful login by checking if the error message is displayed
		Assert.assertTrue(loginLink.isDisplayed(),"Invalid login attempt failed as expected. Error message is displayed.");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
}
}
