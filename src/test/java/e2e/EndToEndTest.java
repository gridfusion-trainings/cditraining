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

	public final String GRIDURL="http://localhost:4444/wd/hub";
	//public final String GRIDURL="https://vm-106.element34.net/wd/hub";

	@DataProvider(name = "platforms", parallel = true)
	  public Object[][] getCapabilities() {
	    
	    return new Object[][]{
	    	//{DesiredCapabilities.firefox()},
	    	{DesiredCapabilities.chrome()},
	    };
	  }
	
	
	public static String URLFactory(String environment) {
		
		Map<String, String> urls = new HashMap<String, String>();
		urls.put("QA", "http://172.17.0.2:8080/mf/"); //goes to docker container
		urls.put("AWS", "http://ec2-3-120-160-174.eu-central-1.compute.amazonaws.com:9998/digi");
		urls.put("PRODUCTION", "http://172.17.0.3:8080/mf");

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
			Thread.sleep(50);
			Assert.assertEquals(driver.getTitle(), "Devops Training Result Page");
		}
		finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}
}
