package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory 
{

	private static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	public static void setDriver(WebDriver driverParam) {
        driver = driverParam;
    }
	public static void initDriver()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	public static void quitDriver()
	{
		if(driver!=null)
			driver.quit();
	}
	
}
