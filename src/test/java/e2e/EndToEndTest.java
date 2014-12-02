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
import org.uiautomation.ios.IOSCapabilities;
import org.uiautomation.ios.communication.device.DeviceVariation;

//mark class as an integration test
public class EndToEndTest {
	
	//local remote webdriver
	public final String GRIDURL="http://localhost:4444/wd/hub";
	
	//Selenium Grid Hub with Android on OSX
	//public final String GRIDURL="http://192.168.1.112:4444/wd/hub";

	
	@DataProvider(name = "platforms", parallel = true)
	  public Object[][] getCapabilities() {

		//Android
	    DesiredCapabilities androidWeb = new DesiredCapabilities();
	    androidWeb.setCapability("platform", "ANDROID");
	    androidWeb.setCapability("browserName", "android");
	    androidWeb.setCapability("version", "");
	    androidWeb.setCapability(SelendroidCapabilities.EMULATOR,false);
	    
	    //IPAD
	    IOSCapabilities ipad = IOSCapabilities.ipad("Safari");
	    ipad.setBrowserName("mobile safari/ipad");

	    
	    return new Object[][]{
	    	{DesiredCapabilities.firefox()},
	    	{DesiredCapabilities.chrome()},
	    	//{DesiredCapabilities.safari()},	        
	    	//{androidWeb},
	    	//{ipad},
	    };
	  }
	
	
	public static String URLFactory(String environment) {
		
		Map<String, String> urls = new HashMap<String, String>();
		urls.put("QA", "http://localhost:8080/tmf3");
		urls.put("PRODUCTION", "http://ec2-54-68-17-140.us-west-2.compute.amazonaws.com:8080/tmf3");	
		urls.put("VAGRANT", "http://192.168.1.150:8080/tmf2/");	
		
		String url = (String) urls.get(environment);
		return url;
	}
	

	
	@Test(dataProvider="platforms", groups = {"end2end", "production"})
	public void fillPage(DesiredCapabilities caps) throws InterruptedException, MalformedURLException{
		
		
		String environment = System.getProperty("environment");
		System.out.println("Environment: " + environment + "   Browser: " + caps.getBrowserName());
		
		String url = URLFactory(environment);		
		WebDriver driver = new RemoteWebDriver(new URL(GRIDURL), caps);
		
		driver.get(url);

		try {
			driver.findElement(By.id("firstname")).sendKeys("Michael");
			driver.findElement(By.id("lastname")).sendKeys("Palotas");			
			driver.findElement(By.id("submitbutton")).click();	
			Assert.assertEquals(driver.getTitle(), "MF Engineering");
		}
		finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
