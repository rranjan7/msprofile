package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedList 
	{ 
		private WebDriver driver;
		public   SearchedList(WebDriver driver)
		{
			 this.driver=driver;
		}
		
		
		//+++++++++++++++++++++++++++
		
		String firstLinkClick;
		
        public void fileRead() throws IOException
        {
        	FileRead file=new FileRead();
         Properties pr=file.fileRead("Utils/SearchedListUtils.properties");
//         =pr.getProperty("");
         firstLinkClick=pr.getProperty("firstLinkClick1");
        }
        
        //+++++++++++++++++++++++++++++
		public WebDriver firstLinkAfterSearch() throws IOException
		 {
			fileRead();
			  driver.findElement(By.cssSelector(firstLinkClick)).click();
			  return driver;
		 }
	}
