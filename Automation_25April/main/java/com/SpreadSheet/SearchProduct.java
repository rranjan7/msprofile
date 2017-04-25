package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	
	 private WebDriver driver;
	 Properties props;
		public  SearchProduct(WebDriver driver)
		 {
			 this.driver=driver;
			 props=new Utils(driver).getProperty("Properties/SearchProductUtils.properties");
			}
		 
		
	 public SearchedList searchByEditionName() throws IOException
	  {
		
		  driver.findElement(By.cssSelector(props.getProperty("serachBar1"))).sendKeys("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)");
	      
	
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector(props.getProperty("searchButton1"))).click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      return new SearchedList(driver);
	  }
	  
}
