package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelReader;
import utils.ExtentManager;
import utils.TestDataManager;
import keywords.ColumnKeywordExecutor;
import java.util.*;

/**
 * TestNG test runner class for executing keyword-driven test flows.
 * Now supports multiple sheets in both test data and keyword files.
 */
public class TestRunnerCategory {
    // Configuration constants for file paths and sheet names
    private static final String TEST_DATA_PATH = "src/test/resources/data/RunManagerCategoryFullregression.xlsx";
    private static final String KEYWORDS_PATH = "src/test/resources/data/CategoryWatchFullregressionTestflow.xlsx";
    private static final String TEST_DATA_SHEET = "Categoryfullregresiontestcases";
    private static final String KEYWORDS_SHEET = "Businessflow_CategoryfullRegres";
    
    // WebDriver instance for browser automation
    private WebDriver driver;
    
    // Keyword executor for invoking test methods
    private ColumnKeywordExecutor executor;
    
    // Maps test case IDs to their associated keyword sequences
    private Map<String, List<String>> testFlowMap;

    /**
     * Test setup method executed before each test method.
     * Initializes WebDriver and keyword executor.
     */
    
    public void testSetup() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        
        // Initialize keyword executor with the WebDriver instance
        this.executor = new ColumnKeywordExecutor(driver);
    }

    /**
     * Test teardown method executed after each test method.
     * Cleans up WebDriver resources.
     */
    @AfterMethod
    public void testTeardown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /**
     * Class-level setup executed once before any test methods.
     * Loads keyword mappings from Excel files.
     */
    @BeforeClass
    public void loadTestCases() {
        this.testFlowMap = loadKeywordsMapping();
    }

    /**
     * Main test execution method.
     * @param testData DataProvider array containing test case information
     * @throws Throwable 
     */
    
    @Test(dataProvider = "testData")
   public void executeTest(Object[] testData) {
    	

        String testScenario = (String) testData[0];
        String testCaseId = (String) testData[1];
        String executeFlag = (String) testData[4];
        
     // Set current test case before execution
        TestDataManager.setCurrentTestCase(testCaseId);
        
        ExtentTest test = ExtentManager.startTest(testCaseId, testScenario);
        
        if(!"Yes".equalsIgnoreCase(executeFlag)) {
            test.skip("Test case skipped: " + testCaseId);
            throw new SkipException("Test case skipped: " + testCaseId);
        }
        
        testSetup();
        List<String> keywords = testFlowMap.get(testCaseId);
        if (keywords == null || keywords.isEmpty()) {
            test.skip("No keywords found for test case: " + testCaseId);
            throw new SkipException("No keywords found for test case: " + testCaseId);
        }

        
        System.out.println("Executing test case: " + testCaseId);
        try {
            // Execute and collect failures
            List<Throwable> failures = executor.executeTestFlow(testScenario, keywords);
            
            // Store failures in test context for the listener
            ITestContext context = Reporter.getCurrentTestResult().getTestContext();
            context.setAttribute("failures", failures);
            
            if (!failures.isEmpty()) {
                // Mark test as failed but don't throw to allow afterMethod to run
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
                printTestStatus(testCaseId, "Fail");
            } else {
                test.pass("All keywords executed successfully");
                printTestStatus(testCaseId, "Pass");
            }
        } catch (Exception e) {
            test.fail("Test execution error: " + e.getMessage());
            printTestStatus(testCaseId, "Fail");
           test.fail(e);
        }
    
    }

    // Helper method to print the formatted status
    private void printTestStatus(String testCaseId, String status)
    {
    	System.out.println("==============================================================================================");
    	System.out.println("\n" + testCaseId + " - " + status);
    	System.out.println("==============================================================================================");
    }
    

    /**
     * DataProvider method supplying test cases from Excel.
     * @return 2D array of test case data
     */
    @DataProvider(name = "testData")
    public Object[][] getTestData() {
        return ExcelReader.getTestData(TEST_DATA_PATH, TEST_DATA_SHEET);
    }

    /**
     * Loads keyword mappings from Excel file.
     * @return Map of test case IDs to their keyword sequences
     */
    private Map<String, List<String>> loadKeywordsMapping() {
        Map<String, List<String>> mapping = new HashMap<>();
        
        // Read keyword data from Excel
        Object[][] keywordsData = ExcelReader.getTestData(KEYWORDS_PATH, KEYWORDS_SHEET);
        
        // Process each row of keyword data
        for (Object[] row : keywordsData) {
            String testCaseId = (String) row[0];
            List<String> keywords = new ArrayList<>();
            
            // Collect all non-empty keywords for this test case
            for (int i = 1; i < row.length; i++) {
                if (row[i] != null && !row[i].toString().trim().isEmpty()) {
                    keywords.add(row[i].toString().trim());
                }
            }
            
            // Add to mapping if keywords found
            if (!keywords.isEmpty()) {
                mapping.put(testCaseId, keywords);
            }
        }
        
        return mapping;
    }
    
    @AfterSuite
    public void tearDownSuite() {
        ExtentManager.endTest();
    }
}
