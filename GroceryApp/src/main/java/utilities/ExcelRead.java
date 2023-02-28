package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {

	public String readFromExcelFile(int i, int j) throws IOException {
		String excelFilePathString = System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelRead\\Read.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePathString);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(j);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			String data = cell.getStringCellValue();
			System.out.print(data);
			return data;

		case NUMERIC:
			double data1 = cell.getNumericCellValue();
			System.out.print(data1);
			return String.valueOf(data1);
		default:
			return null;
		}

	}

}
