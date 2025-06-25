package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks
{

	@Before
	public void setUp(Scenario scenario)
	{
		
		WebDriver driver = new ChromeDriver(); // or use ChromeOptions
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        DriverFactory.setDriver(driver);
		
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String path=ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), scenario.getName());
			scenario.attach(path.getBytes(),"image/png","Failure Screenshot ");
		}
		DriverFactory.quitDriver();
	}
}

