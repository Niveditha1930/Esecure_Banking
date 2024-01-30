package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	
	@FindBy(xpath ="//input[@name='viewdet']")
	private WebElement viewActiveCust;
	
	@FindBy(xpath="//input[@name='view_cust_by_ac']")
	private WebElement viewActiveCustByAcc;
	
	@FindBy(xpath ="//input[@name='apprvac']")
	private WebElement approvpenAcc;
	
	@FindBy(xpath ="//input[@name='del_cust']")
	private WebElement deletecust;
	
	@FindBy(xpath ="//input[@name='credit_cust_ac']")
	private WebElement creditCustomerBtn;
	
	@FindBy(xpath ="//input[@name='home']")
	private WebElement HomeBtn;
	
	@FindBy(xpath="//input[@name='logout_btn']")
	private WebElement logoutbtn;
	
	//Initialization
    public StaffHomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    
    public void clickHome()
    {
    	HomeBtn.click();
    }
    
    public WebElement getActivecust()
    {
    	return viewActiveCust;
    }
    
    public WebElement getActivecustByAcc()
    {
    	return viewActiveCustByAcc;
    }
    
    public void ClickApprovepenAcc()
    {
    	approvpenAcc.click();
    }
    
    public WebElement getDelecust()
    {
    	return deletecust;
    }
    
    public WebElement getCreditcust()
    {
    	return creditCustomerBtn;
    }
    
    public void clickcreditcustBtn()
    {
    	creditCustomerBtn.click();
    }
    
    public void ClickLogOutbtn()
    {
    	logoutbtn.click();
    	
    }

}
