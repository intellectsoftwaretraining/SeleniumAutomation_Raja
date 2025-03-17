package common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class SeleniumGenerics {

	public static SoftAssert sa;
	public static Map<String , String> map = new HashMap<String, String>();
	
	public WebDriver openBrowser(String browserName, String URL) 
	{
		WebDriver driver =null;
		
		if(browserName.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}else 
		{
			System.out.println("Please provide only chrome or IE");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		return driver;
	}
	
	public void closeBrowser(WebDriver driver) 
	{
		driver.close();
		PrintUtils.logMsg("Browser is Closed");	
	}
	
	public void quitBrowser(WebDriver driver) 
	{
		driver.quit();
		PrintUtils.logMsg("Browser is Quited");
	}
	
	
	public String getPageTitle(WebDriver driver) 
	{
		String actualValue = driver.getTitle();
		System.out.println("Actual Page Title is :: " + actualValue);
		Reporter.log("Actual Page Title is :: " + actualValue);
		return actualValue;
	}
	
	public void refreshBrowser(WebDriver driver) 
	{
		driver.navigate().refresh();
	}
	
	public void takeScreenShot(WebDriver driver, String  screeshotName) throws Exception 
	{	
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/"+screeshotName+".png"));
	}
	
	public void takeElementScreenshot(WebElement ele, String  screeshotName) throws IOException 
	{
		File src= ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/"+screeshotName+".png"));
	}
	
	public void clickElement(WebElement ele) 
	{
		ele.click();
		PrintUtils.logMsg("Element is clicked");
	}
	
	public void enterText(WebElement ele, String valueToEnter) 
	{
		ele.sendKeys(valueToEnter);
		PrintUtils.logMsg("Value entered in input box is :: "+ valueToEnter);
	}
	
	public void selectDropdownByIndex(WebElement ele, int index) 
	{
		Select st = new Select(ele);
		st.selectByIndex(index);
	}
	
	public String getElementText(WebElement ele) 
	{
		String actualValue = ele.getText();
		PrintUtils.logMsg("Actual text from ele is :: " + actualValue);
		return actualValue;
	}
	
	public String getElementAttribute(WebElement ele, String attributeName) 
	{
		String actualValue = ele.getDomAttribute(attributeName);
		PrintUtils.logMsg("Actual Value from attibute name:: " + actualValue);
		return actualValue;
	}
}
