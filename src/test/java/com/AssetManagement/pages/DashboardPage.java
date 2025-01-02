package com.AssetManagement.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='Dashboard']")
	WebElement headermsg;

	@FindBy(xpath = "//a[@href='logout.htm']")
	WebElement logout;

	public boolean DashboardExists() {
		try {
			return headermsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		logout.click();
		System.out.println("Logout Successful");
	}

}
