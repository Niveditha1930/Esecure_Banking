package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class HomePage {

	//Declaration

	@FindBy(xpath="//li[text()='Open Account']'")
	private WebElement OpenAccount;

	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement ApplyDebitCard;

	@FindBy(xpath = "//a[contains(text(),'Internet ')]")
	private WebElement InterNetBanking;

	@FindBy(xpath = "//li[contains(text(),'Fund Transfer')]")
	private WebElement FundTransfer;
	
	@FindBy(xpath = "//li[text()='Register']")
	private WebElement IRegister;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement ILogin;

	//Initialization

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Performing actions on webElement
	public void clickOpenAccount()
	{
		OpenAccount.click();
	}

	public void clickApplyDebitCard()
	{
		ApplyDebitCard.click();
	}
    
	public void mouseInternet(WebDriverUtils w,WebDriver driver)
	{
		w.mouseOver(driver,InterNetBanking);
	}
	
	public void mouseInternetRegister(WebDriverUtils w,WebDriver driver)
	{
		w.mouseOver(driver,IRegister);
	}
	
	public void mouseInternetLogin(WebDriverUtils w,WebDriver driver)
	{
		w.mouseOver(driver,ILogin);
	}
	
	
	}
	
