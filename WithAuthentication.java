package com.googlesheet.GoogleSheet;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class WithAuthentication{
    public static void main(String[] args) throws MalformedURLException, GeneralSecurityException, IOException, ServiceException {
        URL SPREADSHEET_FEED_URL;
        SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/list/1pzVL-xrEq2XoETwZyNNb6etIGSZN1ZJytdKKWxAB4aU/default/public/values");

        File p12 = new File("/Users/swapanpreetkaur/Downloads/client_secert.json");
        JsonFactory JSON_FACTORY = new  JacksonFactory();
        
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        
        String[] SCOPESArray = {"https://spreadsheets.google.com/feeds/list/1pzVL-xrEq2XoETwZyNNb6etIGSZN1ZJytdKKWxAB4aU/default/public/values"};
        final List SCOPES = Arrays.asList(SCOPESArray);
        
        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountId("363645755906-fuljus2dppk879eu78p1lv7chgmavomj.apps.googleusercontent.com")
                .setServiceAccountScopes(SCOPES)
                .setServiceAccountPrivateKeyFromP12File(p12)
                .build();
        
        SpreadsheetService service = new SpreadsheetService("Print Google Spreadsheet Demo");
        
        
        service.setOAuth2Credentials(credential);        
        
        ListFeed lf = service.getFeed(SPREADSHEET_FEED_URL, ListFeed.class);

        //Iterate over feed to get cell value
        for (ListEntry le : lf.getEntries()) {
            CustomElementCollection cec = le.getCustomElements();
            //Pass column name to access it's cell values
            String val = cec.getValue("Cell1");
            System.out.println(val);
            String val2 = cec.getValue("Cell2");
            System.out.println(val2);
        }
        }

    }

