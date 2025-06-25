package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager
{

	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String filename)
	{
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(filename);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
		
	}
}
