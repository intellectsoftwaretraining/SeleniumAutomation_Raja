package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import common.ExcelConfig;
import common.ExtentReport;
import common.SeleniumGenerics;
import pages.HomePage;
import pages.LoginPage;

public class TestNGBaseClass extends SeleniumGenerics {

	
	public WebDriver driver = null;
	public LoginPage _loginPage =null;
	public HomePage _homePage = null;
	public ExcelConfig excel = new ExcelConfig();
	
	@BeforeSuite
	public void beforeSuite() 
	{
		ExtentReport.startReport();
	}
	

	@AfterSuite
	public void afterSuite() 
	{
		ExtentReport.endReport();
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		sa = new SoftAssert();
		driver = openBrowser("chrome", "https://bptravel.blueprism.com/");
		
		_loginPage = PageFactory.initElements(driver, LoginPage.class);
		_homePage = PageFactory.initElements(driver, HomePage.class);
		
		//_loginPage = new LoginPage(driver);
		//_homePage = new HomePage(driver);
	}
	
	
	@AfterMethod
	public void afterMethod() 
	{
		closeBrowser(driver);
	}
}
