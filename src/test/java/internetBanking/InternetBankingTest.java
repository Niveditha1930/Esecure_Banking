package internetBanking;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Com.ObjectRepo.CustomerIBLoginPage;
import Com.ObjectRepo.DashBoardPage;
import Com.ObjectRepo.FundTransferIBPage;
import Com.ObjectRepo.HomePage;
import Com.ObjectRepo.InternetBankingRegisterPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListnerImplementation.class)
public class InternetBankingTest extends BaseClass {
	
	@Test(retryAnalyzer = genericUtilities.RetryImpclass.class)
	
	public void testRun() throws IOException, EncryptedDocumentException, AWTException, InterruptedException
	{
		
	      HomePage h=new HomePage(driver);
	      InternetBankingRegisterPage i=new InternetBankingRegisterPage(driver);
	      WebElement InternetBankingBtn =i.retrunInternet();
	      w.scroll(driver,InternetBankingBtn);
	      h.mouseInternet(w, driver);
	      h.mouseInternetRegister(w, driver);
	      i.registerClick();
	      String customerID = i.writeDataIntoTextFields(driver);
	      DashBoardPage d=new DashBoardPage(driver);
	      d.clickHome();
	      w.scroll(driver, InternetBankingBtn);
	      h.mouseInternet(w, driver);
	      h.mouseInternetLogin(w, driver);
	      CustomerIBLoginPage c=new CustomerIBLoginPage(driver);
	      i.clickLgBtn();
	      c.customerCredentials(customerID,"password");
	      FundTransferIBPage f=new FundTransferIBPage(driver);
	      f.clickfundTransferBtn();
	      f.clickAddBene();
	      f.writeDataToAddBenefiTextFields(driver,"Saving");
	      f.fundtransfer("200","sent");
	}

}
