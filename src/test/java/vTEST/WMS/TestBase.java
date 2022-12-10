package vTEST.WMS;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class TestBase {
	public WebDriver driver;
	@BeforeClass
	public void setup() throws IOException, Exception
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		  driver = new  ChromeDriver();	
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) 
	{
		if (result.getStatus()== ITestResult.SUCCESS)
		{
			System.out.println("Test case is passed so, not capturing screen shot");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
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
		}
		
}
	@AfterClass
	public void TearDown() throws IOException
	{
		 driver.quit();	
	}
	
	
	
	
	
	
	
	
	
	
}