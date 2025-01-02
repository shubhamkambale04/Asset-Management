package com.AssetManagement.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath = "//img[@alt='main']")
	WebElement homepage;

	public void clickLogin() {
		login.click();
	}

	public boolean HomePageExists() {
		try {
			return homepage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
