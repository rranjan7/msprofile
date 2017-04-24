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
		
	 public  ProductProfile(WebDriver driver)
		 {
			 this.driver=driver;
			 
		 }
//	 +++++++++++++++++++++++++++++++++++++++++++++++++++++
	 String editionButton;
	 String searchEdition;
		
     public void fileRead() throws IOException
     {
     	FileRead file=new FileRead();
      Properties pr=file.fileRead("Utils/ProductProfileUtil.properties");
//      =pr.getProperty("");
      editionButton=pr.getProperty("editionButton1");
      searchEdition=pr.getProperty("searchEdition1");
     }
     
//	 +++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	 
		 public ProductProfile editionsButton() throws IOException
		 {fileRead();
			 driver.findElement(By.xpath(editionButton)).click();
			return new ProductProfile(driver);
		 }
	    public WebDriver searchEdition() throws IOException
	    {
	    	fileRead();
//	    		By byCss = By.cssSelector(searchEdition);

	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	              
                List<WebElement> editionList = driver.findElements(By.cssSelector("#editionsAndPricing li.adb-stack--item a[href*='editions'] span"));
                for(WebElement edition: editionList) {
//                      System.out.println(edition.getAttribute(“innerHTML”));
                    if(edition.getAttribute("innerHTML").equals("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)")) {
                        driver.findElement(By.cssSelector("#editionsAndPricing li.adb-stack--item a[href*='editions']")).click();
                    }
                    break;
                }
	            
                
	          return driver;
	    	 
	    }
	    
	   
}
