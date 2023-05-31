package steller.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Lokesh
 *
 */

public class JavaScriptUtility {
	
	JavascriptExecutor js;
	/**
	 * 
	 * @param driver
	 */
	
	public  JavaScriptUtility(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	/**
	 * this method is used to scrollUP
	 */
	
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0.-document.body.scrollHeight)");
	}
	/**
	 * this method is used to scroll till element
	 * @param element
	 */
	
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * this method is used to scrollDOWN 
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0.document.body.scrollHeight)");
	}
	/**
	 * this method is used to lanchApplication
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 *this method is used to SendKeys 
	 * @param element
	 * @param data
	 */
public void sendKeys(WebElement element,String data)
{
	js.executeScript("arguments[0].value=arguments[1]", element,data);
}
/**
 * this method is used to click on element
 * @param element
 */
public void click(WebElement element)
{
	js.executeScript("arguments[0].click", element);
}
/**
 * this method is used to click element by ID
 * @param elementID
 */
public void clickElementByID(String elementID)
{
	js.executeScript("document.getElementById('elementId).click()");
}
/**
 * this method is used to getText
 * @param element
 * @return
 */
public String getTheText(WebElement element)
{
	String textFieldValue=(String) js.executeScript("return arguments[0].value;", element);
	return textFieldValue;
}
/**
 *this method is used to getURL of current page 
 * @return
 */
public String getUrlofCurrentPage()
{
	String url=(String)js.executeScript("return window.location.href");
	return url;
}
/**
 * this method is used to get Title of current page
 * @return
 */
public String getTitleofCurrentpage()
{
	String title=(String)js.executeScript("return document.title");
	return title;
}





}
