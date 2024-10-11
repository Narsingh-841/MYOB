package com.asis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class TestCreateExcel {
	public Workbook wb;
	public Sheet sheet1;
	
	private static void createCell(Cell cell, Workbook wb, HorizontalAlignment halign, VerticalAlignment valign) {
	    //Cell cell = row.createCell(column);
	    //cell.setCellValue("Align It");
	    CellStyle cellStyle = wb.createCellStyle();
	    cellStyle.setAlignment(halign);
	    cellStyle.setVerticalAlignment(valign);
	    cell.setCellStyle(cellStyle);
	}
	
	public void createTest() {
		Row row;
		wb = new HSSFWorkbook();  // or new XSSFWorkbook();
		sheet1 = wb.createSheet("BAS SUMMARY");
		// Create a row and put some cells in it. Rows are 0 based.
		int startRow = 0;
		int endRow = 3;
		
		int startColmn =0;
		int endCol = 6;
		
		for(int i = 0; i<endRow;i++ ) {
			row = sheet1.createRow(i);
			
			if(i == 0) { // for 0th row
				Cell cell = row.createCell(startColmn);
				cell.setCellValue("BAS SUMMARY");
				createCell(cell,wb, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
				sheet1.addMergedRegion(new CellRangeAddress(startRow,0,startColmn,6));
			}
			else if(i==1) {
				
		        Cell clientLabelCell = row.createCell(0);
		        clientLabelCell.setCellValue("Client:");
		        createCell(clientLabelCell, wb, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
			}
			else if(i==2) {
			        Cell yearLabelCell = row.createCell(0);
			        yearLabelCell.setCellValue("Year:");
			        createCell(yearLabelCell, wb, HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
			}
			else {
				for(int  j = 0; j < endCol; j++) {				
					
				}
			}			
		}
		
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("workbook.xls");
			wb.write(fileOut);
			 fileOut.close();
			 wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCreateExcel obj = new TestCreateExcel();
		obj.createTest();
		System.out.println("Done");
	}

}
