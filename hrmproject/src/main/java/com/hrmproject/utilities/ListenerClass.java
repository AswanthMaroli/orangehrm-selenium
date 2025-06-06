
package com.hrmproject.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author Aswanth Maroli
 * @date   Jun 6, 2025
 */

public class ListenerClass extends ExtentManager implements ITestListener {
	
	
    @Override
	public void onStart(ITestContext context) {
		
		try {
			
			setExtent();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
         test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
        test.pass("Test Passed");
        
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
        test.fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
        test.skip("Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
        endReport();
	}

}
