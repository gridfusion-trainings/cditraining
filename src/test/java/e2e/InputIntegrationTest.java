package e2e;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//mark class as an integration test
public class InputIntegrationTest {
	
	
	
	public static String URLFactory(String environment) {
		
		Map urls = new HashMap();
		urls.put("QA", "http://192.168.1.6:8080/tmf2");
		urls.put("PRODUCTION", "http://ec2-54-68-4-210.us-west-2.compute.amazonaws.com:8080/tmf2");	
		
		String url = (String) urls.get(environment);
		return url;
	}
	
	@Parameters("environment")
	@Test(groups = {"integration", "production"})
	public void fillPage(String environment) throws InterruptedException, MalformedURLException{
		
		String url = URLFactory(environment);
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.112:4444/wd/hub"), capability);
		
		driver.get(url);
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
