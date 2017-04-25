package com.SpreadSheet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class ProductProfile 
{
	
	 private WebDriver driver;
		private Properties props;
		
	 public  ProductProfile(WebDriver driver)
		 {
			 this.driver=driver;
			 props=new Utils(driver).getProperty("Properties/ProductProfileUtil.properties");
			String searchEdition=props.getProperty("searchEdition1");
			 
		 }

	 public EditUrl productProfile() throws IOException
		 {
			 driver.findElement(By.xpath(props.getProperty("editionButton1"))).click();
		//	    		By byCss = By.cssSelector(searchEdition);
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         List<WebElement> editionList = driver.findElements(By.cssSelector("#editionsAndPricing li.adb-stack--item a[href*='editions'] span"));
                for(WebElement edition: editionList) 
                {
                    if(edition.getAttribute("innerHTML").equals("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)")) {
                        driver.findElement(By.cssSelector("#editionsAndPricing li.adb-stack--item a[href*='editions']")).click();
                    }
                    break;
                }
	            
                
	          return new EditUrl(driver);
	    	 
	    }
	    
	   
}
