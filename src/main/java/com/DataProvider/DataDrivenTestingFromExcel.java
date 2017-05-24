package com.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.Utils.ExcelLibrary;

public class DataDrivenTestingFromExcel {
	@DataProvider(name="excelSheetDataRead",parallel = true)
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		String path=file.getPath();
		ExcelLibrary excel =  new ExcelLibrary(path);
		Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(path);
		return data;
	}
	/*
	@DataProvider(name="singleExcelMultipleSheets",parallel = true)
	public static Object[][] singleExcelMultipleSheets(Method methodName,ITestContext context) throws Exception{
		File file = new File("resources/"+context.getCurrentXmlTest().getParameter("Product Name")+"TestData.xlsx");
		ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath(),methodName.getName());
		 Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}*/
}
