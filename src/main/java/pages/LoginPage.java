package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.PrintUtils;
import common.SeleniumGenerics;

public class LoginPage extends SeleniumGenerics{

	WebDriver driver;
	
	public LoginPage(WebDriver pageDriver) 
	{
		this.driver = pageDriver;
	}

	// Page Elements - Locate
	@FindBy(id = "username")
	WebElement userNameEle;

	@FindBy(id = "password")
	WebElement passwordEle;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement LoginButtonEle;

	@FindBy(linkText = "Configuration")
	WebElement configLinkEle;
	
	@FindBy(id = "message")
	WebElement errorMessageEle;

	// page methods


	public void clickConfigLink(String expectedTitle) 
	{
		clickElement(configLinkEle);
		String value =	getPageTitle(driver);
		if(value.equals(expectedTitle))
		{
			PrintUtils.logMsg("Config page title matched");
		}else 
		{
			PrintUtils.logError("Config page title not matched");
			
		}
	}
	
	public void loginWithValidUserDetails(String userName, String pwd, String expectedTitle) 
	{
		enterText(userNameEle,userName);
		enterText(passwordEle, pwd);
		clickElement(LoginButtonEle);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(LoginButtonEle));
		
		String value =	getPageTitle(driver);
		if(value.equals(expectedTitle))
		{
			PrintUtils.logMsg("Home page title matched");
		}else 
		{
			PrintUtils.logError("Home page title not matched");
		}
	}
	
	public void loginWithInValidUserDetails(String userName, String pwd, String expectedErrorMsg) 
	{
		enterText(userNameEle,userName);
		enterText(passwordEle, pwd);
		clickElement(LoginButtonEle);
		String value =	getElementText(errorMessageEle);
		if(value.equals(expectedErrorMsg))
		{
			PrintUtils.logMsg("Error message is matched");
		}else 
		{
			PrintUtils.logError("Error message is not matched");
		}
	
	}

}
