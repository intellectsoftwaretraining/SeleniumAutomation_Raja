package common;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	public String TestID =null;
	public String TestName =null;
	public String TestDesc =null;
	public String TestData =null;

	public String SheetName = "BPTravelData";

	public void getData(String TestcaseID) 
	{
		try {
			File file = new File("./src/test/resources/Excel.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(SheetName);

			for(int i = 1; i<=sh.getLastRowNum();i++)
			{
				TestID = sh.getRow(i).getCell(0).getStringCellValue();
				
				if(TestcaseID.equals(TestID))
				{
				TestName= sh.getRow(i).getCell(1).getStringCellValue();
				TestDesc= sh.getRow(i).getCell(2).getStringCellValue();
				TestData= sh.getRow(i).getCell(3).getStringCellValue();
				break;
				}
				
				//UserName=admin#Password=admin#expectedTitle=BP Travel - Search#Form=Chennai#child=2
			}
			ExtentReport.setTestCaseName(TestName, TestDesc);
			splitDataAndAddToMap(TestData);

		}
		catch (Exception e) {
			System.out.println("Exception occured please check");
		}
	}
	
	public void splitDataAndAddToMap(String Data) 
	{
		for(int i = 0; i<Data.split("#").length;i++)
		{
			String Keyvalue = Data.split("#")[i]; //UserName=admin
			String key = Keyvalue.split("=")[0];
			String value = Keyvalue.split("=")[1];
			SeleniumGenerics.map.put(key, value);
		}
		
		PrintUtils.logMsg("Test Data is ::"+SeleniumGenerics.map.entrySet());
	}
	
}
