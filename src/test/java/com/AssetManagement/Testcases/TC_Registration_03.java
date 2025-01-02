package com.AssetManagement.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.pages.RegistrationPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Registration_03 extends BaseClass {

	@DataProvider(name = "registrationData")
	public Object[][] createRegistrationData() {
		return new Object[][] { { "John", "Doe", "EMP12345", "SAP67890", "Password@123", "john.doe@example.com", "",
				"1234", "9876543210", "Testing", "IT", "Trainee", "India", "Maharashtra", "Pune", "sector-21", "263/21",
				"tower B", "" },
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

		// Step 5 & 6: Fill out the registration form with valid data
		rp.registrationPage(firstname, lastname, employeeId, sapcode, password, emailId, deskphone, extensionno,
				mobileno, designation, department, emptype, country, state, location, sublocation, subsublocation,
				office, reportingl1);

		// Step 7 Click on Submit Button
		rp.clickSubmit();
	}
}
