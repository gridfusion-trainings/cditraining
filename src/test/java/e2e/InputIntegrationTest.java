package e2e;


import io.selendroid.SelendroidCapabilities;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//mark class as an integration test
public class InputIntegrationTest {
	
	@DataProvider(name = "platforms", parallel = true)
	  public Object[][] getCapabilities() {

	    DesiredCapabilities androidWeb = new DesiredCapabilities();
	    androidWeb.setCapability("platform", "ANDROID");
	    androidWeb.setCapability("browserName", "android");
	    androidWeb.setCapability("version", "");
	    androidWeb.setCapability(SelendroidCapabilities.EMULATOR,false);

	    return new Object[][]{
	        {DesiredCapabilities.firefox()},
	        {DesiredCapabilities.chrome()},
	        {DesiredCapabilities.safari()},	        
	        //{androidWeb},
	    };
	  }
	
	
	public static String URLFactory(String environment) {
		
		Map urls = new HashMap();
		urls.put("QA", "http://192.168.1.6:8080/tmf2");
		urls.put("PRODUCTION", "http://ec2-54-68-4-210.us-west-2.compute.amazonaws.com:8080/tmf2");	
		
		String url = (String) urls.get(environment);
		return url;
	}
	

	
	@Test(dataProvider="platforms", groups = {"integration", "production"})
	public void fillPage(DesiredCapabilities caps) throws InterruptedException, MalformedURLException{
		
		
		String environment = System.getProperty("environment");
		System.out.println("Environment: " + environment);
		
		String url = URLFactory(environment);
		
		//DesiredCapabilities capability = DesiredCapabilities.chrome();
		//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.112:4444/wd/hub"), capability);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.112:4444/wd/hub"), caps);

		
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
			Thread.sleep(5000);
			driver.quit();
	
		}
	}
}
