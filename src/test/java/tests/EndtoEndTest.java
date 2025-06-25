package tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import utils.RetryAnalyzer;
public class EndtoEndTest extends BaseTest 
{
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void productFlow()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login("standard_user", "secret_sauce");
		
		HomePage homepage=new HomePage(driver);
		homepage.addtoCart();
		homepage.cartLink();
		System.out.println("CurrentPage is:"+driver.getCurrentUrl());
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		CartPage cartpage=new CartPage(driver);
		cartpage.proceedToCheckout();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.checkoutDetails("Lavanya", "Tenneti", "12376");
		checkoutPage.finishCheckout();
		logger.info("Checkout process is successful");
		
		Assert.assertTrue(checkoutPage.getSuccessMessage().contains("Thank you"));
	}

}
