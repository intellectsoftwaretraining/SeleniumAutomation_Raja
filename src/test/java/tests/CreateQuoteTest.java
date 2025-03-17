package tests;

import org.testng.annotations.Test;

public class CreateQuoteTest extends TestNGBaseClass {

	
	@Test
	public void createNewQuote() 
	{
		_loginPage.loginWithInValidUserDetails("admin", "admin", "BP Travel - Search");	
		_homePage.clickCreateQuote();
	}
	
}
