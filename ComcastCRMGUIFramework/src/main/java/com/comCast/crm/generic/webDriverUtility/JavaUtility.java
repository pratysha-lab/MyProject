package com.comCast.crm.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * @author Pratyusha
 */
public class JavaUtility {
	/**
	 * utility method for get the random number
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		
		int randomNumber=r.nextInt(5000);
		return randomNumber;
	}
	/**
	 * utility method for get the current system date
	 * @param dateFormat
	 * @return
	 */
	public String getCurrentDate(String dateFormat) {
		Date d=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
		String currentSystemDate=sdf.format(d);
		return currentSystemDate;
	}
	/**
	 * utility method for get the after or before date
	 * @param dateFormat
	 * @param numberOfDays
	 * @return 
	 */
	public String getAfterOrBeforeDate(String dateFormat,int numberOfDays) {
		Date d=new Date();
		SimpleDateFormat date=new SimpleDateFormat(dateFormat);
		date.format(d);
		
		
		//when we want before/ after date
		Calendar c=date.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, numberOfDays);
		String dateRequired=date.format(c.getTime());
		
		return dateRequired;
		
	}
	
	

}
