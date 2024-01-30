package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.JavaUtils;

public class ApprovPenAccPage {
	
	@FindBy(xpath ="//input[@placeholder='Application number']")
	private WebElement searctextfield;
	
	@FindBy(name ="search_application")
	private WebElement searchbtn;
	
	@FindBy(name ="approve_cust")
	private WebElement apprvbtn;

    @FindBy(xpath ="//div[@class='pending_customers_container']//tbody//tr[2]/td[2]")
    private WebElement applicationfield;
    
	public ApprovPenAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterseacrhtext(String appnum)
	{
		searctextfield.sendKeys(appnum);
	}
	
	public void searchbtn()
	{
		searchbtn.click();
	}
	//
	public String validate(WebDriver driver)
	{
		searchbtn.click();
		String application=null;
		try
		{
		application=applicationfield.getText();
		
		if(application!=null)
		{
			apprvbtn.click();
		}
		}
		catch(Exception e)
		{
		}
			//WebDriverUtils w=new WebDriverUtils();
			JavaUtils j=new JavaUtils();
			String ActNumber= j.extractDigit(driver);
		     System.out.println("Account number: "+ActNumber);
		  	 return ActNumber;
	
}
}