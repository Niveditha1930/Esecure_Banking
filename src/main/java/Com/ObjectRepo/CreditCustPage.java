package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustPage {
	
	
	
	@FindBy(name ="customer_account_no")
	private WebElement customerAcc;
	
	@FindBy(name="credit_amount")
	private WebElement creditAmount;
	
	@FindBy(name ="credit_btn")
	private WebElement creditBtn;
	
	public CreditCustPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void creditamount(String acuntNum,String Amount)
	{
		customerAcc.sendKeys(acuntNum);
		creditAmount.sendKeys(Amount);
		creditBtn.click();
	}
}
