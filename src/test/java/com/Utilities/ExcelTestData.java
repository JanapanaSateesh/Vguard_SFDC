package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelTestData {
	
	
	public String[][] getTestData(String sheetName) throws IOException {
		
		File excelFile = new File("./TestData/TestData.xlsx");
		FileInputStream fi = new FileInputStream(excelFile);
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows(); 
		int numberOfColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[numberOfRows-1][numberOfColumns];
		for(int i=0;i<numberOfRows-1;i++) {
			for(int j=0;j<numberOfColumns;j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j)); 
				  

			}
		}
		
		workbook.close();
		fi.close();
		
		return data;
	}

}
