package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
	private WebDriver driver;
	private Logger logger=LogManager.getLogger(HomePage.class);
	
	private By addtoCart=By.id("add-to-cart-sauce-labs-backpack");
	private By cartlink=By.className("shopping_cart_link");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void addtoCart()
	{
		driver.findElement(addtoCart).click();
		logger.info("items are added to Add toCart ");
	}
	public void cartLink()
	{
		driver.findElement(cartlink).click();
		logger.info("Cart link is opened ");
	}
}
