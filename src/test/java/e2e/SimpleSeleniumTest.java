package e2e;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SimpleSeleniumTest {

	@Test
	public void ciscoTest2() throws IOException, InterruptedException {


		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("video", true);
		RemoteWebDriver driver =
				new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);



		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);


		//System.out.println(getVideoURLNew(driver));

		//go to homepage
		Reporter.log("Opening CS homepage");
		driver.get("https://www.credit-suisse.com/ch/en.html");
		//System.out.println("http://"+HUB_HOST+":4444/grid/resources/liveView?session=" + driver.getSessionId().toString());

		//click on login
		Reporter.log("Clicking login button");
		driver.findElement(By.id("btn_login")).click();
		Thread.sleep(3000);

		Reporter.log("Clicking Online Banking Link ");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Online Banking")));
		driver.findElement(By.xpath("//*[@id=\"mod_login_selector\"]/div/section/div[1]/section[1]/ul/li[1]/a")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("here.")));
		driver.findElement(By.linkText("here.")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("4711");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button")));
		driver.findElement(By.className("button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
		Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your login is invalid"));

		//Thread.sleep(3000);

		driver.quit();
	}



}
