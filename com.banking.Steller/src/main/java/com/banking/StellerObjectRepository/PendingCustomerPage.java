package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingCustomerPage {
	// Declaration
	@FindBy(name = "application_no")
	private WebElement ApplicationNoTxtEdt;
	@FindBy(name = "search_application")
	private WebElement SearchBtn;
	@FindBy(name = "approve_cust")
	private WebElement ApproveBtn;
	@FindBy(xpath="//a[.='Staff Login']") 
	private WebElement Staffloginlink;
	@FindBy(xpath="//a[.='Home']") 
	private WebElement homeloginlink;

	public WebElement getHomeloginlink() {
		return homeloginlink;
	}

	public WebElement getStaffloginlink() {
		return Staffloginlink;
	}

	// initialization
	public PendingCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getApplicationNoTxtEdt() {
		return ApplicationNoTxtEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getApproveBtn() {
		return ApproveBtn;
	}

}
