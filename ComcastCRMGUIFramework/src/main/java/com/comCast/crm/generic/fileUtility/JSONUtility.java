package com.comCast.crm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Pratyusha
 */
public class JSONUtility {
	/**
	 *  utility method for get the data from json file 
	 * @param key
	 * @return String
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		
		FileReader file=new FileReader("./configAppData/appCommonData.json");
		JSONParser parse=new JSONParser();
		Object obj=parse.parse(file);
		
		JSONObject jobj=(JSONObject)obj;
		String data=jobj.get(key).toString();
		return data;
	}
	/**
	 * utility method for get the data from json 
	 * @param key
	 * @return Numeric 
	 * @throws IOException
	 * @throws ParseException
	 */
	public Double getDataFromJsonNumber(String key) throws IOException, ParseException {
		FileReader file=new FileReader("./configAppData/appCommonData.json");
		JSONParser parse=new JSONParser();
		Object obj=parse.parse(file);
		
		JSONObject jobj=(JSONObject)obj;
		Double data=Double.valueOf( jobj.get(key).toString());
		return data;
	}

}
