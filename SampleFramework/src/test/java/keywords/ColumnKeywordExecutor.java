package keywords;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import testScripts.CategoryFullregression;
import testScripts.Sample;
import utils.ExtentManager;

/**
 * Executes keyword-driven tests by dynamically invoking methods from test classes.
 * Provides flexible method execution across multiple test classes with WebDriver injection.
 */
public class ColumnKeywordExecutor {
    // WebDriver instance to be injected into test classes
    private final WebDriver driver;

    /**
     * Constructor initializes the executor with a WebDriver instance
     * @param driver WebDriver instance to be used by test methods
     */
    public ColumnKeywordExecutor(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Record type for storing test class metadata
     * @param simpleName Simplified class name for display
     * @param clazz The actual Class object
     */
    public record TestClassEntry(String simpleName, Class<?> clazz) {}
    
    /**
     * Array of test classes that can be searched for methods
     * Add new test classes here to make their methods available
     */
    private static final TestClassEntry[] TEST_CLASSES = {
        new TestClassEntry("Sample", Sample.class),
        new TestClassEntry("CategoryFullRegression", CategoryFullregression.class)
    };
    
    /**
     * Executes a sequence of test methods across registered test classes
     * @param flowName Name of the test flow for reporting
     * @param methodNames List of method names to execute in order
     * @return 
     */
    
    public List<Throwable> executeTestFlow(String flowName, List<String> methodNames) {
        ExtentTest flowTest = ExtentManager.getTest().createNode(flowName);
        List<Throwable> failures = new ArrayList<>();
        
        for (String methodName : methodNames) {
            ExtentTest methodNode = flowTest.createNode(methodName);
            boolean executed = false;
            
            for (TestClassEntry entry : TEST_CLASSES) {
                try {
                    executeMethodWithReporting(entry.clazz(), methodName, methodNode);
                    executed = true;
                    break;
                } catch (NoSuchMethodException e) {
                    continue; // Try next class
                } catch (Throwable e) {
                    executed = true; // Method was found and ran — don't report as missing
                    handleFailure(entry.simpleName(), methodName, e, methodNode, failures);
                    break; // No need to try other classes once method is found
                }
            }
            
            if (!executed) {
                handleMethodNotFound(methodName, methodNode, failures);
            }
        }
        
        return failures; // Now safe to return since we're not throwing
    }

    private void handleFailure(String className, String methodName, Throwable e, 
                             ExtentTest methodNode, List<Throwable> failures) {
        // 1. Log to ExtentReports
        methodNode.fail(MarkupHelper.createLabel("FAILED", ExtentColor.RED));
        methodNode.fail(e);
        
        // 2. Log to console
        System.err.println("✗ FAIL [" + className + "." + methodName + "]: " + e.getMessage());
        
        // 3. Store failure
        failures.add(e);
        
        // 4. Mark TestNG context as failed WITHOUT throwing
        ITestResult result = Reporter.getCurrentTestResult();
        if (result != null) {
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);
        }
    }

    private void handleMethodNotFound(String methodName, ExtentTest methodNode, 
                                    List<Throwable> failures) {
        NoSuchMethodException e = new NoSuchMethodException(
            "Method '" + methodName + "' not found in any test class");
        methodNode.fail(e);
        failures.add(e);
        
        ITestResult result = Reporter.getCurrentTestResult();
        if (result != null) {
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);
        }
    }

    private void executeMethodWithReporting(Class<?> testClass, String methodName, 
                                          ExtentTest methodNode) throws Throwable {
        try {
            Constructor<?> ctor = testClass.getConstructor(WebDriver.class);
            Object instance = ctor.newInstance(driver);
            
            Method method;
            try {
                method = testClass.getMethod(methodName, ExtentTest.class);
                method.invoke(instance, methodNode);
            } catch (NoSuchMethodException e) {
                method = testClass.getMethod(methodName);
                method.invoke(instance);
            }
            
            // Log success
            methodNode.pass(MarkupHelper.createLabel("PASSED", ExtentColor.GREEN));
            System.out.println("✓ PASS [" + methodName + "]");
        } catch (InvocationTargetException e) {
            throw e.getCause(); // Unwrap the real exception
        }
    }

}
