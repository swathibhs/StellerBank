package com.banking.Steller.Viewcustomer;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.StellerObjectRepository.AddBeneficiarypage;
import com.banking.StellerObjectRepository.CreditCustomerAccPage;
import com.banking.StellerObjectRepository.CustomerLoginPage;
import com.banking.StellerObjectRepository.CustomerProfilePage;
import com.banking.StellerObjectRepository.DeleteBenPage;
import com.banking.StellerObjectRepository.FundTransferPage;
import com.banking.StellerObjectRepository.HomePage;
import com.banking.StellerObjectRepository.StaffLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import steller.Utilities.BaseClass;
import steller.Utilities.ExcelUtility;
import steller.Utilities.FileUtility;
import steller.Utilities.JavaUtility;
import steller.Utilities.WebUtility;

public class CreditcustomerTest extends BaseClass{
	@Test
	public void creditCustomer() throws IOException, InterruptedException {
				
			//fetch data from Properties file
				String USERNAME = fUtil.getPropertykeyValue("staff_id");
				String PASSWORD = fUtil.getPropertykeyValue("staff_password");
		  //fetch data from excel
		        String CustomerACCNO = eUtil.getExcelData("credit",1,0 );
		        String AMOUNT = eUtil.getExcelData("credit",1,1 );
		        String CUST_ID = eUtil.getExcelData("custLogin",1,0 );
		        String CUSTPassword = eUtil.getExcelData("custLogin",1,1 );
		
		   //creating object for pom
				  HomePage hp = new HomePage(driver);
				  StaffLoginPage slp = new StaffLoginPage(driver);
				  CreditCustomerAccPage ccap = new CreditCustomerAccPage(driver);
				  CustomerLoginPage clp = new CustomerLoginPage(driver);
				  CustomerProfilePage cpp = new CustomerProfilePage(driver);
		        
		     //click on staff login link
				      hp.getStaffLoginLink().click();
		        
		        
		        //verify staff login page displayed
		        String logurl = driver.getCurrentUrl();
		        Assert.assertTrue(logurl.contains("staff_login.php"));
		      
		        //enter staff id and password and click on login btn
		        slp.staffLogin(USERNAME,PASSWORD);
		        
		        //verify staff Profile page displayed
		        String prourl = driver.getCurrentUrl();
		        Assert.assertTrue(prourl.contains("staff_profile.php"));
		       
		        //click on credit customer button
		        hp.getCreditBtn().click();
		     
		        
		      //verify credit customer page displayed
		        String credurl = driver.getCurrentUrl();
		        Assert.assertTrue(credurl.contains("credit_customer_ac.php"));
		       
		        //enter customer a/c number and amount 
		        	ccap.creditCustomer(CustomerACCNO,AMOUNT);
	
		        String creditpopup = driver.switchTo().alert().getText();
		        System.out.println(creditpopup);
		        Thread.sleep(3000);
		       
		       //verify credit popup
		       if(creditpopup.contains("Amount credited Successfully to customer account")) {
		    	   System.out.println("Amount credit popup displayed");
		       }
		       else {System.out.println("Amount credit popup not displayed");
		       }
		       
		       driver.switchTo().alert().accept();
		       Thread.sleep(3000);
		       
		       //click on logout
		       ccap.getLogOutBtn().click();
		     
		       
		        //verify staff login page displayed
		        String slogurl = driver.getCurrentUrl();
		        Assert.assertTrue(slogurl.contains("staff_login.php"));
		       
		        //click on home link
		        slp.getHomeLink().click();
		      
		        //verify home page displayed
		        String homedurl = driver.getCurrentUrl();
		        Assert.assertTrue(homedurl.contains("index.php"));
		    
		      //mousehover and click on login
		        hp.mousehoverInternetBanking(driver, wUtil);
		        hp.getLoginBtn().click();
		        clp.custLogin(CUST_ID, CUSTPassword);
		        	
		        	//verify particular Customer page displayed
		      //  cpp.verifyCustomerHomePage(driver, USERNAME);
		        	
		        	//click on statement to check all transaction
		        	cpp.getStatementLnk().click();

		       }}
	


