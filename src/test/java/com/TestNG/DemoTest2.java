package com.TestNG;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class DemoTest2 extends BaseClass{
	
	@Test
	public void runFourthTest()
	{
		System.out.println("<----4th--->");
	}
	
	@Test
	public void runFifthTest()
	{
		System.out.println("<----5th--->");
	}

}
