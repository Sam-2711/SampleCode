package vTEST.WMS;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase2 {
	
//http://relevantcodes.com/automation-testing/extentreports/extentreports-for-selenium/#content
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public  ExtentHtmlReporter htmlReporter;
	private Logger log;
	@BeforeSuite
	public void Extentsetup() {
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/WMS_ExtentReport21.html", true);
		extent.addSystemInfo("Project", "WMS");
		extent.addSystemInfo("QA", "Sam");
		extent.addSystemInfo("Environment", "Test");
 
		
	}
	
	
	@BeforeClass
	public void setup() throws IOException, Exception
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		  driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		
	}

	/*public static String getSceenShot(WebDriver driver,String screenshotname) throws Exception {
		String dateName=new SimpleDateFormat("yyyymmddhhmmss").format(new  Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty(("user.dir")+"/failedTestScreenshot"+screenshotname+dateName+".png");
		File finaldestination=new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
		
	}*/
	
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception 
	      
	{          
		if (result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "TestCase passed name is"+result.getName());
			System.out.println("Test case is passed so, not capturing screen shot");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			
			test.log(LogStatus.FAIL, "TestCase failed name is"+result.getName());
			test.log(LogStatus.FAIL, "TestCase failed name is"+result.getThrowable());
			
		//	String screenshotpath=TestBase2.getSceenShot(driver, result.getName());
		//	logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
			try {
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				File f = ts.getScreenshotAs(OutputType.FILE);
				
				File actF = new File(System.getProperty("user.dir")+"\\"+result.getName()+".png");
				
				FileUtils.copyFile(f, actF);
			} catch (Exception e) {
				// TODO Auto-generated catch block				
			} 
		}
		else
		{
			System.out.println("Test case is skipped so, not capturing screen shot");
			test.log(LogStatus.SKIP, "TestCase skipped name is"+result.getName());
		}
		   
}
	@AfterClass
	public void TearDown() throws IOException
	{
		
		driver.quit();
		//extent.close();
	}
	
	@AfterSuite
public void CloseExrent() {
		
		extent.flush();	
		extent.close();
}
	
	
}
