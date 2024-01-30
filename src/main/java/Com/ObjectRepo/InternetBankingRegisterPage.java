package Com.ObjectRepo;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelUtil;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtils;

public class InternetBankingRegisterPage {
	
	//Declaration
	
	  @FindBy(xpath ="//a[contains(text(),'Internet Banking')]")
	   private WebElement InternetBankingbtn;
	  
	  @FindBy(xpath ="//li[contains(text(),'Register')]")
	  private WebElement register;
	  
	  @FindBy(xpath ="//li[text()='Login ']")
	  private WebElement IBlgbtn;
	
		@FindBy(name = "submit")
		private WebElement submitbutton;
		
		@FindBy(name ="dob")
		private WebElement dob;
		
		//initialization
		public InternetBankingRegisterPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		
		public void mouseoverIB(WebDriver driver,WebElement element)
		{
			WebDriverUtils w=new WebDriverUtils();
		    w.mouseOver(driver,InternetBankingbtn);
		}
		
		public WebElement retrunInternet()
		{
			return InternetBankingbtn;
		}
		
		public void registerClick()
		{
			register.click();
		}
		
		public void clickSubmit()
		{
			submitbutton.click();
		}
		
		public WebElement ScrollLogin()
		{
			return IBlgbtn;
		}
		public void clickLgBtn()
		{
			IBlgbtn.click();
		}
		
		public String writeDataIntoTextFields(WebDriver driver) throws EncryptedDocumentException, IOException, AWTException, InterruptedException
		{
			ExcelUtil e=new ExcelUtil();
			JavaUtils j=new JavaUtils();
		    dob.click();
			   
		     j.enterKeyUsingRobot(KeyEvent.VK_5);
		     j.enterKeyUsingRobot(KeyEvent.VK_6);
		     Thread.sleep(500);
		     j.enterKeyUsingRobot(KeyEvent.VK_1);
		     Thread.sleep(500);
		     j.enterKeyUsingRobot(KeyEvent.VK_9);
		     Thread.sleep(500);
		     j.enterKeyUsingRobot(KeyEvent.VK_9);
		     Thread.sleep(500);
		     j.enterKeyUsingRobot(KeyEvent.VK_8);
		     
			int lastCell = e.getLastCellNum("DebitCardDetails",0);
			   
			   HashMap<String, String> hm = e.hashMapData("DebitCardDetails", lastCell-1);
			   

			   for(Entry<String, String> set:hm.entrySet())
			   {
				   driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			   }
			   
			   clickSubmit();
			   Thread.sleep(1000);
				JavaUtils j1=new JavaUtils();
				String customerID= j1.extractDigit(driver);
				System.out.println("Customer ID: "+customerID);
				return customerID;
		}}