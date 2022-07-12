package com.vcentry.hrm.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.vcentry.hrm.utils.CommonFunctions;

public class ListernerClass extends CommonFunctions implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName()+"is passed");
		log.info(result.getName()+"is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getName()+"is failed"+result.getThrowable());
		log.error(result.getName()+"is failed");
		test.addScreenCaptureFromPath(CommonFunctions.screenshot());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getName()+"is skipped");
		log.info(result.getName()+"is skipped");	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("********************Execution Start***********");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		log.info("********************Execution Start***********");
	}

}
