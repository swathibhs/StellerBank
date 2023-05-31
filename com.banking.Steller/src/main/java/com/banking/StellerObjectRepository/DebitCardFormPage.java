package com.banking.StellerObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steller.Utilities.JavaUtility;
import steller.Utilities.WebUtility;

public class DebitCardFormPage {
	// Declaration
	@FindBy(name = "holder_name")
	private WebElement holderNameTxtEdt;
	@FindBy(name = "pan")
	private WebElement PanTxtEdt;
	@FindBy(name = "mob")
	private WebElement phoneTxtEdt;
	@FindBy(name = "acc_no")
	private WebElement accNoTxtEdt;
	@FindBy(name = "dbt_crd_submit")
	private WebElement submitBtn;
	

	// initialization
	public DebitCardFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization
	public WebElement getHolderNameTxtEdt() {
		return holderNameTxtEdt;
	}


	public WebElement getPanTxtEdt() {
		return PanTxtEdt;
	}

	public WebElement getPhoneTxtEdt() {
		return phoneTxtEdt;
	}

	public WebElement getAccNoTxtEdt() {
		return accNoTxtEdt;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	

//	public void enterDetailforDebit(HashMap<String ,String>fields,WebDriver driver,JavaUtility jUtil) {
//	for(Entry<String,String> set:fields.entrySet()) {
//		if(set.getKey().equalsIgnoreCase("name"))
//		{
//		holderNameTxtEdt.sendKeys(set.getValue()+jUtil.getRandomNumber());
//			
//		}
//		else {
//		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//	}}}
}
