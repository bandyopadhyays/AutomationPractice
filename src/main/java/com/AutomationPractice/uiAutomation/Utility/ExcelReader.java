package com.AutomationPractice.uiAutomation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
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
	private static Cell cell;
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
			cell = row.getCell(colIndex);
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				//System.out.println(cellValue);
				if (cellValue.contains("E")) {
					String[] cellStringval = cellValue.split("E");
					
					return cellStringval[0].replace(".", "");
				} else if (cellValue.contains(".")){
					String[] cellStringval = cellValue.split("\\."); //regx
					return cellStringval[0];
				} else {
					return cellValue;
				}
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
			/**
			 * if (row.getCell(colIndex).getCellTypeEnum() == CellType.NUMERIC) { return
			 * String.valueOf(Integer.valueOf((int)
			 * row.getCell(colIndex).getNumericCellValue())); } else { return
			 * row.getCell(colIndex).getStringCellValue(); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//return colName;
	}

	private static CellType getCellTypeEnum() {
		return null;
	}

	/**
	 * public static void main(String[] args) {
	 * System.out.println(System.getProperty("user.dir"));
	 * System.out.println(getDataFromExcel("Registration_Data","Mobile_No",1)); }
	 **/

}
