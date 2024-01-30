package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccNumPage {
	
	@FindBy(xpath="//input[@name='account_no']")
	private WebElement custacctextfield;
	
	@FindBy(xpath="//input[@name='submit_view']")
	private WebElement submitbtn;
	
	
	
	//Initialization
	public ViewCustomerByAccNumPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCusttextfield()
	{
		return custacctextfield;
	}
	
	public WebElement getSubmitbtn()
	{
		return submitbtn;
	}
	
	public void ViewCustByAcc(String custAcc)
	{
		custacctextfield.sendKeys(custAcc);
		submitbtn.click();
	}
		
	
	}
