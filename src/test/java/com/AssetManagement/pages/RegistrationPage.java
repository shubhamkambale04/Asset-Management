package com.AssetManagement.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(tagName = "h1")
	WebElement registerheading;

	@FindBy(xpath = "//button[contains(text(),'CANCEL')]")
	WebElement cancel;

	@FindBy(xpath = "//input[@id='name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='emp_id']")
	WebElement employeeId;

	@FindBy(xpath = "//input[@id='sap_code']")
	WebElement sapcode;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='email_id']")
	WebElement emailId;

	@FindBy(xpath = "//input[@id='deskphone']")
	WebElement deskphone;

	@FindBy(xpath = "//input[@id='ext']")
	WebElement extensionno;

	@FindBy(xpath = "//input[@id='mobileno']")
	WebElement mobileno;

	@FindBy(xpath = "//select[@id='designation']")
	WebElement designation;

	@FindBy(xpath = "//select[@id='department']")
	WebElement department;

	@FindBy(xpath = "//select[@id='emptype']")
	WebElement emptype;

	// Profile image
	// @FindBy(xpath = "//input[@id='file']")
	// WebElement file;

	@FindBy(xpath = "//select[@id='country']")
	WebElement country;

	@FindBy(xpath = "//select[@id='state']")
	WebElement state;

	@FindBy(xpath = "//select[@id='location']")
	WebElement location;

	@FindBy(xpath = "//select[@id='sub_location']")
	WebElement sublocation;

	@FindBy(xpath = "//select[@id='sub_sub_location']")
	WebElement subsublocation;

	@FindBy(xpath = "//select[@id='office_address']")
	WebElement office;

	@FindBy(xpath = "//select[@id='reportingl1']")
	WebElement reportingl1;

	// Below reporting levels are not mandatory to registration of user and it
	// not selected while registration.

	/*
	 * @FindBy(xpath = "//select[@id='reportingl2']") WebElement reportingl2;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl3']") WebElement reportingl3;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl4']") WebElement reportingl4;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl5']") WebElement reportingl5;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl6']") WebElement reportingl6;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl7']") WebElement reportingl7;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl8']") WebElement reportingl8;
	 * 
	 * @FindBy(xpath = "//select[@id='reportingl9']") WebElement reportingl9;
	 */

	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	public boolean verifyRegisterNow()
	{
		try {
			return registerheading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void registrationPage(String firstnameValue, String lastnameValue, String employeeIdValue,
			String sapcodeValue, String passwordValue, String emailIdValue, String deskphoneValue,
			String extensionnoValue, String mobilenoValue, String designationValue, String departmentValue,
			String emptypeValue, String countryValue, String stateValue, String locationValue, String sublocationValue,
			String subsublocationValue, String officeValue, String reportingl1Value) {

		firstname.sendKeys(firstnameValue);
		lastname.sendKeys(lastnameValue);
		employeeId.sendKeys(employeeIdValue);
		sapcode.sendKeys(sapcodeValue);
		password.sendKeys(passwordValue);
		emailId.sendKeys(emailIdValue);
		deskphone.sendKeys(deskphoneValue);
		extensionno.sendKeys(extensionnoValue);
		mobileno.sendKeys(mobilenoValue);

		selectDesignation(designationValue);
		selectDepartment(departmentValue);
		selectEmpType(emptypeValue);
		selectCountry(countryValue);
		selectState(stateValue);
		selectLocation(locationValue);
		selectSubLocation(sublocationValue);
		selectSubSubLocation(subsublocationValue);
		selectOffice(officeValue);
		selectReportingL1(reportingl1Value);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void clickCancelButton() {
		cancel.click();
	}

	private boolean isOptionPresentInDropdown(WebElement dropdownElement, String value) {
		Select select = new Select(dropdownElement);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public void selectDesignation(String value) {
		if (isOptionPresentInDropdown(designation, value)) {
			Select select = new Select(designation);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in Designation dropdown");
			// You can also throw an exception or log an error here
		}
	}

	public void selectDepartment(String value) {
		if (isOptionPresentInDropdown(department, value)) {
			Select select = new Select(department);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in Department dropdown");
		}
	}

	public void selectEmpType(String value) {
		if (isOptionPresentInDropdown(emptype, value)) {
			Select select = new Select(emptype);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in EmpType dropdown");
		}
	}

	public void selectCountry(String value) {
		if (isOptionPresentInDropdown(country, value)) {
			Select select = new Select(country);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in Country dropdown");
		}
	}

	public void selectState(String value) {
		if (isOptionPresentInDropdown(state, value)) {
			Select select = new Select(state);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in State dropdown");
		}
	}

	public void selectLocation(String value) {
		if (isOptionPresentInDropdown(location, value)) {
			Select select = new Select(location);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in Location dropdown");
		}
	}

	public void selectSubLocation(String value) {
		if (isOptionPresentInDropdown(sublocation, value)) {
			Select select = new Select(sublocation);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in SubLocation dropdown");
		}
	}

	public void selectSubSubLocation(String value) {
		if (isOptionPresentInDropdown(subsublocation, value)) {
			Select select = new Select(subsublocation);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in SubSubLocation dropdown");
		}
	}

	public void selectOffice(String value) {
		if (isOptionPresentInDropdown(office, value)) {
			Select select = new Select(office);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in Office dropdown");
		}
	}

	public void selectReportingL1(String value) {
		if (isOptionPresentInDropdown(reportingl1, value)) {
			Select select = new Select(reportingl1);
			select.selectByVisibleText(value);
		} else {
			System.out.println("Value " + value + " not present in ReportingL1 dropdown");
		}
	}
}
