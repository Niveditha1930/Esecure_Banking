package com.TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtil;

public class ReadingDatafromExcelUsingDataprovider {
	
	@DataProvider
	public String readDataTest() throws EncryptedDocumentException, IOException
	{
		ExcelUtil e=new ExcelUtil();
		String value = e.getExcelData("OpenAccount",0,1,"name");
		return value;
	}
	
	@Test(dataProvider ="readDataTest")
	public void readFromExcel(String name)
	{
		System.out.println("customer name: "+name);
	}
}
