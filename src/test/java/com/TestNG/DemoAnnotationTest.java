package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoAnnotationTest {

	@BeforeSuite
	public void openDBTest()
	{
		System.out.println("opening DB connection");
	}
	
	@BeforeMethod
	public void loginTest()
	{
		System.out.println("login");
	}
	
	
	@Test
	public void testScriptTest()
	{
		System.out.println("Test script class-2");
	}
	
	@AfterMethod
	public void logoutTest()
	{
		System.out.println("logout");
	}
	@AfterSuite
	public void closeDB()
	{
		System.out.println("close DB connection");
	}
}
