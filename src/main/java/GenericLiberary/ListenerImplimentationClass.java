package GenericLiberary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentationClass implements ITestListener {
 public static ExtentReports report;
 public static ExtentTest test;
 
	public void onTestStart(ITestResult result) {
		//execution Start from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"-------> testScript execution start");
		test.log(Status.INFO,MethodName+"---->testScript execution start");
	
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--->Passed");
		Reporter.log(MethodName+"----->test execution successful"); 
	}

	public void onTestFailure(ITestResult result) {
	
		 String FailedScript = result.getMethod().getMethodName();
	String fs=FailedScript + new JavaUtility().getSystemDateAndTimeFormate();
	EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
	File src=edriver.getScreenshotAs(OutputType.FILE);
	File path= new File("./ScreenShot/"+fs+".png");
	String filepath=path.getAbsolutePath();
	try {
		FileUtils.copyFile(src, path);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	test.addScreenCaptureFromPath(filepath);
	test.log(Status.FAIL,result.getThrowable()+"---Test Script execution Failed");
	Reporter.log("---test Script Exection failed");
//		WebDriverUtility wbLib=new WebDriverUtility();
//		
//		wbLib.fullPageScreenShot(null, null);
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"---Skipped");
		Reporter.log("--testScript Execution skipped--");
	}

	public void onStart(ITestContext context) {
		//configure the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("BioBook");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base Url","http://rmgtestingserver/domain/Bio_Book/");
		report.setSystemInfo("reporter_Name","Raju");
		ITestNGMethod[] AllMetthodNmae=context.getAllTestMethods();
		String MehtodName=AllMetthodNmae.toString();
		test=report.createTest(MehtodName);
		
	}

	public void onFinish(ITestContext context) {
		//consolidated the report
		report.flush();
		
	}
	

}
