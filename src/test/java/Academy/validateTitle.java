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

public class validateTitle extends base{
	
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		log.info("Driver is initialized");
		driver.get(url1);
		log.info("Navigated to home page");
		
	}
	
	@Test
	public void ValidateTitle() throws IOException, InterruptedException
	{  
		
		
//LANDING PAGE
		
		LandingPage landobj= new LandingPage(driver);
	
//	Test : whether the txt is present or not in landing page 		
		String landpageTxt=landobj.getLandpageText().getText();
		System.out.println(landpageTxt);
		Assert.assertEquals(landpageTxt,"FEATURED 01COURSES");
		log.info("successfully validated text message");

		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		
	}
	



}
