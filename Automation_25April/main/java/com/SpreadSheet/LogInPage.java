package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	  private WebDriver driver;
		private Properties props;
	    public  LogInPage(WebDriver driver)
		{
			this.driver=driver;
			props=new Utils(driver).getProperty("Properties/LoginPageUtil.properties");
		}
      
      
	  public SearchProduct fillCredential() throws IOException
      { 
		
       
		  driver.findElement(By.id(props.getProperty("passwordId"))).sendKeys(props.getProperty("password1"));
		 
      
		  driver.findElement(By.id(props.getProperty("loginButtonId"))).click();
		 
	  return new SearchProduct(driver);
      }

}
