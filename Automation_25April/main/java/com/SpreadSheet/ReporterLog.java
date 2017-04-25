package com.SpreadSheet;
import java.sql.Timestamp;
import org.testng.Reporter;
/**
 * Custom Reporter class to format the logs with timestamp.
 * @author aditya.raj
 *
 */
public class ReporterLog {
    
    public void info(String msg){
        Reporter.log(new Timestamp(System.currentTimeMillis())+"\t[Info]\t"+msg);
    }
    
    public void error(String msg){
        Reporter.log(new Timestamp(System.currentTimeMillis())+"\t[Error]\t"+msg);
    }
    public void warning(String msg){
        Reporter.log(new Timestamp(System.currentTimeMillis())+"\t[Warning]\t"+msg);
    }
    
    public void exceptionlog(String msg){
        Reporter.log(new Timestamp(System.currentTimeMillis())+"\t[Exception]\t"+msg);
    }
    
}
