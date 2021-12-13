package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver1)
	{
		this.driver =  driver1;
	}
	
	By email=By.cssSelector("#user_email");
	By password=By.cssSelector("#user_password");
	By loginbutton=By.cssSelector("input[value='Log In']");
	By forgotPass=By.xpath("//a[@class='link-below-button']");

	
	public ForgotPassPage getForgotPassword()
	{
		driver.findElement(forgotPass).click();
		ForgotPassPage forgotObj=new ForgotPassPage(driver);
		return forgotObj;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginbutton);
	}
}
