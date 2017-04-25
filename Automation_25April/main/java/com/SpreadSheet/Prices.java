package com.SpreadSheet;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Prices 
{
	public static String text;
	public static String text1;
	public static String text2;
	public static String text3;
	WebDriver driver;
	Properties props;
	public Prices(WebDriver driver)
	{
		this.driver=driver;
		props=new Utils(driver).getProperty("Properties/PricesUtils.properties");	
	}
	
	public Prices getUSD() throws IOException
	{   
		
		 text=driver.findElement(By.xpath(props.getProperty("PricesUSD"))).getAttribute("value");
		System.out.println(text);
		return new Prices(driver);
	}
	public Prices getAUD() throws IOException
	{
		
		text1=driver.findElement(By.xpath(props.getProperty("PricesAUD"))).getAttribute("value");
		System.out.println(text1);
		return new Prices(driver);
	} 
	
	public Prices getEUR() throws IOException
	{
		
		text2=driver.findElement(By.xpath(props.getProperty("PricesEUR"))).getAttribute("value");
		System.out.println(text2);
		return new Prices(driver);
	}
	
	public Verify getGBP() throws IOException
	{
		
		text3=driver.findElement(By.xpath(props.getProperty("PricesGBP"))).getAttribute("value");
		System.out.println(text3);
		return new Verify(driver);
	}

}
