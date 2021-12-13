package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.ForgotPassPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	
		private static Logger log=LogManager.getLogger(base.class.getName());
		
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		System.out.println(url1);
		
	}
	
	@Test (dataProvider="getData")
	public void basePageNavigation(String email , String pass, String txt) throws IOException, InterruptedException
	{
		
		
		driver.get(url1);
		
		
//LANDING PAGE
		
		LandingPage landobj= new LandingPage(driver);

	
		
//LOGING PAGE
		LoginPage logobj=landobj.getLogin();
		
//Test :givn email and password in login page
		logobj.getEmail().sendKeys(email);
		logobj.getPassword().sendKeys(pass);
		//System.out.println(txt);
		log.info(txt);
		
		Thread.sleep(1000);
//Test :click on login button in login page
		logobj.getLoginButton().click();// here the page not navigate to another page
		ForgotPassPage fp=logobj.getForgotPassword();
		fp.getEmail().sendKeys("xxxxx");
		fp.getSendMeInstruction().click();
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] dat= new Object[2][3]; //[column][row]
		
		dat[0][0]="surya@yahoo.com";
		dat[0][1]="12344";
		dat[0][2]="Restricted User";
		
		dat[1][0]="pran@yahoo.com";
		dat[1][1]="14566";
		dat[1][2]="Non Restricted User";
		
		return dat;

	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
