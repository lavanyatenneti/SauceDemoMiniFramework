package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import base.BaseTest;
import dataProviders.LoginDataProvider;

public class LoginTest extends BaseTest
{
	
	@Test(dataProvider="loginCredentialsfromCSV",dataProviderClass=LoginDataProvider.class)
	public void validLogin(String username,String password)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String currentUrl=driver.getCurrentUrl();
		
		if(username.equals("standard_user") && password.equals("secret_sauce"))
		{
			Assert.assertTrue(currentUrl.contains("inventory"),"Login should succeed");
			logger.info("ValidLogin is successful");
			//(TakeScreenshot)as
		}else if(username.equals("problem_user")&& password.equals("secret_sauce"))
		{
			Assert.assertTrue(currentUrl.contains("inventory"),"Login should succeed");
		}
		else
		{
		
			Assert.assertTrue(currentUrl.contains("demo"),"Login should fail or stay in login page");
		}
	
	}
	

}
