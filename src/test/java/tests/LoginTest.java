package tests;

import org.testng.annotations.Test;

public class LoginTest extends TestNGBaseClass {

	
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() 
	{
		excel.getData("TC001");
		_loginPage.loginWithValidUserDetails(map.get("UserName"),map.get("Password"),map.get("expectedTitle"));
		sa.assertAll();
	}
	
	
	@Test(priority = 2)
	public void verifyLoginWithInValidUserNameAndPassword() 
	{
		excel.getData("TC002");
		_loginPage.loginWithInValidUserDetails(map.get("UserName"),map.get("Password"), map.get("expectedTitle"));
		sa.assertAll();
	}
	
	@Test(enabled =false)
	public void verifyLoginOnlyWithValidUserName() 
	{
		_loginPage.loginWithInValidUserDetails("admin", "", "Please enter a password");
		sa.assertAll();
	}
}
