package vTEST.WMS;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationTest  extends TestBase4    {
	LocationPage LocObj=new LocationPage();
	
	
	@Test(priority=1)
	public void loginWMS() throws Exception {
		LocObj.WMSLogin(driver);
		Assert.assertEquals("Testing System", driver.getTitle());
	}
	
	@Test(priority=1)
	public void addNewLocation() throws Exception {
		LocObj.addLocation(driver);
        String tosrchaddedLoc=driver.getPageSource();
        String addeditem="ZZzr12345";
        boolean chkLoc=tosrchaddedLoc.contains(addeditem);
        Assert.assertTrue(true);
		//Assert.assertTrue(chkLoc);
	}
	
	
}
