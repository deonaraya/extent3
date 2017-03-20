package com.fw.extent.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * Created by chandrad on 3/18/17.
 */
public class BaseTest {

    public WebDriver driver ;
    private static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("extent.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public synchronized void beforeClass() {
      ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
      ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
        driver = new ChromeDriver() ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            test.get().fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable());
        else
            test.get().pass("Test passed");

        extent.flush();
        driver.close();
    }
}
