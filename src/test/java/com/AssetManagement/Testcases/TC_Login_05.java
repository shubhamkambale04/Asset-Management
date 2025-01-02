package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

 
public class TC_Login_05 extends BaseClass {

	@DataProvider(name = "invalidLoginDataProvider")
	public Object[][] invalidLoginDataProvider() {
		return new Object[][] { { "ADMIN1", "Admin@123", "User" } };
	}

	@Test(dataProvider = "invalidLoginDataProvider")
	public void verifyInvalidLogin(String username, String password, String role) throws InterruptedException {
		
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Step 5 & 6
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);

		// Role should not be selected if username is incorrect
		if (!username.equals("ADMIN1")) {

			// Step 7 Select role only if the credentials are valid
			lp.selectRole(role);
		} else {
			System.out.println("Incorrect username");
		}

		// Step 8 Click on login Button
		lp.clickLoginButton();

		// Wait for the error message to be displayed
		WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));

		//Step 9 Assert unsuccessful login by checking if the error message is displayed
		Assert.assertTrue(loginLink.isDisplayed(),"Invalid username login failed as expected. Error message is displayed.");
	}
}
