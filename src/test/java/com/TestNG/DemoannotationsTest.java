package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoannotationsTest {
	
	@BeforeSuite
	public void openConnectionTest()
	{
		System.out.println("---Open DB connection--");
	}
	
	@BeforeMethod
	public void againlogin1Test()
	{
		System.out.println("1nd before method--->login");
	}
	
	@BeforeClass
	public void openBrowserTest()
	{
		System.out.println("--opening the browse--");
	}
	
	@BeforeMethod
	public void againlogin2Test()
	{
		System.out.println("2nd before method--->login");
	}
	
	@BeforeMethod
	public void loginTest()
	{
		System.out.println("--Login--");
	}
	
	
	@Test
	public void testScriptTest()
	{
		System.out.println("Test script");
	}
	
	@AfterMethod
	public void logoutTest()
	{
		System.out.println("--logout--");
	}
	
	@AfterMethod
	
	public void logout1Test()
	{
		System.out.println("---logout1--");
	}
	
	@AfterClass
	public void closeBrowserTest()
	{
		System.out.println("--closing the browser--");
	}
	
	@AfterSuite
	public void closeDBTest()
	{
		System.out.println("--closing db connection--");
	}

}

