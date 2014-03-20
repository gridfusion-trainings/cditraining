package e2e;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InputTest {
	
	/*
	@Test
	public void fillPage() throws InterruptedException, MalformedURLException{
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		driver.get("http://localhost:8080/tmf2");
		driver.findElement(By.id("firstname")).sendKeys("MICHAEL");
		driver.findElement(By.id("lastname")).sendKeys("PALOTAS");
		driver.findElement(By.id("dob")).sendKeys("02/09/1936");
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	*/

}
