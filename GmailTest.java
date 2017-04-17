package gSheetTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GmailTest {

	@Test
	public void gmailPage() throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://gmail.com");
//		driver.findElement(By.id("Email")).sendKeys("asheesh.kumar@appdirect.com");
//		driver.findElement(By.xpath("//*[@id='next']")).click();
//		
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.findElement(By.id("username")).sendKeys("asheesh.kumar@appdirect.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("");
//		driver.findElement(By.xpath("//*[@id='id7']")).click();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a")).click();
//		driver.findElement(By.xpath("//*[@id='gb283']/span[1]")).click();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream fin = new FileInputStream(new File("config.properties"));
		Properties pr = new Properties();
		pr.load(fin);
		String emailId = pr.getProperty("emailId");
		String password = pr.getProperty("password");

		driver.get("https://drive.google.com/open?id=0B9R9YQ9A5etic0tjZEVPcHJuWFE");
		driver.findElement(By.id("Email")).sendKeys(emailId);
		driver.findElement(By.xpath("//*[@id='next']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys(emailId);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='id7']")).click();

		
//		driver.close();
	}
}
