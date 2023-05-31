package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccNoPage {
	// Declaration
	@FindBy(name = "account_no")
	private WebElement CustomerAccNo;
	@FindBy(name = "submit_view")
	private WebElement submitBtn;
	@FindBy(name = "logout_btn")
	private WebElement logOutBtn;

	// initialization
	public ViewCustomerByAccNoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getCustomerAccNo() {
		return CustomerAccNo;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
		
		
		}
	}


