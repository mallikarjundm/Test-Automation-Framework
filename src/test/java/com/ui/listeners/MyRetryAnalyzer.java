package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//	private static final int MAX_NUM_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUM_OF_ATTEMPTS" ));
	private static final int MAX_NUM_OF_ATTEMPTS=Integer.parseInt(JsonUtility.readJson(Env.QA).getMAX_NUM_OF_ATTEMPTS());
	
	
	private static  int currentAttempt=1;
	
	

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt<=MAX_NUM_OF_ATTEMPTS)
		{
			currentAttempt++;
			return true ;
		}
		return false;
	}
	

}
