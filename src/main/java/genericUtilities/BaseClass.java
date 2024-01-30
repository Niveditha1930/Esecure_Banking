package genericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public JavaUtils j=new JavaUtils();
	public WebDriverUtils w=new WebDriverUtils();
	public ExcelUtil e=new ExcelUtil();
	public FileUtil f=new FileUtil();
	public DataBaseUtil d=new DataBaseUtil();
	
	
	@BeforeSuite(alwaysRun =true)
	public void ConfigureDB() throws SQLException
	{
		//d.getConnection();
		Reporter.log("<------Open DB Connection----->",true);
	}
     //@Parameters("browser")
	@BeforeClass(alwaysRun =true)
	public void launchBrowser() throws IOException
	{
	Reporter.log("<------Opening the browser---->",true);
	//if(value.equals("chrome"))
	//{
		driver=new ChromeDriver();
	//}else if (value.equals("edge")) {
		//driver=new EdgeDriver();	
//	}
	
		sdriver=driver;
		w.pageLoadtimeOut(driver, 10);
		w.maximizeWindow(driver);
		String urlnew = f.getPropertyFile("urlnew");
		driver.get(urlnew);
	}
	
	@AfterClass(alwaysRun =true)
	public void closeBrowser()
	{
		Reporter.log("<------closing the browser---->",true);
		driver.quit();
	}
	
	@AfterSuite(alwaysRun =true)
	public void closingDB()
	{
		Reporter.log("<------closing DB Connection----->",true);
	}

}
