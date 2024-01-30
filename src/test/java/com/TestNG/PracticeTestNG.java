package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@Test
	public void createTest()
	{
		System.out.println("--creating--");
	}
	
	@Test
	public void editTest()
	{
		System.out.println("--edit--");
	}
	
	
	@Test(dependsOnMethods ="editTest")
	public void deleteTest()
	{
		System.out.println("--delete--");
	}
}
