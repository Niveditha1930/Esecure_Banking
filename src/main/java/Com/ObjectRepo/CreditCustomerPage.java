package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {
	
	//Declaration
	
	@FindBy(xpath ="//input[@name='customer_account_no']")
	private WebElement custaccnum;
	
	@FindBy(xpath ="//input[@name='credit_amount']")
	private WebElement creditamt;
	
	@FindBy(xpath ="//input[@name='credit_btn']")
	private WebElement creditbtn;
	
	//Initialization
	
	public CreditCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getcustaccnum()
	{
		return custaccnum;
	}
	
	public WebElement getcredamt()
	{
		return creditamt;
	}
	
	public void creditAmt(String custAcc, String creAmt)
	{
		custaccnum.sendKeys(custAcc);
		creditamt.sendKeys(creAmt);
		creditbtn.click();
	}
}
