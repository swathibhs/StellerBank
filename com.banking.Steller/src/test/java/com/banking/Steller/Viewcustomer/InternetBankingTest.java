
package com.banking.Steller.Viewcustomer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.StellerObjectRepository.AccountOpeningformPage;
import com.banking.StellerObjectRepository.AddBeneficiarypage;
import com.banking.StellerObjectRepository.CreditCustomerAccPage;
import com.banking.StellerObjectRepository.CustomerLoginPage;
import com.banking.StellerObjectRepository.CustomerProfilePage;
import com.banking.StellerObjectRepository.DeleteBenPage;
import com.banking.StellerObjectRepository.FundTransferPage;
import com.banking.StellerObjectRepository.HomePage;
import com.banking.StellerObjectRepository.InternetBankingRegFormPage;
import com.banking.StellerObjectRepository.StaffLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import steller.Utilities.BaseClass;
import steller.Utilities.ExcelUtility;
import steller.Utilities.FileUtility;
import steller.Utilities.JavaUtility;
import steller.Utilities.WebUtility;

public class InternetBankingTest extends BaseClass{
	@Test
	public void eBanking() throws IOException, Throwable {
		
	//fetch data from Properties file
		String USERNAME = fUtil.getPropertykeyValue("staff_id");
		String PASSWORD = fUtil.getPropertykeyValue("staff_password");
  //fetch data from excel
		String DATE = eUtil.getExcelData("opening",1,15 );
		String MONTH = eUtil.getExcelData("opening",1,16 );
		String YEAR = eUtil.getExcelData("opening",1,17 );
        String CUST_ID = eUtil.getExcelData("custLogin",1,0 );
        String CUSTPassword = eUtil.getExcelData("custLogin",1,1 );
//creating object for pom
        HomePage hp = new HomePage(driver);
        StaffLoginPage slp = new StaffLoginPage(driver);
        InternetBankingRegFormPage ibrp = new InternetBankingRegFormPage(driver);
        AccountOpeningformPage aofp = new AccountOpeningformPage(driver);
        CustomerLoginPage clp = new CustomerLoginPage(driver);
        CustomerProfilePage cpp = new CustomerProfilePage(driver);

//mousehover on internetBtn
hp.mousehoverInternetBanking(driver, wUtil);
//click on register btn
hp.getRegisterBtn().click();
 
 //verify eBanking Reg_Form page displayed
 String eBank = driver.getCurrentUrl();
 Assert.assertTrue(eBank.contains("ebanking_reg_form.php"));

 //enter all details in eBanking form
 ibrp.enterDetails(eUtil.getMultipledata("DataProviderInternet"), driver);
 aofp.enterdob(DATE, MONTH, YEAR);
 ibrp.getSubmitBtn().click();
 
//get text from alert
String Registration = driver.switchTo().alert().getText();
System.out.println(Registration);
//verify that notification popup 
Assert.assertTrue(Registration.contains("Registration Successfull"));
Thread.sleep(2000);

//convert and fetch application no.
String CustomerId="";
for(int i=0;i<Registration.length();i++) {
	if(Character.isDigit(Registration.charAt(i))) {
		CustomerId=CustomerId+Registration.charAt(i);	
	}
}
System.out.println("Customer ID-- "+CustomerId);

//click on ok
driver.switchTo().alert().accept();

//click on home link
ibrp.getHomeLink().click();

hp.mousehoverInternetBanking(driver, wUtil);
hp.getLoginBtn().click();
clp.custLogin(CUST_ID, CUSTPassword);

//verify particular Customer page displayed

	cpp.verifyCustomerHomePage(driver, USERNAME);
	cpp.getLogoutBtn().click();
	
	//verify customer login page displayed
	   String custurl1 = driver.getCurrentUrl();
	   Assert.assertTrue(custurl1.contains("customer_login.php"));
	  
	}

}
