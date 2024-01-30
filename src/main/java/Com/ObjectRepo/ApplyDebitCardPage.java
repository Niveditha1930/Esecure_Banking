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

public class ApplyDebitCardPage {
	
	
	@FindBy(name="dob")
	private WebElement dob;
	
	@FindBy(name ="dbt_crd_submit")
	private WebElement submitbtn;
	
	public ApplyDebitCardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void click()
	{
		submitbtn.click();
	}
	
	public String[] writeDataIntoTextFields(WebDriver driver) throws EncryptedDocumentException, IOException, AWTException, InterruptedException
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
	     
		int lastCell = e.getLastCellNum("ApplyDebitCard",0);
		   
		   HashMap<String, String> hm = e.hashMapData("ApplyDebitCard", lastCell-1);
		   

		   for(Entry<String, String> set:hm.entrySet())
		   {
			  
			   driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		   }
		   
		  
		     submitbtn.click();
		     String debit = j.extractDigit(driver);
		     char[] ch2 = debit.toCharArray();
				String debitCardNumber="";
				String debitCardPin="";
				
				for(int i=0;i<ch2.length;i++) {
					if(i>=0&&i<=11) {
						debitCardNumber=debitCardNumber+ch2[i];
					}else {
						debitCardPin=debitCardPin+ch2[i];
					}
				}
				
				String[] s=new String[2];
				s[0]=debitCardNumber;
				s[1]=debitCardPin;
				return s;
	}

}