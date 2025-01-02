package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Login_06 extends BaseClass {

	@DataProvider(name = "invalidLoginDataProvider")
	public Object[][] invalidLoginDataProvider() {
		return new Object[][] { { "ADMIN", "Admin@125", "User" } };
	}

	@Test(dataProvider = "invalidLoginDataProvider")
	public void verifyInvalidPasswordLogin(String username, String password, String role) throws InterruptedException {
		
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Step 5 & 6
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);
		// Role should not be selected if username is empty
		if (!password.equals("Admin@125")) {

			// Step 7 Select role only if the credentials are valid
			lp.selectRole(role);
		} else {
			System.out.println("Incorrect password");
		}

		// Step 8 Click on login Button
		lp.clickLoginButton();

		// Wait for the error message to be displayed
		WebElement errorMessage = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));

		// Step 9 Assert unsuccessful login by checking if the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(),
				"Invalid password login attempt failed as expected. Error message is displayed.");
	}
}
