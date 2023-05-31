package com.banking.Steller.Viewcustomer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.StellerObjectRepository.AccountOpeningformPage;
import com.banking.StellerObjectRepository.CustomerRegisterConformationPage;
import com.banking.StellerObjectRepository.HomePage;
import com.banking.StellerObjectRepository.PendingCustomerPage;
import com.banking.StellerObjectRepository.StaffLoginPage;
import com.banking.StellerObjectRepository.StaffProfilePage;
import com.banking.StellerObjectRepository.ViewCustomerByAccNoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import steller.Utilities.BaseClass;
import steller.Utilities.ExcelUtility;
import steller.Utilities.FileUtility;
import steller.Utilities.JavaUtility;
import steller.Utilities.WebUtility;

public class ViewAccountTest extends BaseClass {
	@Test
	public void ViewCustByAccNo() throws Throwable{
	      //fetch data from Properties file
				String USERNAME = fUtil.getPropertykeyValue("staff_id");
				String PASSWORD = fUtil.getPropertykeyValue("staff_password");
				   //fetch data from excel
		        String DATE = eUtil.getExcelData("opening",1,15 );
		        String MONTH = eUtil.getExcelData("opening",1,16 );
		        String YEAR = eUtil.getExcelData("opening",1,17 );
			
		   //creating object for pom
				        HomePage hp = new HomePage(driver);
				        AccountOpeningformPage aofp = new AccountOpeningformPage(driver);
				        StaffLoginPage slp = new StaffLoginPage(driver);
				        StaffProfilePage spp = new StaffProfilePage(driver);
				        PendingCustomerPage pcp = new PendingCustomerPage(driver);
				        ViewCustomerByAccNoPage vcap = new ViewCustomerByAccNoPage(driver);
				    	CustomerRegisterConformationPage crcp = new CustomerRegisterConformationPage(driver);
						//click on open account
						hp.getOpenAccBtn().click();

						//verify customer register form page displayed
						String custReg = driver.getCurrentUrl();
						Assert.assertTrue(custReg.contains("customer_reg_form.php"));

						//enter  customer detail
						aofp.enterDetails(eUtil.getMultipledata("DataProvider"), driver,wUtil,jUtil);

						//enter dob
						aofp.enterdob(DATE, MONTH, YEAR);


						//click on submit btn
						aofp.getSubmitBtn().click();

						//verify customer register confirmation page
						String CustRegConf=driver.getCurrentUrl();
						Assert.assertTrue(CustRegConf.contains("cust_regfrm_confirm.php"));

						//click on confirm btn
						crcp.getConformBtn().click();

					
				     //get text from alert
				String text = driver.switchTo().alert().getText();
				System.out.println(text);
				Thread.sleep(2000);
				//convert and fetch application no.
				String ApplicationNo="";
				for(int i=0;i<text.length();i++) {
					if(Character.isDigit(text.charAt(i))) {
						ApplicationNo=ApplicationNo+text.charAt(i);
					}}
				System.out.println("application number-- "+ApplicationNo);

				//verify that notification popup 
				if(text.contains("Application submitted successfully")) {
				System.out.println("application succefully submitted");
				}
				//click on ok
				driver.switchTo().alert().accept();


				//verify home page is displayed
				String homeurl = driver.getCurrentUrl();
				Assert.assertTrue(homeurl.contains("Online_Banking_System/"));

				//click on staff login link
				hp.getStaffLoginLink().click();

				//verify staff login page displayed r not
				String logurl = driver.getCurrentUrl();
				Assert.assertTrue(logurl.contains("staff_login.php"));

				//enter staff id and password and click on login btn
				slp.staffLogin(USERNAME,PASSWORD);

				//verify staff Profile page displayed
				String prourl = driver.getCurrentUrl();
				Assert.assertTrue(prourl.contains("staff_profile.php"));

				//click on approve pending account
				spp.getApprovePendingAccBtn().click();

				//verify pending customer page displayed
				String pendurl = driver.getCurrentUrl();
				Assert.assertTrue(pendurl.contains("pending_customers.php"));

				//enter application number
				pcp.getApplicationNoTxtEdt().sendKeys(ApplicationNo);

				//click on search button
				pcp.getSearchBtn().click();

				//click on approve button
				pcp.getApproveBtn().click();

				//get text account no
				String accountText = driver.switchTo().alert().getText();
				System.out.println(accountText);
				Thread.sleep(3000);
				
				//verify  account created popup is displayed
				if(accountText.contains("Account Created Successfully")) {
				 System.out.println("account created popup is displayed");
				}
			
				
				//click on ok btn
				 driver.switchTo().alert().accept(); 
				 
				//convert and fetch application no.
					String AccountNo="";
					for(int i=0;i<accountText.length();i++) {
						if(Character.isDigit(accountText.charAt(i))) {
							AccountNo=AccountNo+accountText.charAt(i);
						}}
        	 
     //click on staff login link
        	 pcp.getStaffloginlink().click();
        	 
       //verify staff Profile page displayed
             String pro1url = driver.getCurrentUrl();
             Assert.assertTrue(pro1url.contains("staff_profile.php"));
             
        //click on view customer by a/c number
             spp.getVeiwCustAccNoBtn().click();
          
            //verify view customer account by a/c number page should be displayed
             String cust = driver.getCurrentUrl();
             Assert.assertTrue(cust.contains("view_customer_by_acc_no.php"));
           
        	 //enter account number
        	 vcap.getCustomerAccNo().click();
        	 vcap.getCustomerAccNo().sendKeys(AccountNo);
        	 Thread.sleep(2000);
 
             //click on submit btn
        	 vcap.getSubmitBtn().click();
             
 }

}
