package com.googlesheet.GoogleSheet;

import java.io.IOException;


import java.net.URL;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

/**
 * Hello world!
 *
 */
public class WithoutAuthentication {
public static final String GOOGLE_ACCOUNT_USERNAME = "swapanpreet.kaur@appdirect.com"; // Fill in google account username
public static final String GOOGLE_ACCOUNT_PASSWORD = "Swapanpreet1!"; // Fill in google account password
public static final String SPREADSHEET_URL = "https://spreadsheets.google.com/feeds/list/1pzVL-xrEq2XoETwZyNNb6etIGSZN1ZJytdKKWxAB4aU/default/public/values "; //Fill in google spreadsheet URI

public static void main(String[] args) throws IOException, ServiceException
{
  /** Our view of Google Spreadsheets as an authenticated Google user. */
  SpreadsheetService service = new SpreadsheetService("Print Google Spreadsheet Demo");

  // Login and prompt the user to pick a sheet to use.
 try{
  service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME, GOOGLE_ACCOUNT_PASSWORD);
  } catch (AuthenticationException ex)
  {
	  System.out.println("AuthenticationException caught");
  }

  // Load sheet
URL metafeedUrl = new URL(SPREADSHEET_URL);
  //SpreadsheetEntry spreadsheet = service.getEntry(metafeedUrl, SpreadsheetEntry.class);
  //URL listFeedUrl = ((WorksheetEntry) spreadsheet.getWorksheets().get(0)).getListFeedUrl();

//Get Feed of Spreadsheet url
  ListFeed lf = service.getFeed( metafeedUrl, ListFeed.class);

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
