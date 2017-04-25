package com.SpreadSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;



public class Browser {	
	
	public WebDriver getDriver() throws IOException
	{
		 String fireFoxPath=null;
		 String safariPath=null;
		 String chromePath=null;
		 WebDriver webDriver=null;
		 String chrome = null;
	     String fileName="Utils/Driver.properties";
		 
		 FileRead common=new FileRead();
			Properties pr=common.fileRead(fileName);
			
			
		 fireFoxPath=pr.getProperty("fireFoxDriverPath");
		 safariPath=pr.getProperty("safariDriverPath");
		 chromePath=pr.getProperty("chromeDriverPath");
		 
		 
		 String browser=System.getProperty("browser");
	if(browser!=null)
	{
		if(browser=="firefox")
	{
		Reporter.log("launching firefox browser",true); 
			System.setProperty("webdriver.gecko.driver",fireFoxPath);
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			System.out.println("Firefox Driver initialized");
			webDriver = new FirefoxDriver(capabilities);
			
	}
		else if(browser=="safari")
	{
			Reporter.log("launching Safari browser",true); 
			webDriver = new SafariDriver();
	}
			else if(browser=="chrome")
    {
				Reporter.log("launching chrome browser",true); 
				System.setProperty("webdriver.chrome.driver", chromePath);
				webDriver = new ChromeDriver();
	}
			
	}else
	{
		Reporter.log("launching chrome browser",true); 
		System.setProperty("webdriver.chrome.driver", chromePath);
		webDriver = new ChromeDriver();

		}
	
			
	
		return webDriver;
		
	}
}