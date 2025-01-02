package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.pages.RegistrationPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Registration_06 extends BaseClass {

	@DataProvider(name = "registrationData")
	public Object[][] createRegistrationData() {
		return new Object[][] { { "John", "Doe", "EMP12345", "SAP67890", "Password@123", "john.doe@example.com", "1234",
				"abc123", "9876543210", "Testing", "IT", "Trainee", "India", "Maharashtra", "Pune", "sector-21",
				"263/21", "tower B" },
				// Add more data sets as needed
		};
	}

	@Test(dataProvider = "registrationData")
	public void verifyNumericFields(String deskphone, String extensionno, String mobileno) throws InterruptedException {

		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		// Step 4 Click on Register Now
		lp.clickRegisterNow();

		RegistrationPage rp = new RegistrationPage(driver);

		// Step 5 & 6: Fill out the registration form with valid data
		// rp.registrationPage(deskphone, extensionno, mobileno);

		// Step 7 Click on Submit Button
		rp.clickSubmit();
		// Step 7: Verify error messages
		WebElement mobileError = driver.findElement(By.xpath("//span[@id='mobileno-error']"));
		WebElement extensionError = driver.findElement(By.xpath("//span[@id='ext-error']"));
		Assert.assertTrue(mobileError.isDisplayed(), "Error message for Mobile Phone is not displayed.");
		Assert.assertTrue(extensionError.isDisplayed(), "Error message for Extension No. is not displayed.");

		// Optionally, validate the content of the error messages
		Assert.assertEquals(mobileError.getText(), "Please enter a valid mobile number.",
				"Incorrect error message for Mobile Phone.");
		Assert.assertEquals(extensionError.getText(), "Please enter a valid extension number.",
				"Incorrect error message for Extension No.");
	}
}
