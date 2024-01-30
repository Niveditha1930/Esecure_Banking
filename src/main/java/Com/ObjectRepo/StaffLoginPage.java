package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	
	//declaration
	@FindBy(xpath = "//input[@name='staff_id']")
	private WebElement staffID;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='staff_login-btn']")
	private WebElement LoginBtn;
	
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getStaffID()
	{
		return staffID;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getLoginBtn()
	{
		return LoginBtn;
	}
	
    
	//Utilization
	
	public void setCredentials(String sid, String sPw)
	{
		staffID.sendKeys(sid);
		password.sendKeys(sPw);
		LoginBtn.click();
	}
	
	}
