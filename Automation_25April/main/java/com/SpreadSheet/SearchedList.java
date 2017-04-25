package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedList 
	{ 
		private WebDriver driver;
		Properties props;
		String firstLinkClick;
		
		public   SearchedList(WebDriver driver)
		{
			 this.driver=driver;
			 props=new Utils(driver).getProperty("Properties/SearchedListUtils.properties");
		}
	
		public ProductProfile firstLinkAfterSearch() throws IOException
		 {
			
			  driver.findElement(By.cssSelector(props.getProperty("firstLinkClick1"))).click();
			  return new ProductProfile(driver);
		 }
	}
