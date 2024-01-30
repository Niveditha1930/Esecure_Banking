package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage {
	
	@FindBy(xpath ="//li[text()='Fund Transfer']")
	private WebElement fundtransfer;
	
	
	public CustomerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickfundtransfer()
	{
		fundtransfer.click();
	}

}
