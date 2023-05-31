package com.banking.StellerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerProfilePage {
	// Declaration
	@FindBy(xpath = "//li[.='Fund Transfer']")
	private WebElement fundTransferLnk;
	@FindBy(name = "logout_btn")
	private WebElement logoutBtn;
	@FindBy(xpath = "//li[.='Statement']")
	private WebElement StatementLnk;
	
	
	// initialization
	public CustomerProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization
	public WebElement getFundTransferLnk() {
		return fundTransferLnk;
	}



	public WebElement getLogoutBtn() {
		return logoutBtn;
	}



	public WebElement getStatementLnk() {
		return StatementLnk;
	}
	
	public void verifyCustomerHomePage(WebDriver driver,String accountHolderName ){
		if(driver.findElement(By.xpath("//label[.='Welcome" +accountHolderName+"']")).isDisplayed()) {
			System.out.println("customerpage is displayed");
		}
	else
	{
		System.out.println("customerpage is not displayed");
	}
	}
}







