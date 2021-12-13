package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver2;
	
	public LandingPage(WebDriver driver1)
	{
		this.driver2=driver1;
		
		
	}
	
	//get the element object in this landing page only
	By login=By.xpath("//span[normalize-space()='Login']");
	By landtxt=By.xpath("//h2[normalize-space()='Featured Courses']");
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	

	
	public LoginPage getLogin()
	{
		 driver2.findElement(login).click();
//here when click perfome the page navigate to another page so create obj of next page as below for optimization
		 LoginPage logobj = new LoginPage(driver2);
		 return logobj;
	}
	
	public WebElement getLandpageText()
	{
		
		return driver2.findElement(landtxt);
	}
	
	public WebElement getNavigationBar()
	{
		
		return driver2.findElement(navBar);
	}

}
