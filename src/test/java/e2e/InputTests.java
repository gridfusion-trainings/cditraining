package e2e;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InputTests {
	
	@Test
	public void fillPage() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/tmf2");
		driver.findElement(By.id("firstname")).sendKeys("MICHAEL");
		driver.findElement(By.id("lastname")).sendKeys("PALOTAS");
		driver.findElement(By.id("dob")).sendKeys("02/09/1936");
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
