package vTEST.WMS;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQA1 extends TestBase4 {
	
	
	@Test(priority=1)
	public void Test3() throws Exception {
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Vtest");
		
			driver.findElement(By.xpath("//*[id=\"gb\"]/div/div[1]/div/div[1]/a")).click();
	}
	
	
	@Test(priority=2)
	public void Test4() throws Exception {
		
		
		
			
		Assert.assertEquals("sam", "sam");
	}
}
