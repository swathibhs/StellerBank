package com.banking.Steller.Viewcustomer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.banking.StellerObjectRepository.AccountOpeningformPage;
import com.banking.StellerObjectRepository.CustomerRegisterConformationPage;
import com.banking.StellerObjectRepository.HomePage;

import steller.Utilities.BaseClass;

public class OpenAccountTest extends BaseClass{

@Test(groups="smokeTest")
public void openaccound() throws Throwable {

//creating object for pom
HomePage hp = new HomePage(driver);
AccountOpeningformPage aofp = new AccountOpeningformPage(driver);
CustomerRegisterConformationPage crcp = new CustomerRegisterConformationPage(driver);

//click on open account
hp.getOpenAccBtn().click();

//verify customer register form page displayed
String custReg = driver.getCurrentUrl();
Assert.assertTrue(custReg.contains("customer_reg_form.php"));

//fetch data from excel
String DATE = eUtil.getExcelData("opening",1,15 );
String MONTH = eUtil.getExcelData("opening",1,16 );
String YEAR = eUtil.getExcelData("opening",1,17 );

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

}
}
