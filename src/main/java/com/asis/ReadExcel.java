package com.asis;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public ExcelData ReadExcel1(String SheetName, int rNum, int cNum) throws InterruptedException {
		String clientName = "";
		int from = 0; // Initialize with default value
		int to = 0;   // Initialize with default value

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\AsisKaur\\OneDrive - The Outsource Pro\\DataATO.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(SheetName);
			if (s == null) {
				System.out.println("Sheet with name " + SheetName + " does not exist.");
			}
			Row r = s.getRow(rNum);
			Cell c = r.getCell(cNum);
			if (c.getCellType() == CellType.NUMERIC) {
				from = (int) c.getNumericCellValue();

				to = (int) c.getNumericCellValue();
			} else {
				clientName = c.getStringCellValue();
			}
			// Similarly, read 'From' and 'To' values
		} catch (Exception e) {
			System.out.println("Exception while accessing Excel file");
			e.printStackTrace();
		}

		return new ExcelData(clientName, from, to);
	}
}

class ExcelData {
	public String clientName;
	public int from;
	public int to;

	public ExcelData(String clientName, int from, int to) {
		this.clientName = clientName;
		this.from = from;
		this.to = to;
	}

	public String getClientName() {
		return clientName;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
