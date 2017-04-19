package com.googlesheet1.GoogleSheet1;

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

// Demonstrates how to make an authenticated API call using OAuth 2 helper classes.

public class GoogleSheet {
    private static final String APPLICATION_NAME ="PriceGoogle";
    
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    
    private static FileDataStoreFactory DATA_STORE_FACTORY;
  
    //jsonFactory which contains jasonparser
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    // Global instance of the HTTP transport.
    private static HttpTransport HTTP_TRANSPORT;

    
    // OAuth 2.0 scopes. 
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try { 
        	// Initialize the transport.
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            
            // Initialize the data store factory.
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
    
    //Authorizes the installed application to access user's protected data.
    
    public static Credential authorize() throws Exception {
        // Load client secrets.
    	//OAuth 2.0 client secrets JSON model as specified in client_secrets.json file format.
          InputStream in = GoogleSheet.class.getResourceAsStream("/client_secert.json");
        
        //Loads the client_secrets.json file from the given input stream.
          GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
          // set up authorization code flow
        GoogleAuthorizationCodeFlow flow =new GoogleAuthorizationCodeFlow
        		.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
               // .setAccessType("offline")
                .build();
       
        // authorize my application's access to Google services
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

   
     // Build and return an authorized Sheets API client service.
     // @return an authorized Sheets API client service
    
    public static Sheets getSheetsService() throws Exception {
        // authorization
    	
        Credential credential = authorize();
        // set up global Oauth2 instance
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws Exception {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        String spreadsheetId = "11TeFVUDVKt1AhQJRIgICb2Hx-EJfVhUNHCtPisagGOc";
        String range;
        
        //DISPLAY  EDITION NAME , EDITION ID , PRICE OF USD,AUD,EUR,GBP 500 EDITIONS
        
        List<String> price=Arrays.asList("USD!3:500","AUD!3:500","EUR!3:500","GBP!3:500");
        for(int i=0;i<4;i++)
        {
        	range=price.get(i);
        ValueRange response = service.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute();
        
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
        	 System.out.println("EDITION NAME , EDITION ID, PRICE");
         for (List row : values) {
              System.out.printf("%s, %s ,%s \n", row.get(3), row.get(4), row.get(10));
            }
            
        }
        }
    }
}


