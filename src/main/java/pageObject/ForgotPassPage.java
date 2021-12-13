package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassPage {
	
	public WebDriver driver2;
	
	public ForgotPassPage(WebDriver driver1)
	{
		this.driver2=driver1;
		
		
	}
	
	//get the element object in this landing page only
	By forgotEmail = By.cssSelector("#user_email");
	By sendinstr=By.xpath("//input[@name='commit']");

	
	public WebElement getEmail()
	{
		return driver2.findElement(forgotEmail);
	}
	
	public WebElement getSendMeInstruction()
	{
		return driver2.findElement(sendinstr);
	}
	
	

}
