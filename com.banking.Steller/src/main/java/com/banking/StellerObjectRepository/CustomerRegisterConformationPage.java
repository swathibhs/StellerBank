package com.banking.StellerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegisterConformationPage {

	// initialization
	@FindBy(name = "cnfrm-submit")
	private WebElement conformBtn;

	// initialization
	public CustomerRegisterConformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getConformBtn() {
		return conformBtn;
	}

}
