package swissraj1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.PatientLoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	//public Properties prop;
	
	
	@BeforeTest
	public void Beforetest() throws IOException
	{

		driver= InitialzeDriver();
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		PatientLoginPage pl = new PatientLoginPage(driver);
		pl.getUserName().sendKeys("ria1");
		pl.getPassword().sendKeys("Ria12345");
		pl.getSubmit().click();
		
		List<WebElement> sideBarElement = driver.findElements(By.xpath("//*[@class='sidebar-holder']/ul/li"));	
		for(int i = 0; i < sideBarElement.size(); i++)
		{
			String s1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.xpath("//*[@class='sidebar-holder']/ul/li")).get(i).sendKeys(s1);
			
		}
		
		
		
		

	}
	
	/*@AfterTest
	
	public void Aftertest()
	{
		driver.close();
		
	}*/
	
	
	

}
