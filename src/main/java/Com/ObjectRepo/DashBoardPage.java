package Com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	//Declaration
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement Home;
	
	@FindBy(xpath = "//a[text()='About Us']")
	private WebElement AboutUs;
	
	@FindBy(xpath ="//a[text()='Contact Us']")
	private WebElement ContactUs;
	
	@FindBy(xpath = "//a[text()='Staff Login']")
	private WebElement StaffLogin;
	
	//Initializing
	
	public DashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickHome()
	{
		Home.click();
	}
	
	public void staffclick()
	{
		StaffLogin.click();
	}
}
