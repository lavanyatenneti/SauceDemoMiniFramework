package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{

	private WebDriver driver;
	private Logger logger=LogManager.getLogger(LoginPage.class);
	
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginbutton=By.id("login-button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String user,String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginbutton).click();
		logger.info("Login details entered");
	}
}
