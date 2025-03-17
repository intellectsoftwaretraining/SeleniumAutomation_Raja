package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.SeleniumGenerics;

public class HomePage extends SeleniumGenerics {

	//bala murugan
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "Create Quote")
	WebElement createQuoteEle;
	
	
	
	public void clickCreateQuote() 
	{
		clickElement(createQuoteEle);
	}
	
}
