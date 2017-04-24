package com.SpreadSheet;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.SpreadSheet.HomePage;
public class AppdirectTest extends LoadDriver {
	@Test
	public void homePageTest() throws IOException 
	{
		Reporter.log("Opening the Appdirect HomePage",true);
		webDriver=(WebDriver) new HomePage(webDriver)
				.openUrl()
				.logInButton();
	}
	@Test(dependsOnMethods = { "homePageTest" })
	public void loginPageTest() throws IOException 
	{ 
		Reporter.log("Opening the Login Page",true);
		webDriver=(WebDriver) new LogInPage(webDriver)
				.putUserName()
				.putPassword()
				.loginAfterPassword();
	}
	@Test(dependsOnMethods = { "loginPageTest" })
	public void SearchProductPage() throws IOException 
	{  
		Reporter.log("Opening the Search Product  Page",true);
		webDriver=(WebDriver) new SearchProduct(webDriver)
				.searchByEditionName()
				.searchButton();
	}
	@Test (dependsOnMethods = { "SearchProductPage" })
	public void ListPage() throws IOException
	{ 
		Reporter.log("Opening the List Page",true);
		webDriver=(WebDriver) new SearchedList(webDriver)
				.firstLinkAfterSearch();
		
	}
	@Test (dependsOnMethods = { "ListPage" })
	public void ProductProfilePage() throws IOException
	{
		Reporter.log("Opening the Product Profile Page",true);
		webDriver=(WebDriver) new ProductProfile(webDriver)
				.editionsButton()
				.searchEdition();
		
	}
	public void EditUrlPage() throws IOException
	{
		Reporter.log("Opening the Edit Url Page",true);
		webDriver=(WebDriver) new EditUrl(webDriver)
				.editAppUrl().openEdition();
		
	}
}