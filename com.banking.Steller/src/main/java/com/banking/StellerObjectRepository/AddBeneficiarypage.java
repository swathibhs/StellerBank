package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steller.Utilities.WebUtility;

public class AddBeneficiarypage {
	// Declaration
	@FindBy(name = "beneficiary_name")
	private WebElement BeneNameTxtEdt;
	@FindBy(name = "beneficiary_acno")
	private WebElement BeneAccNoTxtEdt;
	@FindBy(name = "Ifsc_code")
	private WebElement ISFCTxtEdt;
	@FindBy(name = "beneficiary_acc_type")
	private WebElement SelectBeneAccTypeDD;
	@FindBy(name = "add_beneficiary_btn")
	private WebElement AddBeneBtn;

	// initialization
	public AddBeneficiarypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getBeneNameTxtEdt() {
		return BeneNameTxtEdt;
	}

	public WebElement getBeneAccNoTxtEdt() {
		return BeneAccNoTxtEdt;
	}

	public WebElement getISFCTxtEdt() {
		return ISFCTxtEdt;
	}

	public WebElement getBeneAccTypeDD() {
		return SelectBeneAccTypeDD;
	}

	public WebElement getAddBeneBtn() {
		return AddBeneBtn;
	}
	
public void addBeneDetails(String BENENAME,String BENEACCNO,String ISFC ) {
	BeneNameTxtEdt.sendKeys(BENENAME);
	BeneAccNoTxtEdt.sendKeys(BENEACCNO);
	ISFCTxtEdt.sendKeys(ISFC);
	
	
}
public void selectBeneAccType(String BENEACCTYPE, WebUtility wUtil) {
	wUtil.selectElementInDropdown(SelectBeneAccTypeDD, BENEACCTYPE);}

}
