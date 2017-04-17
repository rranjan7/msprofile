package ReadSpreadSheet.ReadSheet;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class AppTest 
{
	@Test
	public void test() throws IOException, ServiceException
	{		
		final String GOOGLE_ACCOUNT_USERNAME = "jasdeep.kaur@appdirect.com"; // Fill in google account username
//      public static final String GOOGLE_ACCOUNT_PASSWORD =""; // Fill in google account password
      final String SPREADSHEET_URL = "https://spreadsheets.google.com/feeds/appdirect.com/spreadsheets/1aHI8GFMpdlSZ1UxjS7p9IsEOkCxsDXIsHGF8NOAgNl4/"; //Fill in google spreadsheet URI
 
      
        /** Our view of Google Spreadsheets as an authenticated Google user. */
        SpreadsheetService service = new SpreadsheetService("Print Google Spreadsheet Demo");
 
        // Login and prompt the user to pick a sheet to use.
//        service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME, GOOGLE_ACCOUNT_PASSWORD);
 
        // Load sheet
        URL metafeedUrl = new URL(SPREADSHEET_URL);
        SpreadsheetEntry spreadsheet = service.getEntry(metafeedUrl, SpreadsheetEntry.class);
        URL listFeedUrl = ((WorksheetEntry) spreadsheet.getWorksheets().get(0)).getListFeedUrl();
 
        // Print entries
        ListFeed feed = (ListFeed) service.getFeed(listFeedUrl, ListFeed.class);
        for(ListEntry entry : feed.getEntries())
        {
          System.out.println("new row");
          for(String tag : entry.getCustomElements().getTags())
          {
            System.out.println("     "+tag + ": " + entry.getCustomElements().getValue(tag));
          
        }
      }
	}
}
