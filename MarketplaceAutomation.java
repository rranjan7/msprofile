package com.appdirect.nitya.automation_project;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MarketplaceAutomation {
	WebDriverWait wait;
	
	
	
@Test
	public void sheetAccess() throws Exception{
		GoogleSheetAccess start=new GoogleSheetAccess();
		start.getList();
	}
	
	
}
   