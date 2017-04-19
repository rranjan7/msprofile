

package com.appdirect.price;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ReadSpreadsheet {
		   
	@Test
		   public void testCase() throws IOException
		      {
			 WebDriver driver=new ChromeDriver();
			    System.setProperty("webdriver.chrome.driver","chromedriver");
			    driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			     
			    //Website
					driver.get("http://www.gmail.com");		
				//mailid	
			    WebElement element=driver.findElement(By.id("Email"));
				element.sendKeys("esha.vij@appdirect.com");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
				//clicknext
				 element=driver.findElement(By.xpath("//*[@id='next']"));
				element.click();
				//usernameandpassword
				driver.findElement(By.xpath("//*[@id='username']")).sendKeys("esha.vij@appdirect.com");
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Welcome!");
				
				//clicklogin
				 element=driver.findElement(By.xpath("//*[@id='id7']"));
					element.click();
					//link
					
					driver.get("https://drive.google.com/open?id=0B9R9YQ9A5etic0tjZEVPcHJuWFE");
				
					new Spreadsheet().readSpreadsheet();
		      
		      }
}
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			  
		








