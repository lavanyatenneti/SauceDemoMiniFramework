package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;

//import com.google.common.io.Files;

import org.openqa.selenium.TakesScreenshot;


public class ScreenshotUtil
{

	public static String takeScreenshot(WebDriver driver,String testname)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="test-output/screenshots/"+testname+"_"+timestamp+".png";
		
		try
		{
			File dest=new File(path);
			dest.getParentFile().mkdirs();
			Files.copy(src.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
			//Files.copy(src.toPath(), dest.toPath());
			return path;
			//.copy(src.toPath(), dest.toPath());
		}catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
