package steller.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//create object of generic utility
	public	ExcelUtility eUtil = new ExcelUtility();
	public	FileUtility fUtil = new FileUtility();
	public	JavaUtility jUtil = new JavaUtility();
	public	WebUtility wUtil = new WebUtility();
	public	WebDriver driver;
	public static WebDriver Sdriver;
			
		
		@BeforeSuite(groups= {"smokeTest","RegTest"})
		public void cofig_BS()
		{
			System.out.println("--DataBase Connected succeffully--");
		}
		//@Parameters("BROWSER")
		@BeforeClass(groups= {"smokeTest","RegTest"})
		public void config_BC() throws IOException
		{
		String BROWSER = fUtil.getPropertykeyValue("browser");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
		        WebDriverManager.chromedriver().setup();
		         driver = new ChromeDriver(option);  Sdriver=driver;
			}
			else if(BROWSER.equalsIgnoreCase("edge")) {
				 WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
		        WebDriverManager.chromedriver().setup();
		         driver = new ChromeDriver(option);
		       
			}
			  Sdriver=driver;
			wUtil.maximizeWindow(driver);
		
		
		}
		@BeforeMethod(groups= {"smokeTest","RegTest"})
		public void config_BM() throws IOException
		{
			String URL=fUtil.getPropertykeyValue("url");
			driver.get(URL);
			wUtil.waitTillPageGetsLoad(driver);
		}
		@AfterMethod(groups= {"smokeTest","RegTest"})
		public void confif_AM()
		{
			System.out.println("AferMethod executed");
		}
		@AfterClass(groups= {"smokeTest","RegTest"})
		public void config_AC()
		{
			driver.quit();
		}
		
		@AfterSuite(groups= {"smokeTest","RegTest"})
		public void config_AS()
		{
			System.out.println("--Close DataBase connection--");
		}
		

}
