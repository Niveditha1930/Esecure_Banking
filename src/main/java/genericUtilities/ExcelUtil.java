package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	/**
	 * This method is used to read data from excel file
	 * @param Sheet
	 * @param row
	 * @param cell
	 * @param Data
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String Sheet, int row, int cell,String Data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String Data1 = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		return Data1;
	}
	
	/**
	 * This method is used to get last row count
	 * @param Sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNum(String Sheet) throws EncryptedDocumentException, IOException
	{
	  FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	  int rowCount = wb.getSheet(Sheet).getLastRowNum();
	 //  return rowCount;
	return rowCount;
	 
	  }
	
	public int getLastCellNum(String sheetname,int rownum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetname).getRow(rownum);
		short cellCount = row.getLastCellNum();
		return cellCount;
		
	}
	
	/**
	 * This method is used to store the data into map
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public HashMap<String,String> hashMapData(String SheetName, int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(SheetName);
		  int rcount = sh.getLastRowNum();
		  
		  HashMap<String, String> map=new HashMap<String, String>();
		  
		  for(int i=0;i<=rcount;i++)
		  {
			  String key = sh.getRow(i).getCell(0).getStringCellValue();
			  String value = sh.getRow(i).getCell(cell).getStringCellValue();
			  map.put(key, value);
		  }
		  return map;
		
	}
	
	
	/**
	 * This method is used to write data into excel
	 * @param SheetName
	 * @param Row
	 * @param Cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String SheetName,int Row ,int Cell, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(SheetName);
		  Row row = sh.createRow(Row);
		  row.createCell(Cell).setCellValue(data);
		  
     FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
     wb.write(fout);
     
	}



public void setExcelData(String sheetname, String value, int rownum) throws EncryptedDocumentException, IOException
{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(sheetname);
		for(int i=1;true;i++) {
			
			try {
			 Row row = sh.getRow(rownum);
			 Cell cell = row.getCell(i);
			 if(cell==null) {
				 row.createCell(i).setCellValue(value);
				 break;
			 }

			
			}catch (Exception e) {
				
			}
			
			
		}
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}

}

