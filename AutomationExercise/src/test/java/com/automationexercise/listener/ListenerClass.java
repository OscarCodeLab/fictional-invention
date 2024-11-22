package com.automationexercise.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationexercise.actiondriver.Action;
import com.automationexercise.base.Base;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * Extent report listener class for managing test results.
 * Author: Hitendra
 */
public class ListenerClass extends ExtentManager implements ITestListener {

    private Action action;

    // This method will be triggered at the start of each test
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());  // Ensure 'test' is initialized here
        action = new Action(Base.getDriver());
    }

    // This method will be triggered when a test passes
    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
        }
    }

    // This method will be triggered when a test fails
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            String imgPath = action.screenShot(Base.getDriver(), result.getName());
            try {
                // Attach screenshot to the report
                test.fail("Screenshot attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // This method will be triggered when a test is skipped
    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
        }
    }

    // This method is triggered when a test fails but still passes within a success percentage
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not needed in this case, so it's ignored
    }

    // This method is triggered at the start of the test suite
    public void onStart(ITestContext context) {
        // Not used in this context, so it can remain empty
    }

    // This method is triggered at the end of the test suite
    @Override
    public void onFinish(ITestContext context) {
        // Ensure the extent report is flushed at the end of all tests
        if (extent != null) {
            extent.flush();
        }
    }
}
