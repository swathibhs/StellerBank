package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	// Declaration
	@FindBy(name = "add_beneficiary")
	private WebElement AddBeneficiaryBtn;
	@FindBy(name = "delete_beneficiary")
	private WebElement DeleteBeneficiaryBtn;
	//view
	
	// initialization
	public FundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getAddBeneficiaryBtn() {
		return AddBeneficiaryBtn;
	}

	public WebElement getDeleteBeneficiaryBtn() {
		return DeleteBeneficiaryBtn;
	}
	

}
