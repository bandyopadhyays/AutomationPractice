package com.AutomationPractice.uiAutomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static File f;
	private static FileInputStream fis;
	private static Workbook wb;
	private static Row row;

	private static Sheet sheet;

	static {
		f = new File(System.getProperty("user.dir") + "/src/test/resources/test_data/TestData.xlsx");
		try {
			fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataFromExcel(String sheetName, String colName, int rowIndex) {
		try {
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(0);
			int colIndex = 0;
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colIndex = i;
				}
			}

			row = sheet.getRow(rowIndex);
			if (row.getCell(colIndex).getCellTypeEnum() == CellType.NUMERIC) {
				return String.valueOf(Integer.valueOf((int) row.getCell(colIndex).getNumericCellValue()));
			} else {
				return row.getCell(colIndex).getStringCellValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * public static void main(String[] args) {
	 * System.out.println(System.getProperty("user.dir"));
	 * System.out.println(getDataFromExcel("Login_Data","UserID",1)); }
	 **/

}
