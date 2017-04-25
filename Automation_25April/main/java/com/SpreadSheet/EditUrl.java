package com.SpreadSheet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.yaml.snakeyaml.tokens.DirectiveToken;

public class EditUrl {
	private WebDriver driver;
	Properties props;

	public EditUrl(WebDriver driver)
	{
		this.driver=driver;
		props=new Utils(driver).getProperty("Properties/EditUrlUtils.properties");
	}
	
		
    
	
	 public EditUrl editAppUrl() throws IOException
	    {
	    	String url = driver.getCurrentUrl();
	    	String editedUrl=url.replace("apps", "channel/editApp");
	        driver.get(editedUrl);
	        return new EditUrl(driver);
	    }
	    
	    public Prices openEdition() throws IOException
	    {
	    	
	    	driver.findElement(By.xpath(props.getProperty("editionButton1"))).click();
         List<WebElement> listElement = driver.findElements(By.cssSelector(props.getProperty("parentSelectorOfEdition1")));
	        
         for(WebElement list: listElement)
	            { 
	            	int count=0;
	            	count++;
	            	 if(list.getAttribute("innerHTML").equals("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)"))
		              {
	                     driver.findElement(By.linkText("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)")).click();
	            		 System.out.println(count+"dncnchd"+list.getAttribute("innerHTML"));
	            		 break;
		              }
		              else
		              {
		            	  Reporter.log("Edition not found");
		            	  }
//	            	 count++;
	            }
	            
	        return new Prices(driver);
	    }

		
}
