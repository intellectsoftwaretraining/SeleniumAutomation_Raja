package common;

import org.testng.Reporter;

public class PrintUtils {


	public static void logMsg(String msg) 
	{
		System.out.println(msg);
		Reporter.log(msg);
		ExtentReport.logStep(msg, "PASS");
	}
	
	public static void logError(String msg) 
	{
		System.err.println(msg);
		Reporter.log(msg);
		ExtentReport.logStep(msg, "FAIL");
		SeleniumGenerics.sa.fail();
	}
}
