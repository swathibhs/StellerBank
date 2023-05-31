package com.banking.Steller.Viewcustomer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Approveaccount {
	public static void main(String[] args) throws Throwable {
		//open chrome browser
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver = new ChromeDriver(option);
		        
		        //enter url
		        driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		        
		        //maximize window
		        driver.manage().window().maximize();
		        
		        //implicitwait for 10 seconds
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
		        //click on open account
		        driver.findElement(By.xpath("//li[.='Open Account']")).click();
		        
		        //enter name
		        driver.findElement(By.name("name")).sendKeys("test");
		        
		        //select gender
		        WebElement gender = driver.findElement(By.name("gender"));
		        Select s=new Select(gender);
		        s.selectByValue("Female");
		        
		        //enter phone no
		        driver.findElement(By.name("mobile")).sendKeys("9876543210");
		        
		        //enter email id
		        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
		        
		        //enter dob
		        WebElement date = driver.findElement(By.name("dob"));
		        date.click();
		        date.sendKeys("05");
		        date.sendKeys("08");
		        date.sendKeys("2000"); 
		        
		        //enter pan no
		        driver.findElement(By.name("pan_no")).sendKeys("pan123");
		        
		        //enter citizenship no
		        driver.findElement(By.name("citizenship")).sendKeys("123");
		        
		        //enter home 
		        driver.findElement(By.name("homeaddrs")).sendKeys("bangalore");
		        
		        //enter Office Address
		        driver.findElement(By.name("officeaddrs")).sendKeys("bangalore1");
		        
		        //enter state
		        WebElement state = driver.findElement(By.name("state"));
		        Select s1=new Select(state);
		        s1.selectByIndex(3);
		        
		        //enter s=city
		        WebElement city = driver.findElement(By.name("city"));
		        Select s2=new Select(city);
		        s2.selectByIndex(4);
		        
		        //enter pin code
		        driver.findElement(By.name("pin")).sendKeys("12345");
		        
		        //enter Area/Locality
		        driver.findElement(By.name("arealoc")).sendKeys("bangalore11");
		        
		        //enter nominee_name
		        driver.findElement(By.name("nominee_name")).sendKeys("test12");
		        
		        //enternominee_ac_no
		        driver.findElement(By.name("nominee_ac_no")).sendKeys("12345678");
		        
		        //enter a/c Type
		        WebElement Atype = driver.findElement(By.name("acctype"));
		        Select s3=new Select(Atype);
		        s3.selectByIndex(1);
		        
		        //click on submit btn
		        driver.findElement(By.name("submit")).click();
		        
		        //click on confirm btn
		        driver.findElement(By.name("cnfrm-submit")).click();  
		        
		    
		        //get text from alert
		        String application = driver.switchTo().alert().getText();
		        System.out.println(application);
		        Thread.sleep(2000);
		        
		        //verify that notification popup 
		        if(application.contains("Application submitted successfully")) {
		        	System.out.println("application succefully submitted");
		        }
		        else {
		        	System.out.println("application succefully not submitted");
		        }
		        
		        //click on ok
		        driver.switchTo().alert().accept();
		        
		        //convert and fetch application no.
		        String[] txt=application.split(" ");
		        String AppNo = txt[5].substring(0, 9);
		        System.out.println("application number-- " +AppNo);
		        
		        //verify home page is displayed
		        String homeurl = driver.getCurrentUrl();
		        if(homeurl.contains("Online_Banking_System/"))
		        {
		        	System.out.println("home page is displayed");
		        }
		        else {
		        	System.out.println("homepage not displayed");
		        }
		          
		        //click on staff login link
		        driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		        
		        //verify staff login page dispalyed r not
		        String logurl = driver.getCurrentUrl();
		        if(logurl.contains("staff_login.php"))
		        {
		        	System.out.println("staff login page is displayed");
		        }
		        else {
		        	System.out.println("staff login page not displayed");
		        }
		        //enter staff id and password
		        driver.findElement(By.name("staff_id")).sendKeys("210001");
		        driver.findElement(By.name("password")).sendKeys("password");
		        
		        //click on login btn
		        driver.findElement(By.name("staff_login-btn")).click();
		        
		        //verify staff Profile page displayed
		        String prourl = driver.getCurrentUrl();
		        if(prourl.contains("staff_profile.php"))
		        {
		        	System.out.println("staff Profile page is displayed");
		        }
		        else {
		        	System.out.println("staff Profile page not displayed");
		        }
		        
		        //click on approve pending account
		        driver.findElement(By.name("apprvac")).click();
		        
		        //verify pending customer page displayed
		        String pendurl = driver.getCurrentUrl();
		        if(pendurl.contains("pending_customers.php"))
		        {
		        	System.out.println("pending customer page is displayed");
		        }
		        else {
		        	System.out.println("pending customer page not displayed");
		        }
		        //enter application number
		        driver.findElement(By.name("application_no")).sendKeys(AppNo);
		        
		        //click on search button
		        driver.findElement(By.name("search_application")).click();
		        
		        //click on approve button
		        driver.findElement(By.name("approve_cust")).click();
		        
		        //get text account no
		         String account = driver.switchTo().alert().getText();
		         System.out.println(account);
		         Thread.sleep(3000);
		         
		         //verify  account created popup is displayed
		         if(account.contains("Account Created Successfully")) {
		        	 System.out.println("account created popup is displayed");
		         }
		         else {
		        	 System.out.println("account created popup is not displayed");
		         }
		        
		        	 //click on ok btn
		        	 driver.switchTo().alert().accept();
	}

}
