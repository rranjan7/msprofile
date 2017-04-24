package com.SpreadSheet;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage 
{
		private WebDriver driver;

		public  HomePage(WebDriver driver)
		{
			this.driver=driver;
		}
		String url1;
		String Loginbutton;
        public void fileRead() throws IOException
        {
        	FileRead file=new FileRead();
         Properties pr=file.fileRead("Utils/Homepage.properties");
         url1=pr.getProperty("url");
         Loginbutton=pr.getProperty("loginButtonXpath");
        }
		
	  public HomePage openUrl() throws IOException
	    {
		  fileRead();
		  driver.get(url1);
		return new HomePage(driver);
		  
	    }
	  public WebDriver logInButton() throws IOException
	  	{
		  fileRead();
		  
		  driver.findElement(By.xpath(Loginbutton)).click();
		  return driver;
	  	}  
    
	  
	  
	}
