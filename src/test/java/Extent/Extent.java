package Extent;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Extent extends TestListenerAdapter {
	
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Started");
		
	}
public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Passed");
		
	}
public void onTestFailure(ITestResult result) {
	
	System.out.println("Test Failed");
	
}


public void onTestSkipped(ITestResult result) {
	
	System.out.println("Test Skipped");
	
}
}
