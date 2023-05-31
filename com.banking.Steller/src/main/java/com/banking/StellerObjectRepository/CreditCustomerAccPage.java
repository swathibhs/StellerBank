package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerAccPage {

	// Declaration
	@FindBy(name = "customer_account_no")
	private WebElement CustAccNoTxtEdt;
	@FindBy(name = "credit_amount")
	private WebElement CreditAmountTxtEdt;
	@FindBy(name = "credit_btn")
	private WebElement CreditBtn;
	@FindBy(name = "logout_btn")
	private WebElement logOutBtn;
	

	// initialization
	public CreditCustomerAccPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getCustAccNoTxtEdt() {
		return CustAccNoTxtEdt;
	}

	public WebElement getCreditAmountTxtEdt() {
		return CreditAmountTxtEdt;
	}

	public WebElement getCreditBtn() {
		return CreditBtn;
	}
	
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public void creditCustomer(String CustomerACCNO ,String AMOUNT) {
		CustAccNoTxtEdt.sendKeys(CustomerACCNO);
		CreditAmountTxtEdt.sendKeys(AMOUNT);
		CreditBtn.click();
	}


}
