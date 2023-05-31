package steller.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Lokesh
 *
 */
public class WebUtility {
	/**
	 * this method used to maximize browser window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method used to minimize browser window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method wait until the page gets load
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.implicitWaitDuration));
	}
	/**
	 * this method will wait till element to be visible in the UI
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will wait till element to be click in the UI
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will wait until the alert to present in UI
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method waits until title to be visible in webpage
	 * @param driver
	 * @param title
	 */
	public void waitFORATitle(WebDriver driver,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method waits until url to be visible in webpage
	 * @param driver
	 * @param title
	 */
	public void waitFORAUrl(WebDriver driver,String url)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * this method will ignore if we get nosuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElemenyExc(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * this method used to select element in dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method used to select element in dropdown based on value
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this method used to select element in dropdown based on visibiltytext
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(String text,WebElement element)
	{
		Select select = new Select(element);
		select.selectByValue(text);
	}
	/**
	 * this method will fetch all the options present in the dropdown
	 * @param element
	 */
	public void getAllOptionFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement option:options)
		{
			String text=option.getText();
			System.out.println(text);
		}
	}
	/**
	 * this method is used to perform mousehover on element
	 * @param driver
	 * @param element
	 */
	public void mousehoverOnElement(WebDriver driver,WebElement element)
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform(); 
		}
		
		/**
		 * this method is used to perform right click action
		 * @param driver
		 * @param element
		 */
		public void rigthclickOnElement(WebDriver driver,WebElement element)
			{
				Actions action = new Actions(driver);
				action.contextClick(element).perform();
			}
		/**
		 * this method is used to perform double click action
		 * @param driver
		 * @param element
		 */
		public void doubleclickOnElement(WebDriver driver,WebElement element)
			{
				Actions action = new Actions(driver);
				action.doubleClick(element).perform();
			}
		/**
		 * this method used to switch frames based on index
		 * @param driver
		 * @param index
		 */
		public void switchFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
			
		}
		/**
		 * this method used to switch frames based on id
		 * @param driver
		 * @param index
		 */
		public void switchFrame(WebDriver driver,String id)
		{
			driver.switchTo().frame(id);
			
		}
		
		/**
		 * this method used to switch frames based on webelement
		 * @param driver
		 * @param index
		 */
		public void switchFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
			
		}
		/**
		 * this method is used to switch to main frame of a webpage
		 * @param driver
		 */
		public void switchToFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		/**
		 * this method is used to accept the alert popup
		 * @param driver
		 * @param text
		 */
		public void switchToAlertAndAccept(WebDriver driver,String text)
		{
			Alert alert = driver.switchTo().alert();
			//if(alert.getText().trim().equalsIgnoreCase(text.trim()))
			if(alert.getText().contains(text))
			{
				System.out.println("alert is present");
			}
			else {
				System.out.println("alert is not present");
		}
		alert.accept();
		}
		/**
		 * this method is used to dismiss the alert popup
		 * @param driver
		 * @param text
		 */
		public void switchToAlertAndDismiss(WebDriver driver,String text)
		{
			Alert alert = driver.switchTo().alert();
			if(alert.getText().trim().equalsIgnoreCase(text.trim()))
			{
				System.out.println("alert is present");
			}
			else {
				System.out.println("alert is not present");
		}
		alert.dismiss();
		}
		/**
		 * this method is used to handle fileUploadPopup
		 * @param element
		 * @param path
		 */
		public void fileUpload(WebElement element,String path)
		{
			element.sendKeys(path);
		}
		/**
		 * this method is used to provide user own polling time
		 * @param duration
		 * @param element
		 * @param pollingTime
		 */
		public void customWait(int duration,WebElement element,long pollingTime )
		{
			int count=0;
			while(count<duration)
			{
				try {
					element.click();
					break;}
				catch(Exception e) {
					try {Thread.sleep(pollingTime);
				}catch(InterruptedException e1) {
					e1.printStackTrace();
					}
				count++;
			}
		}}
		/**
		 * this method is used to get screenShots
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws IOException
		 */
public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException 
{
	 TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	 File scr = takesScreenshot.getScreenshotAs(OutputType.FILE);
	 LocalDateTime localDateTime = LocalDateTime.now();
	 
	 File dst = new File("./screenshots/"+screenShotName+""+localDateTime+".png");
	 FileUtils.copyFile(scr, dst);
	 return screenShotName;
}
/**
 * this method is used to switch to child window
 * @param driver
 * @param Title
 */
public void switchWindow(WebDriver driver,String Title)
{
	Set<String> set = driver.getWindowHandles();
	for(String wdw:set) {
		driver.switchTo().window(wdw);
		String text=driver.getTitle();
		if(text.contains(Title))
		{
			break;
		}
	}
}

	/**
	 * this method is used to switch to child window
	 * @param driver
	 * @param Title
	 */
	public void switchingWindow(WebDriver driver,String url)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
	      String wid=it.next();
			driver.switchTo().window(wid);
			String text=driver.getTitle();
			if(text.contains(url))
			{
				break;
			}
		}
		
	
}














}
		
		
		
		
		
		
		


