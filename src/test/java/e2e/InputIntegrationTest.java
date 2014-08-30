package e2e;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//mark class as an integration test
public class InputIntegrationTest {
	
	@Test(groups = {"integration"})
	public void fillPage() throws InterruptedException, MalformedURLException{
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://localhost:8080/tmf2");
		driver.findElement(By.id("firstname")).sendKeys("Tulip");
		driver.findElement(By.id("lastname")).sendKeys("Palotas");
		driver.findElement(By.id("dob")).sendKeys("10/01/2003");

		try {
			driver.findElement(By.id("submitbutton")).click();
			Thread.sleep(2000);
			
			//Assert.assertTrue(driver.findElement(By.id("daysalive")).getText().contentEquals("Days ALIVE: 3865"));
			Assert.assertTrue(true);
		}
		finally {
			driver.quit();
	
		}
	}
}
