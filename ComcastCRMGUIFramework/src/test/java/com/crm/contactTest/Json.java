package com.crm.contactTest;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.comCast.crm.generic.fileUtility.JSONUtility;

public class Json {

	public static void main(String[] args) throws IOException, ParseException {
		JSONUtility jlib=new JSONUtility();
		String BROWSER=jlib.getDataFromJsonFile("browser");
		System.out.println(BROWSER);
		System.out.println(jlib.getDataFromJsonFile("url"));
		System.out.println(jlib.getDataFromJsonFile("username"));
		System.out.println(jlib.getDataFromJsonFile("password"));
	}

}
