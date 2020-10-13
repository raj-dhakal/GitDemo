package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientLoginPage {
	
public WebDriver driver;
	
	public PatientLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By userName = By.id("username");
	private By password = By.id("password");
	private By submit = By.cssSelector("[type='submit']");
	
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}

}
