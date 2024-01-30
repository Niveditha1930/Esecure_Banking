package com.TestNG;

import java.time.Duration;
import java.util.Set;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoIR {
	
	@Test
	public void runTest() throws InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'BUSES')]")).click();
		Set<String> Allwn = driver.getWindowHandles();
		for(String wn:Allwn)
		{
		driver.switchTo().window(wn);
		}
		driver.findElement(By.id("departFrom")).sendKeys("Bangalore");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.id("goingTo")).sendKeys("Mysore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Mysore']")).click();
		driver.findElement(By.id("departDate")).click();
		driver.findElement(By.xpath("//a[text()='30']")).click();
		driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h4[text()='Departure Time']/parent::div//li//label[contains(text(),'After')]")).click();
		driver.findElement(By.xpath("//label[text()='SRS Travels']/ancestor::div[@class='top-search-result-card']//div//button[text()='Select Seat']")).click();
		Actions a=new Actions(driver);
		a.scrollByAmount(0,300).perform();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(@title,'Seat No. : 4L')]"));
		a.moveToElement(ele).click().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[contains(@class,'ng-pristine ng-valid ng-touched')and @type='radio']")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Guest User Login')]")).click();
		driver.findElement(By.name("emailLogin")).sendKeys("niveditha1930@gmail.com");
		driver.findElement(By.name("phoneLogin")).sendKeys("9876543210");
		driver.findElement(By.xpath("//div[@id='profile']//button[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mobileno']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Bangalore");
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select s=new Select(country);
		s.selectByVisibleText("India");
	}

}
