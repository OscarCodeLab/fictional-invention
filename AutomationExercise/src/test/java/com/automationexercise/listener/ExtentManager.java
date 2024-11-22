package com.automationexercise.listener;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    
    public void setExtent() throws IOException  {
        // Set up the Spark reporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        // Initialize the ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Set system information
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Opeyemi");
        extent.setSystemInfo("OS", "Win11");
        extent.setSystemInfo("Browser", "Chrome");
    }

}