package com.SpreadSheet;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.services.sheets.v4.Sheets;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadDataFromSpreadSheet 
{
	public static WebDriver driver;
	private static final String APPLICATION_NAME = "Google Sheets API Quickstart";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),".credentials/23/sheets.googleapis.com-java-quickstart.json");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS, SheetsScopes.DRIVE);
    public static String editionName = null;

	static 
	{
		try 
		{
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) 
		{
			t.printStackTrace();
			System.exit(1);
		}
	}
	public ReadDataFromSpreadSheet(WebDriver driver)
	{
		this.driver=driver;
	}

	public static Credential authorize() throws Exception 
	{
		InputStream in = ReadDataFromSpreadSheet.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
	    clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	public static Sheets getSheetsService() throws Exception 
	{
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}

		public WebDriver sheetList() throws Exception
		{
		Sheets service = getSheetsService();
		

		String spreadsheetId = "11TeFVUDVKt1AhQJRIgICb2Hx-EJfVhUNHCtPisagGOc";

		String range = "USD!3:10";
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
		if (values == null || values.size() == 0) 
		{
			System.out.println("No data found.");
		} else 
		{
			for (List row : values) 
		
			{
				
				FileRead fileReadObject = new FileRead();
				Properties pr = fileReadObject.fileRead("SearchByID.properties");
				if (row.get(3).equals(pr.getProperty("id1"))) 
				{
					System.out.printf("USD:%s, %s\n", row.get(3), row.get(10));
				 editionName= (String) row.get(3);
				
				}
		    }
		}
		
		return driver;
		}
	
}
	

