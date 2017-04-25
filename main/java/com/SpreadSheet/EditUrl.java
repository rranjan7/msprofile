package com.SpreadSheet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class EditUrl {
	private WebDriver driver;

	public EditUrl(WebDriver driver)
	{
		this.driver=driver;
	}
	String parentSelectorOfEdition;
	 String editionButton;
		
    public void fileRead() throws IOException
    {
    	FileRead file=new FileRead();
     Properties pr=file.fileRead("Utils/EditUrlUtils.properties");
     editionButton=pr.getProperty("editionButton1");
     parentSelectorOfEdition=pr.getProperty("parentSelectorOfEdition1");
    }
	
	 public EditUrl editAppUrl()
	    {
	    	String url = driver.getCurrentUrl();
	    	String editedUrl=url.replace("apps", "channel/editApp");
	        driver.get(editedUrl);
	        return new EditUrl(driver);
	    }
	    
	    public WebDriver openEdition()
	    {
	    	driver.findElement(By.xpath(editionButton)).click();
         List<WebElement> listElement = driver.findElements(By.cssSelector(parentSelectorOfEdition));
	        for(WebElement list: listElement)
	            { System.out.println(list.getAttribute("innerHTML"));
	            	
	            	 if(list.getText().equals("Dynamics 365 for Sales, Enterprise Edition (Government Pricing)"))
		              {
	            		 System.out.println("dncnchd"+list.getAttribute("innerHTML"));
//	            		 break;
		              }
		              else
		              {
		            	  Reporter.log("Edition not found");}
	            }
	            
	        return driver;
	    }

}
