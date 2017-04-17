package com.hardik.seleniumAssignment;

import java.net.URL;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;

public class Data {

	
	public static final String GOOGLE_ACCOUNT_USERNAME = "piprojectutd@gmail.com"; 
    public static final String GOOGLE_ACCOUNT_PASSWORD = "password"; 
    public static final String SPREADSHEET_URL = "https://drive.google.com/open?id=0B9R9YQ9A5etic0tjZEVPcHJuWFE";
    String status="";
    

	public void readData(){
		
	    try{
	    /** Our view of Google Spreadsheets as an authenticated Google user. */
	        SpreadsheetService service = new SpreadsheetService("Print Google Spreadsheet Demo");

	        // Login and prompt the user to pick a sheet to use.
	        service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME,GOOGLE_ACCOUNT_PASSWORD);

	        // Load sheet
	        URL metafeedUrl = new URL(SPREADSHEET_URL);
	        SpreadsheetEntry spreadsheet = service.getEntry(metafeedUrl,SpreadsheetEntry.class);
	        URL listFeedUrl = spreadsheet.getWorksheets().get(0).getListFeedUrl();

	        // Print entries
	        ListFeed feed = service.getFeed(listFeedUrl, ListFeed.class);

	        for (ListEntry entry : feed.getEntries()) {
	            System.out.println("new row");
	            for (String tag : entry.getCustomElements().getTags()) {
	                System.out.println("     " + tag + ": "+ entry.getCustomElements().getValue(tag));
	                status=entry.getCustomElements().getValue(tag);
	            }
	        }
	    }catch(Exception e){
	        System.out.println(e);
	    }
	    System.out.println(status);
	   
	    }
	
}
