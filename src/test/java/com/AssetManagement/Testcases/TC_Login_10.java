package com.AssetManagement.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AssetManagement.pages.HomePage;
import com.AssetManagement.pages.LoginPage;
import com.AssetManagement.testBase.BaseClass;

public class TC_Login_10 extends BaseClass {

    @DataProvider(name = "invalidLoginDataProvider")
    public Object[][] invalidLoginDataProvider() {
        // Using a correct username and password but an inactive role
        return new Object[][] { { "1100","Admin@100","User" } };
    }

    @Test(dataProvider = "invalidLoginDataProvider")
    public void verifyInactiveUserLogin(String username, String password, String role) throws InterruptedException {
		
		// Step 3 Click on Login
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Step 5 & 6
		hp.clickLogin();

		LoginPage lp=new LoginPage(driver);
        // Step 8: Click on login Button
        lp.clickLoginButton();

        // Wait for the error message or specific indication of inactive user
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Account not active')]"));

        // Step 9: Assert that an error message indicating login failure is displayed
        Assert.assertTrue(errorMessage.isDisplayed(),
                "Inactive user login attempt failed as expected. Error message is displayed.");
        
        // Step 10: Handle the popup by clicking the "OK" button
        Thread.sleep(2000);
        WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
        okButton.click();
    }
}
