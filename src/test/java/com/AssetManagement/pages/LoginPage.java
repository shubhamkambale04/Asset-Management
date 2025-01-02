package com.AssetManagement.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='emp_id']")
	WebElement username;

	@FindBy(xpath = "//input[@id='credential']")
	WebElement password;

	@FindBy(xpath = "//select[@id='role']")
	WebElement dropdownElement;

	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	WebElement loginButton;

	@FindBy(tagName = "strong")
	WebElement register;

	public void clickRegisterNow() {
		register.click();
		
	}

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public boolean isRoleDropdownVisible() {
		try {
			return dropdownElement.isDisplayed();
		} catch (Exception e) {
			System.out.println("Role dropdown is not visible: " + e.getMessage());
			return false;
		}
	}

	public boolean hasRoles() {
		if (isRoleDropdownVisible()) {
			Select roles = new Select(dropdownElement);
			return !roles.getOptions().isEmpty();
		}
		return false;
	}

	public void selectRole(String role) {
		if (isRoleDropdownVisible() && hasRoles()) {
			Select dropdown = new Select(dropdownElement);
			try {
				dropdown.selectByVisibleText(role);
			} catch (Exception e) {
				System.out.println("Role selection failed: " + e.getMessage());
			}
		} else {
			System.out.println("Dropdown is not visible or has no options.");
		}
	}

	public void clickLoginButton() {

		loginButton.click();
		
	}

	public void handlePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			WebElement popupCloseButton = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='close-popup']")));
			popupCloseButton.click();
		} catch (Exception e) {
			System.out.println("No pop-up appeared or was already handled: " + e.getMessage());
		}
	}
}
