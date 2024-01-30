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

public class OpenAccPage {
	
	@FindBy(xpath ="//li[text()='Open Account']")
	private WebElement OpenAccount;
	
	@FindBy(name ="gender")
    private WebElement gender;
	
	@FindBy(name ="state")
	private WebElement state;
	
	@FindBy(name ="city")
	private WebElement city;
	
	@FindBy(name ="acctype")
	private WebElement acctype;
	
	@FindBy(xpath ="//input[@placeholder='Date of Birth']")
	private WebElement dob;
	
	@FindBy(xpath ="//input[@name='submit']")
	private WebElement submit;
	
	@FindBy(xpath ="//input[@name='cnfrm-submit']")
	private WebElement confirmsub;
	
	@FindBy(xpath="//input[@value='Go back']")
	private WebElement goBack;
	
	public WebElement getState()
	{
		return state;
	}
	
	public WebElement getCity()
	{
		return city;
	}
	
	public WebElement getGender()
	{
		return gender;
	}
	
	public WebElement getAcctype()
	{
		return acctype;
	}
	
	public void clickOpenAccount()
	{
		OpenAccount.click();
	}
	
	public OpenAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String[] writeDataIntoText(WebDriver driver, String SheetName,int cellnum,String Ugender,String Ustate,String Ucity,String Uacctype) throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{  
	ExcelUtil e=new ExcelUtil();
    JavaUtils j=new JavaUtils();
    WebDriverUtils w=new WebDriverUtils();
    //ApprovPenAcc a=new ApprovPenAcc(driver);
    int random=j.random(200);
    String holder_name="";
    String pan="";
    String mob="";
		HashMap<String, String> map = e.hashMapData(SheetName,cellnum);
	 for(Entry<String, String> set:map.entrySet())
	 {
		 if(set.getKey().equals("name"))
		 {
			 holder_name=set.getValue()+random;
			driver.findElement(By.name(set.getKey())).sendKeys(holder_name);
		 }
		 else if(set.getKey().contains("pan"))
		 {
			 pan=set.getValue();
				driver.findElement(By.name(set.getKey())).sendKeys(pan);
			 }
		 
		 else if(set.getKey().contains("mob"))
		 {
			 mob=set.getValue();
				driver.findElement(By.name(set.getKey())).sendKeys(mob);
			 }
		 else
		 {
			 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
	 }
	 }
		   w.selectVisibleText(Ugender,gender);
			w.selectVisibleText(Ustate,state);
			w.selectVisibleText(Ucity, city);
			w.selectVisibleText(Uacctype, acctype);
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
	        
	        String [] s=new String[3];
	        s[0]=holder_name;
	        s[1]=pan;
	        s[2]=mob;
	        System.out.println(s[0]);
	        return s;
	        
	}
	public void clicksubmit()
	{
		submit.click();
	}
	public void clickconfirmsubmit()
	{
		confirmsub.click();
	}
	
	public void clickgoback()
	{
		goBack.click();
	}
}