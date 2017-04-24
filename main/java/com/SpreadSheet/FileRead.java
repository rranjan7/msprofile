package com.SpreadSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

//import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.common.io.FileBackedOutputStream;

public class FileRead {

public Properties fileRead(String fileName) throws IOException
{
	FileInputStream fin ;
	fin = new FileInputStream(new File(fileName));
    Properties pr=new Properties();
    pr.load(fin);
    return pr;
 }

}


