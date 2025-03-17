package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConcept {

	
	public static void main(String[] args)   {
	
		try {
		File file = new File("./src/test/resources/Excel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("UserDetails");
		
		for(int i = 1; i<=sh.getLastRowNum();i++)
		{
		String name = sh.getRow(i).getCell(0).getStringCellValue();
		String password = sh.getRow(i).getCell(1).getStringCellValue();
		//double age = sh.getRow(i).getCell(2).getNumericCellValue();
		String age = sh.getRow(i).getCell(2).getStringCellValue();
		
		System.out.println(name);
		System.out.println(password);
		System.out.println(age);
		}
		
		}
		catch (FileNotFoundException e) {
			System.out.println("Plz check the file path");
		}
		catch (IOException e) {
			System.out.println("Plz check the file path");
		}
		
	}
}
