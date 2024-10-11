package com.asis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class xeroexcel {
	// read excel
	// read data from specific sheet
	//return columns
	private static Workbook workbook;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	private static File file;

	private xeroexcel() {

	}

	public static void readExcel(String filePath, String fileName) {

		file = new File(filePath+"\\"+fileName); 
		//FileInputStream fin = null;


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

	public static String[] getUserLoginDetail(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		String[] cellValues = new String[2]; // Assuming you want to return two cell values

		cellValues[0] = sheet.getRow(1).getCell(0).getStringCellValue(); // Username
		cellValues[1] = sheet.getRow(1).getCell(1).getStringCellValue(); // Password

		return cellValues;
	}

	public static HashMap<String, String> getQuestAnsw( String sheetName) {
		HashMap<String, String> questAns = new HashMap<>();

		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for(int i = 1; i <= rowCount; i++) {			
			row = sheet.getRow(i);

			questAns.put("Security_qa1", row.getCell(2).getStringCellValue());
			questAns.put("Security_qa1_answer", row.getCell(3).getStringCellValue());
			questAns.put("Security_qs2", row.getCell(4).getStringCellValue());
			questAns.put("Security_qa2_answer", row.getCell(5).getStringCellValue());
			questAns.put("Security_qs3", row.getCell(6).getStringCellValue());
			questAns.put("Security_qa3_answer", row.getCell(7).getStringCellValue());
			questAns.put("From date", row.getCell(8).toString());
			questAns.put("To date", row.getCell(9).toString());
		}
		return questAns;		
	}
	public static void closeExcel() throws IOException {
		workbook.close();
	}
}
