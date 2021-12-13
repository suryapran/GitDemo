package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	
	WebDriver drivr=null;
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObjectCofig();
	//BELOW CODE FOR GETTING THE CURRENT TEST 
	ThreadLocal<ExtentTest> localtest = new ThreadLocal<ExtentTest>();//USED FOR RUNNING PARALLEL TEST CASE 

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
		 localtest.set(test); // HERE IT WILL SET THE CURRENT TEST , WHENEVER A TEST CASE START
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		localtest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		localtest.get().fail(result.getThrowable());
		try
		{
			drivr=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			// getDeclaredField("driver") --> "driver" is same name of driver of the current test case .
			//eg: if current test is validateTitle then current browser driver is "driver"  as same as the 
			//driver=initializeBrowser(); in this line of  validateTitle
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String testMethodName=result.getMethod().getMethodName();
		try
		{
			localtest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,drivr), result.getMethod().getMethodName());
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
