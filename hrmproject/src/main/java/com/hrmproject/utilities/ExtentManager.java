package com.hrmproject.utilities;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 *
 * @author Aswanth Maroli
 * @date   Jun 6, 2025
 */

public class ExtentManager {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/MyReport.html");
	    sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	    
	    extent= new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    
	    extent.setSystemInfo("Tester Name", null);
	    extent.setSystemInfo("Browser Name", "Chrome");
	    extent.setSystemInfo("OS Name", "Windows 11");
	    
	    
	
	}
	
	public static void endReport() {
		
		extent.flush();
	}

}
