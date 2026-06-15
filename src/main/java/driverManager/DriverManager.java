package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Manages WebDriver instances in a thread-safe manner using ThreadLocal.
 * Provides centralized control for driver initialization, access, and cleanup.
 * Enhanced to prevent unnecessary driver creation for skipped tests.
 */
public class DriverManager {
    // ThreadLocal instance to maintain separate WebDriver for each thread
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    // Flag to track if driver initialization should be skipped
    private static ThreadLocal<Boolean> skipDriverInitialization = ThreadLocal.withInitial(() -> false);
    
    /**
     * Initializes a new ChromeDriver instance if one doesn't already exist for the current thread
     * and initialization is not explicitly skipped.
     * Configures system properties and maximizes the browser window.
     */
    public static void initDriver() {
        // Check if driver initialization should be skipped
        if (skipDriverInitialization.get()) {
            return;
        }
        
        // Check if current thread already has a driver instance
        if (driver.get() == null) {
            // Set path to ChromeDriver executable from configuration
        	// Let WebDriverManager handle the driver setup automatically
        	 WebDriverManager.chromedriver().setup();
            
            // Create new ChromeDriver instance and store in ThreadLocal
            driver.set(new ChromeDriver());
            
            // Maximize the browser window
            getDriver().manage().window().maximize();
        }
    }
    
    /**
     * Returns the WebDriver instance for the current thread.
     * @return WebDriver instance for the current thread
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    /**
     * Properly quits and cleans up the WebDriver instance for the current thread.
     * Removes the ThreadLocal reference to prevent memory leaks.
     */
    public static void quitDriver() {
        // Check if current thread has an active driver instance
        if (driver.get() != null) {
            // Quit the driver and close all associated windows
            driver.get().quit();
            
            // Remove the driver reference from ThreadLocal
            driver.remove();
        }
        
        // Reset the skip flag for the next test
        skipDriverInitialization.set(false);
    }
    
    /**
     * Marks that driver initialization should be skipped for the current thread.
     * Useful for test cases that should not create a browser instance.
     */
    public static void skipDriverInit() {
        skipDriverInitialization.set(true);
    }
    
    /**
     * Resets the skip flag for the current thread.
     * Useful when you want to ensure driver creation in subsequent tests.
     */
    public static void resetSkipFlag() {
        skipDriverInitialization.set(false);
    }
    
    /**
     * Checks if driver initialization is currently skipped for this thread.
     * @return true if driver initialization is skipped
     */
    public static boolean isDriverInitSkipped() {
        return skipDriverInitialization.get();
    }
}
