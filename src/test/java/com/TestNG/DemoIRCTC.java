package com.TestNG;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class DemoIRCTC {
	
	@Test
	public void runTest() throws InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'BUSES')]")).click();
		Set<String> allwn = driver.getWindowHandles();
		for(String wn:allwn)
		{
			driver.switchTo().window(wn);
		}
		driver.findElement(By.id("departFrom")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.id("goingTo")).sendKeys("Mysore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Mysore']")).click();
		driver.findElement(By.id("departDate")).click();
		driver.findElement(By.xpath("//a[text()='29']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search Bus')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h4[text()='Departure Time']/../ul//li//label[contains(text(),'After 6 pm')]")).click();
		driver.findElement(By.xpath("//label[text()='SRS Travels']/ancestor::div[@class='top-search-result-card']//div//button[text()='Select Seat']")).click();
		driver.findElement(By.xpath("//span[contains(@title,'1U')]")).click();
	}

}
