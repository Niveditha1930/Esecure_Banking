package com.TestNG;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class DemoTest extends BaseClass{
	
	@Test
	public void runFirstTest()
	{
		System.out.println("<----1st--->");
	}
	
	@Test
	public void runTwoTest()
	{
		System.out.println("<----2nd method--->");
	}
	
	@Test
	public void runThreeTest()
	{
		System.out.println("<----3rd method--->");
	}

}
