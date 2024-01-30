package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
	
	
	@DataProvider
	public Object[][] dataprovider_bookTicketsTest()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		
		obj[1][0]="Goa";
		obj[1][1]="Delhi";
		
		obj[2][0]="mumbai";
		obj[2][1]="Bangalore";
		
		return obj;
	}
	
	@Test(dataProvider  ="dataprovider_bookTicketsTest")
	public void bookTicketsTest(String src,String des )
	{
		System.out.println(" Source  "+src+ " Destination  " +des);
	}

}
