package swissraj1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PatientLoginPage;
import PageObject.SceduleAppointment;
import resources.base;

public class ScheduleAppointmentPage extends base {
	
	
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
		SceduleAppointment sc = new SceduleAppointment(driver);
		sc.getAppointment().click();
		driver.findElement(By.xpath("//*[@class='sidebar-holder']/ul/li[4]")).click();
		driver.findElement(By.cssSelector("[type='submit']")).click();
	
		List<WebElement> doctorNames = driver.findElements(By.xpath("//*[@class='table']/tbody/tr/td/ul/li/h4"));
		int j = 0;
		for(int i = 0; i < doctorNames.size(); i++)
		{
			j++;
			
			String name = driver.findElements(By.xpath("//*[@class='table']/tbody/tr/td/ul/li/h4")).get(i).getText();
			if(name.contains("Beth")) 
			{
				
				
				driver.findElements(By.xpath("//*[@class='table']/tbody/tr/td/ul/li/h4/ancestor::ul/following-sibling::button")).get(i).click();
			
				
			}
			else if(j==doctorNames.size())
			{
				System.out.println("Doctor Name is invalid");
				break;
			}
			
		}
		driver.switchTo().frame("myframe");
		driver.findElement(By.xpath("//*[@id='datepicker']")).click();
		
		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(int i = 0; i < dates.size(); i++)
		{
			String date = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td")).get(i).getText();
			if(date.equalsIgnoreCase("23"))
			{
				driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a")).click();
				break;
			}
		}
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id='time']")));
		s.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id='ChangeHeatName']")).click();
		driver.findElement(By.xpath("//*[@id='sym']")).sendKeys("Fevor and Headache");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		
		

	}
	

}
