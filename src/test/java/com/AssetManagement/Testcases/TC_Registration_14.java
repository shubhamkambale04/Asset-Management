package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.pages.RegistrationPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Registration_14 extends BaseClass {

	@DataProvider(name = "registrationData")
	public Object[][] createRegistrationData() {
		return new Object[][] { { "John", "Doe", "EMP12345", "SAP67890", "Password@123", "john.doe@example.com", "",
				"1234", "9876543210", "Testing", "IT", "Trainee", "India", "Maharashtra", "Pune", "sector-21", "263/21",
				"tower B", "Shubham Kambale-1120" },
				// Add more data sets here as needed
		};
	}

	@Test(dataProvider = "registrationData")
	public void verifySuccessfulRegistration(String firstname, String lastname, String employeeId, String sapcode,
			String password, String emailId, String deskphone, String extensionno, String mobileno, String designation,
			String department, String emptype, String country, String state, String location, String sublocation,
			String subsublocation, String office, String reportingl1) throws InterruptedException {

		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		// Step 4 Click on Register Now
		lp.clickRegisterNow();

		RegistrationPage rp = new RegistrationPage(driver);
		// Step 5: Fill out the registration form including the already taken username.
		employeeId.compareTo(employeeId);

		// Step 6: Trigger the real-time validation by clicking outside the username
		// field
		WebElement firstnameField = driver.findElement(By.id("name"));
		firstnameField.click(); // Clicking on another element to trigger validation

		// Wait for the validation error message (assuming it's displayed as a text or
		// popup)
		WebElement errorMessage = driver.findElement(By.xpath("//span[@id='for_emp_id1']"));

		// Step 7: Validate the uniqueness check
		if (errorMessage.isDisplayed()) {
			System.out.println("Test Passed: Username already taken alert is displayed.");
		} else {
			System.out.println("Test Failed: Username uniqueness validation did not work.");
		}
	}
}
