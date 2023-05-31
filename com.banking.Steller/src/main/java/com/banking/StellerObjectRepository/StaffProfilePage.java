package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffProfilePage {
	// Declaration
	@FindBy(name = "view_cust_by_ac")
	private WebElement veiwCustAccNoBtn;
	@FindBy(name = "apprvac")
	private WebElement approvePendingAccBtn;
	@FindBy(name = "credit_cust_ac")
	private WebElement credCustomerAccBtn;
	@FindBy(name = "logout_btn")
	private WebElement logOutBtn;

	// initialization
	public StaffProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getVeiwCustAccNoBtn() {
		return veiwCustAccNoBtn;
	}

	public WebElement getApprovePendingAccBtn() {
		return approvePendingAccBtn;
	}

	public WebElement getCredCustomerAccBtn() {
		return credCustomerAccBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

}
