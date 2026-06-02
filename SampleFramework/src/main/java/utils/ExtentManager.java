package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentManager {
    private static ExtentReports extent;
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    private static Map<String, ExtentTest> testMap = new HashMap<>();
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportName = "Keyword-Driven-Test-Report-" + timeStamp + ".html";
            String reportDirectory = "Reports/Extent Reports/";
            
            new File(reportDirectory).mkdirs();
            
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportDirectory + reportName);
            
            // --- FILTER: EXCLUDE SKIPPED TESTS ---
            htmlReporter.filter().statusFilter().as(new Status[] { Status.PASS, Status.FAIL }).apply();
            
            htmlReporter.config().setDocumentTitle("Test Report");
            htmlReporter.config().setReportName("Automation Execution Report");
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setEncoding("utf-8");
            
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            
            // Add these configurations:
            htmlReporter.config().setJs("$('.test-content').find('span:contains(\"runTestCase\")').parent().hide()");
            
         // ADD THIS LINE TO CONTROL METHOD NAME REPORTING
            extent.setReportUsesManualConfiguration(true);
            
         // THIS IS THE CRITICAL CONFIGURATION:
            htmlReporter.config().setJs("document.getElementsByClassName('test-runner-log')[0].style.display='none';");
            
            extent.setSystemInfo("Organization", "Your Company");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
    
    // --- SCREENSHOT SUPPORT ---
    public synchronized static void addScreenshot(String caption, String imagePath) {
        if (getTest() != null) {
            getTest().addScreenCaptureFromPath(imagePath, caption);
        }
    }
    
    // --- Existing methods (unchanged) ---
    public synchronized static ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().threadId());
    }
    
    public synchronized static ExtentTest startTest(String testName, String description) {
        ExtentTest test = getReporter().createTest(testName, description);
        extentTestMap.put(Thread.currentThread().threadId(), test);
        return test;
    }
    
    public synchronized static ExtentTest getTest(String testName) {
        return testMap.get(testName);
    }
    
    public synchronized static ExtentTest startTest(String testName) {
        ExtentTest test = getReporter().createTest(testName);
        testMap.put(testName, test);
        return test;
    }
    
    public synchronized static void endTest() {
        getReporter().flush();
    }
    
    public synchronized static void removeTest() {
        extentTestMap.remove(Thread.currentThread().threadId());
    }
    
    public synchronized static void addSystemInfo(String key, String value) {
        getReporter().setSystemInfo(key, value);
    }
}