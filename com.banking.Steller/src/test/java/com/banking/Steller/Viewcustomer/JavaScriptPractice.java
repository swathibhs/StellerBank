package com.banking.Steller.Viewcustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import steller.Utilities.JavaScriptUtility;

public class JavaScriptPractice {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        
        JavaScriptUtility js = new JavaScriptUtility(driver);
        //launch application
        js.launchApplication("https://docs.phptravels.com");
        
        //get url of the current page
        String url=js.getUrlofCurrentPage();
        System.out.println(url);
        
        //get title of the current page
        String title=js.getTitleofCurrentpage();
        System.out.println(title);
        
        //scrolldown
        js.scrollDown();
        Thread.sleep(3000);
        
        //scrollUp
        js.scrollUp();
        
        //scrolltillElement //scrollBar1(click on api Response error links)
        //WebElement element=driver.findElement(null)
      
	}

}
