package com.hardik.seleniumAssignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Util {
	WebDriver webDriver;
	WebDriverWait wait;
	public Util(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public void waitVisibilityConditionById(String waitSelector,int time) throws IOException{
	    wait = new WebDriverWait(webDriver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(waitSelector)));
	}
	
	public void waitVisibilityConditionByLinkText(String waitSelector,int time) throws IOException{
	    wait = new WebDriverWait(webDriver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(waitSelector)));
	}
	
}
