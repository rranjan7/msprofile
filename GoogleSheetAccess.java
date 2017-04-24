package com.appdirect.nitya.automation_project;


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
import com.google.gdata.data.analytics.DataFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.api.services.sheets.v4.Sheets;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.Reporter;
    public class GoogleSheetAccess {
        
            FileOutputStream outputFile;
            Properties properties;
            static int count = 0;
            FileWriter fileWritter;
            
            
            private static final String APPLICATION_NAME ="Google Sheets API Java Quickstart";
           
            private static final java.io.File DATA_STORE_DIR = new java.io.File(
                                            System.getProperty("user.home"),".credentials/1/sheets.googleapis.com-java-quickstart");
            
            private static FileDataStoreFactory DATA_STORE_FACTORY;
           
            private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
           
            private static HttpTransport HTTP_TRANSPORT;
            
             
            private static final List<String> SCOPES =Arrays.asList(SheetsScopes.SPREADSHEETS,SheetsScopes.DRIVE);
            static {
                try {
                    HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                    DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
                } catch (Throwable t) {
                    t.printStackTrace();
                    System.exit(1);
                }
            }
            
            
            
            public static Credential authorize() throws Exception {
                
                InputStream in = GoogleSheetAccess.class.getResourceAsStream("client_secret.json");
                GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
                
                GoogleAuthorizationCodeFlow flow =new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
                
                Credential credential = new AuthorizationCodeInstalledApp( flow, new LocalServerReceiver()).authorize("user");
                Reporter.log("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
                return credential;
            }
            
            public static Sheets getSheetsService() throws Exception {
                Credential credential = authorize();
                return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
            }
            public void getList() throws Exception {
               
                Sheets service = getSheetsService();
                String spreadsheetId = "11TeFVUDVKt1AhQJRIgICb2Hx-EJfVhUNHCtPisagGOc"; 
                String range;  
               
                List<Editions> editions = new ArrayList<Editions>();
               
                //List<String> priceDenomination = Arrays.asList("USD!4:519","AUD!4:519","EUR!4:519","GBP!4:519");
                List<String> priceDenomination = new ArrayList<String>();
                priceDenomination.add("USD");
                priceDenomination.add("AUD");
                priceDenomination.add("EUR");
                priceDenomination.add("GBP");
                    
                for(int i=0; i<priceDenomination.size();i++) {
                    
                    range = priceDenomination.get(i)+"!3:519";
                    
                    ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
                    List<List<Object>> values = response.getValues();
                     if (values == null || values.size() == 0) {
                         Reporter.log("No data found.",true);
                     } else {
                       for (List row : values) {   
                        
                         Editions edition = new Editions();
                         Map<String,String> pricing = new HashMap<String,String>(); 
                         
                         String currency = priceDenomination.get(count).substring(0).substring(0, 3);
                         edition.setEditionName(row.get(3).toString());
                         edition.setOfferId(row.get(4).toString());
                         pricing.put(currency, row.get(10).toString());
                         edition.setPrice(pricing);                  
                         editions.add(edition);
                       }             
                     }
                    count++;
                    
                    Reporter.log(editions.size()+"\n",true);
                    for (Editions ed : editions){
                        Reporter.log(ed.getEditionName()+" ",true);
                        Reporter.log(ed.getOfferId()+" ",true);
                        Reporter.log(ed.getPrice().keySet()+" ",true);
                        Reporter.log(ed.getPrice().values()+"\n",true);
                    }
                    
                }
            }    
}
