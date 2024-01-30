package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendedListImp implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		 String methodname = result.getMethod().getMethodName();
		 test=report.createTest(methodname);
		 Reporter.log(methodname+ "   Execution Started  ",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+" passed");
		Reporter.log(methodname+"  Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		try {
			
			String path = WebDriverUtils.getScreenShot(BaseClass.sdriver, methodname);
			
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL,methodname+" Failed");
			test.log(Status.FAIL,result.getThrowable());
			Reporter.log(methodname+" ------->Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+" Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(methodname+" ------>Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		JavaUtils j=new JavaUtils();
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\extent\\report"+j.getFormattedDate()+".html");
		htmlreport.config().setDocumentTitle("Esecure");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("EsecureBanking");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base platform","os");
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("Base-URL","//rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("ReporterName","Niveditha");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	

}
