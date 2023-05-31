package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
	// declaration
		@FindBy(name = "customer_id")
		private WebElement customerIdTxtEdt;
		@FindBy(name = "password")
		private WebElement passwordTxtEdt;
		@FindBy(name = "login-btn")
		private WebElement loginBtn;

		// initialization
		public CustomerLoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		// utilization

		public WebElement getCustomerIdTxtEdt() {
			return customerIdTxtEdt;
		}

		public WebElement getPasswordTxtEdt() {
			return passwordTxtEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		public void custLogin(String CUST_ID,String CUSTPASSWORD) {
			customerIdTxtEdt.sendKeys(CUST_ID);
			passwordTxtEdt.sendKeys(CUSTPASSWORD);
			loginBtn.click();
		}
			

}
