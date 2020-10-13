package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SceduleAppointment {
	
	public WebDriver driver;
	public SceduleAppointment(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By createNewAppointment = By.xpath("//*[@class='sidebar-holder']/ul/li[4]");
	
	public WebElement getAppointment() 
	{
		return driver.findElement(createNewAppointment);
	}
	

}
