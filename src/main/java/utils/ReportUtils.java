package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Utility class for managing ExtentReports test reporting with thread-safe operations.
 * Provides methods to initialize reports, create tests, log results, and generate reports.
 */
public class ReportUtils {
    // Singleton instance of ExtentReports
    private static ExtentReports extent;
    
    // ThreadLocal instance to ensure thread safety for test logging
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    /**
     * Initializes the ExtentReports instance and configures the HTML reporter.
     * Creates a report file named "Report.html" in the test-output directory.
     */
    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Report.html");
        extent.attachReporter(spark);
    }
    
    /**
     * Starts a new test in the report and stores it in the ThreadLocal instance.
     * 
     * @param testName The name of the test to be created in the report
     */
    public static void startTest(String testName) {
        test.set(extent.createTest(testName));
    }
    
    /**
     * Logs a passed step with the given message in the current test.
     * 
     * @param message The message to log for the passed step
     */
    public static void logPass(String message) {
        test.get().pass(message);
    }
    
    /**
     * Logs a failed step with the given message in the current test.
     * 
     * @param message The message to log for the failed step
     */
    public static void logFail(String message) {
        test.get().fail(message);
    }
    
    /**
     * Flushes the report data to the output file and completes report generation.
     * This should be called after all tests have completed.
     */
    public static void flushReport() {
        extent.flush();
    }
}