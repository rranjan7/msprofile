package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	
	 private WebDriver driver;
		public  SearchProduct(WebDriver driver)
		 {
			 this.driver=driver;
		 }
		//============
String serachBar;
String searchButton;
		
        public void fileRead() throws IOException
        {
        	FileRead file=new FileRead();
         Properties pr=file.fileRead("Utils/SearchProductUtils.properties");
//         =pr.getProperty("");
         serachBar=pr.getProperty("serachBar1");
         searchButton=pr.getProperty("searchButton1");
        }
        
        //================
	 public SearchProduct searchByEditionName() throws IOException
	  {
		 fileRead();
//		  System.out.println(ReadDataFromSpreadSheet.editionName);
		  driver.findElement(By.cssSelector(serachBar)).sendKeys("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)");
	      return new SearchProduct(driver);
	  }	
	 public WebDriver searchButton() throws IOException
	  {
		 fileRead();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector(searchButton)).click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      return driver;
	  }
	  
}
