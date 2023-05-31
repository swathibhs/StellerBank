package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steller.Utilities.WebUtility;

public class HomePage {

	// Declaration
	@FindBy(xpath = "//li[.='Open Account']")
	private WebElement openAccBtn;
	@FindBy(xpath = "//li[.='Apply Debit Card']")
	private WebElement applyDebitCardBtn;
	@FindBy(name = "credit_cust_ac")
	private WebElement creditBtn;
	@FindBy(xpath = "//li[.='Fund Transfer']")
	private WebElement fundTransferBtn;
	@FindBy(xpath = "//a[.='Staff Login']")
	private WebElement staffLoginLink;
	@FindBy(xpath = "//div[@class='ebanking']")
	private WebElement eBankingBtn;
	@FindBy(xpath = "//a[.='Login ']")
	private WebElement loginBtn;
	@FindBy(xpath = "//a[.='Register']")
	private WebElement RegisterBtn;

	

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getOpenAccBtn() {
		return openAccBtn;
	}

	public WebElement getApplyDebitCardBtn() {
		return applyDebitCardBtn;
	}

	public WebElement getCreditBtn() {
		return creditBtn;
	}

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}

	public WebElement getStaffLoginLink() {
		return staffLoginLink;
	}

	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getRegisterBtn() {
		return RegisterBtn;}
	
	public WebElement geteBankingBtn() {
		return eBankingBtn;
	}

	
public void mousehoverInternetBanking(WebDriver driver, WebUtility wUtil) {
	wUtil.mousehoverOnElement(driver ,eBankingBtn); 
}
}
	


