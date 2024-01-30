package applyDebitCard;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import Com.ObjectRepo.ApplyDebitCardPage;
import Com.ObjectRepo.DashBoardPage;
import Com.ObjectRepo.HomePage;
import genericUtilities.BaseClass;

public class ApplyDebitCardRepoTest extends BaseClass{
	@Test(retryAnalyzer =genericUtilities.RetryImp1.class)
	public void runTest() throws IOException, EncryptedDocumentException, AWTException, InterruptedException
	{
		
	      HomePage h=new HomePage(driver);
	      h.clickApplyDebitCard();
		  ApplyDebitCardPage ap=new ApplyDebitCardPage(driver);
		  String[] Debitcredentials = ap.writeDataIntoTextFields(driver);
		  System.out.println("Debit card: "+Debitcredentials[0]);
		  System.out.println("Debit pin: "+Debitcredentials[1]);
		  
		   
		   
		 //writing data into excel to send the data into Internet banking page
		    //ExcelUtil e=new ExcelUtil();
			e.setExcelData("DebitCardDetails",Debitcredentials[0],2);
			e.setExcelData("DebitCardDetails",Debitcredentials[1],3);
			e.setExcelData("DebitCardDetails", "5000", 6);
			e.setExcelData("DebitCardDetails", "password", 7);
		    e.setExcelData("DebitCardDetails", "password", 8);
		    
		    DashBoardPage d=new DashBoardPage(driver);
		    d.clickHome();
          
	}
}