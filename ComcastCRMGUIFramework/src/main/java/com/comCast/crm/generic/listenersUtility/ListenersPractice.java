package com.comCast.crm.generic.listenersUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comCast.crm.generic.ObjectUtility.UtilityClassObject;
import com.comCast.crm.generic.baseClassUtility.BaseClass;

/**
 * @author Pratyusha
 */
public class ListenersPractice implements ITestListener, ISuiteListener {
	/*
	 * These are the suite listener methods
	 */
	public ExtentReports report;
	
	public static ExtentTest test;

	/**
	 * method will get execute before the execution of suite file
	 */
	public void onStart(ISuite suite) {
		// config document
		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + date + ".html");
		spark.config().setDocumentTitle("CRM APPLICATION");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// set evn info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-110");
		report.setSystemInfo("Bulid ID", "B01");

	}

	/**
	 * method will get execute after executing the suite file
	 */
	public void onFinish(ISuite suite) {
		report.flush();
	}

	/*
	 * These are the Test listener methods
	 */
	/**
	 * method will get execute after starting each and every test scripts
	 */
	public void onTestStart(ITestResult result) {
		String mn = result.getMethod().getMethodName();
		System.out.println(mn + " is started");
		test = report.createTest(mn);
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, mn + "====>Strated======");
	}

	/**
	 * method will get execute any test script got failed
	 */
	public void onTestFailure(ITestResult result) {
		String mn = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;

		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath, mn + "_" + date);
		UtilityClassObject.getTest().log(Status.FAIL, mn + "====>Failed======");
	}

	public void onTestSuccess(ITestResult result) {
		String mn = result.getMethod().getMethodName();
		UtilityClassObject.getTest().log(Status.PASS, mn + "====>PASSED======");
	}
	/*
	 * public void onTestFailure(ITestResult result) { String mn =
	 * result.getMethod().getMethodName();
	 * 
	 * TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
	 * 
	 * File src = ts.getScreenshotAs(OutputType.FILE); Date d = new Date(); String
	 * date = d.toString().replace(" ", "_").replace(":", "_"); try {
	 * FileUtils.copyFile(src, new File("./screenshot/" + mn + date + ".png")); }
	 * catch (IOException e) { System.out.println("Exception caught");
	 * e.printStackTrace(); } System.out.println(mn + " is failure"); }
	 */

	/**
	 * method will get execute if any test script got skipped
	 */
	public void onTestSkipped(ITestResult result) {
		String mn = result.getMethod().getMethodName();
		UtilityClassObject.getTest().log(Status.SKIP, mn + "====>Skipped======");

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
