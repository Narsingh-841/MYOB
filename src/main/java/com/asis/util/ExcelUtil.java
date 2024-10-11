package com.asis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtil {
	// read excel
	// read data from specific sheet
	//return columns
	private static Workbook workbook;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	private static File file;
	
	private ExcelUtil() {
		
	}
	
	public static void readExcel(String filePath, String fileName) {
		
		file = new File(filePath+"\\"+fileName); 
		System.out.println("fileName "+fileName);
		String fileExtension = fileName.substring(fileName.indexOf("."));
		if(fileExtension.equals(".xlsx")) {
			try {
				workbook = new XSSFWorkbook(new FileInputStream(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(fileExtension.equals(".xls")) {
			try {
				workbook = new HSSFWorkbook(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public static String getUserLoginDetail( String sheetName) {
		sheet = workbook.getSheet(sheetName);
		return sheet.getRow(1).getCell(0).getStringCellValue();			
	}
	
	public static HashMap<String, String> getClientDetail( String sheetName) {
		//System.out.println(sheetName+ " "+ "ExcelUtil");
		HashMap<String, String> clientData = new HashMap<>();
		
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for(int i = 1; i <= rowCount; i++) {			
			row = sheet.getRow(i);			              
			clientData.put("client_name", row.getCell(0).toString());
			clientData.put("from_date", row.getCell(1).toString());
			clientData.put("to_date", row.getCell(2).toString());
			clientData.put("jul_quater", row.getCell(3).getStringCellValue());
			clientData.put("oct_quarter", row.getCell(4).getStringCellValue());
			clientData.put("jan_quarter", row.getCell(5).getStringCellValue());
			clientData.put("apr_quarter", row.getCell(6).getStringCellValue());			

		}
		return clientData;		
	}	

	public static void closeExcel() throws IOException {
		workbook.close();
	}
}
