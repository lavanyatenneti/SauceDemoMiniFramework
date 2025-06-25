package Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage
{
	private WebDriver driver;
	
	private By checkoutBtn=By.id("checkout");
	private By itemName=By.className("inventory_item_name");
	private Logger logger=LogManager.getLogger(CartPage.class);
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void proceedToCheckout()
	{
		logger.info("Proceed checkout method");
		driver.findElement(itemName);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement checkoutbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
		checkoutbutton.click();
	}

	
}
