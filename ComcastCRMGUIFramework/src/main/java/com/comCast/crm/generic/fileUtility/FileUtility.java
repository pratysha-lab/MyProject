package com.comCast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Pratyusha
 * utility class for read the data from properties file
 */
public class FileUtility {
	/**
	 * utility method for fetch data from properties
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/appCommonData.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}

}
