package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	  private WebDriver driver;
	  
	  public  LogInPage(WebDriver driver)
	  {
		 this.driver=driver;
		 
	  }
	  //Utils package calling
	  
	  String email;
		String usernameId;
		String passwordId;
		String password;
		String loginButtonId;
      public void fileRead() throws IOException
      {
      	FileRead file=new FileRead();
       Properties pr=file.fileRead("Utils/LoginPageUtil.properties");
       email=pr.getProperty("eMail1");
       usernameId=pr.getProperty("usernameId1");
       passwordId=pr.getProperty("passwordId1");
       password=pr.getProperty("password1");
       
       loginButtonId=pr.getProperty("loginButtonId1");
      }
      
      
	  public LogInPage putUserName() throws IOException
      { fileRead();
		  driver.findElement(By.id(usernameId)).sendKeys(email);
		  return new LogInPage(driver);
      }
      public LogInPage putPassword() throws IOException
      {  fileRead();
		  driver.findElement(By.id(passwordId)).sendKeys(password);
		  return new LogInPage(driver);
      }
      public WebDriver loginAfterPassword() throws IOException
	  {fileRead();
		  driver.findElement(By.id(loginButtonId)).click();
		  return driver;
	  }
	

}
