package e2e;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SimpleSeleniumTest {
	
	@Test
	public void simpleSeleniumTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		
		driver.get("http://localhost:8080/tmf2");
		
		WebElement firstname=driver.findElement(By.id("firstname"));
		firstname.sendKeys("Michael");
		
		Thread.sleep(5000);
		driver.quit();

	}

}
