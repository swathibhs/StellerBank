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

public class AccountOpeningformPage {
	// declaration
	@FindBy(name = "name")
	private WebElement nameTxtEdt;
	@FindBy(name = "gender")
	private WebElement selectGenderDD;
	@FindBy(name = "mobile")
	private WebElement PhoneNoTxtEdt;
	@FindBy(name = "email")
	private WebElement EmailTxtEdt;
	@FindBy(name = "pan_no")
	private WebElement panTxtEdt;
	@FindBy(name = "citizenship")
	private WebElement CitizenshipTxtEdt;
	@FindBy(name = "homeaddrs")
	private WebElement HomeAddTxtEdt;
	@FindBy(name = "officeaddrs")
	private WebElement OfficeAddTxtEdt;
	@FindBy(name = "state")
	private WebElement selectStateDD;
	@FindBy(name = "city")
	private WebElement selectCityDD;
	@FindBy(name = "pin")
	private WebElement PinTxtEdt;
	@FindBy(name = "arealoc")
	private WebElement AreaTxtEdt;
	@FindBy(name = "nominee_name")
	private WebElement NNameTxtEdt;
	@FindBy(name = "nominee_ac_no")
	private WebElement NAccNoTxtEdt;
	@FindBy(name = "acctype")
	private WebElement selectAccTypeDD;
	@FindBy(name = "submit")
	private WebElement submitBtn;
	@FindBy(name="dob")
	private WebElement dobTxtEdt;

	

	// initialization
	public AccountOpeningformPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getNameTxtEdt() {
		return nameTxtEdt;
	}

	public WebElement getSelectGenderDD() {
		return selectGenderDD;
	}

	public WebElement getPhoneNoTxtEdt() {
		return PhoneNoTxtEdt;
	}

	public WebElement getEmailTxtEdt() {
		return EmailTxtEdt;
	}

	public WebElement getCitizenshipTxtEdt() {
		return CitizenshipTxtEdt;
	}

	public WebElement getHomeAddTxtEdt() {
		return HomeAddTxtEdt;
	}

	public WebElement getOfficeAddTxtEdt() {
		return OfficeAddTxtEdt;
	}

	public WebElement getSelectStateDD() {
		return selectStateDD;
	}

	public WebElement getSelectCityDD() {
		return selectCityDD;
	}

	public WebElement getPinTxtEdt() {
		return PinTxtEdt;
	}

	public WebElement getAreaTxtEdt() {
		return AreaTxtEdt;
	}

	public WebElement getNNameTxtEdt() {
		return NNameTxtEdt;
	}

	public WebElement getNAccNoTxtEdt() {
		return NAccNoTxtEdt;
	}

	public WebElement getSelectAccTypeDD() {
		return selectAccTypeDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getDobTxtEdt() {
		return dobTxtEdt;
	}
	
	//enter details
	//business libraries
	WebUtility wUtil;
			public String enterDetails(HashMap<String ,String>fields,WebDriver driver,WebUtility wUtil,JavaUtility jUtil) {
				String name="";
			for(Entry<String,String> set:fields.entrySet()) {
			
						
						
			if(set.getKey().equalsIgnoreCase("gender"))
					{
				wUtil.selectElementInDropdown(set.getValue(),selectGenderDD);
				
			}
			else if(set.getKey().equalsIgnoreCase("state")) {
				wUtil.selectElementInDropdown(set.getValue(),selectStateDD);
			}
			else if(set.getKey().equalsIgnoreCase("city")) {
				wUtil.selectElementInDropdown(set.getValue(),selectCityDD);
			}
			else if(set.getKey().equalsIgnoreCase("acctype")) {
				wUtil.selectElementInDropdown(set.getValue(),selectAccTypeDD);}
				else if(set.getKey().equalsIgnoreCase("name"))
				{
					nameTxtEdt.sendKeys(set.getValue()+jUtil.getRandomNumber());
					name=set.getValue()+jUtil.getRandomNumber();
					
				}
				else {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
			}
			return name;
			}
	
	//enter dob
	public void enterdob(String DATE,String MONTH,String YEAR ) {
		dobTxtEdt.click();
		dobTxtEdt.sendKeys(DATE);
		dobTxtEdt.sendKeys(MONTH);
		dobTxtEdt.sendKeys(YEAR);
	}

}
