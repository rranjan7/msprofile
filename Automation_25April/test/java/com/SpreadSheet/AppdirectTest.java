package com.SpreadSheet;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.SpreadSheet.HomePage;
public class AppdirectTest 
{
	public HomePage homePage;
	public LogInPage logInPage;
	public SearchProduct searchProduct;
	public SearchedList searchedList;
	public ProductProfile productProfile;
	public EditUrl editUrl;
	public Prices prices;
	public Verify verify;
	public String baseUrl;
	public Utils util;
	public WebDriver webDriver;
	@BeforeSuite
    public void getEdtions() throws Exception{
        GoogleSheetAccess googleSheetAccess = new GoogleSheetAccess();
        googleSheetAccess.getList();
    }

    @BeforeTest
    public void getDriver() throws IOException{
//    	util=new Utils();
//    	webDriver=util.getDriver();
//        baseUrl=util.getUrl();
    Browser browser=new Browser();
    browser.getDriver();
    }
    
    @Test
    public void checkEditionPrice() throws IOException
    {
//        new Utils(webDriver).openUrl(baseUrl)
    	webDriver=(WebDriver) new HomePage(webDriver)
        .clickLogInButton()
        .fillCredential()
        .searchByEditionName()
        .firstLinkAfterSearch()
        .productProfile()
        .editAppUrl()
        .openEdition()
        .getUSD()
		.getEUR()
		.getAUD()
		.getGBP()
		.CompareUSD()
	    .CompareAUD()
		.CompareEUR()
		.CompareGBP();
    
    }
}
	    
//        .putUserName()
//		.putPassword()
//        .searchByEditionName()
//		.searchButton()
//        .firstLinkAfterSearch()
//        .editionsButton()
//        .searchEdition();
//        .editAppUrl()
//		.openEdition()
//		.getUSD()
//		.getEUR()
//		.getAUD()
//		.getGBP();
//         .CompareUSD()
//		.CompareAUD()
//		.CompareEUR()
//		.CompareGBP();
//    }
//    
//	@Test
//	public void homePageTest() throws IOException 
//	{
//		Reporter.log("Opening the Appdirect HomePage",true);
//		webDriver=(WebDriver) new HomePage(webDriver)
//				.openUrl()
//				.logInButton();
//		        .putUserName()
//				.putPassword()
//	            .searchByEditionName()
//				.searchButton()
//		        .firstLinkAfterSearch()
//		        .editionsButton()
//		        .searchEdition();
//		        .editAppUrl()
//				.openEdition()
//				.getUSD()
//				.getEUR()
//				.getAUD()
//				.getGBP();
//		         .CompareUSD()
//				.CompareAUD()
//				.CompareEUR()
//				.CompareGBP();
//		
//	}
