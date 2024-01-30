package approvePendingAccount;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Com.ObjectRepo.ApprovPenAccPage;
import Com.ObjectRepo.CreditCustPage;
import Com.ObjectRepo.DashBoardPage;
import Com.ObjectRepo.OpenAccConfirmPage;
import Com.ObjectRepo.OpenAccPage;
import Com.ObjectRepo.StaffHomePage;
import Com.ObjectRepo.StaffLoginPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImp2.class)
public class ApprovePendingRepoTest extends BaseClass{
	
	@Test(retryAnalyzer = genericUtilities.RetryImpclass.class)
	public void runTest() throws IOException, EncryptedDocumentException, AWTException, InterruptedException
	{
		
		String StaffID = f.getPropertyFile("username");
		String password = f.getPropertyFile("password");
		
        
	      OpenAccPage o=new OpenAccPage(driver);
	      o.clickOpenAccount();
	      String[] dataForApplyDebitCard = o.writeDataIntoText(driver,"OpenAccount",1,"Female","California","Fresno","Saving");
	      o.clicksubmit();
	      OpenAccConfirmPage o1=new OpenAccConfirmPage(driver);
	      o1.clickconfirm();
	      String appnum =o1.getapplication(driver);
	      System.out.println("Application number: "+appnum);
	      
	      DashBoardPage d=new DashBoardPage(driver);
	      d.staffclick();
	      StaffLoginPage s=new StaffLoginPage(driver);
	      s.setCredentials(StaffID, password);
	      StaffHomePage s1=new StaffHomePage(driver);
	      s1.ClickApprovepenAcc();
	      
	      ApprovPenAccPage a=new ApprovPenAccPage(driver);
	      a.enterseacrhtext(appnum);
	      String AcctNumber = a.validate(driver);
	      //ExcelUtil e=new ExcelUtil();
	      
	       //writing data into excel to send the data for Apply Debitcard
	       e.setExcelData("ApplyDebitCard",dataForApplyDebitCard[0],0);
		   e.setExcelData("ApplyDebitCard",dataForApplyDebitCard[1],1);
		   e.setExcelData("ApplyDebitCard",dataForApplyDebitCard[2],2);
		   e.setExcelData("ApplyDebitCard",AcctNumber,3);
		   
		   
		   
		 //writing data into excel to send the data into Internet banking page
			e.setExcelData("DebitCardDetails", dataForApplyDebitCard[0],0);
			e.setExcelData("DebitCardDetails", AcctNumber,1);		
			e.setExcelData("DebitCardDetails", dataForApplyDebitCard[1],4);
			e.setExcelData("DebitCardDetails", dataForApplyDebitCard[2],5);
			e.setExcelData("AddBeneficiary", dataForApplyDebitCard[0], 0);
			e.setExcelData("AddBeneficiary","1011",1);
			e.setExcelData("AddBeneficiary", AcctNumber,2);
			
			StaffHomePage h=new StaffHomePage(driver);
		     h.clickHome();
		     WebElement creditCustomerBtn = h.getCreditcust();
		     w.scroll(driver, creditCustomerBtn);
		     h.clickcreditcustBtn();
		     
			
			//Credit amount in customer account
			CreditCustPage c=new CreditCustPage(driver);
			c.creditamount(AcctNumber,"5000");
			w.alertAccept(driver);
			
			s1.ClickLogOutbtn();
			d.clickHome();
		   
	}

}
