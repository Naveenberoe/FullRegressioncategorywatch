package testScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.Constants;
import utils.ExtentManager;

/**
 * CommonSteps class contains reusable methods for test automation
 * including web element interactions and screenshot capturing
 */
public class CommonSteps {
    
    // Extent Report variables for test reporting
    static ExtentReports extent;
    ExtentTest test;
    static ChromeDriver driver;
    
    // Page Object instances
    Constants cnstnt = new Constants(driver);
    
    /**
     * Constructor for CommonSteps class
     * @param driver WebDriver instance to be used for all operations
     */
    public CommonSteps(WebDriver driver) {
        CommonSteps.driver = (ChromeDriver) driver; 
        this.test = ExtentManager.getTest();
    }
    
    /**
     * Enters text into a web element located by the given locator
     * @param driver WebDriver instance
     * @param elementLocator By locator for the target element
     * @param text Text to be entered into the element
     */
    public void enterText(WebDriver driver, By elementLocator, String text) {
        try {
            WebElement element = driver.findElement(elementLocator);
            element.clear();
            element.sendKeys(text);
            Thread.sleep(2000);
            System.out.println("Text entered - " + text);
            test.log(Status.PASS, "Text Entered");
            test.pass("Text entered successfully").addScreenCaptureFromPath(captureScreenshot(driver, "Text Entered"));
        }
        catch(Exception e) {
            System.out.println(e);
            test.log(Status.FAIL, "Text Not entered");
            test.fail(e).addScreenCaptureFromPath(captureScreenshot(driver, "Text not entered"));
        } 
    }
    
        public static String captureScreenshot(WebDriver driver, String screenshotName) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String dest = System.getProperty("user.dir") + "/test-output/screenshots/" + 
                             screenshotName + "_" + timeStamp + ".png";
                
                File destination = new File(dest);
                FileUtils.copyFile(source, destination);
                return dest;
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
                return null;
            }
        }
        
        public static String takeScreenshot(String prefix) {
            try {
                // 1. Create screenshot directory if it doesn't exist
                String screenshotDir = "test-output/screenshots/";
                new File(screenshotDir).mkdirs();
                
                // 2. Generate timestamped filename
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
                String fileName = prefix + "_" + timestamp + ".png";
                String filePath = screenshotDir + fileName;
                
                // 3. Capture screenshot using Selenium
                if (driver != null) {
                    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    
                    // 4. Copy to destination
                    FileUtils.copyFile(screenshotFile, new File(filePath));
                    
                    // 5. Return relative path for ExtentReports
                    return filePath;
                }
                return "screenshot_failed_driver_null.png";
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
                return "screenshot_failed.png";
            }
        }
        
        public static void addScreenshotToReport(WebDriver driver, String message) throws IOException {
            ExtentTest test = ExtentManager.getTest();
            if (test != null) {
                String screenshotPath = captureScreenshot(driver, "screenshot");
                if (screenshotPath != null) {
                    test.addScreenCaptureFromPath(screenshotPath, message);
                }
            }
        }
    
    
    /**
     * Takes a screenshot and saves it to the screenshots directory
     * @param driver WebDriver instance
     * @param testName Name of the test for screenshot naming
     */
    public void takeScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(
                screenshot,
                new File("screenshots/" + testName + ".png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clicks on a web element located by the given locator
     * @param driver WebDriver instance
     * @param elementLocator By locator for the target element
     * @throws Exception 
     */
    public void click(WebDriver driver, By elementLocator) throws Exception {
        try {
            WebElement element = driver.findElement(elementLocator);
            element.click();
            System.out.println("Object clicked ");
            Thread.sleep(1000);
            test.log(Status.PASS, "Object Clicked");
            test.pass("Object Clicked successfully").addScreenCaptureFromPath(captureScreenshot(driver, "Object Clicked"));
        }
        catch(Exception e) {
            System.out.println(e);
            test.log(Status.FAIL, "Object Not Clicked");
            test.fail(e).addScreenCaptureFromPath(captureScreenshot(driver, "Object Not clicked"));
            throw e;
        }
    }
    
    /**
     * Simple JavaScript click for any WebElement
     * @param driver WebDriver instance
     * @param element The WebElement to click
     */
    public void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
    
    /**
     * Clicks a WebElement with basic error handling and logging
     * @param driver WebDriver instance (for potential fallback operations)
     * @param element The WebElement to click
     */
    public void clickElement(WebDriver driver, WebElement element) {
        try {
            // Attempt standard click
            element.click();
            System.out.println("Successfully clicked element");
            
            // Brief pause (consider replacing with proper wait)
            Thread.sleep(500); // Reduced from 2000ms to 500ms
        }
        catch(Exception e) {
            System.out.println("Standard click failed: " + e.getMessage());
            
            // JavaScript click fallback
            try {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
                System.out.println("Used JavaScript fallback click");
            } catch (Exception jsEx) {
                System.out.println("JavaScript click also failed: " + jsEx.getMessage());
            }
        }
    }
    
    /**
     * Gets any element within a shadow DOM
     * @param driver WebDriver instance
     * @param hostSelector CSS selector for the shadow host
     * @param shadowElementSelector CSS selector for the element inside shadow DOM
     * @return WebElement from shadow DOM
     */
    public WebElement getShadowElement(WebDriver driver, String hostSelector, String shadowElementSelector) {
        WebElement host = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(hostSelector)));
        
        SearchContext shadowRoot = host.getShadowRoot();
        return shadowRoot.findElement(By.cssSelector(shadowElementSelector));
    }
    
//    public WebElement getCurrentWebElement(String pageName, String elementName) {
//        try {
//            // Get the LiveElement definition
//            LiveElement elm = getElement(pageName, elementName);
//            if (elm == null) {
//                throw new RuntimeException("Could not retrieve LiveElement for " + 
//                                       pageName + "." + elementName);
//            }
//
//            // Handle shadow DOM case
//            if (elm.getChild() != null) {
//                // Wait for host element
//                WebElement host = new WebDriverWait(driver, Duration.ofSeconds(15))
//                    .until(ExpectedConditions.presenceOfElementLocated(elm.getParent()));
//
//                // Try both native and JS shadow root access
//                try {
//                    SearchContext shadowRoot = host.getShadowRoot();
//                    return shadowRoot.findElement(By.cssSelector(elm.getChild()));
//                } catch (Exception e) {
//                    return (WebElement) ((JavascriptExecutor) driver).executeScript(
//                        "return arguments[0].shadowRoot.querySelector(arguments[1])", 
//                        host, 
//                        elm.getChild()
//                    );
//                }
//            } 
//            // Handle regular element case
//            else {
//                return new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.presenceOfElementLocated(elm.getParent()));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to get element " + elementName + 
//                                   " from page " + pageName, e);
//        }
//    }
//
//    public LiveElement getElement(String pageName, String elementName) {
//        try {
//            // Try exact class name match first
//            Class<?> pageClass;
//            try {
//                pageClass = Class.forName("PageObjects." + pageName);
//            } catch (ClassNotFoundException e) {
//                // Fallback to case-insensitive class search
//                try {
//                    pageClass = Class.forName("PageObjects." + pageName.toLowerCase());
//                } catch (ClassNotFoundException e2) {
//                    throw new RuntimeException("Page class not found: PageObjects." + pageName + 
//                                           " (tried case variations)");
//                }
//            }
//
//            // Case-insensitive method search
//            Method foundMethod = null;
//            for (Method method : pageClass.getMethods()) {
//                if (method.getName().equalsIgnoreCase(elementName)) {
//                    foundMethod = method;
//                    break;
//                }
//            }
//            if (foundMethod == null) {
//                throw new NoSuchMethodException("Method " + elementName + " not found in " + pageName);
//            }
//
//            // Invoke the method
//            Object result = foundMethod.invoke(null);
//            if (!(result instanceof LiveElement)) {
//                throw new RuntimeException("Method " + elementName + 
//                                       " did not return a LiveElement");
//            }
//
//            return (LiveElement) result;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to get element " + elementName + 
//                                   " from page " + pageName, e);
//        }
//    }
//    
    public String captureToastMessage(WebDriver driver, By locator) {
        try {
            // Wait for the toast to appear and become visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            
            // Capture the text immediately
            String message = toastElement.getText();
            
            // Optional: Wait for the toast to disappear if you need to verify that
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            
            return message;
        } catch (TimeoutException e) {
            throw new RuntimeException("Toast message did not appear within 3 seconds", e);
        }
    }
    
    
    
}