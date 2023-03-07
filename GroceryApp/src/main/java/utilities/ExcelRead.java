package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	XSSFSheet sheet;
	XSSFRow r;
	XSSFCell c;

	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			File excelfile = new File(fileName);
			FileInputStream file = new FileInputStream(excelfile);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int col = sheet.getRow(0).getLastCellNum();
			arrayExcelData = new String[rows - 1][col];
			for (int i = 0; i < rows - 1; i++) {
				for (int j = 0; j < col; j++) {
					c = sheet.getRow(i + 1).getCell(j);
					DataFormatter dataFormatter = new DataFormatter();
					arrayExcelData[i][j] = dataFormatter.formatCellValue(c);
				}
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public String readFromExcelFile(int i, int j) {
		String excelFilePathString = System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelRead\\Read.xlsx";
		FileInputStream inputStream;
		String data = null;
		try {
			inputStream = new FileInputStream(excelFilePathString);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(j);
			CellType type = cell.getCellType();

			switch (type) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				double data1 = cell.getNumericCellValue();
				data = String.valueOf(data1);
				break;
			default:
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
