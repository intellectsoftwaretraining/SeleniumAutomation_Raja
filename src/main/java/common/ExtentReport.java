package common;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	private static ExtentReports extent;
	private static ExtentTest test;

	public static void startReport()
	{
		extent = new ExtentReports("./ExtentReport/BP_TRAVEL_REPORT.html", true);
		extent.loadConfig(new File("./extent-config.xml"));
	}
	
	public static void setTestCaseName(String testCaseName, String testDescription ) 
	{
		test = extent.startTest(testCaseName, testDescription);
	}
	
	public static void logStep(String msg, String status) 
	{
		if (status.toUpperCase().equals("PASS"))
		{
			test.log(LogStatus.PASS, msg);
		}
		else if (status.toUpperCase().equals("FAIL"))
		{
			test.log(LogStatus.FAIL, msg );
		}
		else if (status.toUpperCase().equals("INFO"))
		{
			test.log(LogStatus.INFO, msg);
		}
	}

	public static void endReport() 
	{
		extent.endTest(test);
		extent.flush();
	}
	
}
