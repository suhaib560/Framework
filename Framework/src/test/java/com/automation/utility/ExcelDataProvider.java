package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	
	XSSFWorkbook wb;

	public ExcelDataProvider() throws FileNotFoundException
	{
		File src = new File("C:\\Users\\dell\\git\\Framework\\Framework\\TestData\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		try {
			  wb = new XSSFWorkbook(fis);
			 
		} catch (IOException e) {
			
			System.out.println("Unable to read excel"+e.getMessage());
		}
		
		
	}

	public String getStringData(String SheetName, int row, int column) 
	{
	return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int SheetIndex, int row, int column) 
	{
	return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName, int row, int column)
	{
	return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
