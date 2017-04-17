package com.hardik.seleniumAssignment;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpreadSheet {

WebDriver webDriver;
	public String GOOGLE_ACCOUNT_USERNAME = "hardik.ranjan@appdirect.com"; 
	public String GOOGLE_ACCOUNT_PASSWORD = "Welcome!";
	public String SPREADSHEET_URL = "https://spreadsheets.google.com/feeds/spreadsheets/1L8xtAJfOObsXL-XemliUV10wkDHQNxjn6jKS4XwzYZ8"; 

	@Test
	public void run() throws IOException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
    	webDriver = new ChromeDriver();
    	webDriver.get("http://www.gmail.com");
        
        webDriver.findElement(By.id("Email")).sendKeys(GOOGLE_ACCOUNT_USERNAME);
        webDriver.findElement(By.id("next")).click();
        
        new Util(webDriver).waitVisibilityConditionById("username", 20);
        
        webDriver.findElement(By.id("username")).sendKeys(GOOGLE_ACCOUNT_USERNAME);
        webDriver.findElement(By.id("password")).sendKeys(GOOGLE_ACCOUNT_PASSWORD);
    	webDriver.findElement(By.xpath("//*[@id='id7']")).click();
    	webDriver.get("https://drive.google.com/drive/folders/0B9R9YQ9A5etieExOVDJzdTFnUjQ");
    	
    	//String parentHandle = webDriver.getWindowHandle();
    	
    	//Alert alert=webDriver.switchTo().alert();
        //String alertMessage=webDriver.switchTo().alert().getText();
       // System.out.println(alertMessage);       
        //alert.accept();
       /* new Util(webDriver).waitVisibilityConditionByLinkText("Price Lists", 20);
        WebElement element = webDriver.findElement(By.linkText("Price Lists"));
        Actions builder = new Actions(webDriver);
        builder.doubleClick(element).perform();
    	*/
    	
    	webDriver.get("https://drive.google.com/open?id=0B9R9YQ9A5etic0tjZEVPcHJuWFE");
    	
    	new Data().readData();
    	
    	
    	
	}
}
