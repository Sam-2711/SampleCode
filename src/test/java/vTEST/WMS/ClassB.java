package vTEST.WMS;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ClassB {
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void Extentsetup() {
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/WMS_ExtentReport2.html", true);
		extent.addSystemInfo("Project", "WMS");
		extent.addSystemInfo("QA", "Sam");
		extent.addSystemInfo("Environment", "Test");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}
	@AfterMethod
	public void getResult(ITestResult result) {
		
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		
		
		extent.endTest(test);
		
		
		
		
	}


	
	@Test
	public void Test1(){
		test=extent.startTest("Started");
		System.out.println("Test1 form Class B");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "TestFailed");
		
	}
	@Test
	public void Test2(){
		test=extent.startTest("Started");
		
		System.out.println("Test2 form Class B");
		
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Test Passed");
	}
	
	@Test
	public void Test3(){
		test=extent.startTest("Started");
		System.out.println("Test3 form Class B");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "TestFailed");
		
	}


}
