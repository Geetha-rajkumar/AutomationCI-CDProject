package DheekshaAcedemy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

public static ExtentReports getReportObject()
{
	
	String path =System.getProperty("user.dir")+"//report//index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation results");
	reporter.config().setDocumentTitle("test results");
	ExtentReports extent =  new ExtentReports();
	extent.attachReporter(reporter);
	
	extent.setSystemInfo("Tester","Rahul Shetty");
	extent.createTest(path);
	return extent;
	
}
}
