package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	private WebDriver driver;
	
	private By firstName=By.id("first-name");
	private By lastName=By.id("last-name");
	private By zipCode=By.id("postal-code");
	private By continueBtn=By.id("continue");
	private By finishButton = By.id("finish");
    private By successMessage = By.className("complete-header");
	private Logger logger=LogManager.getLogger(CheckoutPage.class);
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void checkoutDetails(String fn,String ln,String postal)
	{
		driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastName).sendKeys(ln);
		driver.findElement(zipCode).sendKeys(postal);
		driver.findElement(continueBtn).click();
		logger.info("Checkout details");
	}

	public void finishCheckout() {
		// TODO Auto-generated method stub
		driver.findElement(finishButton).click();
	}

	public String getSuccessMessage() {
		// TODO Auto-generated method stub
		return driver.findElement(successMessage).getText();
	}
	
}
