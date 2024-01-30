package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
   
@Test(retryAnalyzer =genericUtilities.RetryImpclass.class)
public void run()
{
	Assert.assertEquals("A","B");
}
}
