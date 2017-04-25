package com.SpreadSheet;

import org.openqa.selenium.WebDriver;

public class Verify 
{
	private WebDriver driver;

	public Verify(WebDriver driver)
	{
		this.driver=driver;
	}
 public Verify CompareUSD()
 {
	 String pricesUSD=Prices.text;
	 String pricesUSD1="ssd";
	 if(pricesUSD.equals(pricesUSD1)){
		 
	 }
	 System.out.println(Prices.text); 
	 return new Verify(driver);
	 
 }
 
 public Verify CompareAUD()
 {
	 String pricesAUD=Prices.text1;
	 String pricesAUD1="ssd";
if(pricesAUD.equals(pricesAUD1)){
		 
	 }
	 return new Verify(driver);
 }
 
 public Verify CompareEUR()
 { String pricesEUR=Prices.text2;
 String pricesEUR1="ssd";
 if(pricesEUR.equals(pricesEUR1)){
	 
 }
	 return new Verify(driver);
 }
 
 public WebDriver CompareGBP()
 {
	 String pricesGBP=Prices.text3;
	 String pricesGBP1="ssd";
if(pricesGBP.equals(pricesGBP1)){
		 
	 }
	 return driver;
 }
}
