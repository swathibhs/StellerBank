package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteBenPage {
	// Declaration
	@FindBy(xpath = "//input[@value=' 5 '")
	private WebElement clickRadioBtn;
	@FindBy(name = "delete_beneficiary")
	private WebElement DeleteBeneBtn;
	@FindBy(name = "logout_btn")
	private WebElement logoutBtn;
	
	// initialization
	public DeleteBenPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getClickRadioBtn() {
		return clickRadioBtn;
	}

	public WebElement getDeleteBeneBtn() {
		return DeleteBeneBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

}
