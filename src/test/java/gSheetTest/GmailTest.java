package gSheetTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GmailTest {

	@Test
	public void gmailPage() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://gmail.com");
//		driver.findElement(By.id("Email")).sendKeys("asheesh.kumar@appdirect.com");
//		driver.findElement(By.xpath("//*[@id='next']")).click();
//		
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.findElement(By.id("username")).sendKeys("asheesh.kumar@appdirect.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("#gutthipalak34#");
//		driver.findElement(By.xpath("//*[@id='id7']")).click();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
//		driver.findElement(By.xpath("//*[@id='gb283']/span[1]")).click();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://drive.google.com/drive/folders/0B9R9YQ9A5etiUUowdHh4d0JkTjg");
		driver.findElement(By.id("Email")).sendKeys("asheesh.kumar@appdirect.com");
		driver.findElement(By.xpath("//*[@id='next']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("asheesh.kumar@appdirect.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("#gutthipalak34#");
		driver.findElement(By.xpath("//*[@id='id7']")).click();

		
//		driver.close();
	}
}
