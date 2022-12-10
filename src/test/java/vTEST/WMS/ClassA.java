package vTEST.WMS;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ClassA extends TestBase3 {
	

	
	@Test
	public void Test1(){
		
		System.out.println("Test1 form Class A");
		
		Assert.assertTrue(false);
		
		
	}
	@Test
	public void Test2(){
		
		System.out.println("Test2 form Class A");
		Assert.assertTrue(true);
	}
	
	@Test
	public void Test3(){
		
		System.out.println("Test3 form Class A");
		Assert.assertTrue(false);
	}
	@Test
	public void Test4(){
		Assert.assertTrue(false);
	}
	

}
