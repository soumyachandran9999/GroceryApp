package dataProvider;

import org.testng.annotations.DataProvider;

import utilities.ExcelRead;

public class DataProviderByExcel {
	static ExcelRead excel;
	@DataProvider(name="create_user_data")
	public static Object[][] DataSet(String filepath, String sheetName ){
		try {
			excel=new ExcelRead();
			Object[][] arrayObjects=excel.getExcelData(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelRead"+filepath, sheetName);
					
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
