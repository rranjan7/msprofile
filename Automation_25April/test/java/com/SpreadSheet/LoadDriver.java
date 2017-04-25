package com.SpreadSheet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class LoadDriver {

	public static WebDriver webDriver;
	
	@BeforeClass
	public void loadDriver() throws Exception{
//		Reporter.log("Starting The Browser");
//		GoogleSheetAccess googleSheetAccess=new GoogleSheetAccess();
//		googleSheetAccess.getList();
		Reporter.log("Opening the Browser Page",true);
		Browser browser=new Browser();
		webDriver=(WebDriver) browser.getDriver();
		
	}
	
	@AfterClass
	public void destroyDriver() throws InterruptedException{
		Reporter.log("Closing the App");
//		webDriver.close();
	}
}
