package base;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import jdk.internal.org.jline.utils.Log;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseTest 
{
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static Logger logger=LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void setReport()
	{
		logger.info("Setting up Report");
		extent=ExtentManager.createInstance("test-output/extent-report.html");
	}
	
	@BeforeMethod
	public void setLogger(Method method)
	{
		String safeName=method.getName().replaceAll("[^A-Za-z0-9_-]", "_");
		ThreadContext.put("testName",safeName);
	}
	@BeforeMethod(alwaysRun=true)
	public void setUp(Method method)
	{
		logger.info("Browser setup");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-save-password-bubble");
		options.setExperimentalOption("prefs",Map.of("credentials_enable_service",false,"profile.password_manager_enabled",false));
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		logger.debug("Able to open the website");
		test=extent.createTest(method.getName());
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath=ScreenshotUtil.takeScreenshot(driver,result.getName());
			test.fail("Test failed:"+result.getThrowable(),
			MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("Test PAssed:");
		}else
			test.skip("test skipped :"+ result.getThrowable());
		if(driver!=null)
		driver.quit();
	}
	public void clearLoggerContext()
	{
		ThreadContext.clearAll();
	}
	@AfterSuite
	public void flushReport()
	{
		extent.flush();
		logger.info("TestExecution completed");
	}
}
