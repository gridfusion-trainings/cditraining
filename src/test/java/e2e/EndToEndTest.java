package e2e;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//mark class as an integration test
public class EndToEndTest {
	
	//local remote webdriver
	public final String GRIDURL="http://10.0.2.15:4444/wd/hub";

	@DataProvider(name = "platforms", parallel = true)
	  public Object[][] getCapabilities() {
	    
	    return new Object[][]{
	    	//{DesiredCapabilities.firefox()},
	    	{DesiredCapabilities.chrome()},
	    };
	  }
	
	
	public static String URLFactory(String environment) {
		
		Map<String, String> urls = new HashMap<String, String>();
		urls.put("QA", "http://172.17.0.3:8080/tmf2/"); //goes to docker container
		//urls.put("PRODUCTION", "http://ec2-54-213-34-255.us-west-2.compute.amazonaws.com:8080/tmf2/");
		urls.put("PRODUCTION", "http://172.17.0.4:8080/tmf2");
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
		System.out.println("PAGE TITLE: " + driver.getTitle());

		try {
			driver.findElement(By.id("firstname")).sendKeys("Michael");
			driver.findElement(By.id("lastname")).sendKeys("Palotas");			
			driver.findElement(By.id("submitbutton")).click();
			Thread.sleep(50); //TODO: this should be removed. Bug in Selenium3?
			Assert.assertEquals(driver.getTitle(), "Digicomp Result");
		}
		finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}
}
