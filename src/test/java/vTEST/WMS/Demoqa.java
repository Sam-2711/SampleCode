package vTEST.WMS;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demoqa extends TestBase4{
	
	@Test(priority=1)
	public void Test1() throws Exception {
		
		driver.get("https://demoqa.com/text-box");
		
		driver.findElement(By.xpath("//*[@type='text' and @placeholder='Full Name']")).sendKeys("Samadhan");
		driver.findElement(By.xpath("//*[@type='email' and @placeholder='name@example.com']")).sendKeys("smart.samadhan@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"CurrentAddress\"]")).click();
			
		
	}
	
	@Test(priority=2)
	public void Test2() throws Exception {
		
		//driver.get("https://demoqa.com/text-box");
		
		
			
		Assert.assertEquals("sam", "sam");
	}
	}
	


