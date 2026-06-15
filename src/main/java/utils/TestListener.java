package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {
    
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
    
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    @Override
    public void onStart(ITestContext context) {
        // Suite-level setup remains unchanged
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = getTestName(result);
        String description = getTestDescription(result);
        
        ExtentTest test = ExtentManager.startTest(testName, description);
        extentTest.set(test);
        
        if (result.getMethod().getPriority() == 1) {
            logEnvironmentInfo();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        
        if (Boolean.parseBoolean(System.getProperty("captureAllScreenshots", "false"))) {
            attachScreenshot(test, "Success");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            // Get the collected failures from the executor
            List<Throwable> failures = (List<Throwable>) result.getAttribute("failures");
            
            if (failures != null && !failures.isEmpty()) {
                for (Throwable failure : failures) {
                    test.log(Status.FAIL, failure.getMessage());
                }
            } else {
                Throwable thrown = result.getThrowable();
                if (thrown != null) {
                    // Get root cause (e.g., NoSuchElementException inside TimeoutException)
                    Throwable rootCause = thrown;
                    while (rootCause.getCause() != null) {
                        rootCause = rootCause.getCause();
                    }

                    String failureDetails = "Exception: " + thrown.getClass().getSimpleName() + "\n"
                            + "Message: " + thrown.getMessage() + "\n"
                            + "Root Cause: " + rootCause.getClass().getSimpleName() + "\n"
                            + "Root Cause Message: " + rootCause.getMessage();

                    // Print to console (visible in VS Code Terminal)
                    System.out.println("========== TEST FAILURE ==========");
                    System.out.println(failureDetails);
                    thrown.printStackTrace();
                    System.out.println("===================================");

                    // Log full details to Extent Report
                    test.log(Status.FAIL, failureDetails);
                    test.fail(thrown);
                }
            }
            
            // Capture final screenshot for the test case
            attachScreenshot(test, "FinalFailure");
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
        
        if (result.getThrowable() != null) {
            test.skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentTest.remove();
        driverThreadLocal.remove();
    }

    // ========== HELPER METHODS (NO CHANGES NEEDED BELOW) ==========
    
    private String getTestName(ITestResult result) {
        Object[] parameters = result.getParameters();
        if (parameters != null && parameters.length > 0 && parameters[0] instanceof Map) {
            Map<?, ?> testData = (Map<?, ?>) parameters[0];
            return testData.get("TestCaseID").toString();
        }
        return result.getName();
    }

    private String getTestDescription(ITestResult result) {
        try {
            Object[] parameters = result.getParameters();
            if (parameters == null || parameters.length == 0) return "";
            Object firstParam = parameters[0];
            if (!(firstParam instanceof Map)) return "";
            Map<?, ?> testData = (Map<?, ?>) firstParam;
            Object description = testData.get("Description");
            return description != null ? description.toString() : "";
        } catch (Exception e) {
            System.err.println("Error getting test description: " + e.getMessage());
            return "";
        }
    }

    private void attachScreenshot(ExtentTest test, String status) {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) return;

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String screenshotDir = "test-output/screenshots/";
            String fileName = status + "_" + timestamp + ".png";
            String filePath = screenshotDir + fileName;

            new File(screenshotDir).mkdirs();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
            test.addScreenCaptureFromPath(filePath);
        } catch (Exception e) {
            test.warning("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private void logEnvironmentInfo() {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.info("Browser: " + System.getProperty("browser", "Chrome"));
            test.info("Environment: " + System.getProperty("env", "STAGE"));
            test.info("Execution Mode: " + 
                (Boolean.parseBoolean(System.getProperty("parallel", "false")) ? "Parallel" : "Sequential"));
        }
    }
}