package vTEST.WMS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	
	/*
	
	
	
	@org.testng.annotations.Test(dataProvider="dataProvider")
	public void Test(String data) {
		
		//System.out.println("I am Test Method");
		System.out.println(data);
	}
	@DataProvider
	public Object[][] dataProvider() throws Exception {
		Object[][] data=new Object[4][2];
		File f =new File(System.getProperty("user.dir")+"\\TestData.xlsx"); 
		FileInputStream fis=new FileInputStream(f);  
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		 for (int i=0;i<4;i++) {
			 
			 for(int j=0;j<2;j++) {
			
			 data[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			 
			 }
			}
		 return data;
        
	}
	
	
	
	*/
	@org.testng.annotations.Test(dataProvider="ExcelData")
	public void Test(String Item,String Location,String QTY) {
		
		System.out.println(Item);
		System.out.println(Location);
		System.out.println(QTY);
	}
	
	
	@DataProvider
	public static Object[][] ExcelData() throws Exception {
				
		File f= new File (System.getProperty("user.dir")+"\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet5");
		//String dataa = sh.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(dataa);
		//String data = sh.getRow(2).getCell(2).getStringCellValue();
		//System.out.println(data);
		
		Object[][] objArr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++) {
			
			 
			XSSFRow Row=sh.getRow(i);
			
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++) {
				
				XSSFCell colmn=Row.getCell(j);
				//System.out.print(String.valueOf(colmn)+ "\t");
				objArr[i][j]=sh.getRow(i).getCell(j).toString();
				//System.out.print(objArr[i][j] + "\t");
				
			}
			//System.out.println("\t");
		}
		return objArr;
	}
	
}		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

