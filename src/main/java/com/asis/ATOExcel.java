package com.asis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ATOExcel {
//	public static void readExcel(String filePath) {
//        try {
//            FileInputStream file = new FileInputStream(new File(filePath));
//
//            // Create Workbook instance for XLS/XLSX file
//            Workbook workbook = WorkbookFactory.create(file);
//
//            // Get the first sheet from the workbook
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Iterate through each row in the sheet
//            for (Row row : sheet) {
//                // Iterate through each cell in the row
//                for (Cell cell : row) {
//                    // Print the cell value
//                    System.out.print(cell.toString() + "\t");
//                }
//                System.out.println(); // Move to the next line after printing each row
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        // Provide the path to your Excel file
//        String filePath = "C:\\Users\\AsisKaur\\OneDrive - The Outsource Pro\\DataATO.xlsx";
//
//        // Call the readExcel function with the file path
//        readExcel(filePath);
	public static final String FILE_PATH = "C:\\Users\\AsisKaur\\OneDrive - The Outsource Pro\\Desktop\\DataATO.xlsx";
    public static final String SHEET_NAME = "Xero";

    public static void readExcel() {
        try (FileInputStream file = new FileInputStream(new File(FILE_PATH));
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.out.println("Sheet not found: " + SHEET_NAME);
                return;
            }

            Map<String, Integer> columnMap = getColumnMap(sheet.getRow(0));

            for (Row row : sheet) {
                for (Map.Entry<String, Integer> entry : columnMap.entrySet()) {
                    String columnName = entry.getKey();
                    int columnIndex = entry.getValue();
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        System.out.print(columnName + ": " + "\t");
                        System.out.print(columnIndex + ": " + "\t");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> getColumnMap(Row headerRow) {
        Map<String, Integer> columnMap = new HashMap<>();
        for (Cell cell : headerRow) {
            columnMap.put(cell.toString(), cell.getColumnIndex());
        }
        return columnMap;
    }

    public static void main(String[] args) {
        readExcel();
    }
}
