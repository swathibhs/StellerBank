package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {

	// Declaration
	@FindBy(name = "staff_id")
	private WebElement StaffIDTxtEdt;
	@FindBy(name = "password")
	private WebElement PasswordTxtEdt;
	@FindBy(name = "staff_login-btn")
	private WebElement LoginBtn;
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeLink;

	// initialization
	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getStaffIDTxtEdt() {
		return StaffIDTxtEdt;
	}

	public WebElement getPasswordTxtEdt() {
		return PasswordTxtEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public void staffLogin(String USERNAME, String PASSWORD) {
		StaffIDTxtEdt.sendKeys(USERNAME);
		PasswordTxtEdt.sendKeys(PASSWORD);
		LoginBtn.click();
	}
}
