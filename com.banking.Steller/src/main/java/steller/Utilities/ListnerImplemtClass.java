package steller.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplemtClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		System.out.println("--I AM Listening--");
		
		 TakesScreenshot takesScreenshot = (TakesScreenshot)BaseClass.Sdriver;
		 File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		 LocalDateTime localDateTime = LocalDateTime.now();
		 String cDateTime = localDateTime.toString().replace(" ", "_").replace(":", "_");
		 File dst = new File("screenshots/"+" "+testName+" "+cDateTime+".png");
		 try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {

	}
	

}
