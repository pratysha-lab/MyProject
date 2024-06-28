package com.comCast.crm.generic.ObjectUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Pratyusha
 * THIS UTILITY CLASS use for sharing the static variable for multiple threads in case of parallel execution 
 */
public class UtilityClassObject {
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();

	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
}
