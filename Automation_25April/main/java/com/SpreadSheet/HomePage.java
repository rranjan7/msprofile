package com.SpreadSheet;



import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
public class HomePage 
{
		private WebDriver driver;
		private Properties props;
		private String loginButton;
		public  HomePage(WebDriver driver)
		{
			this.driver=driver;
			props=new Utils(driver).getProperty("Properties/Homepage.properties");
		}
		
	  public LogInPage clickLogInButton() throws IOException
	  	{
		  System.out.println("bhyhd");
		  driver.get(props.getProperty("chromeDriverPath"));
//		  loginButton=props.getProperty("loginButtonXpath");
		  new Utils(driver).getElement(props.getProperty("loginButtonXpath")).click();
		  return new LogInPage(driver);
	  	}

	}
