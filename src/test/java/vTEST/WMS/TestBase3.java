package vTEST.WMS;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase3 {

	

	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	
	@BeforeSuite
	public void Extentsetup() {
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/WMS_ExtentReport26A3.html");
		htmlReporter.config().setDocumentTitle("WMS Testing");
		htmlReporter.config().setReportName("WMS Functional Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project", "WMS");
		extent.setSystemInfo("QA", "Sam");
		extent.setSystemInfo("Environment", "Test");
		
	
	}
	
	
	@BeforeClass
	public void setup() throws IOException, Exception
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    test = extent.createTest(getClass().getSimpleName());
	}

	public static String getSceenShot(WebDriver driver,String screenshotname) throws Exception {
		String dateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty(("user.dir")+"/failedTestScreenshot"+screenshotname+dateName+".png");
		File finaldestination=new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
		
	}
	@BeforeMethod
	public void beforeMethod(Method method){
		//extent.createTest("Test Started");
		//test = extent.createTest(getClass().getSimpleName());
		test.log(Status.INFO, method.getName()+"**************test started***************");
		System.out.println("**************"+method.getName()+" Started***************");
		
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getName());
			test.log(Status.FAIL, result.getThrowable());
			
			String imagePath = TestBase3.getSceenShot(driver, result.getName());
			test.addScreenCaptureFromPath(imagePath);
			System.out.println(result.getName()+" is Fail");
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+" is pass");
			System.out.println(result.getName()+" is pass");
			
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, result.getName()+" is skipped");
			System.out.println(result.getName()+" is Skipped");
		}
		test.log(Status.INFO,result.getName()+"**************test Finished***************");
		System.out.println("**************"+result.getName()+"Finished***************");
		
	}

	@AfterClass
	public void TearDown() throws IOException
	{
		
		driver.close();
	}
	
	@AfterSuite
public void CloseExtent() {
		
		extent.flush();
		
		
}
	

}
