package openAccount;


import java.awt.AWTException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Com.ObjectRepo.OpenAccConfirmPage;
import Com.ObjectRepo.OpenAccPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ExtendedListImp.class)
public class OpenAccTest extends BaseClass {
	
	@Test
	
	public void runTest() throws IOException, EncryptedDocumentException, AWTException, InterruptedException
	{  
	      OpenAccPage o=new OpenAccPage(driver);
	      o.clickOpenAccount();
	      String[] s = o.writeDataIntoText(driver,"OpenAccount",1,"Female","California","Fresno","Saving");
	      o.clicksubmit();
	      OpenAccConfirmPage o1=new OpenAccConfirmPage(driver);
	      o1.clickconfirm();
	      String appnum =o1.getapplication(driver);
	      System.out.println(appnum);
	}

}
