package vTEST.WMS;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemTest extends TestBase4 {
		
	
	ItemPage obj=new ItemPage();
	
	@Test(priority=1)
	public void loginWMS() throws Exception {
				obj.WMSLogin(driver);
		Assert.assertEquals("Testing System", driver.getTitle());
	}
	@Test(priority=2)
	public void navigatetoItems() throws Exception {
		obj.ItemsNavigation(driver);
		String pgesrce=driver.getPageSource();
		String txttocheck=("All Items");
		boolean textpresent=pgesrce.contains(txttocheck);
		Assert.assertTrue(textpresent);
	
		
	} 
	@Test(dataProvider="getItemCode",priority=3)
	public void add_New_Item(String ItemCode) throws Exception {
		obj.NewItem(driver,ItemCode);
		Assert.assertTrue(true);
	}
	@Test(dataProvider="getItemCode",priority=4)
	public void searchItem(String ItemCode) throws Exception {
		obj.ItemSearch(driver,ItemCode);
		String added_item=driver.getPageSource();
		String itemtosearch=ItemCode;
		
		boolean chckitemfoosearch=added_item.contains(itemtosearch);

		Assert.assertTrue(chckitemfoosearch);
	}
	
	
	@DataProvider
	public Object[][] getItemCode() throws Exception {
		
		Object[][] ItemCode=new Object[1][1];
		File f =new File(System.getProperty("user.dir")+"\\sama.xlsx"); 
		FileInputStream fis=new FileInputStream(f); 
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		ItemCode[0][0] = sh.getRow(55).getCell(0).getStringCellValue();
    
         return ItemCode;

	}


	
	
	

}
