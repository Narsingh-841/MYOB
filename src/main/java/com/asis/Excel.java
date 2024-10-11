package com.asis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.asis.util.BaseClass;



public class Excel {

	public Workbook wb;
	public  Sheet sheet1;
	public  Sheet sheet2;
	public int start_row = 0;
	public int start_col = 0;
	public final int total_col = 14;
	public String[][] col_data = { 
			{ "BAS SUMMARY" },
			{ "Basis:", "Cash" },
			{ "Monthly/", "Income ", "Income", "GST", "Capital", "Purchases ", "GST", "GST", "Wages ", "PAYG", "PAYG ",
				"Fuel", "ATO Total", "ATO Report" },
			{ "Quarterly", "inc GST", "GST Free", "Received", "inc GST", "inc GST", "Paid", "Payment", "XXX",
					"W/holding", "Instalment", "Credit", "Payment" },
			{ "", "(G1)", "(G3)", "(1A)", "(G10)", "(G11)", "(1B)", "Refund", "(W1)", "(4)", "(5A)", "(7D)",
			"Refund" } 
	};
	
	

	public ArrayList<String[]> col_data2 = new ArrayList<>();




	public ArrayList<ArrayList<QuaterData>> local_row_data = new ArrayList<>();
	public void print_rowdata() {
		int rowNo = 0;
		for(ArrayList<QuaterData> row : local_row_data) {
			System.out.println(" ROw No "+rowNo);
			rowNo++;
		}
	}
	public void createTest1() {

		Map<Integer, List<String>> tableData = new HashMap<>();

		for (int i = 0; i<col_data.length;i++) { 
			tableData.put(i, new ArrayList<String>(Arrays.asList(col_data[i]))); 
		}

		wb = new HSSFWorkbook(); 
		sheet1 = wb.createSheet("Financial Summary");

		//printing header section
		for(Entry<Integer, List<String>> entry: tableData.entrySet()) { 
			start_row =entry.getKey(); 
			Row row = sheet1.createRow(start_row);

			int col_start = 0; 
			for (String col : entry.getValue()) { 
				Cell cell = row.createCell(col_start);
				cell.setCellValue(col); 
				col_start = col_start+1;
			} 
			while(col_start < total_col) 
			{ 
				Cell cell =  row.createCell(col_start);
				cell.setCellValue(""); 
				col_start = col_start+1; 
			}
		}
		// printing middle section
		for (ArrayList<QuaterData> row : local_row_data) {
			start_row++;
			int col_start = 0;
			Row new_row = sheet1.createRow(start_row);
			for(QuaterData r : row) {

				Cell cell = new_row.createCell(col_start);
				cell.setCellValue(r.getQuarter_name()); 
				col_start =col_start+1;
				Cell cell1 = new_row.createCell(col_start);
				cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				Cell cell2 = new_row.createCell(col_start);
				cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				Cell cell3 = new_row.createCell(col_start);
				cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				Cell cell4 = new_row.createCell(col_start);
				cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				Cell cell5 = new_row.createCell(col_start);
				cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				Cell cell6 = new_row.createCell(col_start);
				cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				Cell cell7 = new_row.createCell(col_start);
				cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				Cell cell8 = new_row.createCell(col_start);
				cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				Cell cell9 = new_row.createCell(col_start);
				cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				Cell cell10 = new_row.createCell(col_start);
				cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				Cell cell11 = new_row.createCell(col_start);
				cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				Cell cell12 = new_row.createCell(col_start);
				cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				Cell cell13 = new_row.createCell(col_start);
				cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}


		FileOutputStream fileOut; 
		try {
			fileOut = new FileOutputStream("wb.xls");
			wb.write(fileOut); 
			fileOut.close(); 
			wb.close(); 
		} catch(FileNotFoundException e) {// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public void createBASSummary(ArrayList<ArrayList<QuaterData>> ato_row_data,
			ArrayList<ArrayList<QuaterData>> p_XERO_DATA, Sheet sheetName
			) {

		Map<Integer, List<String>> tableData = new HashMap<>();
		for (int i = 0; i<col_data2.size();i++) { 
			tableData.put(i, new ArrayList<String>(Arrays.asList(col_data2.get(i)))); 
		}
		//printing header section

		for(Entry<Integer, List<String>> entry: tableData.entrySet()) { 
			start_row =entry.getKey(); 
			Row row = sheet1.createRow(start_row);

			int col_start = 0; 
			for (String col : entry.getValue()) { 
				Cell cell = row.createCell(col_start);
				cell.setCellValue(col); 
				col_start = col_start+1; 
			} 
			while(col_start < total_col) 
			{ 
				Cell cell =  row.createCell(col_start);
				cell.setCellValue(""); 
				col_start = col_start+1; 
			}
		}
		// printing middle section
		for (ArrayList<QuaterData> row : ato_row_data) {
			start_row++;
			int col_start = 0;
			Row new_row = sheetName.createRow(start_row);
			for(QuaterData r : row) {
				Cell cell = new_row.createCell(col_start);
				cell.setCellValue(r.getQuarter_name()); 

				// Apply bold font to the cell
				CellStyle style = sheetName.getWorkbook().createCellStyle();
				Font font = sheetName.getWorkbook().createFont();
				font.setBold(true);
				style.setFont(font);
				cell.setCellStyle(style);
				col_start =col_start+1;
				Cell cell1 = new_row.createCell(col_start);
				cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				Cell cell2 = new_row.createCell(col_start);
				cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				Cell cell3 = new_row.createCell(col_start);
				cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				Cell cell4 = new_row.createCell(col_start);
				cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				Cell cell5 = new_row.createCell(col_start);
				cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				Cell cell6 = new_row.createCell(col_start);
				cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				Cell cell7 = new_row.createCell(col_start);
				cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				Cell cell8 = new_row.createCell(col_start);
				cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				Cell cell9 = new_row.createCell(col_start);
				cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				Cell cell10 = new_row.createCell(col_start);
				cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				Cell cell11 = new_row.createCell(col_start);
				cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				Cell cell12 = new_row.createCell(col_start);
				cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				Cell cell13 = new_row.createCell(col_start);
				cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}

		/*========== Start of total of each column section ===================================*/
		start_row++;	
		start_col = 0;		
		Row new_row = sheetName.createRow(start_row);

		Cell cell = new_row.createCell(start_col);
		cell.setCellValue("Total for the year");	
		// Apply bold font to the total cell
		CellStyle totalStyle = sheetName.getWorkbook().createCellStyle();
		Font totalFont = sheetName.getWorkbook().createFont();
		totalFont.setBold(true);
		totalStyle.setFont(totalFont);
		cell.setCellStyle(totalStyle);
		start_col =start_col+1; 

		Cell cell1 = new_row.createCell(start_col);
		cell1.setCellValue(QuaterData.getTotal_of_year_G1());		
		start_col =start_col+1; 

		Cell cell2 = new_row.createCell(start_col);
		cell2.setCellValue(QuaterData.getTotal_of_year_G3());		
		start_col =start_col+1; 

		Cell cell3 = new_row.createCell(start_col);
		cell3.setCellValue(QuaterData.getTotal_of_year_1A());		
		start_col =start_col+1; 

		Cell cell4 = new_row.createCell(start_col);
		cell4.setCellValue(QuaterData.getTotal_of_year_G10());		
		start_col =start_col+1; 

		Cell cell5 = new_row.createCell(start_col);
		cell5.setCellValue(QuaterData.getTotal_of_year_G11());		
		start_col =start_col+1; 

		Cell cell_1B = new_row.createCell(start_col);
		cell_1B.setCellValue(QuaterData.getTotal_of_year_1B());		
		start_col =start_col+1; 

		Cell cell6 = new_row.createCell(start_col);
		cell6.setCellValue(QuaterData.getTotal_of_year_GST_Refund());		
		start_col =start_col+1; 

		Cell cell7 = new_row.createCell(start_col);
		cell7.setCellValue(QuaterData.getTotal_of_year_W1());		
		start_col =start_col+1; 

		Cell cell8 = new_row.createCell(start_col);
		cell8.setCellValue(QuaterData.getTotal_of_year_4());		
		start_col =start_col+1; 

		Cell cell9 = new_row.createCell(start_col);
		cell9.setCellValue(QuaterData.getTotal_of_year_5A());		
		start_col =start_col+1; 

		Cell cell_10 = new_row.createCell(start_col);
		cell_10.setCellValue(QuaterData.getTotal_of_year_7D());		
		start_col =start_col+1; 

		Cell cell_11 = new_row.createCell(start_col);
		cell_11.setCellValue(QuaterData.getTotal_of_year_ATO_Total_Refund());		
		start_col =start_col+1; 

		Cell cell_12 = new_row.createCell(start_col);
		cell_12.setCellValue(QuaterData.getTotal_of_year_ATO_Reports());		
		start_col =start_col+1; 

		/*========== END of total of each column section ===================================*/

		/*=======================Start of EXRO DATA + Variance section ================================*/
		for (ArrayList<QuaterData> row : p_XERO_DATA) {
			start_row++;
			int col_start = 0;
			Row xero_row = sheetName.createRow(start_row);
			for(QuaterData r : row) {
				Cell xero_cell = xero_row.createCell(col_start);
				xero_cell.setCellValue(r.getQuarter_name()); 
				col_start =col_start+1;
				Cell xero_cell1 = xero_row.createCell(col_start);
				xero_cell1.setCellValue(r.get_G1()); 
				col_start =col_start+1; 
				Cell xero_cell2 = xero_row.createCell(col_start);
				xero_cell2.setCellValue(r.get_G3());
				col_start =col_start+1; 
				Cell xero_cell3 = xero_row.createCell(col_start);
				xero_cell3.setCellValue(r.get_1A());
				col_start =col_start+1; 
				Cell xero_cell4 = xero_row.createCell(col_start);
				xero_cell4.setCellValue(r.get_G10());	
				col_start =col_start+1; 
				Cell xero_cell5 = xero_row.createCell(col_start);
				xero_cell5.setCellValue(r.get_G11());
				col_start =col_start+1; 
				Cell xero_cell6 = xero_row.createCell(col_start);
				xero_cell6.setCellValue(r.get_1B());
				col_start =col_start+1; 
				Cell xero_cell7 = xero_row.createCell(col_start);
				xero_cell7.setCellValue(r.get_GST_Refund());
				col_start =col_start+1; 
				Cell xero_cell8 = xero_row.createCell(col_start);
				xero_cell8.setCellValue(r.get_W1());
				col_start =col_start+1; 
				Cell xero_cell9 = xero_row.createCell(col_start);
				xero_cell9.setCellValue(r.get_4());
				col_start =col_start+1; 
				Cell xero_cell10 = xero_row.createCell(col_start);
				xero_cell10.setCellValue(r.get_5A());
				col_start =col_start+1; 
				Cell xero_cell11 = xero_row.createCell(col_start);
				xero_cell11.setCellValue(r.get_7D());
				col_start =col_start+1; 
				Cell xero_cell12 = xero_row.createCell(col_start);
				xero_cell12.setCellValue(r.get_ATO_Total_Refund());
				col_start =col_start+1; 
				Cell xero_cell13 = xero_row.createCell(col_start);
				xero_cell13.setCellValue(r.get_ATO_Reports());
				col_start =col_start+1; 				
			}
		}
		/*=======================END of EXRO DATA + Variance section ================================*/

		/*====================Start of last section===================================*/
		start_row +=2;
		Row headRow = sheetName.createRow(start_row);

		// Create a cell style with bold font
		CellStyle boldGreenStyle = sheetName.getWorkbook().createCellStyle();
		Font boldFont = sheetName.getWorkbook().createFont();
		boldFont.setBold(true);
		boldGreenStyle.setFont(boldFont);
		boldGreenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		boldGreenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Cell headRowCol1 = headRow.createCell(0);
		headRowCol1.setCellValue("BAS not yet Paid/(Received)"); 
		headRowCol1.setCellStyle(boldGreenStyle);

		Cell headRowCol2 = headRow.createCell(1);
		headRowCol2.setCellValue("GST");
		headRowCol2.setCellStyle(boldGreenStyle); 
		for(HashMap<String, Double> entry : BaseClass.LAST_TABLE_DATA) {
			start_row++;

			int col_start = 0;
			Row xero_row = sheetName.createRow(start_row);
			for(String key: entry.keySet()) {
				Cell xero_key = xero_row.createCell(col_start);
				xero_key.setCellValue(key); 
				col_start =col_start+1;

				Cell xero_val = xero_row.createCell(col_start);
				xero_val.setCellValue(entry.get(key));
				col_start++;
			}
		}
		/*====================End of last section===================================*/
	}


	public void createFinancialSummaryExcelWithData(
			String fileName, 
			ArrayList<ArrayList<QuaterData>> ato_row_data,
			ArrayList<ArrayList<QuaterData>> p_XERO_DATA, 
			ArrayList<ArrayList<String>> activity_statement_data, 
			String[] client_data
			){
		String[] table_heading = {"BAS SUMMARY"};
		String[] client_name = {"Client:",client_data[0]};
		String[] client_year = {"Year:",client_data[1]};
		String[] basis = {"Basis:","Cash"};


		String[] tableHead1 = { "Monthly/", "Income ", "Income", "GST", "Capital", "Purchases ", "GST", "GST", "Wages ", "PAYG", "PAYG ",
				"Fuel", "ATO Total", "ATO " };
		String[] tableHead2 = { "Quarterly", "inc GST", "GST Free", "Received", "inc GST", "inc GST", "Paid", "Payment", "XXX",
				"W/holding", "Instalment", "Credit", "Payment" , "Report"};
		String[] tableHead3 = { "", "(G1)", "(G3)", "(1A)", "(G10)", "(G11)", "(1B)", "Refund", "(W1)", "(4)", "(5A)", "(7D)",
				"Refund" ,""} ;


		col_data2.add(table_heading);
		col_data2.add(client_name);
		col_data2.add(client_year);
		col_data2.add(basis);
		col_data2.add(tableHead1);
		col_data2.add(tableHead2);
		col_data2.add(tableHead3);

		wb = new HSSFWorkbook(); 
		sheet1 = wb.createSheet("BAS Summary");
		sheet2 = wb.createSheet("ICA Statement");

		createBASSummary(ato_row_data,p_XERO_DATA,sheet1);
		printICAStatementSheet(activity_statement_data,sheet2,client_data, sheet2);

		Font boldFont = wb.createFont();
		boldFont.setBold(true);
		CellStyle boldCenterStyle = wb.createCellStyle();
		boldCenterStyle.setAlignment(HorizontalAlignment.CENTER);
		boldCenterStyle.setFont(boldFont);


		boldCenterStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		boldCenterStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// Merge cells for the table heading
		sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));
		Row headingRow = sheet1.createRow(0);
		Cell headingCell = headingRow.createCell(0);
		headingCell.setCellStyle(boldCenterStyle);
		headingCell.setCellValue(table_heading[0]);

		// Write data to cells
		for (int i = 1; i < col_data2.size(); i++) {
		    Row row = sheet1.createRow(i);
		    for (int j = 0; j < col_data2.get(i).length; j++) {
		        Cell cell = row.createCell(j);
		        cell.setCellValue(col_data2.get(i)[j]);
		    }
		}
		// Create cell styles for table headers
		CellStyle tableHead1Style = wb.createCellStyle();
		CellStyle tableHead2Style = wb.createCellStyle();
		CellStyle tableHead3Style = wb.createCellStyle();

		for (int i = 0; i < 7; i++) {
			Row row = sheet1.createRow(i);
			for (int j = 0; j < col_data2.get(i).length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(col_data2.get(i)[j]);
				cell.setCellStyle(boldCenterStyle); // Apply bold and center alignment to heading cell

				// Apply border style to each cell
				CellStyle borderStyle = wb.createCellStyle();
				borderStyle.setBorderTop(BorderStyle.THIN);
				borderStyle.setBorderRight(BorderStyle.THIN);
				cell.setCellStyle(borderStyle);

				// If it's the last column and within the range, add right border
				if (j == col_data2.get(i).length - 1 && j <= 13) { // Ensure the last column is within range (0 to 13)
					borderStyle.setBorderRight(BorderStyle.THIN);
				}
			}
		}
		for (int i = 7; i <= 23; i++) {
			Row row = sheet1.getRow(i); // Retrieve the existing row
			if (row == null) {
				row = sheet1.createRow(i); // If the row doesn't exist, create a new one
			}
			Cell cell = row.getCell(13); // Retrieve the existing cell in column N
			if (cell == null) {
				cell = row.createCell(13); // If the cell doesn't exist, create a new one
			}
			CellStyle borderStyle = wb.createCellStyle();
			//	            borderStyle.setBorderBottom(BorderStyle.THIN); // Apply border to the bottom side
			borderStyle.setBorderRight(BorderStyle.THIN);
			cell.setCellStyle(borderStyle); // Apply the border style to the existing cell
			if (i == 23) {
				for (int j = 0; j <= 13; j++) { // Iterate over each cell in the row (column indices from 0 to 13)
					cell = row.getCell(j); // Retrieve the cell at the current column index
					if (cell == null) {
						cell = row.createCell(j); // If the cell doesn't exist, create a new one
					}
					borderStyle = wb.createCellStyle();
					borderStyle.setBorderRight(BorderStyle.THIN);
					borderStyle.setBorderBottom(BorderStyle.THIN); // Apply the bottom border
					cell.setCellStyle(borderStyle); // Apply the border style to the cell
				}
			}
		}


		tableHead1Style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		tableHead1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// Apply border style to tableHead1 row
		Row tableHead1Row = sheet1.createRow(4);
		for (int j = 0; j < tableHead1.length; j++) {
			Cell cell = tableHead1Row.createCell(j);
			cell.setCellValue(tableHead1[j]);
			cell.setCellStyle(tableHead1Style);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
		}
		tableHead1Style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		tableHead1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// Apply border style to tableHead2 row
		Row tableHead2Row = sheet1.createRow(5);
		for (int j = 0; j < tableHead2.length; j++) {
			Cell cell = tableHead2Row.createCell(j);
			cell.setCellValue(tableHead2[j]);
			cell.setCellStyle(tableHead2Style);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
		}


		tableHead2Style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		tableHead2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		tableHead3Style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		tableHead3Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// Apply border style to tableHead3 row
		Row tableHead3Row = sheet1.createRow(6);
		for (int j = 0; j < tableHead3.length; j++) {
			Cell cell = tableHead3Row.createCell(j);
			cell.setCellValue(tableHead3[j]);
			cell.setCellStyle(tableHead3Style);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
		}
		CellStyle greenStyle = wb.createCellStyle();
		greenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// Apply border style to greenStyle
		greenStyle.setBorderBottom(BorderStyle.THIN);
		greenStyle.setBorderRight(BorderStyle.THIN);
		greenStyle.setBorderLeft(BorderStyle.THIN);
		greenStyle.setBorderTop(BorderStyle.THIN);

		// Apply the green style to cells in column H (index 7) and N (index 13) up to row 23
		for (int i = 7; i <= 23; i++) { // Rows 8 to 23
			Row row = sheet1.getRow(i); // Retrieve the existing row
			if (row == null) {
				row = sheet1.createRow(i); // If the row doesn't exist, create a new one
			}

			// Apply green style to cells in column H (index 7)
			Cell cellH = row.getCell(7); // Retrieve the cell in column H
			if (cellH == null) {
				cellH = row.createCell(7); // If the cell doesn't exist, create a new one
			}
			cellH.setCellStyle(greenStyle); // Apply the green style to the cell

			// Apply green style to cells in column N (index 13)
			Cell cellN = row.getCell(13); // Retrieve the cell in column N
			if (cellN == null) {
				cellN = row.createCell(13); // If the cell doesn't exist, create a new one
			}
			cellN.setCellStyle(greenStyle); // Apply the green style to the cell
		}
			Row row21 = sheet1.getRow(20); // Retrieve row 21 (index 20 because rows are 0-indexed)
			if (row21 == null) {
				row21 = sheet1.createRow(20); // If row 21 doesn't exist, create a new one
			}
			
			for (int i = 0; i < row21.getLastCellNum(); i++) {
				Cell cell = row21.getCell(i); // Retrieve each cell in row 21
				if (cell == null) {
					cell = row21.createCell(i); // If the cell doesn't exist, create a new one
				}
				cell.setCellStyle(greenStyle); // Apply the green style to the cell
			}
			Row row22 = sheet1.getRow(21); // Retrieve row 21 (index 20 because rows are 0-indexed)
			if (row22 == null) {
				row22 = sheet1.createRow(21); // If row 21 doesn't exist, create a new one
			}
			for (int i = 0; i < row22.getLastCellNum(); i++) {
				Cell cell = row22.getCell(i); // Retrieve each cell in row 21
				if (cell == null) {
					cell = row22.createCell(i); // If the cell doesn't exist, create a new one
				}
				cell.setCellStyle(greenStyle); // Apply the green style to the cell
			}

		FileOutputStream fileOut; 
		try {
			fileOut = new FileOutputStream(fileName);
			wb.write(fileOut); 
			fileOut.close(); 
			wb.close(); 
		} catch(FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	private void printICAStatementSheet(ArrayList<ArrayList<String>> activity_statement_data, Sheet ica_sheet, String[] client_data, Sheet sheetName) {
		// TODO Auto-generated method stub
		
		 Font boldFont = wb.createFont();
	        boldFont.setBold(true);
	        CellStyle boldCenterStyle = wb.createCellStyle();
	        boldCenterStyle.setAlignment(HorizontalAlignment.CENTER);
	        boldCenterStyle.setFont(boldFont);

	        // Fill color setup (light green)
	        CellStyle greenCellStyle = wb.createCellStyle();
	        greenCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        greenCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        greenCellStyle.setAlignment(HorizontalAlignment.CENTER);
	        greenCellStyle.setFont(boldFont);

	        int start_row = 0;
	        String[][] ica_col_data = {
	                {"Activity statement", "1"},
	                {client_data[0]},
	                {"Processed Date", "Effective Date", "Description", "Debit(DR)", "Credit(CR)", "Running Balance"}
	        };

	        // Loop through ica_col_data to create column headers
	        for (int i = 0; i < ica_col_data.length; i++) {
	            Row row = ica_sheet.createRow(start_row);
	            for (int j = 0; j < ica_col_data[i].length; j++) {
	                Cell cell = row.createCell(j);
	                cell.setCellValue(ica_col_data[i][j]);
	                // Apply bold style to all cells in the first two rows
	                if (i <= 2) {
	                    cell.setCellStyle(boldCenterStyle);
	                    cell.setCellStyle(greenCellStyle);
	                }
	                // Apply light green fill color to all cells in the third row
	            }
	            start_row++; // Increment start_row for the next iteration
	        }

	        // Populate activity statement data
	        for (ArrayList<String> row_data : activity_statement_data) {
	            Row row = ica_sheet.createRow(start_row++);
	            int col_start = 0;
	            for (String col_data : row_data) {
	                Cell cell = row.createCell(col_start++);
	                cell.setCellValue(col_data);
	            }
	        }
	        for (int i = 0; i < ica_col_data[0].length; i++) {
	            ica_sheet.autoSizeColumn(i);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel obj = new Excel();
		obj.createTest1();
	}
}

