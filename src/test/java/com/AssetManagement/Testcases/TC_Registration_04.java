package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.pages.RegistrationPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Registration_04 extends BaseClass {

	@Test
	public void verifyMandatoryFields() {
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		// Step 4 Click on Register Now
		lp.clickRegisterNow();

		RegistrationPage rp = new RegistrationPage(driver);
		// Step 5 Leave all mandatory fields empty

		// Step 6 Click on submit button
		rp.clickSubmit();

		// Locate the error message element
        WebElement errorMessage = driver.findElement(By.xpath("//input[@id='name']"));

		if (errorMessage.isDisplayed()) {
			System.out.println("Test Passed: Error message displayed as expected.");
		} else {
			System.out.println("Test Failed: Error message not displayed.");
		}
	}
}
