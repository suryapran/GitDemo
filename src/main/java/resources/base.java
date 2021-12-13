package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties pr;
	public String url1;
	
	public WebDriver initializeBrowser() throws IOException
	{
		pr= new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Owner\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\externaldata.properties");

		
		pr.load(fin);
		
		//String browserName=System.getProperty("browser");// This is get browser name from maven system.
		String browserName=pr.getProperty("browser"); // This is get browser name from .properties file
		url1=pr.getProperty("url");
		System.out.println("my browser   "+browserName);
		System.out.println("my browser   "+browserName);
		System.out.println("my browser   "+browserName);
		System.out.println("my browser   "+browserName);
		System.out.println(url1);
		
	
		
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else
		{
			// if  browserName=="IE"
			System.setProperty("webdriver.chrome.driver", "C:\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE); //here the virtual copy of screen shot taken
		
		String destinationFile =System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		
		FileUtils.copyFile(sourceFile, new File(destinationFile));
		return destinationFile;
	}
	
	
}
