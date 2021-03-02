package com.qa.orangehrm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1 implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(1);
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(2);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(3);
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println(4);
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(5);
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(6);
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(7);
		
	}

}
