package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerIBLoginPage {
	
	@FindBy(xpath ="//li[text()='Login ']")
	private WebElement customerLgBtn;
	
	@FindBy(xpath ="//input[@name='customer_id']")
	private WebElement customerID;
	
	@FindBy(xpath ="//input[@name='password']")
	private WebElement cpassword;
	
	@FindBy(xpath="//input[@name='login-btn']")
	private WebElement cLoginBtn;
	
	public CustomerIBLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void customerLgbtn()
	{
		customerLgBtn.click(); 
	}
	public WebElement getcustomerID()
	{
		return customerID;
	}
	
	public WebElement getCpassword()
	{
		return cpassword;
	}
	
	public WebElement getLoginBtn()
	{
		return cLoginBtn;
	}
	
	//Utilization
	
	public void customerCredentials(String cid,String cpw)
	{
		customerID.sendKeys(cid);
		cpassword.sendKeys(cpw);
		cLoginBtn.click();
	}
	}

