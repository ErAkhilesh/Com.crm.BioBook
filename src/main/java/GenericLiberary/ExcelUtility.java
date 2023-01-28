package GenericLiberary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class ExcelUtility extends JavaUtility {
	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String readDataFromExcel(String SheetName,int RowNo,int ColumnNo) throws Throwable, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);  
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value=cel.getStringCellValue();
		return value;

	}
	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param column
	 * @param data
	 * @throws Throwable
	 * 
	 */
	public void writeDataIntoExcel(String SheetName,int RowNo,int column,String data ) throws Throwable 
	{
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.createRow(RowNo);
		Cell cel = ro.createCell(column);
		cel.setCellValue(data);
		FileOutputStream fos= new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);
	}
	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getLastRowNO(String SheetName) throws Throwable, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		return count;

	}
	/**
	 * 
	 * @param sheetName
	 * @param keyCell
	 * @param valueCell
	 * @return 
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	//	public Map<String,String>(String sheetName,int keyCell,int valueCell) throws Throwable
	//	{
	//		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	//		Workbook wb = WorkbookFactory.create(fi);
	//		Sheet sh = wb.getSheet(sheetName);
	//		int count=sh.getLastRowNum();
	//		Map<String,String> map=new HashMap<String, String>();
	//		for(int i=0;i<count;i++)
	//		{
	//			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
	//			String value=sh.getRow(i).getCell(valueCell).getStringCellValue();
	//			
	//		}
	public  HashMap<String,String> list(WebDriver driver,String sheetName) throws Throwable {
		HashMap<String,String> map=new HashMap<String, String>();
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
			String key = wb.getSheet(sheetName).getRow(i).getCell(0).getStringCellValue();
			String value = wb.getSheet(sheetName).getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		//		for ( Entry<String, String> set:map.entrySet()) {
		//			driver.findElement(By.name(set.getKey())).clear();
		//			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());

		//}
		return map;
	}
	public  ArrayList<String> arraylist(WebDriver driver,String sheetName) throws Throwable {
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
			String value = wb.getSheet(sheetName).getRow(i).getCell(1).getStringCellValue();
			al.add(value);
		}
		return al;
	}

		public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
		{
			FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);	
			int lastRow=sh.getLastRowNum();
			System.out.println(lastRow);
			int lastCell=sh.getRow(0).getLastCellNum();
			System.out.println(lastCell);
			Object[][] obj = new Object[lastRow+2][lastCell];
				for(int i=0;i<=lastRow;i++)
				{
					for(int j=0;j<lastCell;j++)
					{
						obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
					}
				}
				
				
			
			return obj;
		}
}
