package swissraj1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PatientLoginPage;
import resources.base;

public class LoginPage extends base{
	
	public WebDriver driver;
	//public Properties prop;
	
	
	@BeforeTest
	public void Beforetest() throws IOException
	{

		driver= InitialzeDriver();
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		driver.get(prop.getProperty("url"));
		PatientLoginPage lp = new PatientLoginPage(driver);
		lp.getUserName().sendKeys("ria1");
		lp.getPassword().sendKeys("Ria12345");
		lp.getSubmit().click();
		
		
		
		

	}
	
	@AfterTest
	
	public void Aftertest()
	{
		driver.close();
		
	}
	
	
	

}
