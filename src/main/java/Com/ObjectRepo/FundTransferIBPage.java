package Com.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelUtil;
import genericUtilities.WebDriverUtils;

public class FundTransferIBPage {
	
	@FindBy(xpath ="//input[@name='beneficiary_name']")
	private WebElement beneficiaryName;
	
	@FindBy(name ="beneficiary_acno")
	private WebElement beneficiaryAcc;
	
	@FindBy(name ="Ifsc_code")
	private WebElement ifsc;
	
	@FindBy(xpath ="//li[text()='Fund Transfer']")
	private WebElement Fundtransferbtn;
	
	@FindBy(xpath ="//input[@name='add_beneficiary']")
	private WebElement addbeneficiary;
	
	@FindBy(xpath ="//select[@name='beneficiary_acc_type']")
	private WebElement accType;
	
	@FindBy(xpath ="//input[@name='add_beneficiary_btn']")
	private WebElement addbtn;
	
	
	@FindBy(xpath ="//select[@name='beneficiary']")
	private WebElement selectBeneficiary;
	
	@FindBy(name ="trnsf_amount")
	private WebElement amountTransfer;
	
	@FindBy(name ="trnsf_remark")
	private WebElement remark;
	
	@FindBy(xpath ="//input[@name='fnd_trns_btn']")
	private WebElement clickSendBtn;
	
	@FindBy(xpath="//label[@class='OTP_msg']//br[2]")
	private WebElement verifyOTP;
	
	public FundTransferIBPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
  
	public void clickAddBene()
	{
		addbeneficiary.click();
	}
	
	public void clickfundTransferBtn()
	{
		Fundtransferbtn.click();
	}
	
	public WebElement getAcountType()
	{
		return accType;
	}
	
	public WebElement getSelectBen()
	{
		return selectBeneficiary;
	}
	
	public void writeDataToAddBenefiTextFields(WebDriver driver,String userInputActType) throws EncryptedDocumentException, IOException, InterruptedException
	{
		ExcelUtil e=new ExcelUtil();
		WebDriverUtils w=new WebDriverUtils();
		int lastCell = e.getLastCellNum("AddBeneficiary",0);
		   
		   HashMap<String, String> hm = e.hashMapData("AddBeneficiary", lastCell-2);
		   

		   for(Entry<String, String> set:hm.entrySet())
		   {
			  System.out.println(set.getValue());
			   driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		   }
		   
		  w.selectVisibleText(userInputActType,accType);
		  addbtn.click();
		  w.alertAccept(driver);
		  //Fundtransferbtn.click();
		  //selectBen.click();
		  //w.selectVisibleText(UserInputtoSeleBen,selectBen);
		  
	}
	public void fundtransfer(String amount,String mess)
	{   
		WebDriverUtils w=new WebDriverUtils();
		Fundtransferbtn.click();
		 w.selectByIndex(selectBeneficiary,1);
		 amountTransfer.sendKeys(amount);
		 remark.sendKeys(mess);
		 clickSendBtn.click();
		 String text = verifyOTP.getText();
		 System.out.println("OTP text "+text);
	}
}
