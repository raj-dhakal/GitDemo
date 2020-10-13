package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By profile = By.xpath("//*[@class='sidebar-holder']/ul/li[3]");
	
	
	public WebElement getProfile() {
		return driver.findElement(profile);
	}

}
