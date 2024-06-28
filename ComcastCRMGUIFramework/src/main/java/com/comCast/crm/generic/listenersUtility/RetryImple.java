package com.comCast.crm.generic.listenersUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * @author Pratyusha
 */
public class RetryImple implements IRetryAnalyzer{

	int count=0,limit=5;
	/**
	 * method will get execute based on limit we given  if any test script got failed
	 */
	@Override
	public boolean retry(ITestResult result) {
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}

}
