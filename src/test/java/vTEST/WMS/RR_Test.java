package vTEST.WMS;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RR_Test extends TestBase4 {
	
	RR_Page RRObj=new RR_Page();
	
	@Test(priority=1)
	public void loginWMS() {
		RRObj.WMSLogin(driver);
		Assert.assertEquals("Testing System", driver.getTitle());
	}
	
	@Test(priority=2)
	public void selectReceive() throws Exception {
		RRObj.navigate_to_RR(driver);
		
		String pagesrce=driver.getPageSource();
		String txt_to_chck="Receiving, Returns, & Putaway";
		boolean chck_for_text=pagesrce.contains(txt_to_chck);
		//System.out.println(chck_for_text);
		Assert.assertTrue(chck_for_text);
	}
	
	@Test(priority=3)
	public void ReceiveStock() throws Exception {
		
		RRObj.Receive_New_Stock(driver);
		
		
		
	}
	
	
	
	
	
	

}
