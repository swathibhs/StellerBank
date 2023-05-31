package steller.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * this method used to insert data into excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	
	public void insertDataIntoExcel(String SheetName,int rowNum,int cellNum,String data) throws IOException 
	{
		FileInputStream FileInputStream = new FileInputStream(IPathConstants.excelPath);
		 Workbook workbook = WorkbookFactory.create(FileInputStream);
		 Sheet sheet = workbook.getSheet(SheetName);
		 Row row = sheet.createRow(rowNum);
		 Cell cell = row.createCell(cellNum);
		 cell.setCellValue(data);
		 FileOutputStream fileOutputStream = new FileOutputStream(IPathConstants.excelPath);
		 workbook.write(fileOutputStream);
		 workbook.close();
		 }
	/**
	 * this method is used to fetch data from excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public String getExcelData(String SheetName,int rowNum,int cellNum) throws IOException 
	{
		FileInputStream FileInputStream = new FileInputStream(IPathConstants.excelPath);
		 Workbook workbook = WorkbookFactory.create(FileInputStream);
		 Sheet sheet = workbook.getSheet(SheetName);
		 Row row = sheet.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		 DataFormatter dataFormatter = new DataFormatter();String data=dataFormatter.formatCellValue(cell);
		 return data;
	}
	public int getRowNumber(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream FileInputStream = new FileInputStream(IPathConstants.excelPath);
		 Workbook workbook = WorkbookFactory.create(FileInputStream);
		 Sheet sheet = workbook.getSheet(SheetName);	
		 int row=sheet.getLastRowNum();
		 return row;
		 }
		/*
		 * this method used to fetch data from excel using map 
		 */
	public HashMap<String,String> getMultipledata(String Sheetname) throws Throwable, IOException {
		FileInputStream fin = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0;i<=count;i++) {
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		}
		return map;
	}
	

}
