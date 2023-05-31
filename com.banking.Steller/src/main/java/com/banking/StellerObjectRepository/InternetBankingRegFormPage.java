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

public class InternetBankingRegFormPage {
	// declaration
		@FindBy(name = "holder_name")
		private WebElement nameTxtEdt;
		@FindBy(name = "accnum")
		private WebElement AccNoTxtEdt;
		@FindBy(name = "dbtcard")
		private WebElement DebitCardTxtEdt;
		@FindBy(name = "dbtpin")
		private WebElement DebitPinTxtEdt;
		@FindBy(name = "mobile")
		private WebElement PhoneNoTxtEdt;
		@FindBy(name = "pan_no")
		private WebElement panTxtEdt;
		@FindBy(name="dob")
		private WebElement dobTxtEdt;
		@FindBy(name = "last_trans")
		private WebElement LastTranscationTxtEdt;
		@FindBy(name = "password")
		private WebElement passwordTxtEdt;
		@FindBy(name = "cnfrm_password")
		private WebElement ConfrmPasswordTxtEdt;
		@FindBy(name = "submit")
		private WebElement submitBtn;
		@FindBy(xpath="//a[.='Home']")
		private WebElement homeLink;
	

		

		// initialization
		public InternetBankingRegFormPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		// utilization
		
		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		public WebElement getHomeLink() {
			return homeLink;
		}

		
		public void enterDetails(HashMap<String ,String>fields,WebDriver driver) {
			for(Entry<String,String> set:fields.entrySet()) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}	
		//enter dob
		public void enterdob(String DATE,String MONTH,String YEAR ) {
			dobTxtEdt.click();
			dobTxtEdt.sendKeys(DATE);
			dobTxtEdt.sendKeys(MONTH);
			dobTxtEdt.sendKeys(YEAR);
		}}
