package smokeprod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SmokeTest {
	
    @Test(groups = {"production"})
	public void fillPage() throws InterruptedException, MalformedURLException{
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://ec2-50-112-182-162.us-west-2.compute.amazonaws.com:8080/tmf2");
		driver.findElement(By.id("firstname")).sendKeys("Tulip");
		driver.findElement(By.id("lastname")).sendKeys("Palotas");
		driver.findElement(By.id("dob")).sendKeys("10/01/2003");

		try {	
			driver.findElement(By.id("submitbutton")).click();
			Thread.sleep(2000);
		}
		finally {
			driver.quit();
	
		}

	}

}
