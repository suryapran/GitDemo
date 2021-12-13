package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import resources.base;

public class validateNavigationBar extends base {
	
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		driver.get(url1);
		
	}
	
	
	@Test
	public void ValidateNavigation() throws IOException, InterruptedException
	{
		
		
		
//LANDING PAGE
		
		LandingPage landobj= new LandingPage(driver);
	
//	Test : whether the txt is present or not in landing page 		
	//landobj.getNavigationBar().isDisplayed();
		//System.out.println("display :"+landobj.getNavigationBar().isDisplayed());
	Assert.assertTrue(landobj.getNavigationBar().isDisplayed());
	
	log.info("Navigationbar is displayed");

		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
