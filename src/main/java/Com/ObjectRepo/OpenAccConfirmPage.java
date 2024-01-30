package Com.ObjectRepo;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtils;

public class OpenAccConfirmPage {
	
	@FindBy(name ="cnfrm-submit")
	private WebElement confirmsub;
	
	@FindBy(xpath="//input[@value='Go back']")
	private WebElement goBackBtn;
	
	public OpenAccConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickconfirm()
	{
		confirmsub.click();
	}
	
		
	
	public String getapplication(WebDriver driver) {
	//handle the alert pop up
			WebDriverUtils w=new WebDriverUtils();
			w.alert(driver);
			String text = w.alertGetText(driver);	
			String appl="";
			char[] ch = text.toCharArray();
			for(int i=0;i<text.length();i++) {

				if(Character.isDigit(ch[i])) {
					appl=appl+ch[i];
				}
			}
			w.alertDismiss(driver);
			return appl;
		}
	
		public void clickOnGoBackButton() {
			goBackBtn.click();
		}
}
